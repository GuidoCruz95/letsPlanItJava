package com.service.lestplanit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
}
