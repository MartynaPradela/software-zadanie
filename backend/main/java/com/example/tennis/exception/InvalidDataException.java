package com.example.tennis.exception;

/**
 * May be thrown when object, which is being validated, is invalid
 */
public class InvalidDataException extends BusinessException {

	public InvalidDataException(String message) {
		super(message);
	}

}
