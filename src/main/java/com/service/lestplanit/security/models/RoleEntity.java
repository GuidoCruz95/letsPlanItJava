package com.service.lestplanit.security.models;

import jakarta.persistence.*;

/**
 * Entity class representing user roles.
 */
@Entity
@Table(name = "role_entity")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Enum representing the role name (e.g., ROLE_USER, ROLE_ADMIN)
    @Enumerated(EnumType.STRING)
    private ERole name;

    public RoleEntity() {
    }

    /**
     * Constructor to create a RoleEntity object with the given role.
     *
     * @param role The ERole representing the role name.
     */

    public RoleEntity(ERole role) {
        this.name = role;
    }

    /**
     * Retrieves the role name.
     *
     * @return The ERole representing the role name.
     */
    public ERole getName() {
        return name;
    }

    /**
     * Sets the role name.
     *
     * @param name The ERole representing the role name to set.
     */
    public void setName(ERole name) {
        this.name = name;
    }
}
