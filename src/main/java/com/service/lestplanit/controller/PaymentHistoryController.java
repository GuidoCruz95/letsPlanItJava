package com.service.lestplanit.controller;

import com.service.lestplanit.models.PaymentHistory;
import com.service.lestplanit.services.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling requests related to payment histories.
 */
@RestController
@RequestMapping("/paymentHistories")
public class PaymentHistoryController {

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    /**
     * Retrieves all payment histories.
     *
     * @return List of all payment histories.
     */
    @GetMapping
    public List<PaymentHistory> getAllPaymentHistories() {
        return paymentHistoryService.getAllPaymentHistories();
    }

    /**
     * Retrieves a specific payment history by its ID.
     *
     * @param paymentHistoryId The ID of the payment history.
     * @return The payment history with the specified ID.
     */
    @GetMapping("/{paymentHistoryId}")
    public PaymentHistory getPaymentHistoryById(@PathVariable Long paymentHistoryId) {
        return paymentHistoryService.getPaymentHistoryById(paymentHistoryId);
    }

    /**
     * Creates a new payment history.
     *
     * @param paymentHistory The payment history to be created.
     * @return The created payment history.
     */
    @PostMapping
    public ResponseEntity<PaymentHistory> createPaymentHistory(@RequestBody PaymentHistory paymentHistory) {
        PaymentHistory createdPaymentHistory = paymentHistoryService.createPaymentHistory(paymentHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaymentHistory);
    }

    /**
     * Updates an existing payment history.
     *
     * @param paymentHistoryId The ID of the payment history to be updated.
     * @param paymentHistory   The updated payment history data.
     * @return The updated payment history.
     */
    @PutMapping("/{paymentHistoryId}")
    public PaymentHistory updatePaymentHistory(@PathVariable Long paymentHistoryId, @RequestBody PaymentHistory paymentHistory) {
        return paymentHistoryService.updatePaymentHistory(paymentHistoryId, paymentHistory);
    }

    /**
     * Deletes a payment history by its ID.
     *
     * @param paymentHistoryId The ID of the payment history to be deleted.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{paymentHistoryId}")
    public ResponseEntity<Void> deletePaymentHistory(@PathVariable Long paymentHistoryId) {
        paymentHistoryService.deletePaymentHistory(paymentHistoryId);
        return ResponseEntity.noContent().build();
    }
}
