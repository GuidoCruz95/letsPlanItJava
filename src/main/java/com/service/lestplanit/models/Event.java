package com.service.lestplanit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

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

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate, Integer cost) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public Subscription addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
        return subscription;
    }
}
