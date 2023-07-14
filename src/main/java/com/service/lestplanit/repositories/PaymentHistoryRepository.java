package com.service.lestplanit.repositories;

import com.service.lestplanit.models.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing payment history data.
 */
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
}
