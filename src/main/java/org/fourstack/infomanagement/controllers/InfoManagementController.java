package org.fourstack.infomanagement.controllers;

import java.time.LocalDate;
import java.util.Arrays;

import org.fourstack.infomanagement.annotations.BasePath;
import org.fourstack.infomanagement.codetype.CourseType;
import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;
import org.fourstack.infomanagement.codetype.Proficiency;
import org.fourstack.infomanagement.models.Address;
import org.fourstack.infomanagement.models.ContactInfo;
import org.fourstack.infomanagement.models.EducationDetail;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.models.ProfessionalInfo;
import org.fourstack.infomanagement.models.ProfessionalSkill;
import org.fourstack.infomanagement.models.WorkExperience;
import org.fourstack.infomanagement.payload.PersonalProfessionalInfoPayload;
import org.fourstack.infomanagement.services.PersonalProfessionalInfoMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePath
public class InfoManagementController {
	
	@Autowired
	private PersonalProfessionalInfoMapService infoMapService;
	
	@GetMapping("/info-payload")
	public PersonalProfessionalInfoPayload getSampleResponse() {
		return getResponsePayload();
	}
	
	@PostMapping("/info-payload")
	public PersonalProfessionalInfoPayload saveInfoPayload(@RequestBody(required = false) PersonalProfessionalInfoPayload payload) {
		return infoMapService.savePayload(payload);
	}
	
	@PutMapping("/info-payload/{id}")
	public PersonalProfessionalInfoPayload updateInfoPayload(@RequestBody PersonalProfessionalInfoPayload payload) {
		return infoMapService.savePayload(payload);
	}
	
	private PersonalProfessionalInfoPayload getResponsePayload() {
		Person person = new Person();
		person.setFirstName("Manjunath");
		person.setLastName("HM");
		person.setDateOfBirth(LocalDate.of(1992, 2, 10));
		person.setGender(GenderType.MALE);
		person.setMaritalStatus(MaritalStatus.SINGLE);
		person.setContactInfo(new ContactInfo("9590788100", null, "manjunathcs052@gmail.com"));
		person.setAddress(new Address("#101", "Renuka Residency", "B Narayanapura", "Bengaluru South", "Bengaluru", "Karnataka", "India", "560016"));
		
		
		ProfessionalInfo profession = new ProfessionalInfo();
		profession.setTotalExperience(48);
		profession.setRelevantExperience(12);
		profession.setCurrentOrganization("UST");
		profession.setDesignation("Senior Software Engineeer");
		profession.setEducationalDetails(Arrays.asList(new EducationDetail("VTU", "Dr. AIT", "CSE", "2015", CourseType.FULL_TIME)));
		profession.setProfessionalSkills(Arrays.asList(new ProfessionalSkill("Java", Proficiency.PROFICIENT), new ProfessionalSkill("Spring boot", Proficiency.PROFICIENT)));
		profession.setWorkExperiences(Arrays.asList(new WorkExperience("UST", LocalDate.of(2019, 06, 03), null, true)));
		
		PersonalProfessionalInfoPayload payload = new PersonalProfessionalInfoPayload(person, profession);
		return payload;
	}
}
