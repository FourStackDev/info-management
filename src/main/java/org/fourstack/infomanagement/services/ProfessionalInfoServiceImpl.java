package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.fourstack.infomanagement.models.ProfessionalInfo;
import org.fourstack.infomanagement.models.WorkExperience;
import org.fourstack.infomanagement.repositories.ProfessionalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalInfoServiceImpl implements ProfessionalInfoService {
	
	@Autowired
	private ProfessionalInfoRepository professionalInfoRepository;
	
	@Autowired
	private WorkExperienceService workExperienceService;

	@Override
	public List<ProfessionalInfo> getProfesionalInfoList() {
		return professionalInfoRepository.findAll();
	}

	@Override
	public ProfessionalInfo getProfessionalInfoById(long id) {
		Optional<ProfessionalInfo> optionInfo= professionalInfoRepository.findById(id);
		return optionInfo.isPresent() ? optionInfo.get() : null;
	}

	@Override
	public ProfessionalInfo saveProfessionalInfo(ProfessionalInfo professionalInfo) {
		List<WorkExperience> workExperiences = professionalInfo.getWorkExperiences();
		
		workExperiences = workExperiences.stream()
					   .map(workExp -> workExperienceService.saveWorkExperience(workExp))
					   .collect(Collectors.toList());
		
		professionalInfo.getWorkExperiences().clear();
		professionalInfo.getWorkExperiences().addAll(workExperiences);
		return professionalInfoRepository.save(professionalInfo);
	}

}
