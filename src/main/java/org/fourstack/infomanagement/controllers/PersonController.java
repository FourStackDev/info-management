package org.fourstack.infomanagement.controllers;

import java.util.List;

import org.fourstack.infomanagement.config.BasePath;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
