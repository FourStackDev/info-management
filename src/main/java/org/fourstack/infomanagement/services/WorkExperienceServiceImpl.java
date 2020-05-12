package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.fourstack.infomanagement.models.ProjectDetail;
import org.fourstack.infomanagement.models.WorkExperience;
import org.fourstack.infomanagement.repositories.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {
	
	@Autowired
	private WorkExperienceRepository workExperienceRepository;
	
	@Autowired
	private ProjectDetailService projectDetailService;
	
	@Override
	public List<WorkExperience> getAllWorkExperience() {
		return workExperienceRepository.findAll();
	}

	@Override
	public WorkExperience getWorkExperienceById(Long id) {
		Optional<WorkExperience> optional = workExperienceRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public WorkExperience saveWorkExperience(WorkExperience workExperience) {
		List<ProjectDetail> projects = workExperience.getProjects();
		
		List<ProjectDetail> updatedProjects = projects.stream()
													  .map(project -> projectDetailService.saveProjectDetail(project))
													  .collect(Collectors.toList());
		
		workExperience.getProjects().clear();
		workExperience.getProjects().addAll(updatedProjects);
		return workExperienceRepository.save(workExperience);
	}

}
