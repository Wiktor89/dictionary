package com.example.transaction.exeption;

public class UserSaveException extends RuntimeException {

	private String message;

	public UserSaveException(String message) {
		super(message);
	}
}
