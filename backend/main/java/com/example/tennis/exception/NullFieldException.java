package com.example.tennis.exception;

/**
 * May be thrown, when value expect to be non-null, but it's null
 */
public class NullFieldException extends InvalidDataException {

	public NullFieldException(String field) {
		super("The required field is null: " + field);
	}

}
