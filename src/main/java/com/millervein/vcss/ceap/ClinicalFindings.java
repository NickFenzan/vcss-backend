package com.millervein.vcss.ceap;

import javax.persistence.Embeddable;

@Embeddable
public class ClinicalFindings {
	public boolean c0;
	public boolean c1;
	public boolean c2;
	public boolean c3;
	public boolean c4a;
	public boolean c4b;
	public boolean c5;
	public boolean c6;
	public int s;

	public String getScore() {
		String out = "C";
		if(c0){
			out += "0";
		}else{
			if(c1){
				out += "1,";
			}
			if(c2){
				out += "2,";
			}
			if(c3){
				out += "3,";
			}
			if(c4a){
				out += "4a,";
			}
			if(c4b){
				out += "4b,";
			}
			if(c5){
				out += "5,";
			}
			if(c6){
				out += "6,";
			}
		}
		if(out.charAt(out.length() -1) == ','){
			out = out.substring(0, out.length() - 1);
		}
		out += "-s"+s;
		return out;
	}

}
