package com.mentorMentee.beans;

public class Objectives {
	private Integer MMANum;
	private String quarter;
	private String year;
	private Boolean objReviewed;
	private String actionPlan;
	private String results;
	private Integer MMObjNum;
	
	public void setAllDefault() {
		this.MMANum = 0;
		this.quarter = "";
		this.year = "";
		this.objReviewed = false;
		this.actionPlan = "";
		this.results = "";
	}
	public Integer getMMANum() {
		return MMANum;
	}
	public void setMMANum(Integer mMANum) {
		MMANum = mMANum;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Boolean getObjReviewed() {
		return objReviewed;
	}
	public void setObjReviewed(Boolean objReviewed) {
		this.objReviewed = objReviewed;
	}
	public String getActionPlan() {
		return actionPlan;
	}
	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public Integer getMMObjNum() {
		return MMObjNum;
	}
	public void setMMObjNum(Integer mMObjNum) {
		MMObjNum = mMObjNum;
	}
	
}
