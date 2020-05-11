package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.ProfessionalInfo;
import org.fourstack.infomanagement.repositories.ProfessionalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalInfoServiceImpl implements ProfessionalInfoService {
	
	@Autowired
	private ProfessionalInfoRepository professionalInfoRepository;

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
		return professionalInfoRepository.save(professionalInfo);
	}

}
