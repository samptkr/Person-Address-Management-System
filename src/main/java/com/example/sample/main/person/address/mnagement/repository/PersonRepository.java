package com.example.sample.main.person.address.mnagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sample.main.person.address.mnagement.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
