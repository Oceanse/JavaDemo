package com.demo.exception.custom_execption.demo1;

/**
 * Creating your own Exception that is known as custom exception or user-defined exception
 * By the help of custom exception, you can have your own exception and message.
 */


/**
 * Custom checked exception
 */
public class InvalidAgeException extends RuntimeException {

    public InvalidAgeException() {
        super();
    }

    public InvalidAgeException(String errorMessage) {
        super(errorMessage);
    }

}
