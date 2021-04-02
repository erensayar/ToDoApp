package com.erensayar.todoapp.Security;

import com.erensayar.todoapp.Annotation.CurrentUser;
import com.erensayar.todoapp.Entity.User;
import com.erensayar.todoapp.ViewModel.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author erensayar
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/auth")
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAuthentication(@CurrentUser User user) {
        return ResponseEntity.ok(user);
    }

}
