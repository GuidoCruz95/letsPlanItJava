package com.service.lestplanit.services;

import com.service.lestplanit.exceptions.ItemNotFoundException;
import com.service.lestplanit.models.Subscription;
import com.service.lestplanit.repositories.SubscriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing subscriptions.
 */
@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    /**
     * Retrieves all subscriptions.
     *
     * @return List of all subscriptions.
     */
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    /**
     * Retrieves a specific subscription by its ID.
     *
     * @param subscriptionId The ID of the subscription.
     * @return The subscription with the specified ID.
     * @throws ItemNotFoundException if the subscription is not found.
     */
    public Subscription getSubscriptionById(Long subscriptionId) {
        Optional<Subscription> subscriptionOptional = subscriptionRepository.findById(subscriptionId);
        if (subscriptionOptional.isPresent()) {
            return subscriptionOptional.get();
        } else {
            throw new ItemNotFoundException("Subscription not found with ID: " + subscriptionId);
        }
    }

    /**
     * Creates a new subscription.
     *
     * @param subscription The subscription to be created.
     * @return The created subscription.
     */
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    /**
     * Updates an existing subscription.
     *
     * @param subscriptionId The subscription identifier to take as reference to update an item.
     * @param subscription   The subscription to be updated.
     * @return The updated subscription.
     */
    public Subscription updateSubscription(Long subscriptionId, Subscription subscription) {
        Optional<Subscription> subscriptionToUpdate = subscriptionRepository.findById(subscriptionId);
        if (subscriptionToUpdate.isPresent()) {
            Subscription existingEntity = subscriptionToUpdate.get();
            existingEntity.setEvent(subscription.getEvent());
            existingEntity.setPerson(subscription.getPerson());
            existingEntity.setNotes(subscription.getNotes());
            existingEntity.setTotalPayed(subscription.getTotalPayed());
            existingEntity.setPaymentHistorySet(subscription.getPaymentHistorySet());
            return subscriptionRepository.save(existingEntity);
        } else {
            throw new EntityNotFoundException("Entity not found with ID: " + subscriptionId);
        }
    }

    /**
     * Deletes a subscription by its ID.
     *
     * @param subscriptionId The ID of the subscription to be deleted.
     * @throws ItemNotFoundException if the subscription is not found.
     */
    public void deleteSubscription(Long subscriptionId) {
        if (subscriptionRepository.existsById(subscriptionId)) {
            subscriptionRepository.deleteById(subscriptionId);
        } else {
            throw new ItemNotFoundException("Subscription not found with ID: " + subscriptionId);
        }
    }
}
