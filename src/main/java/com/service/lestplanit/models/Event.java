package com.service.lestplanit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Represents an event.
 */
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private Integer cost;
    //TODO: Review the data type for this attribute, seems that we can improve if we can use a list of strings
    private String requirements;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Subscription> subscriptions;

    /**
     * Constructs a new Event with the specified name, start date, end date, and cost.
     *
     * @param name      the name of the event
     * @param startDate the start date of the event
     * @param endDate   the end date of the event
     * @param cost      the cost of the event
     */
    public Event(String name, LocalDateTime startDate, LocalDateTime endDate, Integer cost) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    /**
     * Retrieves the name of the event.
     *
     * @return the name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the ID of the event.
     *
     * @return the ID of the event
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the name of the event.
     *
     * @param name the name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the start date of the event.
     *
     * @return the start date of the event
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the event.
     *
     * @param startDate the start date of the event
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Retrieves the end date of the event.
     *
     * @return the end date of the event
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the event.
     *
     * @param endDate the end date of the event
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Retrieves the location of the event.
     *
     * @return the location of the event
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the event.
     *
     * @param location the location of the event
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Retrieves the cost of the event.
     *
     * @return the cost of the event
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * Sets the cost of the event.
     *
     * @param cost the cost of the event
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * Retrieves the requirements of the event.
     *
     * @return the requirements of the event
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Sets the requirements of the event.
     *
     * @param requirements the requirements of the event
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Retrieves the subscriptions associated with the event.
     *
     * @return the subscriptions associated with the event
     */
    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Sets the subscriptions associated with the event.
     *
     * @param subscriptions the subscriptions associated with the event
     */
    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * Adds a subscription to the event.
     *
     * @param subscription the subscription to be added
     * @return the added subscription
     */
    public Subscription addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
        return subscription;
    }
}
