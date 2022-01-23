package com.example.sample.main.person.address.mnagement.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.main.person.address.mnagement.dto.PersonDetailsDto;
import com.example.sample.main.person.address.mnagement.entity.Person;
import com.example.sample.main.person.address.mnagement.repository.AddressRepository;
import com.example.sample.main.person.address.mnagement.repository.PersonRepository;
import com.example.sample.main.person.address.mnagement.service.PersonDetailService;

@Service
@Transactional
public class PersonDetailsServiceImpl implements PersonDetailService {

	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Override
	public List<Person> getAllPersonDetails() {
		return personRepo.findAll();
	}

	@Override
	public Person getPersonDetails(int id) {
		return personRepo.findById(id).orElse(new Person());
	}

	@Override
	public Person savePersonDetails(PersonDetailsDto request) {
		return personRepo.save(request.getPerson());
	}

	@Override
	public boolean removePersonDetails(int id) {
		personRepo.deleteById(id);
		return true;
	}

	@Override
	public Person updatePersonDetails(Person request) {
		return personRepo.save(request);
	}

}
