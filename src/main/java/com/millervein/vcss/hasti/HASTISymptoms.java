package com.millervein.vcss.hasti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class HASTISymptoms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "native", strategy = "native")
	public Integer id;
	public Integer heaviness;
	public Integer aching;
	public Integer swelling;
	public Integer throbbing;
	public Integer itching;

	@JsonProperty
	public int totalScore() {
		return heaviness + aching + swelling + throbbing + itching;
	}

	public Integer getId() {
		return id;
	}

    public Integer getHeaviness() {
        return this.heaviness;
    }

    public Integer getAching() {
        return this.aching;
    }

    public Integer getSwelling() {
        return this.swelling;
    }

    public Integer getThrobbing() {
        return this.throbbing;
    }

    public Integer getItching() {
        return this.itching;
    }
    
}
