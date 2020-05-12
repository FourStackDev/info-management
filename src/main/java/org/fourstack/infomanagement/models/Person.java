package org.fourstack.infomanagement.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.fourstack.infomanagement.codetype.GenderType;
import org.fourstack.infomanagement.codetype.MaritalStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class <b><i>Person</i></b> is an Entity Model of the Application.<br/>
 * It stores the Person Object information and also manages the Sub
 * models(Address, ContactInfo, Language) information
 * 
 * @author Manjunath_HM
 *
 */
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

	@Column(name = "firstname", nullable = false)
	@JsonProperty(value = "first_name")
	private String firstName;

	@Column(name = "middlename")
	@JsonProperty(value = "middle_name")
	private String middleName;

	@Column(name = "lastname", nullable = false)
	@JsonProperty(value = "last_name")
	private String lastName;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name = "date_of_birth", nullable = false)
	@JsonProperty(value = "birth_date")
	private LocalDate dateOfBirth;

	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "gender")
	private GenderType gender;

	@Column(name = "fathername")
	@JsonProperty(value = "father_name")
	private String fatherName;

	@Column(name = "mothername")
	@JsonProperty(value = "mother_name")
	private String motherName;

	@Column(name = "marital_status")
	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "marital_status")
	private MaritalStatus maritalStatus;

	@OneToOne(fetch = FetchType.EAGER, cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	})
	@JsonProperty(value = "contact_information")
	private ContactInfo contactInfo;

	@OneToOne(fetch = FetchType.EAGER, cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	})
	@JsonProperty(value = "address")
	private Address address;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	}, orphanRemoval = true)
	@JoinColumn(name = "person_id")
	@JsonProperty(value = "languages")
	private List<Language> languages = new ArrayList<>();
	
	/**
	 * createDateTime and updateDateTime columns are used to track the insertion and
	 * updation of Entities at database level
	 */
	@CreationTimestamp
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDateTime createDateTime;
	
	@UpdateTimestamp
	@Column(name = "updated_date", nullable = false, updatable = true)
	private LocalDateTime updateDateTime;

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
	public Person(String firstName, String middleName, String lastName, LocalDate dateOfBirth, GenderType gender,
			String fatherName, String motherName, MaritalStatus maritalStatus) {
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

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
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

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	
	public void setMaritalStatus(MaritalStatus maritalStatus) {
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
	
	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", maritalStatus=" + maritalStatus + ", contactInfo=" + contactInfo + ", address="
				+ address + "]";
	}
}
