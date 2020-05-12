package org.fourstack.infomanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.codetype.CustErrCodesAndMsgs;
import org.fourstack.infomanagement.payload.ErrorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorResponseRepository extends JpaRepository<ErrorResponse, Long> {

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
}
