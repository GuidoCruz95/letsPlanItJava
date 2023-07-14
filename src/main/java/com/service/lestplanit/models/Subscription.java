package com.service.lestplanit.models;

import jakarta.persistence.*;

import java.util.Set;

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

}
