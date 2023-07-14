package com.service.lestplanit.services;

import com.service.lestplanit.models.Person;
import com.service.lestplanit.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class testingController {

    /**
     * The generator for generating the CI values for Person objects.
     * This is used for testing purposes only.
     */
    private final AtomicLong ciGenerator;

    /**
     * The repository for managing Person objects.
     */
    private final PersonRepository personRepository;

    @Autowired
    public testingController(PersonRepository personRepository) {
        this.ciGenerator = new AtomicLong();
        this.personRepository = personRepository;
    }

    /**
     * Creates a new Person.
     *
     * @param name  The name for a person, by default it uses 'Jose'.
     * @param email The email for a person, by default it uses 'jose@default-email.com'.
     * @return The created person.
     */
    @GetMapping("/create-default-entity")
    public Person createPerson(@RequestParam(value = "name", defaultValue = "Jose") String name,
                               @RequestParam(value = "email", defaultValue = "jose@default-email.com") String email) {
        Person person = new Person(ciGenerator.incrementAndGet(), name, email);
        personRepository.save(person);
        return person;
    }

    /**
     * Retrieves a list of people.
     *
     * @return The list of people.
     */
    @GetMapping("/people")
    public List<Person> getPeopleList() {
        return personRepository.findAll();
    }
}
