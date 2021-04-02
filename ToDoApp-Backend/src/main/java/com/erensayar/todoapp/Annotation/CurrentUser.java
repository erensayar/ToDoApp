package com.erensayar.todoapp.Annotation;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author erensayar
 */
@Target({ElementType.PARAMETER})
@Retention(RUNTIME)
@AuthenticationPrincipal
public @interface CurrentUser {

}
