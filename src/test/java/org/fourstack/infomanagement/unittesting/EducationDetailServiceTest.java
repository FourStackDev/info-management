package org.fourstack.infomanagement.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.fourstack.infomanagement.models.EducationDetail;
import org.fourstack.infomanagement.repositories.EducationDetailRepository;
import org.fourstack.infomanagement.services.EducationDetailService;
import org.fourstack.infomanagement.services.EducationDetailServiceImpl;
import org.fourstack.infomanagement.utils.EntityGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit TestCase Class used to Test the {@link EducationDetailService}.
 * 
 * @author Manjunath HM
 *
 */
@Slf4j
public class EducationDetailServiceTest {

	@Mock
	private EducationDetailRepository educationDetailRepository;

	@InjectMocks
	private EducationDetailServiceImpl educationDetailService;

	@BeforeEach
	public void doInitialization() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_getEducationalDetailsList() {
		List<EducationDetail> mockEducationDetailList = EntityGenerator.getEducationDetailList();
		// mock the Repository call
		when(educationDetailRepository.findAll()).thenReturn(mockEducationDetailList);

		// call the service layer
		List<EducationDetail> educationalDetailsList = educationDetailService.getEducationalDetailsList();

		// verify the results
		assertEquals(mockEducationDetailList.size(), educationalDetailsList.size());
		assertEquals(mockEducationDetailList, educationalDetailsList);
	}

	@Test
	public void test_saveEducationDetail() {
		EducationDetail educationDetail = EntityGenerator.getEducationDetail();
		// mock the repository
		when(educationDetailRepository.save(educationDetail)).thenReturn(educationDetail);

		// call the service layer
		EducationDetail savedEducationDetail = educationDetailService.saveEducationDetail(educationDetail);
		log.info("Saved EducationDetail: "+savedEducationDetail);

		// verify the results
		assertEquals(educationDetail.getCollgeName(), savedEducationDetail.getCollgeName());
		assertEquals(educationDetail.getCourseName(), savedEducationDetail.getCourseName());
		assertEquals(educationDetail.getCourseType(), savedEducationDetail.getCourseType());
		assertEquals(educationDetail.getPassOutYear(), savedEducationDetail.getPassOutYear());
		assertEquals(educationDetail.getUniversityName(), savedEducationDetail.getUniversityName());
		assertEquals(educationDetail, savedEducationDetail);
	}

	@Test
	public void test_saveAllEducationDetails() {
		List<EducationDetail> educationDetailList = EntityGenerator.getEducationDetailList();
		// mock the repository
		when(educationDetailRepository.saveAll(educationDetailList)).thenReturn(educationDetailList);

		// call the Service layer
		List<EducationDetail> savedEducationDetailList = educationDetailService
				.saveAllEducationDetails(educationDetailList);

		// verify the result
		assertEquals(educationDetailList, savedEducationDetailList);
		assertEquals(educationDetailList.size(), savedEducationDetailList.size());
	}
}
