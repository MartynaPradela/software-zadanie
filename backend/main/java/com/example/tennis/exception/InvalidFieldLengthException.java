package com.example.tennis.exception;

public class InvalidFieldLengthException extends InvalidDataException {

	public InvalidFieldLengthException(int minLength) {
		super("Invalid field length, the min length is: " + minLength);
	}

}
