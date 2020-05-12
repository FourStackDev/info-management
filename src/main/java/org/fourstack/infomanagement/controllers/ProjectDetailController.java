package org.fourstack.infomanagement.controllers;

import java.util.List;

import org.fourstack.infomanagement.annotations.BasePath;
import org.fourstack.infomanagement.models.ProjectDetail;
import org.fourstack.infomanagement.services.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePath
public class ProjectDetailController {
	
	@Autowired
	private ProjectDetailService service;
	
	@GetMapping("/projects")
	public ResponseEntity<List<ProjectDetail>> getAllProjectDetails() {
		return new ResponseEntity<List<ProjectDetail>>(service.getAllProjectDetails(), HttpStatus.OK);
	}
	
	@PostMapping("/projects")
	public ResponseEntity<ProjectDetail> saveProjectDetail(@RequestBody ProjectDetail projectDetail) {
		return new ResponseEntity<ProjectDetail>(service.saveProjectDetail(projectDetail), HttpStatus.CREATED);
	}
}
