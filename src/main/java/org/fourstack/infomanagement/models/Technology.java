package org.fourstack.infomanagement.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Technology implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5157408858732324079L;

	private Long id;

	@JsonProperty(value = "technology_name")
	private String name;

	@JsonProperty(value = "technology_version")
	private String version;

	/**
	 * No argument Constructor
	 */
	public Technology() {
	}

	/**
	 * Parameterized Constructor to initialize the Technology Object
	 * 
	 * @param name
	 * @param version
	 */
	public Technology(String name, String version) {
		super();
		this.name = name;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Technology [name=" + name + ", version=" + version + "]";
	}
}
