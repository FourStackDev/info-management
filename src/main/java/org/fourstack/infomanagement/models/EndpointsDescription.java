package org.fourstack.infomanagement.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EndpointsDescription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5721101075901998730L;

	@JsonProperty(value = "method_type")
	private String _method;
	
	@JsonProperty(value = "end_uri")
	private String _uri;
	
	@JsonProperty(value = "method_description")
	private String _description;

	/**
	 * No argument Constructor
	 */
	public EndpointsDescription() {
	}

	/**
	 * Parameterized Constructor to initialize the EndpointsDescription Object
	 * 
	 * @param _method
	 * @param _uri
	 * @param _description
	 */
	public EndpointsDescription(String _method, String _uri, String _description) {
		super();
		this._method = _method;
		this._uri = _uri;
		this._description = _description;
	}

	public String get_method() {
		return _method;
	}

	public void set_method(String _method) {
		this._method = _method;
	}

	public String get_uri() {
		return _uri;
	}

	public void set_uri(String _uri) {
		this._uri = _uri;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}
}
