package com.mentorMentee.beans;

import java.util.ArrayList;
import java.util.List;

public class EvalMenteeByMentor {
	private List<String> evalMenteeByMentor;
	
	public void setAllDefault() {
		List<String> evalMenteeByMentor = new ArrayList<String>();
		evalMenteeByMentor.add("");
		evalMenteeByMentor.add("");
		evalMenteeByMentor.add("");
		evalMenteeByMentor.add("");
		evalMenteeByMentor.add("");
		this.evalMenteeByMentor = evalMenteeByMentor;
	}
	
	public List<String> getEvalMenteeByMentor() {
		return evalMenteeByMentor;
	}

	public void setEvalMenteeByMentor(List<String> evalMenteeByMentor) {
		this.evalMenteeByMentor = evalMenteeByMentor;
	}
	
}
