package com.example.Lv4_5.Exception;

public class InvalidRangeException extends IndexOutOfBoundsException {

    /**
     * Throw when input is not a valid number
     *
     * @param message
     */
    public InvalidRangeException(String message) {
        super(message);
    }
}
