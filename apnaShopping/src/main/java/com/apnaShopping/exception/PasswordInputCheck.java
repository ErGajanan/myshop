package com.apnaShopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class PasswordInputCheck extends Exception
{
    public PasswordInputCheck(String message)
    {
        super(message);
    }
}