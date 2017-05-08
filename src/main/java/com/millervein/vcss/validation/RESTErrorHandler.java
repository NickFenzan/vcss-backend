package com.millervein.vcss.validation;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RESTErrorHandler {

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO error(ValidationException ex) {
		Errors errors = ex.getErrors();
		ErrorDTO errorDTO = new ErrorDTO();
		for(ObjectError globalError : errors.getGlobalErrors()){
			errorDTO.addGlobalError(globalError.getDefaultMessage());
		}
		for(FieldError fieldError : errors.getFieldErrors()){
			errorDTO.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return errorDTO;
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void entityNotFound(EntityNotFoundException ex){
		
	}
}
