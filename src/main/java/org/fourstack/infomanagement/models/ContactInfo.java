package org.fourstack.infomanagement.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class <b><i>ContactInfo</i></b> is an Entity model of the application. <br/>
 * It is a sub entity for the Person Entity. This entity stores the contact
 * information of the Person. It has 2 unique constraint columns (primary
 * Contact number and mailId)
 * 
 * @author Manjunath_HM
 *
 */
@Entity
@Table(name = "contact_info", uniqueConstraints = { @UniqueConstraint(columnNames = "primary_contact_number"),
		@UniqueConstraint(columnNames = "mailId") })
public class ContactInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -914363100778675068L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "primary_contact_number")
	@JsonProperty(value = "prim_contact_num")
	private String primaryContactNum;

	@Column(name = "secondary_contact_number")
	@JsonProperty(value = "sec_contact_num")
	private String secondaryContactNum;

	@Column(name = "mailId")
	@JsonProperty(value = "mail_id")
	private String mailId;

	/**
	 * No argument Constructor. It is needed for the JPA transactions
	 */
	public ContactInfo() {
	}

	/**
	 * @param primaryContactNum
	 * @param secondaryContactNum
	 * @param mailId
	 */
	public ContactInfo(String primaryContactNum, String secondaryContactNum, String mailId) {
		super();
		this.primaryContactNum = primaryContactNum;
		this.secondaryContactNum = secondaryContactNum;
		this.mailId = mailId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimaryContactNum() {
		return primaryContactNum;
	}

	public void setPrimaryContactNum(String primaryContactNum) {
		this.primaryContactNum = primaryContactNum;
	}

	public String getSecondaryContactNum() {
		return secondaryContactNum;
	}

	public void setSecondaryContactNum(String secondaryContactNum) {
		this.secondaryContactNum = secondaryContactNum;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "ContactInfo [primaryContactNum=" + primaryContactNum + ", secondaryContactNum=" + secondaryContactNum
				+ ", mailId=" + mailId + "]";
	}
}
