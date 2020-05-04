package org.fourstack.infomanagement.models;

import java.io.Serializable;

public class ContactInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -914363100778675068L;

	private Long id;
	private String primaryContactNum;
	private String secondaryContactNum;
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
		return "ContactInfo [primaryContactNum=" + primaryContactNum + ", secondaryContactNum="
				+ secondaryContactNum + ", mailId=" + mailId + "]";
	}
}
