package com.service.lestplanit.repositories;

import com.service.lestplanit.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing event data.
 */
public interface EventRepository extends JpaRepository<Event, Long> {
}
