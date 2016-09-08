package com.mentorMentee.beans;

public class MenteeRequest {
	private Mentee menteeObj;
	private Objectives objectivesObj;
	private EvalMenteeByMentor evalMenteeByMentorObj;
	private EvalMentorByMentee evalMentorByMenteeObj;
	
	public EvalMenteeByMentor getEvalMenteeByMentorObj() {
		return evalMenteeByMentorObj;
	}
	public void setEvalMenteeByMentorObj(EvalMenteeByMentor evalMenteeByMentorObj) {
		this.evalMenteeByMentorObj = evalMenteeByMentorObj;
	}
	public Mentee getMenteeObj() {
		return menteeObj;
	}
	public void setMenteeObj(Mentee menteeObj) {
		this.menteeObj = menteeObj;
	}
	public Objectives getObjectivesObj() {
		return objectivesObj;
	}
	public void setObjectivesObj(Objectives objectivesObj) {
		this.objectivesObj = objectivesObj;
	}
	public EvalMentorByMentee getEvalMentorByMenteeObj() {
		return evalMentorByMenteeObj;
	}
	public void setEvalMentorByMenteeObj(EvalMentorByMentee evalMentorByMenteeObj) {
		this.evalMentorByMenteeObj = evalMentorByMenteeObj;
	}
	
}
