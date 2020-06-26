package com.millervein.vcss.ceap;

import javax.persistence.Embeddable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Embeddable
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ClinicalFindings {
	public Boolean c0;
	public Boolean c1;
	public Boolean c2;
	public Boolean c2r;
	public Boolean c3;
	public Boolean c4;
	public Boolean c4a;
	public Boolean c4b;
	public Boolean c4c;
	public Boolean c5;
	public Boolean c6;
	public Boolean c6r;
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
			if(c2r){
				out += "2r,";
			}
			if(c3){
				out += "3,";
			}
			if(c4){
				out += "4,";
			}
			if(c4a){
				out += "4a,";
			}
			if(c4b){
				out += "4b,";
			}
			if(c4c){
				out += "4c,";
			}
			if(c5){
				out += "5,";
			}
			if(c6){
				out += "6,";
			}
			if(c6r){
				out += "6r,";
			}
		}
		if(out.charAt(out.length() -1) == ','){
			out = out.substring(0, out.length() - 1);
		}
		if(s > 0){
			out += "-s";
		}else{
			out += "-a";
		}
		return out;
	}

}
