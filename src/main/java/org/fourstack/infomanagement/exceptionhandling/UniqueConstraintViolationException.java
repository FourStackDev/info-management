package org.fourstack.infomanagement.exceptionhandling;

/**
 * Exception class to handle the Bad Request Body Coming into the application.
 * Bad Request may be unproper JSON.
 * 
 * @author Manjunath_HM
 *
 */
public class UniqueConstraintViolationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5261702155883901996L;
	
	private String custErrorMsg;

	public UniqueConstraintViolationException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UniqueConstraintViolationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UniqueConstraintViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UniqueConstraintViolationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UniqueConstraintViolationException(Throwable cause) {
		super(cause);
	}
	
	public UniqueConstraintViolationException(String custErrorMsg, String message, Throwable cause) {
		this(message, cause);
		this.custErrorMsg = custErrorMsg;
	}

	public String getCustErrorMsg() {
		return custErrorMsg;
	}

	public void setCustErrorMsg(String custErrorMsg) {
		this.custErrorMsg = custErrorMsg;
	}
}
