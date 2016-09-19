package com.mentorMentee.controller;

import com.mentorMentee.beans.EvalMenteeByMentor;
import com.mentorMentee.beans.EvalMentorByMentee;
import com.mentorMentee.beans.Login;
import com.mentorMentee.beans.Mentee;
import com.mentorMentee.beans.MenteeRequest;
import com.mentorMentee.beans.Objectives;
import com.mentorMentee.dao.MentorMenteeDAO;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MentorMenteeSpringRestController { 
	
	@Autowired
	MentorMenteeDAO mentorMenteeDAO;
	
	@RequestMapping(value = "/authenticateUser/", method = RequestMethod.POST)
	public ResponseEntity<Login> authenticationMethod(@RequestBody Login loginObj) {
		System.out.println("=====In authentication=====");
		try {
			loginObj = mentorMenteeDAO.authenticateUser(loginObj);
			if(loginObj.getAuthenticated()){
				return new ResponseEntity(loginObj, HttpStatus.OK);
			}
			else{
				return new ResponseEntity(loginObj, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(loginObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/getMentorMenteeNames/", method = RequestMethod.POST)
	public ResponseEntity<Mentee> getMentorMenteeNamesMethod(@RequestBody Mentee menteeObj) {
		System.out.println("=====In getMentorMenteeNames=====");
		try {
			menteeObj = mentorMenteeDAO.getMentorMenteeNames(menteeObj);
			return new ResponseEntity(menteeObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(menteeObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/getMentorMenteeNamesForMentor/", method = RequestMethod.POST)
	public ResponseEntity<Mentee> getMentorMenteeNamesForMentorMethod(@RequestBody Mentee menteeObj) {
		System.out.println("=====In getMentorMenteeNamesForMentor=====");
		try {
			menteeObj = mentorMenteeDAO.getMentorMenteeNamesForMentor(menteeObj);
			return new ResponseEntity(menteeObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(menteeObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/getObjectives/", method = RequestMethod.POST)
	public ResponseEntity<Objectives> getObjectivesMethod(@RequestBody MenteeRequest menteeReq) {
		System.out.println("=====In getObjectives=====");
		Mentee menteeObj = menteeReq.getMenteeObj();
		Objectives objectivesObj = menteeReq.getObjectivesObj();
		try {
			objectivesObj = mentorMenteeDAO.getObjDetails(menteeObj,objectivesObj);
			return new ResponseEntity(objectivesObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(objectivesObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/setObjectives/", method = RequestMethod.POST)
	public ResponseEntity<Objectives> setObjectivesMethod(@RequestBody MenteeRequest menteeReq) {
		System.out.println("=====In setObjectives=====");
		Mentee menteeObj = menteeReq.getMenteeObj();
		Objectives objectivesObj = menteeReq.getObjectivesObj();
		try {
			objectivesObj = mentorMenteeDAO.setObjDetails(menteeObj,objectivesObj);
			return new ResponseEntity(objectivesObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(objectivesObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/setObjectivesObjReviewed/", method = RequestMethod.POST)
	public ResponseEntity<Objectives> setObjectivesObjReviewedMethod(@RequestBody MenteeRequest menteeReq) {
		System.out.println("=====In setObjectivesObjReviewed=====");
		Mentee menteeObj = menteeReq.getMenteeObj();
		Objectives objectivesObj = menteeReq.getObjectivesObj();
		try {
			objectivesObj = mentorMenteeDAO.setObjectivesObjReviewed(menteeObj,objectivesObj);
			return new ResponseEntity(objectivesObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(objectivesObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/setObjectivesActionPlan/", method = RequestMethod.POST)
	public ResponseEntity<Objectives> setObjectivesActionPlanMethod(@RequestBody MenteeRequest menteeReq) {
		System.out.println("=====In setObjectivesActionPlan=====");
		Mentee menteeObj = menteeReq.getMenteeObj();
		Objectives objectivesObj = menteeReq.getObjectivesObj();
		try {
			objectivesObj = mentorMenteeDAO.setObjectivesActionPlan(menteeObj,objectivesObj);
			return new ResponseEntity(objectivesObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(objectivesObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/getEvalMenteeByMentor/", method = RequestMethod.POST)
	public ResponseEntity<EvalMenteeByMentor> getEvalMenteeByMentorMethod(@RequestBody MenteeRequest menteeReq) {
		System.out.println("=====In getEvalMenteeByMentor=====");
		Mentee menteeObj = menteeReq.getMenteeObj();
		EvalMenteeByMentor evalMenteeByMentorObj = menteeReq.getEvalMenteeByMentorObj();
		try {
			evalMenteeByMentorObj = mentorMenteeDAO.getEvalMenteeByMentorDetails(menteeObj, evalMenteeByMentorObj);
			return new ResponseEntity(evalMenteeByMentorObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(evalMenteeByMentorObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/getEvalMentorByMentee/", method = RequestMethod.POST)
	public ResponseEntity<EvalMentorByMentee> getEvalMentorByMenteeMethod(@RequestBody MenteeRequest menteeReq) {
		System.out.println("=====In getEvalMentorByMentee=====");
		Mentee menteeObj = menteeReq.getMenteeObj();
		EvalMentorByMentee evalMentorByMenteeObj = menteeReq.getEvalMentorByMenteeObj();
		try {
			evalMentorByMenteeObj = mentorMenteeDAO.getEvalMentorByMenteeDetails(menteeObj, evalMentorByMenteeObj);
			return new ResponseEntity(evalMentorByMenteeObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(evalMentorByMenteeObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/setEvalMenteeByMentor/", method = RequestMethod.POST)
	public ResponseEntity<EvalMenteeByMentor> setEvalMenteeByMentorMethod(@RequestBody MenteeRequest menteeReq) {
		System.out.println("=====In setEvalMenteeByMentor=====");
		Mentee menteeObj = menteeReq.getMenteeObj();
		EvalMenteeByMentor evalMenteeByMentorObj = menteeReq.getEvalMenteeByMentorObj();
		System.out.println("evalMenteeByMentorObj"+evalMenteeByMentorObj.getEvalMenteeByMentor());
		try {
			evalMenteeByMentorObj = mentorMenteeDAO.setEvalMenteeByMentorDetails(menteeObj, evalMenteeByMentorObj);
			return new ResponseEntity(evalMenteeByMentorObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(evalMenteeByMentorObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/setEvalMentorByMentee/", method = RequestMethod.POST)
	public ResponseEntity<EvalMentorByMentee> setEvalMentorByMenteeMethod(@RequestBody MenteeRequest menteeReq) {
		System.out.println("=====In setEvalMentorByMentee=====");
		Mentee menteeObj = menteeReq.getMenteeObj();
		EvalMentorByMentee evalMentorByMenteeObj = menteeReq.getEvalMentorByMenteeObj();
		try {
			evalMentorByMenteeObj = mentorMenteeDAO.setEvalMentorByMenteeDetails(menteeObj, evalMentorByMenteeObj);
			return new ResponseEntity(evalMentorByMenteeObj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(evalMentorByMenteeObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/logoutUser", method = RequestMethod.POST)
	public ResponseEntity<String> logoutUserMethod() {
		System.out.println("=====In logoutUser=====");
		//Mentee menteeObj = menteeReq.getMenteeObj();
		//EvalMentorByMentee evalMentorByMenteeObj = menteeReq.getEvalMentorByMenteeObj();
		String loggedOut = "";
		try {
			loggedOut = mentorMenteeDAO.setlogoutUser();
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
