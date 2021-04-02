package com.erensayar.todoapp.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author erensayar
 */
@RestController
public class ErrorHandler implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    ApiError handleError(WebRequest webRequest) {
        Map<String, Object> attributes =
                this.errorAttributes.getErrorAttributes
                        (webRequest, ErrorAttributeOptions.of
                                (ErrorAttributeOptions.Include.MESSAGE,
                                 ErrorAttributeOptions.Include.BINDING_ERRORS,
                                 ErrorAttributeOptions.Include.EXCEPTION
                                )
                        );

        String message = (String) attributes.get("message");
        String path = (String) attributes.get("path");


        //System.out.println("Errors: " + attributes.containsKey("errors"));
        //System.out.println("Exception: " + attributes.containsKey("exception"));

        ApiError error = new ApiError(message, path);

        // Add Validation Fields Error For NOT VALID Situtations
        if (attributes.containsKey("errors")) {
            @SuppressWarnings("unchecked")
            List<FieldError> fieldErrors = (List<FieldError>) attributes.get("errors");
            Map<String, String> validationFieldErrors = new HashMap<>();
            for (FieldError fieldError : fieldErrors) {
                validationFieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            error.setValidationFieldsErrors(validationFieldErrors);
        }

        // For EXCEPTION Situations
        // if db not exist then add message add
        if (attributes.containsKey("exception")) {

            if (attributes.get("exception").toString().
                    equals("org.springframework.dao.EmptyResultDataAccessException") ||
                    attributes.get("exception").toString().
                            equals("javax.persistence.EntityNotFoundException")) {
                error.setMessage("Your Object Not Found! Check Your Data!");
            }

            if (attributes.get("exception").toString().contains("ConstraintViolationException")) {
                error.setMessage("User Name Already Exist. Take Another User Name.");
            }
        }

        return error;
    }

    @Override // Default Error EndPoint Adress
    public String getErrorPath() {
        return "/error";
    }
}
