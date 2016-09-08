package com.mentorMentee.beans;

import java.util.List;

public class Mentee {
	private String menteeName;
	private String mentorName;
	private List<String> menteeNames;
	private List<String> quarters;
	private List<String> years;
	private String quarter;
	private Integer year;
	
	public List<String> getQuarters() {
		return quarters;
	}
	public void setQuarters(List<String> quarters) {
		this.quarters = quarters;
	}
	public List<String> getYears() {
		return years;
	}
	public void setYears(List<String> years) {
		this.years = years;
	}
	
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public String getMenteeName() {
		return menteeName;
	}
	public void setMenteeName(String menteeName) {
		this.menteeName = menteeName;
	}
	public List<String> getMenteeNames() {
		return menteeNames;
	}
	public void setMenteeNames(List<String> menteeNames) {
		this.menteeNames = menteeNames;
	}
}
