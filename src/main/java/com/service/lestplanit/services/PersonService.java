package com.service.lestplanit.services;

import com.service.lestplanit.exceptions.ItemNotFoundException;
import com.service.lestplanit.models.Person;
import com.service.lestplanit.repositories.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing people.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * Retrieves all persons.
     *
     * @return List of all persons.
     */
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    /**
     * Retrieves a specific person by their ID.
     *
     * @param personId The ID of the person.
     * @return The person with the specified ID.
     * @throws ItemNotFoundException if the person is not found.
     */
    public Person getPersonById(Long personId) {
        Optional<Person> personOptional = personRepository.findById(personId);
        if (personOptional.isPresent()) {
            return personOptional.get();
        } else {
            throw new ItemNotFoundException("Person not found with ID: " + personId);
        }
    }

    /**
     * Creates a new person.
     *
     * @param person The person to be created.
     * @return The created person.
     */
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    /**
     * Updates an existing person.
     *
     * @param personId The person identifier to take as reference to update an item.
     * @param person   The person to be updated.
     * @return The updated person.
     */
    public Person updatePerson(Long personId, Person person) {
        Optional<Person> personToUpdate = personRepository.findById(personId);
        if (personToUpdate.isPresent()) {
            Person existingEntity = personToUpdate.get();

            existingEntity.setEmail(person.getEmail());
            existingEntity.setName(person.getName());
            existingEntity.setLastname(person.getLastname());
            existingEntity.setBirthdate(person.getBirthdate());
            existingEntity.setAboutYou(person.getAboutYou());
            existingEntity.setSubscriptions(person.getSubscriptions());

            // Save the updated entity
            return personRepository.save(existingEntity);
        } else {
            throw new EntityNotFoundException("Entity not found with ID: " + personId);
        }
    }

    /**
     * Deletes a person by their ID.
     *
     * @param personId The ID of the person to be deleted.
     * @throws ItemNotFoundException if the person is not found.
     */
    public void deletePerson(Long personId) {
        if (personRepository.existsById(personId)) {
            personRepository.deleteById(personId);
        } else {
            throw new ItemNotFoundException("Person not found with ID: " + personId);
        }
    }
}
