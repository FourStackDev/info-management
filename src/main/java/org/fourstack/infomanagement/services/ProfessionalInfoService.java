package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.ProfessionalInfo;

public interface ProfessionalInfoService {
	
	public List<ProfessionalInfo> getProfesionalInfoList();
	
	public ProfessionalInfo getProfessionalInfoById(long id);
	
	public ProfessionalInfo saveProfessionalInfo(ProfessionalInfo professionalInfo);
}
