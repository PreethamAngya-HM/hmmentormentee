package com.mentorMentee.beans;

import java.util.ArrayList;
import java.util.List;

public class EvalMentorByMentee {
	private List<String> evalMentorByMentee;
	
	public void setAllDefault() {
		List<String> evalMentorByMentee = new ArrayList<String>();
		evalMentorByMentee.add("");
		evalMentorByMentee.add("");
		evalMentorByMentee.add("");
		evalMentorByMentee.add("");
		evalMentorByMentee.add("");
		this.evalMentorByMentee = evalMentorByMentee;
	}
	
	public List<String> getEvalMentorByMentee() {
		return evalMentorByMentee;
	}

	public void setEvalMentorByMentee(List<String> evalMentorByMentee) {
		this.evalMentorByMentee = evalMentorByMentee;
	}
}
