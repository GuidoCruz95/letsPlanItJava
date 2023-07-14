package com.service.lestplanit.controller;

import com.service.lestplanit.models.Person;
import com.service.lestplanit.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling requests related to persons.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * Retrieves all persons.
     *
     * @return List of all persons.
     */
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    /**
     * Retrieves a specific person by their ID.
     *
     * @param personId The ID of the person.
     * @return The person with the specified ID.
     */
    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable Long personId) {
        return personService.getPersonById(personId);
    }

    /**
     * Creates a new person.
     *
     * @param person The person to be created.
     * @return The created person.
     */
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    /**
     * Updates an existing person.
     *
     * @param personId The ID of the person to be updated.
     * @param person   The updated person data.
     * @return The updated person.
     */
    @PutMapping("/{personId}")
    public Person updatePerson(@PathVariable Long personId, @RequestBody Person person) {
        return personService.updatePerson(personId, person);
    }

    /**
     * Deletes a person by their ID.
     *
     * @param personId The ID of the person to be deleted.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }
}
