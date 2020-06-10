package org.fourstack.infomanagement.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.fourstack.infomanagement.codetype.CourseType;
import org.fourstack.infomanagement.codetype.FluencyType;
import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;
import org.fourstack.infomanagement.codetype.Proficiency;
import org.fourstack.infomanagement.models.Address;
import org.fourstack.infomanagement.models.ContactInfo;
import org.fourstack.infomanagement.models.EducationDetail;
import org.fourstack.infomanagement.models.Language;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.models.ProfessionalSkill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility Class which is used to generate the Entities that are required for
 * the test cases.
 * <p>
 * Single Entities required for the Test case are generated by JavaCode, but the
 * list of entities will be generated by using the ObjectMapper
 * </p>
 * 
 * @author Manjunath HM
 *
 */
public class EntityGenerator {
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}

	/**
	 * Generates and returns the Language entity for the specified Id. Language
	 * Object generated by this method will have id attached to it.
	 * 
	 * @param id Unique id(Long value) for the Object
	 * @return Language object.
	 */
	public static Language getLanguage(Long id) {
		Language language = getLanguage();
		language.setId(id);
		return language;
	}

	/**
	 * Generates and returns the Language entity without an id.
	 * 
	 * @return Language Object without id
	 */
	public static Language getLanguage() {
		Language language = new Language("Kannada", Proficiency.EXPERT,
				Arrays.asList(FluencyType.SPEAK, FluencyType.READ, FluencyType.WRITE));
		return language;
	}

	/**
	 * Generates and returns list of language Objects. The Objects will be generated
	 * from the json file by using the Jackson Object mapper.<br/>
	 * If json file is missing or the content inside the file is matching with the
	 * Language object then this method generates an Exception.
	 * 
	 * @return List of Language Objects
	 */
	public static List<Language> getLanguageList() {
		Language[] languages = {};
		try {
			languages = mapper.readValue(CommonUtils.getFileContent("json-files/language-list.json"), Language[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return Arrays.asList(languages);
	}

	/**
	 * Generates and returns the Address entity without an id.
	 * 
	 * @return Address Object without id.
	 */
	public static Address getAddress() {
		Address address = new Address();
		address.setDoorNo("#154");
		address.setAddressLine1("3rd cross, 15th main");
		address.setAddressLine2("Malleswaram");
		address.setTaluk("Bengaluru North");
		address.setDistrict("Bengaluru");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPincode("560003");
		return address;
	}

	/**
	 * Generates and returns the Address entity for the specified Id. Address Object
	 * generated by this method will have id attached to it.
	 * 
	 * @param id Unique id(Long value) for the Object
	 * @return Address Object
	 */
	public static Address getAddress(Long id) {
		Address address = getAddress();
		address.setId(id);
		return address;
	}

	/**
	 * Generates and returns list of Address Objects. The Objects will be generated
	 * from the json file by using the Jackson Object mapper.<br/>
	 * If json file is missing or the content inside the file is matching with the
	 * Address object then this method generates an Exception.
	 * 
	 * @return List of Address Objects
	 */
	public static List<Address> getAddressList() {
		Address[] addresses = {};
		try {
			addresses = mapper.readValue(CommonUtils.getFileContent("json-files/address-list.json"), Address[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Arrays.asList(addresses);
	}

	public static ContactInfo getContactInfo() {
		ContactInfo contactInfo = new ContactInfo("9876543210", "8769541239", "contact-need@gmail.com");
		return contactInfo;
	}

	public static ContactInfo getContactInfo(Long id) {
		ContactInfo contactInfo = getContactInfo();
		contactInfo.setId(id);
		return contactInfo;
	}

	public static List<ContactInfo> getContactInfoList() {
		ContactInfo[] contacts = {};
		try {
			contacts = mapper.readValue(CommonUtils.getFileContent("json-files/contact-info-list.json"),
					ContactInfo[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Arrays.asList(contacts);
	}

	public static Person getPerson() {
		Person person = new Person();
		person.setFirstName("Manjunath");
		person.setLastName("HM");
		person.setDateOfBirth(LocalDate.of(1992, 02, 10));
		person.setFatherName("Munikrishnappa");
		person.setMotherName("Jayalakshmamma");
		person.setGender(GenderType.MALE);
		person.setMaritalStatus(MaritalStatus.SEPATARED);
		person.setAddress(getAddress());
		person.setContactInfo(getContactInfo());
		person.setLanguages(getLanguageList());

		return person;
	}

	public static Person getPerson(Long id) {
		Person person = getPerson();
		person.setId(id);

		return person;
	}

	public static List<Person> getPersonList() {
		Person[] persons = {};
		try {
			persons = mapper.readValue(CommonUtils.getFileContent("json-files/person-info-list.json"), Person[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return Arrays.asList(persons);
	}

	public static EducationDetail getEducationDetail() {
		EducationDetail education = new EducationDetail();
		education.setCourseName("B.E");
		education.setCollgeName("Dr. Ambedkar Institute of Technology");
		education.setCourseType(CourseType.FULL_TIME);
		education.setPassOutYear("2015");
		education.setUniversityName("VTU(Visvesvaraya Technological University)");

		return education;
	}

	public static EducationDetail getEducationDetail(Long id) {
		EducationDetail education = getEducationDetail();
		education.setId(id);
		return education;
	}

	public static List<EducationDetail> getEducationDetailList() {
		EducationDetail[] educationList = {};
		try {
			educationList = mapper.readValue(CommonUtils.getFileContent("json-files/education-details-list.json"),
					EducationDetail[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return Arrays.asList(educationList);
	}

	public static ProfessionalSkill getProfessionalSkill() {
		ProfessionalSkill skill = new ProfessionalSkill();
		skill.setName("Java");
		skill.setProficiency(Proficiency.PROFICIENT);

		return skill;
	}

	public static ProfessionalSkill getProfessionalSkill(Long id) {
		ProfessionalSkill skill = getProfessionalSkill();
		skill.setId(id);
		return skill;
	}

	public static List<ProfessionalSkill> getProfessionalSkillList() {
		ProfessionalSkill[] skills = {};
		try {
			skills = mapper.readValue(CommonUtils.getFileContent("json-files/professional-skills-list.json"),
					ProfessionalSkill[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return Arrays.asList(skills);
	}
}
