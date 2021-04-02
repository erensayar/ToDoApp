package com.erensayar.todoapp;

import com.erensayar.todoapp.Entity.Note;
import com.erensayar.todoapp.Entity.User;
import com.erensayar.todoapp.Service.Implementation.NoteService;
import com.erensayar.todoapp.Service.Implementation.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

/**
 * @author erensayar
 */
@SpringBootApplication
public class ToDoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoAppApplication.class, args);
    }

}
