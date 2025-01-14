package com.example.Lv4.Exception;

public class InvalidRangeException extends Exception {

    /**
     * Throw when input is not a valid number
     *
     * @param message
     */
    public InvalidRangeException(String message) {
        super(message);
    }
}
