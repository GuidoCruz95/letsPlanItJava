package com.service.lestplanit.models;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Represents a subscription.
 */
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private String notes;
    private Long totalPayed;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private Set<PaymentHistory> paymentHistorySet;

    /**
     * Retrieves the event associated with the subscription.
     *
     * @return the event associated with the subscription
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets the event associated with the subscription.
     *
     * @param event the event associated with the subscription
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Retrieves the person associated with the subscription.
     *
     * @return the person associated with the subscription
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the person associated with the subscription.
     *
     * @param person the person associated with the subscription
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Retrieves the notes associated with the subscription.
     *
     * @return the notes associated with the subscription
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes associated with the subscription.
     *
     * @param notes the notes associated with the subscription
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Retrieves the total amount paid for the subscription.
     *
     * @return the total amount paid for the subscription
     */
    public Long getTotalPayed() {
        return totalPayed;
    }

    /**
     * Sets the total amount paid for the subscription.
     *
     * @param totalPayed the total amount paid for the subscription
     */
    public void setTotalPayed(Long totalPayed) {
        this.totalPayed = totalPayed;
    }

    /**
     * Retrieves the set of payment history associated with the subscription.
     *
     * @return the set of payment history associated with the subscription
     */
    public Set<PaymentHistory> getPaymentHistorySet() {
        return paymentHistorySet;
    }

    /**
     * Sets the set of payment history associated with the subscription.
     *
     * @param paymentHistorySet the set of payment history associated with the subscription
     */
    public void setPaymentHistorySet(Set<PaymentHistory> paymentHistorySet) {
        this.paymentHistorySet = paymentHistorySet;
    }
}
