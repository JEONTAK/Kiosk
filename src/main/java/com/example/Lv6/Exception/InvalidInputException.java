package com.example.Lv6.Exception;

public class InvalidInputException extends Exception {

    /**
     * Throw when input is not a valid number
     *
     * @param message
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
