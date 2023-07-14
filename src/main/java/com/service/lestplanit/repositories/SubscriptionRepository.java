package com.service.lestplanit.repositories;

import com.service.lestplanit.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing subscription data.
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
