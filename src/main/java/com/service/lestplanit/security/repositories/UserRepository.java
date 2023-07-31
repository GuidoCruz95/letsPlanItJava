package com.service.lestplanit.security.repositories;

import com.service.lestplanit.security.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing UserEntity data.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Retrieves an optional UserEntity object by username.
     *
     * @param username The username of the user to retrieve.
     * @return Optional containing the UserEntity if found, or empty if not found.
     */
    Optional<UserEntity> findByUsername(String username);

    /**
     * Custom query to retrieve an optional UserEntity object by username.
     *
     * @param username The username of the user to retrieve.
     * @return Optional containing the UserEntity if found, or empty if not found.
     */
    @Query("select u from UserEntity u where u.username = ?1")
    Optional<UserEntity> getName(String username);
}
