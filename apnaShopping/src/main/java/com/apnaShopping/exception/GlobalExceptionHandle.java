package com.apnaShopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle
{
    @ExceptionHandler(PasswordInputCheck.class)
    public ResponseEntity<String> handlePasswordInputException(PasswordInputCheck ex) {

        String errorMessage = ex.getMessage();

        // Return a ResponseEntity with the error message and appropriate HTTP status
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(EmptyNameException.class)
    public ResponseEntity<String> handleNameInputException(EmptyNameException ex)
    {
        String errorMessage=ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }
}
