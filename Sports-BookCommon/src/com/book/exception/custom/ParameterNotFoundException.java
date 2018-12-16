package com.book.exception.custom;

public class ParameterNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 658020533328852196L;

	public ParameterNotFoundException() {
		super();
	}

	public ParameterNotFoundException(String message) {
		super(message);
	}

	public ParameterNotFoundException(Throwable cause) {
		super(cause);
	}

	public ParameterNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
