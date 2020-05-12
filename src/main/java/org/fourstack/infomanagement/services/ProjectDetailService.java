package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.ProjectDetail;

public interface ProjectDetailService {
	
	public List<ProjectDetail> getAllProjectDetails();
	
	public ProjectDetail getProjectDetailById(Long id);
	
	public ProjectDetail saveProjectDetail(ProjectDetail projectDetail);
}
