package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.codetype.CustErrCodesAndMsgs;
import org.fourstack.infomanagement.payload.ErrorResponse;
import org.fourstack.infomanagement.repositories.ErrorResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ErrorResponseServiceImpl implements ErrorResponseService {
	
	@Autowired
	private ErrorResponseRepository errorRepository;
	
	@Override
	public Optional<List<ErrorResponse>> findByCustomErrorCode(CustErrCodesAndMsgs customErrorCode) {
		return errorRepository.findByCustomErrorCode(customErrorCode);
	}

	@Override
	public Optional<List<ErrorResponse>> findByCustomErrorMsg(CustErrCodesAndMsgs customErrorMsg) {
		return errorRepository.findByCustomErrorMsg(customErrorMsg);
	}

	@Override
	public Optional<List<ErrorResponse>> findByErrorCode(int errorCode) {
		return errorRepository.findByErrorCode(errorCode);
	}

	@Override
	public Optional<Page<ErrorResponse>> findByErrorCode(int errorCode, Pageable pageable) {
		return errorRepository.findByErrorCode(errorCode, pageable);
	}

	@Override
	public List<ErrorResponse> getAllErrorResponses() {
		return errorRepository.findAll();
	}

	@Override
	public Page<ErrorResponse> getPageOfErrorResponses(Pageable pageable) {
		return errorRepository.findAll(pageable);
	}

	@Override
	public ErrorResponse saveErrorResponse(ErrorResponse errorResponse) {
		return errorRepository.save(errorResponse);
	}
}
