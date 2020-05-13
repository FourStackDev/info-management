package org.fourstack.infomanagement.payload;

import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class <b><i>PersonRequestPayload</i></b> is used to get the request payload
 * from the clients. Based on the parameters populated in the payload the
 * Objects will be filtered and sent back to the Clients.
 * 
 * @author Manjunath_HM
 *
 */
public class PersonRequestPayload {
	@JsonProperty(value = "first_name")
	private String firstName;
	
	@JsonProperty(value = "last_name")
	private String lastName;
	
	@JsonProperty(value = "gender")
	private GenderType gender;
	
	@JsonProperty(value = "marital_status")
	private MaritalStatus maritalStatus;
	
	@JsonProperty(value = "prim_contact_num")
	private String primaryContactNumber;
	
	@JsonProperty(value = "mail_id")
	private String mailId;
	
	@JsonProperty(value = "state")
	private String state;
	
	@JsonProperty(value = "country")
	private String country;
	
	@JsonProperty(value = "pincode")
	private String pincode;
	
	public PersonRequestPayload() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param maritalStatus
	 * @param primaryContactNumber
	 * @param mailId
	 * @param state
	 * @param country
	 * @param pincode
	 */
	public PersonRequestPayload(String firstName, String lastName, GenderType gender, MaritalStatus maritalStatus,
			String primaryContactNumber, String mailId, String state, String country, String pincode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.primaryContactNumber = primaryContactNumber;
		this.mailId = mailId;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
