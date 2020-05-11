package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.EducationDetail;

public interface EducationDetailService {
	
	public List<EducationDetail> getEducationalDetailsList();
	
	public EducationDetail saveEducationDetail(EducationDetail educationDetail);
	
	public List<EducationDetail> saveAllEducationDetails(List<EducationDetail> educationDetailList);
}
