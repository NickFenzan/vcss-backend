package com.millervein.vcss.ceap;

import javax.persistence.Embeddable;

@Embeddable
public class AnatomicFindings {
	public boolean s;
	public boolean p;
	public boolean d;
	
	public String getScore() {
		String out = "A";
		if (s) {
			out += "s,";
		}
		if (p) {
			out += "p,";
		}
		if (d) {
			out += "d,";
		}
		if(out.charAt(out.length()-1) == ','){
			out = out.substring(0, out.length() - 1);
		}
		return out;
	}
}
