package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.WorkExperience;

public interface WorkExperienceService {
	
	public List<WorkExperience> getAllWorkExperience();
	
	public WorkExperience getWorkExperienceById(Long id);
	
	public WorkExperience saveWorkExperience(WorkExperience workExperience);
}
