package com.mathapp.exceptions;

public class InvalidFunctionModeException extends Exception {
	
	private static final long serialVersionUID = -1230655453588436526L;
	
	public InvalidFunctionModeException() {
		super();
	}

	public InvalidFunctionModeException(String message) {
		super(message);
	}
}
