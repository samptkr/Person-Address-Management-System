package com.example.sample.main.person.address.mnagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.main.person.address.mnagement.dto.PersonDetailsDto;
import com.example.sample.main.person.address.mnagement.entity.Person;
import com.example.sample.main.person.address.mnagement.serviceimpl.PersonDetailsServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Person Rest Controller", description = "REST API for Person Address Management System")
@RequestMapping("/person")
public class PersonDetailsController {
	
	@Autowired
	private PersonDetailsServiceImpl service;	
	
	@ApiOperation(value = "Get person by id ", response = Person.class, tags = "addPersonsDetails")
	@GetMapping("/get/{id}")
	public ResponseEntity<Person> addPersonsDetails(@PathVariable int id){	
		Person person = service.getPersonDetails(id);
		if(person!=null && person.getId()!=null) {
			return new ResponseEntity<Person>(person, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Person>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiOperation(value = "Get all person details", response = Person.class, tags = "getAllPersonsDetails")
	@GetMapping("/getAll")
	public ResponseEntity<List<Person>> getAllPersonsDetails(){	
		List<Person> personList = service.getAllPersonDetails();
		if(personList!=null && personList.size() > 0) {
			return new ResponseEntity<List<Person>>(service.getAllPersonDetails(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
		}
	}	
	
	@ApiOperation(value = "add person details", response = Person.class, tags = "addPersonsDetails")
	@PostMapping("/save")
	public ResponseEntity<Person> addPersonsDetails(@RequestBody PersonDetailsDto request){	
		Person person = service.savePersonDetails(request);
		if(person!=null && person.getId()!=null) {
			return new ResponseEntity<Person>(person, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Person>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiOperation(value = "update person details", response = Person.class, tags = "updatePersonsDetails")
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePersonsDetails(@RequestBody PersonDetailsDto request, @PathVariable int id){	
		
		Person existingPerson = service.getPersonDetails(id);
		Person modifiedPerson = request.getPerson();
		existingPerson.setAddress(modifiedPerson.getAddress());
		Person latestPerson = service.updatePersonDetails(existingPerson);
		if(latestPerson!=null && latestPerson.getId()!=null) {
			return new ResponseEntity<Person>(latestPerson, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Person>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiOperation(value = "Delete person details", response = Person.class, tags = "removePersonsDetails")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removePersonsDetails(@PathVariable int id){	
		Boolean flag = service.removePersonDetails(id);
		if(flag) {
			return new ResponseEntity<String>("Person details removed successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
