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

}
