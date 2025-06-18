package com.aryajohary.collegedirectory.exceptions;

public class CustomEntityNotFoundException extends RuntimeException{
    public CustomEntityNotFoundException(String message) {
        super(message);
    }
}
