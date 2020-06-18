package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.ProfessionalSkill;

public interface ProfessionalSkillService {

	public List<ProfessionalSkill> getProfessionalSkills();

	public ProfessionalSkill getProfessionalSkillById(Long id);

	public ProfessionalSkill saveProfessionalSkill(ProfessionalSkill professionalSkill);

	public List<ProfessionalSkill> saveAllProfessionalSkills(List<ProfessionalSkill> professionalSkills);
}
