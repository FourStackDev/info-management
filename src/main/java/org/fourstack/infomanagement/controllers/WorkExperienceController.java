package org.fourstack.infomanagement.controllers;

import java.util.List;

import org.fourstack.infomanagement.annotations.BasePath;
import org.fourstack.infomanagement.models.WorkExperience;
import org.fourstack.infomanagement.services.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePath
public class WorkExperienceController {
	
	@Autowired
	private WorkExperienceService service;
	
	@GetMapping("/workExps")
	public ResponseEntity<List<WorkExperience>> getWorkExperienceList() {
		return new ResponseEntity<List<WorkExperience>>(service.getAllWorkExperience(), HttpStatus.OK);
	}
	
	@PostMapping("/workExps")
	public ResponseEntity<WorkExperience> saveWorkExperience(@RequestBody WorkExperience workExperience) {
		return new ResponseEntity<WorkExperience>(service.saveWorkExperience(workExperience), HttpStatus.CREATED);
	}
}
