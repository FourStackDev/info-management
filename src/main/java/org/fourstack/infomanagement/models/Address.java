package org.fourstack.infomanagement.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class <b><i>Address</i></b> is an Entity model of the application.<br/>
 * It is a sub entity for the Person Entity. This entity stores the address of
 * the Person Object
 * 
 * @author Manjunath_HM
 *
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -688044435676223483L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "door_num")
	@JsonProperty(value = "door_number")
	private String doorNo;

	@Column(name = "address_line1", columnDefinition = "TEXT")
	@JsonProperty(value = "addressLine1")
	private String addressLine1;

	@Column(name = "address_line2", columnDefinition = "TEXT")
	@JsonProperty(value = "addressLine2")
	private String addressLine2;

	@Column(name = "ditrict")
	@JsonProperty(value = "ditrict")
	private String district;

	@Column(name = "state")
	@JsonProperty(value = "state")
	private String state;

	@Column(name = "country")
	@JsonProperty(value = "country")
	private String country;

	@Column(name = "pincode")
	@JsonProperty(value = "pincode")
	private String pincode;

	/**
	 * No argument Constructor. It is needed for the JPA transactions
	 */
	public Address() {
	}

	/**
	 * Parameterized constructor to initialize the Address Object
	 * 
	 * @param doorNo       door number
	 * @param addressLine1 To specify the street, cross, main road details
	 * @param addressLine2 To specify the area of locality, taluk, etc..
	 * @param district     District name
	 * @param state        State name
	 * @param country      Country name
	 * @param pincode      pincode of the address
	 */
	public Address(String doorNo, String addressLine1, String addressLine2, String district, String state,
			String country, String pincode) {
		super();
		this.doorNo = doorNo;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.district = district;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", district=" + district + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}

}
