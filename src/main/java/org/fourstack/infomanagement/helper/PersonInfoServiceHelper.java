package org.fourstack.infomanagement.helper;

import static org.fourstack.infomanagement.constants.AppConstants.DEFAULT_OFFSET;
import static org.fourstack.infomanagement.constants.AppConstants.DEFAULT_PAGE;

import java.util.List;

import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.payload.PersonRequestPayload;
import org.fourstack.infomanagement.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Helper class to fetch the {@link Person} objects based on the
 * {@link PersonRequestPayload}. <br/>
 * 
 * <p>
 * {@link Person} Objects will be fetched based on the parameters defined in the
 * {@link PersonRequestPayload} Object.
 * </p>
 * 
 * @author Manjunath_HM
 *
 */
@Component
public class PersonInfoServiceHelper {

	@Autowired
	private PersonService personService;

	/**
	 * To retrieve the {@link List} of {@link Person} Objects by using the
	 * {@link PersonRequestPayload}. Based on the parameters present in the
	 * {@link PersonRequestPayload} the results will be fetched.
	 * 
	 * <p>
	 * {@link Pageable} acts as the input to fetch Results with specified number of
	 * offset from the page specified
	 * </p>
	 * 
	 * @param payload  PersonRequestPayload with parameters to fetch the Results
	 * @param pageable Pageable Object
	 * @return List of Person Objects
	 */
	public List<Person> getPersonsList(PersonRequestPayload payload, Pageable pageable) {
		
		String firstName = payload.getFirstName();
		String lastName = payload.getLastName();
		GenderType gender = payload.getGender();
		MaritalStatus maritalStatus = payload.getMaritalStatus();
		
		List<Person> personList;
		
		
		if (firstName != null) {
			if (lastName == null && gender == null && maritalStatus != null) {
				// Person list by firstName and marital Status (1001)
				personList = getPersonListByFirstnameAndMaritalStatus(firstName, maritalStatus, pageable);
				
			} else if (lastName == null && gender != null && maritalStatus == null) {
				// Person list by firstName and gender (1010)
				personList = getPersonListByFirstnameAndGender(firstName, gender, pageable);
				
			} else if (lastName == null && gender != null && maritalStatus != null) {
				// Person list by firstName, gender and marital status (1011)
				personList = getPersonListByFirstnameAndGenderAndMaritalStatus(firstName, gender, maritalStatus, pageable);
				
			} else if (lastName != null && gender == null && maritalStatus == null) {
				// Person list by firstName and lastname (1100)
				personList = getPersonListByFirstnameAndLastname(firstName, lastName, pageable);
				
			} else if (lastName != null && gender == null && maritalStatus != null) {
				// Person list by firstName, lastname and marital status (1101)
				personList = getPersonListByFirstnameAndLastnameAndMaritalStatus(firstName, lastName, maritalStatus, pageable);
				
			} else if (lastName != null && gender != null && maritalStatus == null) {
				// Person list by firstName, lastname and gender (1110)
				personList = getPersonListByFirstnameAndLastnameAndGender(firstName, lastName, gender, pageable);
				
			} else if (lastName != null && gender != null && maritalStatus != null) {
				// Person list by firstName, lastname, gender and marital status (1111)
				personList = getPersonListByFirstnameAndLastnameAndGenderAndMaritalStatus(firstName, lastName, gender, maritalStatus, pageable);
				
			} else {
				// Person list by first name (1000)
				personList = getPersonListByFirstname(firstName, pageable);
				
			}
		} else {
			if (lastName == null && gender == null && maritalStatus != null) {
				// Person list by marital status (0001)
				personList = getPersonListByMaritalStatus(maritalStatus, pageable);
				
			} else if (lastName == null && gender != null && maritalStatus == null) {
				// Person list by gender (0010)
				personList = getPersonListByGender(gender, pageable);
				
			} else if (lastName == null && gender != null && maritalStatus != null) {
				// Person list by gender and marital status (0011)
				personList = getPersonListByGenderAndMaritalStatus(gender, maritalStatus, pageable);
				
			} else if (lastName != null && gender == null && maritalStatus == null) {
				// Person list by lastname (0100)
				personList = getPersonListByLastName(lastName, pageable);
				
			} else if (lastName != null && gender == null && maritalStatus != null) {
				// Person list by lastname and marital status (0101)
				personList = getPersonListByLastnameAndMaritalStatus(lastName, maritalStatus, pageable);
				
			} else if (lastName != null && gender != null && maritalStatus == null) {
				// Person list by lastname and gender (0110)
				personList = getPersonListByLastnameAndGender(lastName, gender, pageable);
				
			} else if (lastName != null && gender != null && maritalStatus != null) {
				// Person list by lastname, gender and marital status (0111)
				personList = getPersonListByLastnameAndGenderAndMaritalStatus(lastName, gender, maritalStatus, pageable);
				
			} else {
				// without condition (0000)
				personList = personService.getPersons(pageable).getContent();
			}
		}

		return personList;
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects by using the
	 * {@link PersonRequestPayload}. Based on the parameters present in the
	 * {@link PersonRequestPayload} the results will be fetched.
	 * 
	 * 
	 * <p>
	 * {@link Pageable} will be constructed from the payload parameters (pageNumber
	 * and pageOffset)
	 * </p>
	 * 
	 * @param payload PersonRequestPayload with parameters to fetch the Results
	 * @return List of Person Objects
	 */
	public List<Person> getPersonsList(PersonRequestPayload payload) {
		Pageable pageable = PageRequest.of(payload.getPageNumber() != 0 ? payload.getPageNumber() : DEFAULT_PAGE,
				payload.getPageOffset() != 0 ? payload.getPageOffset() : DEFAULT_OFFSET);
		return getPersonsList(payload, pageable);
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on First
	 * name.<br/>
	 * This method will be used when the payload object contains only First name
	 * <p>
	 * This method internally call the service method from the {@link PersonService}
	 * to fetch the results.
	 * </p>
	 * 
	 * @param firstName First Name
	 * @param pageable  {@link Pageable} Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByFirstname(String firstName, Pageable pageable) {
		Page<Person> optionalPage = personService.getPersonByFirstName(firstName, pageable);
		return optionalPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on Last
	 * name.<br/>
	 * This method will be used when the payload object contains only Last name
	 * <p>
	 * This method internally call the service method from the {@link PersonService}
	 * to fetch the results.
	 * </p>
	 * 
	 * @param lastName Last Name
	 * @param pageable {@link Pageable} Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByLastName(String lastName, Pageable pageable) {
		Page<Person> optionalPage = personService.getPersonByLastName(lastName, pageable);
		return optionalPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on Gender.<br/>
	 * 
	 * @param gender   Gender Type
	 * @param pageable {@link Pageable} Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByGender(GenderType gender, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByGender(gender, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on Marital
	 * Status.<br/>
	 * 
	 * @param maritalStatus Marital Status
	 * @param pageable      {@link Pageable} Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByMaritalStatus(MaritalStatus maritalStatus, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByMaritalStatus(maritalStatus, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on First name
	 * and Last name.<br/>
	 * This method will be used when the payload object contains First name and Last
	 * name parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param firstName First Name
	 * @param lastName  Last Name
	 * @param pageable  {@link Pageable} Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByFirstnameAndLastname(String firstName, String lastName, Pageable pageable) {
		Page<Person> personPage = personService.getPersonsByFirstnameAndLastName(firstName, lastName, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on First name
	 * and Marital Status.<br/>
	 * This method will be used when the payload object contains First name and
	 * Marital Status parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param firstName     First name
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByFirstnameAndMaritalStatus(String firstName, MaritalStatus maritalStatus,
			Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByFirstnameAndMaritalStatus(firstName, maritalStatus,
				pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on First name
	 * and Gender.<br/>
	 * This method will be used when the payload object contains First name and
	 * Gender parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param firstName First name
	 * @param gender    Gender
	 * @param pageable  Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByFirstnameAndGender(String firstName, GenderType gender, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByFirstnameAndGender(firstName, gender, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on First name,
	 * Gender and Marital Status.<br/>
	 * This method will be used when the payload object contains First name, Gender
	 * and Marital Status parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param firstName     First name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByFirstnameAndGenderAndMaritalStatus(String firstName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByFirstnameAndGenderAndMaritalStatus(firstName, gender,
				maritalStatus, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on First name,
	 * Last name and Marital Status.<br/>
	 * This method will be used when the payload object contains First name, Last
	 * name and Marital Status parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param firstName     First name
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByFirstnameAndLastnameAndMaritalStatus(String firstName, String lastName,
			MaritalStatus maritalStatus, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByFirstnameAndLastnameAndMaritalStatus(firstName, lastName,
				maritalStatus, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on First name,
	 * Last name and Gender.<br/>
	 * This method will be used when the payload object contains First name, Last
	 * name and Gender parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param firstName First name
	 * @param lastName  Last name
	 * @param gender    Gender
	 * @param pageable  Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByFirstnameAndLastnameAndGender(String firstName, String lastName,
			GenderType gender, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByFirstnameAndLastnameAndGender(firstName, lastName,
				gender, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on Gender and
	 * Marital Status<br/>
	 * This method will be used when the payload object contains Gender and Marital
	 * Status parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param gender        Gender Type
	 * @param maritalStatus Marital Status
	 * @param pageable      pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByGenderAndMaritalStatus(GenderType gender, MaritalStatus maritalStatus,
			Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByGenderAndMaritalStatus(gender, maritalStatus, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on Last name and
	 * Marital Status<br/>
	 * This method will be used when the payload object contains Last name and
	 * Marital Status parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param lastName      Last name
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByLastnameAndMaritalStatus(String lastName, MaritalStatus maritalStatus,
			Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByLastnameAndMaritalStatus(lastName, maritalStatus,
				pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on Last name and
	 * Gender<br/>
	 * This method will be used when the payload object contains Last name and
	 * Gender parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param lastName Last name
	 * @param gender   Gender Type
	 * @param pageable Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByLastnameAndGender(String lastName, GenderType gender, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByLastnameAndGender(lastName, gender, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on Last name,
	 * Gender and Marital Status<br/>
	 * This method will be used when the payload object contains Last name, Gender
	 * and Marital Status parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param lastName      Last name
	 * @param gender        Gender
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByLastnameAndGenderAndMaritalStatus(String lastName, GenderType gender,
			MaritalStatus maritalStatus, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByLastnameAndGenderAndMaritalStatus(lastName, gender,
				maritalStatus, pageable);
		return personPage.getContent();
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on First name,
	 * Last name, Gender and Marital Status<br/>
	 * This method will be used when the payload object contains First name, Last
	 * name, Gender and Marital Status parameters.
	 * <p>
	 * This method internally call the service method from the PersonService to
	 * fetch the results.
	 * </p>
	 * 
	 * @param firstName     First name
	 * @param lastName      Last name
	 * @param gender        Gender Type
	 * @param maritalStatus Marital Status
	 * @param pageable      Pageable Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByFirstnameAndLastnameAndGenderAndMaritalStatus(String firstName, String lastName,
			GenderType gender, MaritalStatus maritalStatus, Pageable pageable) {
		Page<Person> personPage = personService.getPersonListByFirstnameAndLastnameAndGenderAndMaritalStatus(firstName,
				lastName, gender, maritalStatus, pageable);
		return personPage.getContent();
	}
}
