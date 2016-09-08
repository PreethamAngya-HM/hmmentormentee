package com.mentorMentee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.stereotype.Service;

import com.mentorMentee.beans.EvalMenteeByMentor;
import com.mentorMentee.beans.EvalMentorByMentee;
import com.mentorMentee.beans.Login;
import com.mentorMentee.beans.Mentee;
import com.mentorMentee.beans.Objectives;
import com.mentorMentee.connectionPool.DataSourceConnectionPool;

@Service("mentorMenteeDAO")
public class MentorMenteeDAOImplimentation implements MentorMenteeDAO{
	private String loggedInUserEmail;
	private String fullName;
	private Integer MMANum; 
	public String getLoggedInUserEmail() {
		return loggedInUserEmail;
	}

	public void setLoggedInUserEmail(String loggedInUserEmail) {
		this.loggedInUserEmail = loggedInUserEmail;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getMMANum() {
		return MMANum;
	}

	public void setMMANum(Integer mMANum) {
		MMANum = mMANum;
	}
	
	public Login authenticateUser(Login loginObj) throws Exception {
		Login tempLoginObj = new Login();
		try{
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT * FROM LoginTable WHERE email=?;");
			ps.setString(1, loginObj.getEmail());
			ResultSet rs;
			rs=ps.executeQuery();
			if(rs.next()){
				tempLoginObj.setEmail(rs.getString("email"));
				tempLoginObj.setPass(rs.getString("pass"));
				tempLoginObj.setRole(rs.getString("role"));
				if(loginObj.getPass().equals(rs.getString("pass"))){
					System.out.println("========Authenticated=======");
					setLoggedInUserEmail(loginObj.getEmail());
					setFullName(rs.getString("firstname")+" "+rs.getString("lastname"));
					System.out.println("========User======="+getFullName());
					tempLoginObj.setAuthenticated(true);
				}
				else{
					System.out.println("========Authentication Failed=======");
					tempLoginObj.setAuthenticated(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return tempLoginObj;
		}
		return tempLoginObj;
		
	}

	public Objectives getObjDetails(Mentee menteeObj, Objectives objectivesObj) throws Exception {
		System.out.println("======Quarter======"+menteeObj.getQuarter());
		System.out.println("======Year======"+menteeObj.getYear());
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery = "SELECT * FROM public.\"MMObjectives\" WHERE \"MMObjectives\".\"MMANum\"=? AND \"MMObjectives\".\"Quarter\"=? AND \"MMObjectives\".\"Year\"=?;";
			PreparedStatement ps= con.prepareStatement(newQuery);
			ps.setInt(1, getMMANum());
			ps.setString(2, menteeObj.getQuarter());
			ps.setInt(3, menteeObj.getYear());
			//ps.setString(1, Integer.toString(menteeObj.getYear()));
			ResultSet rs;
			rs=ps.executeQuery();
			if(rs.next()){
				objectivesObj.setObjReviewed(rs.getBoolean("reviewed"));
				objectivesObj.setActionPlan(rs.getString("Action Plan"));
				objectivesObj.setResults(rs.getString("results"));
			}
			else{
				objectivesObj.setAllDefault();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectivesObj;
	}

	public EvalMenteeByMentor getEvalMenteeByMentorDetails(Mentee menteeObj, EvalMenteeByMentor evalMenteeByMentorObj)
			throws Exception {
		System.out.println("======Quarter======"+menteeObj.getQuarter());
		System.out.println("======Year======"+menteeObj.getYear());
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery = "SELECT * FROM public.\"EvalOfMenteeByMentor\" WHERE \"EvalOfMenteeByMentor\".\"MMANum\"=? AND \"EvalOfMenteeByMentor\".\"Quarter\"=? AND \"EvalOfMenteeByMentor\".\"Year\"=?;";
			PreparedStatement ps= con.prepareStatement(newQuery);
			ps.setInt(1, getMMANum());
			ps.setString(2, menteeObj.getQuarter());
			ps.setInt(3, menteeObj.getYear());
			ResultSet rs;
			rs=ps.executeQuery();
			if(rs.next()){
				List<String> evalMenteeByMentor = new ArrayList<String>();
				for(int i=1; i<6; i++){
					evalMenteeByMentor.add(rs.getString("Question"+i));
				}
				evalMenteeByMentorObj.setEvalMenteeByMentor(evalMenteeByMentor);
			}
			else{
				evalMenteeByMentorObj.setAllDefault();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return evalMenteeByMentorObj;
	}

	public EvalMentorByMentee getEvalMentorByMenteeDetails(Mentee menteeObj, EvalMentorByMentee evalMentorByMenteeObj)
			throws Exception {
		System.out.println("======Quarter======"+menteeObj.getQuarter());
		System.out.println("======Year======"+menteeObj.getYear());
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery = "SELECT * FROM public.\"EvalOfMentorByMentee\" WHERE \"EvalOfMentorByMentee\".\"MMANum\"=? AND \"EvalOfMentorByMentee\".\"Quarter\"=? AND \"EvalOfMentorByMentee\".\"Year\"=?;";
			PreparedStatement ps= con.prepareStatement(newQuery);
			ps.setInt(1, getMMANum());
			ps.setString(2, menteeObj.getQuarter());
			ps.setInt(3, menteeObj.getYear());
			//ps.setString(1, Integer.toString(menteeObj.getYear()));
			ResultSet rs;
			rs=ps.executeQuery();
			if(rs.next()){
				List<String> evalMentorByMentee = new ArrayList<String>();
				for(int i=1; i<6; i++){
					evalMentorByMentee.add(rs.getString("Question"+i));
				}
				evalMentorByMenteeObj.setEvalMentorByMentee(evalMentorByMentee);
			}
			else{
				evalMentorByMenteeObj.setAllDefault();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return evalMentorByMenteeObj;
	}

	public Mentee getMentorMenteeNames(Mentee menteeObj) throws Exception {
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery = "SELECT * FROM public.\"MentorMenteeAssignment\" WHERE \"MentorMenteeAssignment\".\"Mentee\"=?;";
			PreparedStatement ps= con.prepareStatement(newQuery);
			ps.setString(1,getFullName());
			ResultSet rs;
			rs=ps.executeQuery();
			List<String> menteeNames = new ArrayList<String>();
			if(rs.next()){
					menteeObj.setMentorName(rs.getString("Mentor"));
					setMMANum(rs.getInt("MMANum"));
					//menteeNames.add(rs.getString("Mentee"));
					menteeObj.setMenteeName(getFullName());
			}
			menteeObj.setMenteeNames(menteeNames);
			List<String> quartersTemp = new ArrayList<String>();
			List<String> yearsTemp = new ArrayList<String>();
			quartersTemp.add("Quarter");
			quartersTemp.add("Q1");
			quartersTemp.add("Q2");
			quartersTemp.add("Q3");
			quartersTemp.add("Q4");
			yearsTemp.add("Year");
			yearsTemp.add("2011");
			yearsTemp.add("2012");
			yearsTemp.add("2013");
			yearsTemp.add("2014");
			yearsTemp.add("2015");
			yearsTemp.add("2016");
			yearsTemp.add("2017");
			menteeObj.setQuarters(quartersTemp);
			menteeObj.setYears(yearsTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menteeObj;
	}
	
	public Mentee getMentorMenteeNamesForMentor(Mentee menteeObj) throws Exception {
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery = "SELECT * FROM public.\"MentorMenteeAssignment\" WHERE \"MentorMenteeAssignment\".\"Mentor\"=?;";
			PreparedStatement ps= con.prepareStatement(newQuery);
			ps.setString(1,getFullName());
			ResultSet rs;
			rs=ps.executeQuery();
			List<String> menteeNames = new ArrayList<String>();
			while(rs.next()){
				if(getFullName().equals(rs.getString("Mentor"))){
					menteeObj.setMentorName(rs.getString("Mentor"));
					menteeNames.add(rs.getString("Mentee"));
					if(menteeObj.getMenteeName()!=null){
						if(menteeObj.getMenteeName().equals(rs.getString("Mentee"))){
							setMMANum(rs.getInt("MMANum"));
						}
					}
					else{
						setMMANum(0);
					}
				}
				else{
					System.out.println("===No Mentor Data Found===");
				}
			}
			menteeObj.setMenteeNames(menteeNames);
			List<String> quartersTemp = new ArrayList<String>();
			List<String> yearsTemp = new ArrayList<String>();
			quartersTemp.add("Quarter");
			quartersTemp.add("Q1");
			quartersTemp.add("Q2");
			quartersTemp.add("Q3");
			quartersTemp.add("Q4");
			yearsTemp.add("Year");
			yearsTemp.add("2011");
			yearsTemp.add("2012");
			yearsTemp.add("2013");
			yearsTemp.add("2014");
			yearsTemp.add("2015");
			yearsTemp.add("2016");
			yearsTemp.add("2017");
			menteeObj.setQuarters(quartersTemp);
			menteeObj.setYears(yearsTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menteeObj;
	}

	public Objectives setObjDetails(Mentee menteeObj, Objectives objectivesObj) throws Exception {
		System.out.println("======Quarter======"+menteeObj.getQuarter());
		System.out.println("======Year======"+menteeObj.getYear());
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery1 = "SELECT * FROM public.\"MMObjectives\" WHERE \"MMObjectives\".\"MMANum\"=? AND \"MMObjectives\".\"Quarter\"=? AND \"MMObjectives\".\"Year\"=?;";
			PreparedStatement ps1= con.prepareStatement(newQuery1);
			ps1.setInt(1, getMMANum());
			ps1.setString(2, menteeObj.getQuarter());
			ps1.setInt(3, menteeObj.getYear());
			ResultSet rs1;
			rs1=ps1.executeQuery();
			if(rs1.next()){
				String newQuery = "UPDATE public.\"MMObjectives\" SET \"Results\"=? WHERE \"MMANum\"=? AND \"Quarter\"=? AND \"Year\"=?;";
				PreparedStatement ps= con.prepareStatement(newQuery);
				ps.setString(1, objectivesObj.getResults());
				ps.setInt(2, getMMANum());
				ps.setString(3, menteeObj.getQuarter());
				ps.setInt(4, menteeObj.getYear());
				ps.executeUpdate();
				
			}
			else{
				String newQuery = "INSERT INTO public.\"MMObjectives\"(\"MMANum\", \"Quarter\", \"Year\",\"Results\") VALUES (?, ?, ?, ?);";
				PreparedStatement ps= con.prepareStatement(newQuery);
				ps.setInt(1, getMMANum());
				ps.setString(2, menteeObj.getQuarter());
				ps.setInt(3, menteeObj.getYear());
				ps.setString(4, objectivesObj.getResults());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectivesObj;
	}

	public EvalMentorByMentee setEvalMentorByMenteeDetails(Mentee menteeObj, EvalMentorByMentee evalMentorByMenteeObj)
			throws Exception {
		System.out.println("======Quarter======"+menteeObj.getQuarter());
		System.out.println("======Year======"+menteeObj.getYear());
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery = "SELECT * FROM public.\"EvalOfMentorByMentee\" WHERE \"EvalOfMentorByMentee\".\"MMANum\"=? AND \"EvalOfMentorByMentee\".\"Quarter\"=? AND \"EvalOfMentorByMentee\".\"Year\"=?;";
			PreparedStatement ps= con.prepareStatement(newQuery);
			ps.setInt(1, getMMANum());
			ps.setString(2, menteeObj.getQuarter());
			ps.setInt(3, menteeObj.getYear());
			ResultSet rs;
			rs=ps.executeQuery();
			if(rs.next()){
				String newQuery1 = "UPDATE public.\"EvalOfMentorByMentee\" SET \"Question1\"=?, \"Question2\"=?, \"Question3\"=?, \"Question4\"=?, \"Question5\"=? WHERE \"MMANum\"=? AND \"Quarter\"=? AND \"Year\"=?;";
				PreparedStatement ps1= con.prepareStatement(newQuery1);
				List<String> evalMentorByMentee = evalMentorByMenteeObj.getEvalMentorByMentee();
				for(int i=0; i<evalMentorByMentee.size(); i++){
					ps1.setString(i+1, evalMentorByMentee.get(i));
				}
				ps1.setInt(6, getMMANum());
				ps1.setString(7, menteeObj.getQuarter());
				ps1.setInt(8, menteeObj.getYear());
				ps1.executeUpdate();
			}
			else{
				String newQuery1 = "INSERT INTO public.\"EvalOfMentorByMentee\"(\"MMANum\", \"Quarter\", \"Year\", \"Question1\", \"Question2\", \"Question3\", \"Question4\", \"Question5\") VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement ps1= con.prepareStatement(newQuery1);
				ps1.setInt(1, getMMANum());
				ps1.setString(2, menteeObj.getQuarter());
				ps1.setInt(3, menteeObj.getYear());
				List<String> evalMentorByMentee = evalMentorByMenteeObj.getEvalMentorByMentee();
				for(int i=4; i<9; i++){
					ps1.setString(i, evalMentorByMentee.get(i-4));
				}
				ps1.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return evalMentorByMenteeObj;
	}

	public EvalMenteeByMentor setEvalMenteeByMentorDetails(Mentee menteeObj, EvalMenteeByMentor evalMenteeByMentorObj)
			throws Exception {
		System.out.println("======Quarter======"+menteeObj.getQuarter());
		System.out.println("======Year======"+menteeObj.getYear());
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery = "SELECT * FROM public.\"EvalOfMenteeByMentor\" WHERE \"EvalOfMenteeByMentor\".\"MMANum\"=? AND \"EvalOfMenteeByMentor\".\"Quarter\"=? AND \"EvalOfMenteeByMentor\".\"Year\"=?;";
			PreparedStatement ps= con.prepareStatement(newQuery);
			ps.setInt(1, getMMANum());
			ps.setString(2, menteeObj.getQuarter());
			ps.setInt(3, menteeObj.getYear());
			ResultSet rs;
			rs=ps.executeQuery();
			if(rs.next()){
				String newQuery1 = "UPDATE public.\"EvalOfMenteeByMentor\" SET \"Question1\"=?, \"Question2\"=?, \"Question3\"=?, \"Question4\"=?, \"Question5\"=? WHERE \"MMANum\"=? AND \"Quarter\"=? AND \"Year\"=?;";
				PreparedStatement ps1= con.prepareStatement(newQuery1);
				List<String> evalMenteeByMentor = evalMenteeByMentorObj.getEvalMenteeByMentor();
				for(int i=0; i<evalMenteeByMentor.size(); i++){
					ps1.setString(i+1, evalMenteeByMentor.get(i));
				}
				ps1.setInt(6, getMMANum());
				ps1.setString(7, menteeObj.getQuarter());
				ps1.setInt(8, menteeObj.getYear());
				ps1.executeUpdate();
			}
			else{
				String newQuery1 = "INSERT INTO public.\"EvalOfMenteeByMentor\"(\"MMANum\", \"Quarter\", \"Year\", \"Question1\", \"Question2\", \"Question3\", \"Question4\", \"Question5\") VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement ps1= con.prepareStatement(newQuery1);
				ps1.setInt(1, getMMANum());
				ps1.setString(2, menteeObj.getQuarter());
				ps1.setInt(3, menteeObj.getYear());
				List<String> evalMenteeByMentor = evalMenteeByMentorObj.getEvalMenteeByMentor();
				for(int i=4; i<9; i++){
					ps1.setString(i, evalMenteeByMentor.get(i-4));
				}
				ps1.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return evalMenteeByMentorObj;
	}

	public Objectives setObjectivesObjReviewed(Mentee menteeObj, Objectives objectivesObj) throws Exception {
		System.out.println("======Quarter======"+menteeObj.getQuarter());
		System.out.println("======Year======"+menteeObj.getYear());
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery1 = "SELECT * FROM public.\"MMObjectives\" WHERE \"MMObjectives\".\"MMANum\"=? AND \"MMObjectives\".\"Quarter\"=? AND \"MMObjectives\".\"Year\"=?;";
			PreparedStatement ps1= con.prepareStatement(newQuery1);
			ps1.setInt(1, getMMANum());
			ps1.setString(2, menteeObj.getQuarter());
			ps1.setInt(3, menteeObj.getYear());
			ResultSet rs1;
			rs1=ps1.executeQuery();
			if(rs1.next()){
				String newQuery = "UPDATE public.\"MMObjectives\" SET \"Reviewed\"=? WHERE \"MMANum\"=? AND \"Quarter\"=? AND \"Year\"=?;";
				PreparedStatement ps= con.prepareStatement(newQuery);
				ps.setBoolean(1, objectivesObj.getObjReviewed());
				ps.setInt(2, getMMANum());
				ps.setString(3, menteeObj.getQuarter());
				ps.setInt(4, menteeObj.getYear());
				ps.executeUpdate();
				
			}
			else{
				String newQuery = "INSERT INTO public.\"MMObjectives\"(\"MMANum\", \"Quarter\", \"Year\",\"Reviewed\") VALUES (?, ?, ?, ?);";
				PreparedStatement ps= con.prepareStatement(newQuery);
				ps.setInt(1, getMMANum());
				ps.setString(2, menteeObj.getQuarter());
				ps.setInt(3, menteeObj.getYear());
				ps.setBoolean(4, objectivesObj.getObjReviewed());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectivesObj;
	}

	public Objectives setObjectivesActionPlan(Mentee menteeObj, Objectives objectivesObj) throws Exception {
		System.out.println("======Quarter======"+menteeObj.getQuarter());
		System.out.println("======Year======"+menteeObj.getYear());
		try {
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			String newQuery1 = "SELECT * FROM public.\"MMObjectives\" WHERE \"MMObjectives\".\"MMANum\"=? AND \"MMObjectives\".\"Quarter\"=? AND \"MMObjectives\".\"Year\"=?;";
			PreparedStatement ps1= con.prepareStatement(newQuery1);
			ps1.setInt(1, getMMANum());
			ps1.setString(2, menteeObj.getQuarter());
			ps1.setInt(3, menteeObj.getYear());
			ResultSet rs1;
			rs1=ps1.executeQuery();
			if(rs1.next()){
				String newQuery = "UPDATE public.\"MMObjectives\" SET \"Action Plan\"=? WHERE \"MMANum\"=? AND \"Quarter\"=? AND \"Year\"=?;";
				PreparedStatement ps= con.prepareStatement(newQuery);
				ps.setString(1, objectivesObj.getActionPlan());
				ps.setInt(2, getMMANum());
				ps.setString(3, menteeObj.getQuarter());
				ps.setInt(4, menteeObj.getYear());
				ps.executeUpdate();
				
			}
			else{
				String newQuery = "INSERT INTO public.\"MMObjectives\"(\"MMANum\", \"Quarter\", \"Year\",\"Action Plan\") VALUES (?, ?, ?, ?);";
				PreparedStatement ps= con.prepareStatement(newQuery);
				ps.setInt(1, getMMANum());
				ps.setString(2, menteeObj.getQuarter());
				ps.setInt(3, menteeObj.getYear());
				ps.setString(4, objectivesObj.getActionPlan());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectivesObj;
	}
	
}
