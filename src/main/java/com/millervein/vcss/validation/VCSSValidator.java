package com.millervein.vcss.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.millervein.vcss.core.VCSS;
import com.millervein.vcss.core.VCSSSymptoms;

@Component
public class VCSSValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return VCSS.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		VCSS v = (VCSS) target;
		validatePID(v, errors);
		validateDOS(v, errors);
		validateVcssLeg("right", v.right, errors);
		validateVcssLeg("left", v.left, errors);
	}

	private void validateVcssLeg(String side, VCSSSymptoms symptoms, Errors errors) {
		validateVcssSymptomValue(side + ".activeUlcerDuration", symptoms.activeUlcerDuration, errors);
		validateVcssSymptomValue(side + ".activeUlcerNumber", symptoms.activeUlcerNumber, errors);
		validateVcssSymptomValue(side + ".activeUlcerSize", symptoms.activeUlcerSize, errors);
		validateVcssSymptomValue(side + ".induration", symptoms.induration, errors);
		validateVcssSymptomValue(side + ".inflammation", symptoms.inflammation, errors);
		validateVcssSymptomValue(side + ".pain", symptoms.pain, errors);
		validateVcssSymptomValue(side + ".skinPigmentation", symptoms.skinPigmentation, errors);
		validateVcssSymptomValue(side + ".useOfCompressionTherapy", symptoms.useOfCompressionTherapy, errors);
		validateVcssSymptomValue(side + ".varicoseVeins", symptoms.varicoseVeins, errors);
		validateVcssSymptomValue(side + ".venousEdema", symptoms.venousEdema, errors);
		validateUlcerValues(side, symptoms, errors);

	}

	private void validatePID(VCSS v, Errors errors) {
		if (v.pid == null || v.pid < 1) {
			errors.rejectValue("pid", "pid.missing", "Patient ID is missing/invalid");
		}
	}

	private void validateDOS(VCSS v, Errors errors) {
		if (v.dos == null) {
			errors.rejectValue("dos", "dos.missing", "Date of Service is missing/invalid");
		}
	}

	private void validateVcssSymptomValue(String name, Integer value, Errors errors) {
		if (value == null || value > 3 || value < 0) {
			errors.rejectValue(name, "vcss.symptom.badvalue", "Value must be present and between 0 and 3");
		}
	}

	private void validateUlcerValues(String side, VCSSSymptoms symptoms, Errors errors) {
		if (symptoms.activeUlcerNumber == 0) {
			if (symptoms.activeUlcerSize > 0) {
				errors.rejectValue(side + ".activeUlcerSize", "vcss.symptom.noulcersize",
						"Cannot have an active ulcer size with an active ulcer count of 0");
			}
			if (symptoms.activeUlcerDuration > 0) {
				errors.rejectValue(side + ".activeUlcerDuration", "vcss.symptom.noulcerduration",
						"Cannot have an active ulcer duration with an active ulcer count of 0");
			}
		}
		if (symptoms.activeUlcerNumber > 0){
			if (symptoms.activeUlcerSize == 0) {
				errors.rejectValue(side + ".activeUlcerSize", "vcss.symptom.ulcersize",
						"Cannot have an active ulcer size of 0 with an active ulcer count greater than 0");
			}
			if (symptoms.activeUlcerDuration == 0) {
				errors.rejectValue(side + ".activeUlcerDuration", "vcss.symptom.ulcerduration",
						"Cannot have an active ulcer duration of 0 with an active ulcer count greater than 0");
			}
		}
	}

}
