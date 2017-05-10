package com.millervein.vcss.vcss;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class VCSS {
	@Id
	@GeneratedValue
	public Integer id;
	public Integer pid;
	public LocalDate dos;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "right_id", referencedColumnName = "id", nullable = false)
	public VCSSSymptoms right;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "left_id", referencedColumnName = "id", nullable = false)
	public VCSSSymptoms left;
	
	@Override
	public String toString() {
		return "VCSS [id=" + id + ", pid=" + pid + ", dos=" + dos + ", right=" + right + ", left=" + left + "]";
	}

	public Integer getId() {
		return id;
	}

	public Integer getPid() {
		return pid;
	}

	public LocalDate getDos() {
		return dos;
	}

	public VCSSSymptoms getRight() {
		return right;
	}

	public VCSSSymptoms getLeft() {
		return left;
	}

	
}