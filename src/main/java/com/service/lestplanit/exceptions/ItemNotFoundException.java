package com.service.lestplanit.exceptions;

/**
 * Exception thrown when an item is not found.
 */
public class ItemNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code ItemNotFoundException} with the specified detail message.
     *
     * @param message the detail message
     */
    public ItemNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code ItemNotFoundException} with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the cause of the exception
     */
    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
