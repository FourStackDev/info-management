package org.fourstack.infomanagement.exceptionhandling;

/**
 * Class <b><i>RequestedEntityNotFoundException</i></b> is a child class of
 * RuntimeException, which is used throw the exception when the requested
 * Entities are not found.
 * 
 * @author Manjunath_HM
 *
 */
public class RequestedEntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 327949806059495285L;

	/**
	 * 
	 */
	public RequestedEntityNotFoundException() {
		super();
	}

	/**
	 * @param message Exception Message
	 * @param cause   Root Cause for the exception
	 */
	public RequestedEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message Exception Message
	 */
	public RequestedEntityNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause Root Cause for the exception
	 */
	public RequestedEntityNotFoundException(Throwable cause) {
		super(cause);
	}
}
