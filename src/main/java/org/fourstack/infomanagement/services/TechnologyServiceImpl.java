package org.fourstack.infomanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.fourstack.infomanagement.models.Technology;
import org.fourstack.infomanagement.repositories.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyServiceImpl implements TechnologyService {
	
	@Autowired
	private TechnologyRepository technologyRepository;
	
	@Override
	public List<Technology> getAllTechnologies() {
		return technologyRepository.findAll();
	}

	@Override
	public Technology getTechnologyById(Long id) {
		Optional<Technology> optional = technologyRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Technology saveTechnology(Technology technology) {
		Technology technology2 = findTechnologyByNameAndVersion(technology);
		if (technology2 != null)
			return technologyRepository.save(technology2);
		
		return technologyRepository.save(technology);
	}
	
	@Override
	public Technology findTechnologyByNameAndVersion(Technology technology) {
		Optional<Technology> technology2 = technologyRepository.findByNameAndVersion(technology.getName(), technology.getVersion());
		return technology2.isPresent() ? technology2.get() : null;
	}

	@Override
	public List<Technology> saveTechnologiesBasedOnNameAndVersion(List<Technology> technologies) {
		List<Technology> updatedTechnologies = new ArrayList<>();
		updatedTechnologies = technologies.stream()
										  .map(technology -> saveTechnology(technology))
										  .collect(Collectors.toList());
		return updatedTechnologies;
	}
}
