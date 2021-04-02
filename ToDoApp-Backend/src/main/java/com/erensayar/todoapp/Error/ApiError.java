package com.erensayar.todoapp.Error;

import com.erensayar.todoapp.ViewModel.Views;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author erensayar
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    @JsonView(Views.Base.class)
    private String message;

    @JsonView(Views.Base.class)
    private String path;

    @JsonView(Views.Base.class)
    private long timestamp = new Date().getTime();

    private Map<String, String> validationFieldsErrors;

    public ApiError(String message, String path) {
        this.message = message;
        this.path = path;
    }

}
