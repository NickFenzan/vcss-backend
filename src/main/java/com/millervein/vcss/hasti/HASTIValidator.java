package com.millervein.vcss.hasti;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class HASTIValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return HASTI.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		HASTI v = (HASTI) target;
		validatePID(v, errors);
		validateDOS(v, errors);
		validateHastiLeg("right", v.right, errors);
		validateHastiLeg("left", v.left, errors);
	}

	private void validateHastiLeg(String side, HASTISymptoms symptoms, Errors errors) {
		validateHastiSymptomValue(side + ".heaviness", symptoms.heaviness, errors);
		validateHastiSymptomValue(side + ".aching", symptoms.aching, errors);
		validateHastiSymptomValue(side + ".swelling", symptoms.swelling, errors);
		validateHastiSymptomValue(side + ".throbbing", symptoms.throbbing, errors);
		validateHastiSymptomValue(side + ".itching", symptoms.itching, errors);
	}

	private void validatePID(HASTI v, Errors errors) {
		if (v.pid == null || v.pid < 1) {
			errors.rejectValue("pid", "pid.missing", "Patient ID is missing/invalid");
		}
	}

	private void validateDOS(HASTI v, Errors errors) {
		if (v.dos == null) {
			errors.rejectValue("dos", "dos.missing", "Date of Service is missing/invalid");
		}
	}

	private void validateHastiSymptomValue(String name, Integer value, Errors errors) {
		if (value == null || value > 5 || value < 0) {
			errors.rejectValue(name, "hasti.symptom.badvalue", "Value must be present and between 0 and 5");
		}
	}

}
