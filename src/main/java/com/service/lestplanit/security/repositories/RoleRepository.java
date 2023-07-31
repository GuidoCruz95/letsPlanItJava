package com.service.lestplanit.security.repositories;

import com.service.lestplanit.security.models.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing Role data.
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
