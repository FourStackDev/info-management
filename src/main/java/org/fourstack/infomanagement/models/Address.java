package org.fourstack.infomanagement.models;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -688044435676223483L;

	private Long id;
	private String doorNo;
	private String addressLine1;
	private String addressLine2;
	private String district;
	private String state;
	private String country;
	private String pincode;

	/**
	 * No argument Constructor. It is needed for the JPA transactions
	 */
	public Address() {
	}

	/**
	 * Parameterized constructor to initialize the Address Object
	 * 
	 * @param doorNo
	 * @param addressLine1
	 * @param addressLine2
	 * @param district
	 * @param state
	 * @param country
	 * @param pincode
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
