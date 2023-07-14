package com.service.lestplanit.services;

import com.service.lestplanit.exceptions.ItemNotFoundException;
import com.service.lestplanit.models.PaymentHistory;
import com.service.lestplanit.repositories.PaymentHistoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentHistoryService {

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    /**
     * Retrieves all payment histories.
     *
     * @return List of all payment histories.
     */
    public List<PaymentHistory> getAllPaymentHistories() {
        return paymentHistoryRepository.findAll();
    }

    /**
     * Retrieves a specific payment history by its ID.
     *
     * @param paymentHistoryId The ID of the payment history.
     * @return The payment history with the specified ID.
     * @throws ItemNotFoundException if the payment history is not found.
     */
    public PaymentHistory getPaymentHistoryById(Long paymentHistoryId) {
        Optional<PaymentHistory> paymentHistoryOptional = paymentHistoryRepository.findById(paymentHistoryId);
        if (paymentHistoryOptional.isPresent()) {
            return paymentHistoryOptional.get();
        } else {
            throw new ItemNotFoundException("Payment history not found with ID: " + paymentHistoryId);
        }
    }

    /**
     * Creates a new payment history.
     *
     * @param paymentHistory The payment history to be created.
     * @return The created payment history.
     */
    public PaymentHistory createPaymentHistory(PaymentHistory paymentHistory) {
        return paymentHistoryRepository.save(paymentHistory);
    }

    /**
     * Updates an existing payment history.
     *
     * @param paymentHistoryId The paymentHistory identifier to take as reference to update an item.
     * @param paymentHistory   The payment history to be updated.
     * @return The updated payment history.
     */
    public PaymentHistory updatePaymentHistory(Long paymentHistoryId, PaymentHistory paymentHistory) {
        Optional<PaymentHistory> paymentHistoryToUpdate = paymentHistoryRepository.findById(paymentHistoryId);
        if (paymentHistoryToUpdate.isPresent()) {
            PaymentHistory existingEntity = paymentHistoryToUpdate.get();
            existingEntity.setDate(paymentHistory.getDate());
            existingEntity.setAmount(paymentHistory.getAmount());
            existingEntity.setNotes(paymentHistory.getNotes());
            existingEntity.setSubscription(paymentHistory.getSubscription());
            return paymentHistoryRepository.save(existingEntity);
        } else {
            // Handle the case when the entity with the specified ID is not found
            throw new EntityNotFoundException("Entity not found with ID: " + paymentHistoryId);
        }
    }

    /**
     * Deletes a payment history by its ID.
     *
     * @param paymentHistoryId The ID of the payment history to be deleted.
     * @throws ItemNotFoundException if the payment history is not found.
     */
    public void deletePaymentHistory(Long paymentHistoryId) {
        if (paymentHistoryRepository.existsById(paymentHistoryId)) {
            paymentHistoryRepository.deleteById(paymentHistoryId);
        } else {
            throw new ItemNotFoundException("Payment history not found with ID: " + paymentHistoryId);
        }
    }

}
