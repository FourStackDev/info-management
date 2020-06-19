package org.fourstack.infomanagement.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.codetype.Proficiency;
import org.fourstack.infomanagement.models.ProfessionalSkill;
import org.fourstack.infomanagement.repositories.ProfessionalSkillRepository;
import org.fourstack.infomanagement.services.ProfessionalSkillService;
import org.fourstack.infomanagement.services.ProfessionalSkillServiceImpl;
import org.fourstack.infomanagement.utils.CommonUtils;
import org.fourstack.infomanagement.utils.EntityGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit TestCase Class used to Test the {@link ProfessionalSkillService}. Test
 * class will mock the {@link ProfessionalSkillRepository} and mock results will
 * be returned while invoking the Repository methods.
 * 
 * @author Manjunath HM
 *
 */
@Slf4j
public class ProfessionalSkillServiceTest {

	@Mock
	private ProfessionalSkillRepository professionalSkillRepository;

	@InjectMocks
	private ProfessionalSkillServiceImpl professionalSkillService;

	@BeforeEach
	public void doInitialization() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_getProfessionalSkills() {
		// get professionalSkills List
		List<ProfessionalSkill> mockProfessionalSkillList = EntityGenerator.getProfessionalSkillList();

		// mock the respository
		when(professionalSkillRepository.findAll()).thenReturn(mockProfessionalSkillList);

		// call the service method
		List<ProfessionalSkill> professionalSkills = professionalSkillService.getProfessionalSkills();

		// verify the result
		assertEquals(mockProfessionalSkillList, professionalSkills);
		assertEquals(mockProfessionalSkillList.size(), professionalSkills.size());
	}

	@Test
	public void test_getProfessionalSkillById() {
		Long skillId = CommonUtils.getRandomLong();
		ProfessionalSkill mockProfessionalSkill = EntityGenerator.getProfessionalSkill(skillId);
		// mock the repository
		when(professionalSkillRepository.findById(skillId)).thenReturn(Optional.of(mockProfessionalSkill));

		// call the service method
		ProfessionalSkill actualProfessionalSkill = professionalSkillService.getProfessionalSkillById(skillId);

		// verify the result
		assertEquals(mockProfessionalSkill.getId(), actualProfessionalSkill.getId());
		assertEquals(mockProfessionalSkill.getName(), actualProfessionalSkill.getName());
		assertEquals(mockProfessionalSkill.getProficiency(), actualProfessionalSkill.getProficiency());
		assertEquals(mockProfessionalSkill, actualProfessionalSkill);
	}

	@Test
	public void test_saveProfessionalSkill() {
		ProfessionalSkill mockProfessionalSkill = EntityGenerator.getProfessionalSkill("Angular", Proficiency.BEGINNER);

		// mock the repository
		when(professionalSkillRepository.save(mockProfessionalSkill)).thenReturn(mockProfessionalSkill);

		// call the service method
		ProfessionalSkill savedProfessionalSkill = professionalSkillService
				.saveProfessionalSkill(mockProfessionalSkill);
		log.info("Saved ProfessionalSkill: " + savedProfessionalSkill);

		// verify the result
		assertEquals(mockProfessionalSkill.getName(), savedProfessionalSkill.getName());
		assertEquals(mockProfessionalSkill.getProficiency(), savedProfessionalSkill.getProficiency());
		assertEquals(mockProfessionalSkill, savedProfessionalSkill);
	}

	@Test
	public void test_saveAllProfessionalSkills() {
		List<ProfessionalSkill> mockProfessionalSkillList = EntityGenerator.getProfessionalSkillList();

		// mock the Repository
		when(professionalSkillRepository.saveAll(mockProfessionalSkillList)).thenReturn(mockProfessionalSkillList);

		// call the service method
		List<ProfessionalSkill> savedProfessionalSkills = professionalSkillService
				.saveAllProfessionalSkills(mockProfessionalSkillList);

		// verify the results
		assertEquals(mockProfessionalSkillList, savedProfessionalSkills);
		assertEquals(mockProfessionalSkillList.size(), savedProfessionalSkills.size());
	}
}
