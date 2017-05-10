package com.millervein.vcss.ceap;

import javax.persistence.Embeddable;

@Embeddable
public class Etiology {
	public boolean c;
	public boolean p;
	public boolean s;

	public String getScore() {
		String out = "E";
		if (c) {
			out += "c,";
		}
		if (p) {
			out += "p,";
		}
		if (s) {
			out += "s,";
		}
		if(out.charAt(out.length()-1) == ','){
			out = out.substring(0, out.length() - 1);
		}
		return out;
	}
}
