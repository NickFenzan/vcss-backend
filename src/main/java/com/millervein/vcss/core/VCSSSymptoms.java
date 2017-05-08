package com.millervein.vcss.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class VCSSSymptoms {
	@Id
	@GeneratedValue
	public Integer id;
	public Integer pain;
	public Integer varicoseVeins;
	public Integer venousEdema;
	public Integer skinPigmentation;
	public Integer inflammation;
	public Integer induration;
	public Integer activeUlcerNumber;
	public Integer activeUlcerDuration;
	public Integer activeUlcerSize;
	public Integer useOfCompressionTherapy;

	@JsonProperty
	public int totalScore() {
		return pain + varicoseVeins + venousEdema + skinPigmentation + inflammation + induration + activeUlcerNumber
				+ activeUlcerDuration + activeUlcerSize + useOfCompressionTherapy;
	}

	public Integer getId() {
		return id;
	}

	public Integer getPain() {
		return pain;
	}

	public Integer getVaricoseVeins() {
		return varicoseVeins;
	}

	public Integer getVenousEdema() {
		return venousEdema;
	}

	public Integer getSkinPigmentation() {
		return skinPigmentation;
	}

	public Integer getInflammation() {
		return inflammation;
	}

	public Integer getInduration() {
		return induration;
	}

	public Integer getActiveUlcerNumber() {
		return activeUlcerNumber;
	}

	public Integer getActiveUlcerDuration() {
		return activeUlcerDuration;
	}

	public Integer getActiveUlcerSize() {
		return activeUlcerSize;
	}

	public Integer getUseOfCompressionTherapy() {
		return useOfCompressionTherapy;
	}
	
	

}