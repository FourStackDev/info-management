package org.fourstack.infomanagement.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.ProjectDetail;
import org.fourstack.infomanagement.models.Technology;
import org.fourstack.infomanagement.repositories.ProjectDetailRepository;
import org.fourstack.infomanagement.services.ProjectDetailService;
import org.fourstack.infomanagement.services.ProjectDetailServiceImpl;
import org.fourstack.infomanagement.services.TechnologyService;
import org.fourstack.infomanagement.utils.CommonUtils;
import org.fourstack.infomanagement.utils.EntityGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit TestCase Class used to Test the {@link ProjectDetailService}. Test class
 * will mock the {@link ProjectDetailRepository} and {@link TechnologyService}
 * classes, and then mock results will be returned while invoking the Repository
 * and other Service class methods.
 * 
 * @author Manjunath HM
 *
 */
@Slf4j
public class ProjectDetailServiceTest {

	@Mock
	private ProjectDetailRepository projectDetailRepository;

	@Mock
	private TechnologyService technologyService;

	@InjectMocks
	private ProjectDetailServiceImpl projectDetailService;

	@BeforeEach
	public void doInitialization() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_getAllProjectDetails() {
		List<ProjectDetail> mockProjectDetailList = EntityGenerator.getProjectDetailList();

		// mock the Repository Layer
		when(projectDetailRepository.findAll()).thenReturn(mockProjectDetailList);

		// call the Service layer
		List<ProjectDetail> projectDetailList = projectDetailService.getAllProjectDetails();

		// verify the results
		assertEquals(mockProjectDetailList, projectDetailList);
		assertEquals(mockProjectDetailList.size(), projectDetailList.size());
	}

	@Test
	public void test_getProjectDetailById() {
		long id = CommonUtils.getRandomLong();
		ProjectDetail mockProjectDetail = EntityGenerator.getProjectDetail(id);

		// mock the repository layer
		when(projectDetailRepository.findById(id)).thenReturn(Optional.of(mockProjectDetail));

		// call the service layer
		ProjectDetail projectDetail = projectDetailService.getProjectDetailById(id);

		// verify the results
		assertEquals(mockProjectDetail.getId(), projectDetail.getId());
		assertEquals(mockProjectDetail.getProjectName(), projectDetail.getProjectName());
		assertEquals(mockProjectDetail.getDescription(), projectDetail.getDescription());
		assertEquals(mockProjectDetail.getStartDate(), projectDetail.getStartDate());
		assertEquals(mockProjectDetail.getEndDate(), projectDetail.getEndDate());
		assertEquals(mockProjectDetail.getTeamSize(), projectDetail.getTeamSize());
		assertEquals(mockProjectDetail.getTechnologies(), projectDetail.getTechnologies());
	}

	@Test
	public void test_saveProjectDetail() {
		ProjectDetail mockProjectDetail = EntityGenerator.getProjectDetail("Project - 1", 5,
				"Senior Software Developer", LocalDate.of(2020, 12, 31), LocalDate.of(2022, 12, 31),
				"To develop Micro Service applications which communicates with other services");

		/*
		 * Create a new ArrayList for Technology. Because the list inside
		 * /mockProjectDetail object is an array(wrapped as List using asList()). Hence
		 * it will throw UnSupportedOperationException while trying to delete the
		 * objects.
		 */
		List<Technology> mockTechnologies = new ArrayList<Technology>(mockProjectDetail.getTechnologies());
		mockProjectDetail.setTechnologies(mockTechnologies);

		// mock the Technology Service and ProjectDetailRepository
		when(technologyService.saveTechnologiesBasedOnNameAndVersion(mockProjectDetail.getTechnologies()))
				.thenReturn(mockProjectDetail.getTechnologies());
		when(projectDetailRepository.save(mockProjectDetail)).thenReturn(mockProjectDetail);

		// call the service layer
		ProjectDetail savedProjectDetail = projectDetailService.saveProjectDetail(mockProjectDetail);
		log.info("Saved ProjectDetail: " + savedProjectDetail);

		// verify the results
		assertEquals(mockProjectDetail.getProjectName(), savedProjectDetail.getProjectName());
		assertEquals(mockProjectDetail.getDescription(), savedProjectDetail.getDescription());
		assertEquals(mockProjectDetail.getStartDate(), savedProjectDetail.getStartDate());
		assertEquals(mockProjectDetail.getEndDate(), savedProjectDetail.getEndDate());
		assertEquals(mockProjectDetail.getTeamSize(), savedProjectDetail.getTeamSize());
		assertEquals(mockProjectDetail.getTechnologies(), savedProjectDetail.getTechnologies());
	}
}
