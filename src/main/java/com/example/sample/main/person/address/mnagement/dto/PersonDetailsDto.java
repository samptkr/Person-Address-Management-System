package com.example.sample.main.person.address.mnagement.dto;

import org.springframework.stereotype.Component;

import com.example.sample.main.person.address.mnagement.entity.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class PersonDetailsDto {
	
	private Person person;
	
}
