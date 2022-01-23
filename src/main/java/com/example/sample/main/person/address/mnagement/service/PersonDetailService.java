package com.example.sample.main.person.address.mnagement.service;

import java.util.List;

import com.example.sample.main.person.address.mnagement.dto.PersonDetailsDto;
import com.example.sample.main.person.address.mnagement.entity.Person;

public interface PersonDetailService {
	
	public List<Person> getAllPersonDetails();
	public Person getPersonDetails(int id);
	public Person savePersonDetails(PersonDetailsDto request);
	public boolean removePersonDetails(int id);
	public Person updatePersonDetails(Person request);
}
