package com.service.lestplanit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Represents a payment history.
 */
@Entity
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    private Integer amount;
    private String notes;
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    /**
     * Retrieves the date of the payment.
     *
     * @return the date of the payment
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date of the payment.
     *
     * @param date the date of the payment
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Retrieves the amount of the payment.
     *
     * @return the amount of the payment
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the payment.
     *
     * @param amount the amount of the payment
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * Retrieves the notes associated with the payment.
     *
     * @return the notes associated with the payment
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes associated with the payment.
     *
     * @param notes the notes associated with the payment
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Retrieves the subscription associated with the payment.
     *
     * @return the subscription associated with the payment
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * Sets the subscription associated with the payment.
     *
     * @param subscription the subscription associated with the payment
     */
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
