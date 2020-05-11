package org.fourstack.infomanagement.services;

import java.util.List;

import org.fourstack.infomanagement.models.EducationDetail;
import org.fourstack.infomanagement.repositories.EducationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDetailServiceImpl implements EducationDetailService {
	
	@Autowired
	private EducationDetailRepository educationRepository;

	@Override
	public List<EducationDetail> getEducationalDetailsList() {
		return educationRepository.findAll();
	}

	@Override
	public EducationDetail saveEducationDetail(EducationDetail educationDetail) {
		return educationRepository.save(educationDetail);
	}

	@Override
	public List<EducationDetail> saveAllEducationDetails(List<EducationDetail> educationDetailList) {
		return educationRepository.saveAll(educationDetailList);
	}

}
