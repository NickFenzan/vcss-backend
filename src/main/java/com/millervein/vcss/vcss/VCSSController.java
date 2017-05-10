package com.millervein.vcss.vcss;

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
@RequestMapping("/vcss")
public class VCSSController {

	@Autowired
	private VCSSRepository vcssRepo;
	
	@Autowired
	private VCSSValidator validator;

	@RequestMapping(value = "/submit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public VCSS vcssFormSubmission(@Valid @RequestBody VCSS vcss, BindingResult result) {
		validator.validate(vcss, result);
		if(result.hasErrors()){
			throw new ValidationException(result);
		}
		VCSS existingVCSS = vcssRepo.findByPidAndDos(vcss.pid, vcss.dos);
		if (existingVCSS != null) {
			vcssRepo.delete(existingVCSS.id);
		}
		vcssRepo.saveAndFlush(vcss);
		return vcss;
	}

	
	@RequestMapping(value = "/{patientId}/{dos}", method = RequestMethod.GET)
	public VCSS getVCSS(@PathVariable String patientId, @PathVariable String dos) throws Exception {
		VCSS vcss = vcssRepo.findByPidAndDos(Integer.valueOf(patientId),
				LocalDate.parse(dos, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		if (vcss == null){
			throw new EntityNotFoundException();
		}else{
			return vcss;
		}
	}

	
	
}
