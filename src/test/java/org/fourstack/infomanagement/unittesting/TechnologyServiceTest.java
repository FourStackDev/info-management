package org.fourstack.infomanagement.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.Technology;
import org.fourstack.infomanagement.repositories.TechnologyRepository;
import org.fourstack.infomanagement.services.TechnologyService;
import org.fourstack.infomanagement.services.TechnologyServiceImpl;
import org.fourstack.infomanagement.utils.CommonUtils;
import org.fourstack.infomanagement.utils.EntityGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit TestCase Class used to Test the {@link TechnologyService}. Test class
 * will mock the {@link TechnologyRepository} and mock results will be returned
 * while invoking the Repository methods.
 * 
 * @author Manjunath HM
 *
 */
public class TechnologyServiceTest {
	@Mock
	private TechnologyRepository technologyRepository;

	@InjectMocks
	private TechnologyServiceImpl technologyService;

	@BeforeEach
	public void doInitialization() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_getAllTechnologies() {
		List<Technology> mockTechnologyList = EntityGenerator.getTechnologyList();

		// mock the repository
		when(technologyRepository.findAll()).thenReturn(mockTechnologyList);

		// call the service method
		List<Technology> technologyList = technologyService.getAllTechnologies();

		// verify the results
		assertEquals(mockTechnologyList.size(), technologyList.size());
		assertEquals(mockTechnologyList, technologyList);
	}

	@Test
	public void test_getTechnologyById() {
		long id = CommonUtils.getRandomLong();
		Technology mockTechnology = EntityGenerator.getTechnology(id);

		// mock the repository layer
		when(technologyRepository.findById(id)).thenReturn(Optional.of(mockTechnology));

		// call the service layer method
		Technology technology = technologyService.getTechnologyById(id);

		// verify the results
		assertEquals(mockTechnology.getId(), technology.getId());
		assertEquals(mockTechnology.getName(), technology.getName());
		assertEquals(mockTechnology.getVersion(), technology.getVersion());
		assertEquals(mockTechnology, technology);
	}

	@Test
	public void test_saveTechnology() {
		Technology mockTechnology = EntityGenerator.getTechnology();

		// mock the Repository Layer
		when(technologyRepository.save(mockTechnology)).thenReturn(mockTechnology);

		// call the Service layer method
		Technology savedTechnology = technologyService.saveTechnology(mockTechnology);

		// verify the results
		assertEquals(mockTechnology.getName(), savedTechnology.getName());
		assertEquals(mockTechnology.getVersion(), savedTechnology.getVersion());
		assertEquals(mockTechnology, savedTechnology);
	}

	@Test
	public void test_findTechnologyByNameAndVersion() {
		Technology mockTechnology = EntityGenerator.getTechnology();

		// mock the repository Layer
		when(technologyRepository.findByNameAndVersion(mockTechnology.getName(), mockTechnology.getVersion()))
				.thenReturn(Optional.of(mockTechnology));

		// call the service layer method
		Technology technology = technologyService.findTechnologyByNameAndVersion(mockTechnology);

		// verify the results
		assertEquals(mockTechnology.getName(), technology.getName());
		assertEquals(mockTechnology.getVersion(), technology.getVersion());
		assertEquals(mockTechnology, technology);
	}

	@Test
	public void test_saveTechnologiesBasedOnNameAndVersion() {
		List<Technology> mockTechnologyList = EntityGenerator.getTechnologyList();

		// mock the repository Layer
		mockTechnologyList.stream().forEach(mockTechnology -> {
			when(technologyRepository.findByNameAndVersion(mockTechnology.getName(), mockTechnology.getVersion()))
					.thenReturn(Optional.of(mockTechnology));

			when(technologyRepository.save(mockTechnology)).thenReturn(mockTechnologyList.get(0),
					mockTechnologyList.get(1), mockTechnologyList.get(2), mockTechnologyList.get(3),
					mockTechnologyList.get(4));
		});

		List<Technology> savedTechnologies = technologyService
				.saveTechnologiesBasedOnNameAndVersion(mockTechnologyList);

		assertEquals(mockTechnologyList.size(), savedTechnologies.size());
	}
}
