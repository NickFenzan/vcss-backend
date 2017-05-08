package com.millervein.vcss.validation;

import java.util.ArrayList;
import java.util.List;



public class ErrorDTO {
	private List<String> globalErrors = new ArrayList<String>();
	private List<FieldErrorDTO> fieldErrors = new ArrayList<FieldErrorDTO>();
	public List<String> getGlobalErrors() {
		return globalErrors;
	}
	
	public void addGlobalError(String error){
		this.globalErrors.add(error);
	}
	public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}
	public void addFieldError(String fieldName, String error) {
		this.fieldErrors.add(new FieldErrorDTO(fieldName, error));
	}
	
}
