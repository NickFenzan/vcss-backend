package com.millervein.vcss.hasti;

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
@RequestMapping("/hasti")
public class HASTIController {

	@Autowired
	private HASTIRepository hastiRepo;

	@Autowired
	private HASTIValidator validator;

	@RequestMapping(value = "/submit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HASTI hastiFormSubmission(@Valid @RequestBody HASTI hasti, BindingResult result) {
		validator.validate(hasti, result);
		if(result.hasErrors()){
			throw new ValidationException(result);
		}
		HASTI existingHASTI = hastiRepo.findByPidAndDos(hasti.pid, hasti.dos);
		if (existingHASTI != null) {
			hastiRepo.delete(existingHASTI);
		}
		hastiRepo.saveAndFlush(hasti);
		return hasti;
	}


	@RequestMapping(value = "/{patientId}/{dos}", method = RequestMethod.GET)
	public HASTI getHASTI(@PathVariable String patientId, @PathVariable String dos) throws Exception {
		HASTI hasti = hastiRepo.findByPidAndDos(Integer.valueOf(patientId),
				LocalDate.parse(dos, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		if (hasti == null){
			throw new EntityNotFoundException();
		}else{
			return hasti;
		}
	}



}
