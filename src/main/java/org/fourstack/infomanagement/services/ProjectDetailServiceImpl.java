package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.ProjectDetail;
import org.fourstack.infomanagement.models.Technology;
import org.fourstack.infomanagement.repositories.ProjectDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectDetailServiceImpl implements ProjectDetailService {

	@Autowired
	private ProjectDetailRepository projectDetailRepository;
	
	@Autowired
	private TechnologyService technologyService;
	
	@Override
	public List<ProjectDetail> getAllProjectDetails() {
		return projectDetailRepository.findAll();
	}

	@Override
	public ProjectDetail getProjectDetailById(Long id) {
		Optional<ProjectDetail> optional = projectDetailRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public ProjectDetail saveProjectDetail(ProjectDetail projectDetail) {
		List<Technology> technologies = projectDetail.getTechnologies();
		technologies = technologyService.saveTechnologiesBasedOnNameAndVersion(technologies);
		
		//before adding the technologies, clear the existing list
		projectDetail.getTechnologies().clear();
		projectDetail.getTechnologies().addAll(technologies);
		return projectDetailRepository.save(projectDetail);
	}

}
