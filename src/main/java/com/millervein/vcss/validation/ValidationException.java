package com.millervein.vcss.validation;

import org.springframework.validation.Errors;

@SuppressWarnings("serial")
public class ValidationException extends RuntimeException {
	private Errors errors;

	public ValidationException(Errors errors) {
		super("Validation Exception on object " + errors.getObjectName());
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}
	
	
}
