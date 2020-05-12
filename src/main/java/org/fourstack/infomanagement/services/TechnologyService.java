package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.Technology;

public interface TechnologyService {
	
	public List<Technology> getAllTechnologies();
	
	public Technology getTechnologyById(Long id);
	
	public Technology saveTechnology(Technology technology);
	
	public List<Technology> saveTechnologiesBasedOnNameAndVersion(List<Technology> technologies);

	public Technology findTechnologyByNameAndVersion(Technology technology);
}
