package com.millervein.vcss.ceap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.millervein.vcss.validation.ValidationException;

@RestController
@RequestMapping("/ceap")
public class CEAPController {

	@Autowired
	private CEAPRepository ceapRepo;

	@Autowired
	private CEAPValidator validator;

	@RequestMapping(value = "/submit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CEAP ceapFormSubmission(@Valid @RequestBody CEAP ceap, BindingResult result) {
		validator.validate(ceap, result);
		if(result.hasErrors()){
			throw new ValidationException(result);
		}
		CEAP existingCEAP = ceapRepo.findByPidAndDos(ceap.pid, ceap.dos);
		if (existingCEAP != null) {
			ceapRepo.delete(existingCEAP);
		}
		ceapRepo.saveAndFlush(ceap);
		return ceap;
	}


	@RequestMapping(value = "/{patientId}/{dos}", method = RequestMethod.GET)
	public CEAP getCEAP(@PathVariable String patientId, @PathVariable String dos) throws Exception {
		CEAP ceap = ceapRepo.findByPidAndDos(Integer.valueOf(patientId),
				LocalDate.parse(dos, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		if (ceap == null){
			throw new EntityNotFoundException();
		}else{
			return ceap;
		}
	}



}
