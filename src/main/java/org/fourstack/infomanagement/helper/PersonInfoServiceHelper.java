package org.fourstack.infomanagement.helper;

import static org.fourstack.infomanagement.constants.AppConstants.DEFAULT_PAGE;
import static org.fourstack.infomanagement.constants.AppConstants.DEFAULT_OFFSET;

import java.util.List;

import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;
import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.payload.PersonRequestPayload;
import org.fourstack.infomanagement.services.PersonService;
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

		return null;
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
		return null;
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
		return null;
	}

	/**
	 * To retrieve the {@link List} of {@link Person} Objects based on Gender.<br/>
	 * 
	 * @param gender   Gender Type
	 * @param pageable {@link Pageable} Object
	 * @return List of Person Objects
	 */
	private List<Person> getPersonListByGender(GenderType gender, Pageable pageable) {
		return null;
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
		return null;
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
		return null;
	}

}
