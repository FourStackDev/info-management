package org.fourstack.infomanagement.controllers;

import java.util.List;

import org.fourstack.infomanagement.config.BasePath;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePath
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> getPersonsList() {
		return personService.getPersons();
	}
	
	@PostMapping(value = "/persons", consumes = "application/json")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.CREATED);
	}
}
