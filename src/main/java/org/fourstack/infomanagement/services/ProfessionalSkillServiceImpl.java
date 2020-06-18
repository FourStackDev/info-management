package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.ProfessionalSkill;
import org.fourstack.infomanagement.repositories.ProfessionalSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalSkillServiceImpl implements ProfessionalSkillService {

	@Autowired
	private ProfessionalSkillRepository professionalSkillRepository;

	@Override
	public List<ProfessionalSkill> getProfessionalSkills() {
		return professionalSkillRepository.findAll();
	}

	@Override
	public ProfessionalSkill getProfessionalSkillById(Long id) {
		Optional<ProfessionalSkill> option = professionalSkillRepository.findById(id);

		return option.isPresent() ? option.get() : null;
	}

	@Override
	public ProfessionalSkill saveProfessionalSkill(ProfessionalSkill professionalSkill) {
		return professionalSkillRepository.save(professionalSkill);
	}

	@Override
	public List<ProfessionalSkill> saveAllProfessionalSkills(List<ProfessionalSkill> professionalSkills) {
		return professionalSkillRepository.saveAll(professionalSkills);
	}

}
