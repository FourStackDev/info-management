package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CustErrCodesAndMsgs {

	@JsonProperty("INFO_400")
	BAD_JSON_REQUEST_CODE("INFO_400"),

	@JsonProperty("Bad Request body Received. Please check")
	BAD_JSON_REQUEST_MSG("Bad Request body Received. Please check"),

	@JsonProperty("INFO_422")
	UNABLE_TO_SAVE_ENTITY_CODE ("INFO_422"),

	@JsonProperty("Unable to persist the entity to Database.")
	UNABLE_TO_SAVE_ENTITY_MSG ("Unable to persist the entity to Database."),

	@JsonProperty("INFO_409")
	UNIQUE_CONSTRAINT_VIOLATION_CODE("INFO_409"),
	
	@JsonProperty("Unique Constraint Violation occurred. Please check.")
	UNIQUE_CONSTRAINT_VIOLATION_MSG("Unique Constraint Violation occurred. Please check.");
	
	private String message;
	
	private CustErrCodesAndMsgs(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
