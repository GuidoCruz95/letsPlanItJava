package com.service.lestplanit.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Represents a person.
 */
@Entity
public class Person {

    @Id
    private Long id;
    private String email;
    private String name;
    private String lastname;
    private LocalDateTime birthdate;
    private String aboutYou;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Subscription> subscriptions;

    /**
     * Constructs an empty Person.
     */
    public Person() {
    }

    /**
     * Constructs a Person with the specified ID.
     *
     * @param id the ID of the person
     */
    public Person(Long id) {
        this.id = id;
    }

    /**
     * Constructs a Person with the specified ID, email, and name.
     *
     * @param id    the ID of the person
     * @param email the email of the person
     * @param name  the name of the person
     */
    public Person(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    /**
     * Retrieves the ID of the person.
     *
     * @return the ID of the person
     */
    public Long getId() {
        return id;
    }

    /**
     * Retrieves the email of the person.
     *
     * @return the email of the person
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the last name of the person.
     *
     * @return the last name of the person
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastname the last name of the person
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Retrieves the birth date of the person.
     *
     * @return the birth date of the person
     */
    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birth date of the person.
     *
     * @param birthdate the birth date of the person
     */
    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Retrieves the "About You" information of the person.
     *
     * @return the "About You" information of the person
     */
    public String getAboutYou() {
        return aboutYou;
    }

    /**
     * Sets the "About You" information of the person.
     *
     * @param aboutYou the "About You" information of the person
     */
    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    /**
     * Retrieves the subscriptions associated with the person.
     *
     * @return the subscriptions associated with the person
     */
    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Sets the email of the person.
     *
     * @param email the email of the person
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the subscriptions associated with the person.
     *
     * @param subscriptions the subscriptions associated with the person
     */
    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public String toString() {
        return String.format("Person[ci=%d, email='%s', name='%s']", id, email, name);
    }
}
