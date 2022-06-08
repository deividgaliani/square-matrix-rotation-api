package com.example.squarematrixrotationapi.exceptions;

public class InvalidMatrixException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Permitido apenas matriz quadrada";

	public InvalidMatrixException() {
		super(MSG);
	}
	
}
