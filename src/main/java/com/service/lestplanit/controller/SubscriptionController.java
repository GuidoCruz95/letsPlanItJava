package com.service.lestplanit.controller;

import com.service.lestplanit.models.Subscription;
import com.service.lestplanit.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling requests related to subscriptions.
 */
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    /**
     * Retrieves all subscriptions.
     *
     * @return List of all subscriptions.
     */
    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    /**
     * Retrieves a specific subscription by its ID.
     *
     * @param subscriptionId The ID of the subscription.
     * @return The subscription with the specified ID.
     */
    @GetMapping("/{subscriptionId}")
    public Subscription getSubscriptionById(@PathVariable Long subscriptionId) {
        return subscriptionService.getSubscriptionById(subscriptionId);
    }

    /**
     * Creates a new subscription.
     *
     * @param subscription The subscription to be created.
     * @return The created subscription.
     */
    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription createdSubscription = subscriptionService.createSubscription(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscription);
    }

    /**
     * Updates an existing subscription.
     *
     * @param subscriptionId The ID of the subscription to be updated.
     * @param subscription   The updated subscription data.
     * @return The updated subscription.
     */
    @PutMapping("/{subscriptionId}")
    public Subscription updateSubscription(@PathVariable Long subscriptionId, @RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscriptionId, subscription);
    }

    /**
     * Deletes a subscription by its ID.
     *
     * @param subscriptionId The ID of the subscription to be deleted.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
        return ResponseEntity.noContent().build();
    }
}

