package org.fourstack.infomanagement.controllers;

import java.util.List;

import org.fourstack.infomanagement.annotations.BasePath;
import org.fourstack.infomanagement.models.ProfessionalInfo;
import org.fourstack.infomanagement.services.ProfessionalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePath
public class ProfessionalInfoController {
	
	@Autowired
	private ProfessionalInfoService professionalInfoService;
	
	@GetMapping("/professions")
	public ResponseEntity<List<ProfessionalInfo>> getProfessionalInfoList() {
		return new ResponseEntity<List<ProfessionalInfo>>(professionalInfoService.getProfesionalInfoList(), HttpStatus.OK);
	}
	
	@PostMapping("/professions")
	public ResponseEntity<ProfessionalInfo> addProfessionalInfo(@RequestBody ProfessionalInfo professionalInfo) {
		return new ResponseEntity<ProfessionalInfo>(professionalInfoService.saveProfessionalInfo(professionalInfo), HttpStatus.CREATED);
	}
}
