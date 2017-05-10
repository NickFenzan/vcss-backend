package com.millervein.vcss.ceap;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CEAPValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CEAP.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CEAP c = (CEAP) target;
		validatePID(c, errors);
		validateDOS(c, errors);
		if(c.right != null){
			validateLeg("right", c.right, errors);
		}
		if(c.left != null){
			validateLeg("left", c.left, errors);
		}
		if(c.right == null && c.left == null){
			errors.reject("ceap.nodata", "At least one leg must be filled out");
		}
	}

	private void validateLeg(String side, CEAPDetails details, Errors errors) {
//		if(!(blankOrNull(details.c) && blankOrNull(details.e) && blankOrNull(details.a) && blankOrNull(details.p))){
//			if(blankOrNull(details.c)){
//				errors.rejectValue(side + ".c", "ceap.details.empty", "C cannot be empty if other fields are filled in");
//			}
//			if(blankOrNull(details.e)){
//				errors.rejectValue(side + ".e", "ceap.details.empty", "E cannot be empty if other fields are filled in");
//			}
//			if(blankOrNull(details.a)){
//				errors.rejectValue(side + ".a", "ceap.details.empty", "A cannot be empty if other fields are filled in");
//			}
//			if(blankOrNull(details.p)){
//				errors.rejectValue(side + ".p", "ceap.details.empty", "P cannot be empty if other fields are filled in");
//			}
//		}
	}
	
	private boolean blankOrNull(String prop){
		return prop == null || prop.isEmpty();
	}

	private void validatePID(CEAP c, Errors errors) {
		if (c.pid == null || c.pid < 1) {
			errors.rejectValue("pid", "pid.missing", "Patient ID is missing/invalid");
		}
	}

	private void validateDOS(CEAP c, Errors errors) {
		if (c.dos == null) {
			errors.rejectValue("dos", "dos.missing", "Date of Service is missing/invalid");
		}
	}

}
