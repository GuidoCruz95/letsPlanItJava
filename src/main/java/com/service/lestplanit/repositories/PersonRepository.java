package com.service.lestplanit.repositories;

import com.service.lestplanit.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
