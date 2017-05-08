package com.millervein.vcss.validation;

public class FieldErrorDTO {
	private String name;
	private String error;
	public FieldErrorDTO(String name, String error) {
		super();
		this.name = name;
		this.error = error;
	}
	public String getName() {
		return name;
	}
	public String getError() {
		return error;
	}
	
}
