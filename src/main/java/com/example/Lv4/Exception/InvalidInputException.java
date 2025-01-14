package com.example.Lv4.Exception;

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
