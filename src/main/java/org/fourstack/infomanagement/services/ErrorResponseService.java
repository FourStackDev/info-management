package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.codetype.CustErrCodesAndMsgs;
import org.fourstack.infomanagement.payload.ErrorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ErrorResponseService {
	/**
	 * Retrieve the ErrorResponse based on the custom error code
	 * 
	 * @param customErrorCode Custom Error Code for retrieval
	 * @return Optional Container having List of ErrorResponse objects
	 */
	public Optional<List<ErrorResponse>> findByCustomErrorCode(CustErrCodesAndMsgs customErrorCode);

	/**
	 * Retrieve the ErrorResponse based on the custom error message
	 * 
	 * @param customErrorMsg Custom Error Message for retrieval
	 * @return Optional Container having List of ErrorResponse objects
	 */
	public Optional<List<ErrorResponse>> findByCustomErrorMsg(CustErrCodesAndMsgs customErrorMsg);

	/**
	 * Retrieve the ErrorResponse based on the error code
	 * 
	 * @param errorCode Error code for retrieval
	 * @return Optional Container having List of ErrorResponse objects
	 */
	public Optional<List<ErrorResponse>> findByErrorCode(int errorCode);

	/**
	 * Retrieve the ErrorResponse based on the error code
	 * 
	 * @param errorCode Error code for retrieval
	 * @param pageable  Pageable object
	 * @return Optional Container having Page of ErrorResponse objects
	 */
	public Optional<Page<ErrorResponse>> findByErrorCode(int errorCode, Pageable pageable);

	/**
	 * Retrieve list of Error responses.
	 * 
	 * @return List of Error Response objects
	 */
	public List<ErrorResponse> getAllErrorResponses();

	/**
	 * Retrieve page of Error Responses.
	 * 
	 * @param pageable Pageable Object
	 * @return Page of ErrorResponses.
	 */
	public Page<ErrorResponse> getPageOfErrorResponses(Pageable pageable);

	/**
	 * Save ErrorResponse to the database
	 * 
	 * @param errorResponse ErrorResponse Object
	 * @return Saved ErrorResponse Object
	 */
	public ErrorResponse saveErrorResponse(ErrorResponse errorResponse);
}
