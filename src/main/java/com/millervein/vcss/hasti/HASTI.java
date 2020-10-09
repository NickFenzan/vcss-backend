package com.millervein.vcss.hasti;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class HASTI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "native", strategy = "native")
	public Integer id;
	public Integer pid;
	public LocalDate dos;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "right_id", referencedColumnName = "id", nullable = false)
	public HASTISymptoms right;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "left_id", referencedColumnName = "id", nullable = false)
    public HASTISymptoms left;

    @Override
	public String toString() {
		return "HASTI [id=" + id + ", pid=" + pid + ", dos=" + dos + ", right=" + right + ", left=" + left + "]";
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

	public HASTISymptoms getRight() {
		return right;
	}

	public HASTISymptoms getLeft() {
		return left;
	}
}