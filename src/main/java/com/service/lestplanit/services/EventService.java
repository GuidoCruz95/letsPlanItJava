package com.service.lestplanit.services;

import com.service.lestplanit.exceptions.ItemNotFoundException;
import com.service.lestplanit.models.Event;
import com.service.lestplanit.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing events.
 */
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    /**
     * Retrieves all events.
     *
     * @return List of all events.
     */
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Retrieves a specific event by its ID.
     *
     * @param eventId The ID of the event.
     * @return The event with the specified ID.
     * @throws ItemNotFoundException if the event is not found.
     */
    public Event getEventById(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            return eventOptional.get();
        } else {
            throw new ItemNotFoundException("Event not found with ID: " + eventId);
        }
    }

    /**
     * Creates a new event.
     *
     * @param event The event to be created.
     * @return The created event.
     */
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    /**
     * Updates an existing event.
     *
     * @param eventId The event identifier to take as reference to update an item.
     * @param event   The event to be updated.
     * @return The updated event.
     */
    public Event updateEvent(Long eventId, Event event) {
        Optional<Event> eventToUpdate = eventRepository.findById(eventId);
        if (eventToUpdate.isPresent()) {
            Event existingEntity = eventToUpdate.get();
            existingEntity.setName(event.getName());
            existingEntity.setStartDate(event.getStartDate());
            existingEntity.setEndDate(event.getEndDate());
            existingEntity.setLocation(event.getLocation());
            existingEntity.setCost(event.getCost());
            existingEntity.setRequirements(event.getRequirements());
            existingEntity.setSubscriptions(event.getSubscriptions());
            return eventRepository.save(existingEntity);
        } else {
            // Handle the case when the entity with the specified ID is not found
            throw new ItemNotFoundException("Entity not found with ID: " + eventId);
        }
    }

    /**
     * Deletes an event by its ID.
     *
     * @param eventId The ID of the event to be deleted.
     * @throws ItemNotFoundException if the event is not found.
     */
    public void deleteEvent(Long eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
        } else {
            throw new ItemNotFoundException("Event not found with ID: " + eventId);
        }
    }
}
