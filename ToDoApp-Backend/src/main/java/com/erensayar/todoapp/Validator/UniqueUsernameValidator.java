package com.erensayar.todoapp.Validator;

import com.erensayar.todoapp.Annotation.UniqueUsername;
import com.erensayar.todoapp.Entity.User;
import com.erensayar.todoapp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author erensayar
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    //<============================================>
    UserRepo userRepo;

    @Autowired
    public UniqueUsernameValidator(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    //<============================================>

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        User user = userRepo.findByUsername(username).get();
        if (user != null) {
            return false;
        }
        return true;
    }

}
