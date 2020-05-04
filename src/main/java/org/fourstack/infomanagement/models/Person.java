package org.fourstack.infomanagement.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4900756725622318846L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String fatherName;
	private String motherName;
	private boolean maritalStatus;

	@OneToOne
	private ContactInfo contactInfo;

	@OneToOne
	private Address address;

	/**
	 * No argument Constructor. It is needed for the JPA transactions
	 */
	public Person() {
	}

	/**
	 * Parameterized Constructor to initialize the Person Object.
	 * 
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param dateOfBirth
	 * @param gender
	 * @param fatherName
	 * @param motherName
	 * @param maritalStatus
	 */
	public Person(String firstName, String middleName, String lastName, LocalDate dateOfBirth, String gender,
			String fatherName, String motherName, boolean maritalStatus) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.maritalStatus = maritalStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public boolean isMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", maritalStatus=" + maritalStatus + ", contactInfo=" + contactInfo + ", address="
				+ address + "]";
	}
}
