package com.millervein.vcss.ceap;

import javax.persistence.Embeddable;

@Embeddable
public class PathophysiologicFindings {
	public boolean r;
	public boolean o;
	public boolean n;
	
	public String getScore() {
		String out = "P";
		if(n){
			out += "n";
		}else{
			if (r) {
				out += "r,";
			}
			if (o) {
				out += "o,";
			}
		}
		
		if(out.charAt(out.length()-1) == ','){
			out = out.substring(0, out.length() - 1);
		}
		return out;
	}
}
