package com.service.lestplanit.controller;

import com.service.lestplanit.models.Event;
import com.service.lestplanit.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling requests related to events.
 */
@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    /**
     * Retrieves all events.
     *
     * @return List of all events.
     */
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    /**
     * Retrieves a specific event by its ID.
     *
     * @param eventId The ID of the event.
     * @return The event with the specified ID.
     */
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    /**
     * Creates a new event.
     *
     * @param event The event to be created.
     * @return The created event.
     */
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    /**
     * Updates an existing event.
     *
     * @param eventId The ID of the event to be updated.
     * @param event   The updated event data.
     * @return The updated event.
     */
    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
        return eventService.updateEvent(eventId, event);
    }

    /**
     * Deletes an event by its ID.
     *
     * @param eventId The ID of the event to be deleted.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
}
