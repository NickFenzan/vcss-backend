package com.millervein.vcss.ceap;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CEAP {
	@Id
	@GeneratedValue
	public Integer id;
	public Integer pid;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	public LocalDate dos;
	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name="c.c0",column=@Column(name="right_c0")),
	    @AttributeOverride(name="c.c1",column=@Column(name="right_c1")),
	    @AttributeOverride(name="c.c2",column=@Column(name="right_c2")),
	    @AttributeOverride(name="c.c3",column=@Column(name="right_c3")),
	    @AttributeOverride(name="c.c4a",column=@Column(name="right_c4a")),
	    @AttributeOverride(name="c.c4b",column=@Column(name="right_c4b")),
	    @AttributeOverride(name="c.c5",column=@Column(name="right_c5")),
	    @AttributeOverride(name="c.c6",column=@Column(name="right_c6")),
	    @AttributeOverride(name="c.s",column=@Column(name="right_cs")),
	    @AttributeOverride(name="e.c",column=@Column(name="right_ec")),
	    @AttributeOverride(name="e.p",column=@Column(name="right_ep")),
	    @AttributeOverride(name="e.s",column=@Column(name="right_es")),
	    @AttributeOverride(name="a.s",column=@Column(name="right_as")),
	    @AttributeOverride(name="a.p",column=@Column(name="right_ap")),
	    @AttributeOverride(name="a.d",column=@Column(name="right_ad")),
	    @AttributeOverride(name="p.r",column=@Column(name="right_pr")),
	    @AttributeOverride(name="p.o",column=@Column(name="right_po")),
	    @AttributeOverride(name="p.n",column=@Column(name="right_pn"))
	  })
	public CEAPDetails right;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="c.c0",column=@Column(name="left_c0")),
	    @AttributeOverride(name="c.c1",column=@Column(name="left_c1")),
	    @AttributeOverride(name="c.c2",column=@Column(name="left_c2")),
	    @AttributeOverride(name="c.c3",column=@Column(name="left_c3")),
	    @AttributeOverride(name="c.c4a",column=@Column(name="left_c4a")),
	    @AttributeOverride(name="c.c4b",column=@Column(name="left_c4b")),
	    @AttributeOverride(name="c.c5",column=@Column(name="left_c5")),
	    @AttributeOverride(name="c.c6",column=@Column(name="left_c6")),
	    @AttributeOverride(name="c.s",column=@Column(name="left_cs")),
	    @AttributeOverride(name="e.c",column=@Column(name="left_ec")),
	    @AttributeOverride(name="e.p",column=@Column(name="left_ep")),
	    @AttributeOverride(name="e.s",column=@Column(name="left_es")),
	    @AttributeOverride(name="a.s",column=@Column(name="left_as")),
	    @AttributeOverride(name="a.p",column=@Column(name="left_ap")),
	    @AttributeOverride(name="a.d",column=@Column(name="left_ad")),
	    @AttributeOverride(name="p.r",column=@Column(name="left_pr")),
	    @AttributeOverride(name="p.o",column=@Column(name="left_po")),
	    @AttributeOverride(name="p.n",column=@Column(name="left_pn"))
	  })
	public CEAPDetails left;
	public Integer getId() {
		return id;
	}
	public Integer getPid() {
		return pid;
	}
	public LocalDate getDos() {
		return dos;
	}
	public CEAPDetails getRight() {
		return right;
	}
	public CEAPDetails getLeft() {
		return left;
	}
	
}
