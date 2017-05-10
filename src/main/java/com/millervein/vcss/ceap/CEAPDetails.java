package com.millervein.vcss.ceap;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class CEAPDetails {
	@Embedded
	public ClinicalFindings c;
	@Embedded
	public Etiology e;
	@Embedded
	public AnatomicFindings a;
	@Embedded
	public PathophysiologicFindings p;

	public ClinicalFindings getC() {
		return c;
	}

	public Etiology getE() {
		return e;
	}

	public AnatomicFindings getA() {
		return a;
	}

	public PathophysiologicFindings getP() {
		return p;
	}
	
	public String getScore(){
		if(c != null && e!= null && a!= null && p != null){
			return c.getScore() + e.getScore() + a.getScore() + p.getScore();
		}
		return null;
	}

}
