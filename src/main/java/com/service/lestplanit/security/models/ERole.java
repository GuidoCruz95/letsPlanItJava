package com.service.lestplanit.security.models;

/**
 * Enum representing the roles available in the system.
 */
public enum ERole {
    /**
     * Represents an administrator role with full privileges and permissions.
     */
    ADMIN,

    /**
     * Represents a regular user role with limited privileges and permissions.
     */
    USER,

    /**
     * Represents an invited user role with restricted access until full registration is completed.
     */
    INVITED
}