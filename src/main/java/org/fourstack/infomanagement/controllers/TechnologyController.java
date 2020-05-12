package org.fourstack.infomanagement.controllers;

import java.util.List;

import org.fourstack.infomanagement.annotations.BasePath;
import org.fourstack.infomanagement.models.Technology;
import org.fourstack.infomanagement.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePath
public class TechnologyController {
	
	@Autowired
	private TechnologyService service;
	
	@GetMapping("/technologies")
	public ResponseEntity<List<Technology>> getAllTechnologies() {
		return new ResponseEntity<List<Technology>>(service.getAllTechnologies(), HttpStatus.OK);
	}
	
	@PostMapping("/technologies")
	public ResponseEntity<Technology> saveTechonology(@RequestBody Technology technology) {
		return new ResponseEntity<Technology>(service.saveTechnology(technology), HttpStatus.CREATED);
	}
}
