package com.example.tennis.exception;

/**
 * General exception which can be thrown by application
 */
public class BusinessException extends Exception {

	public BusinessException(String message) {
		super(message);
	}

}
