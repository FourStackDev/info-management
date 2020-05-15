package org.fourstack.infomanagement.codetype;

import org.fourstack.infomanagement.exceptionhandling.InfoManagementExceptionHandler;
import org.fourstack.infomanagement.payload.ErrorResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum {@code CustErrCodesAndMsgs} defines the Custom Error Codes and Messages
 * related to the application. Whenever the Exceptions handled by using
 * {@link InfoManagementExceptionHandler}, then the Custom Error codes and
 * Messages are used to produce {@link ErrorResponse} and sent to the client for
 * better understanding of Exceptions occurred in the application.
 * 
 * @author Manjunath HM
 *
 */
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
	UNIQUE_CONSTRAINT_VIOLATION_MSG("Unique Constraint Violation occurred. Please check."),
	
	@JsonProperty("INFO_404")
	REQUESTED_ENTITY_NOT_FOUND_CODE("INFO_404"),
	
	@JsonProperty("Requested Entity Not Found")
	REQUESTED_ENTITY_NOT_FOUND_MSG("Requested Entity Not Found");
	
	private String message;
	
	private CustErrCodesAndMsgs(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
