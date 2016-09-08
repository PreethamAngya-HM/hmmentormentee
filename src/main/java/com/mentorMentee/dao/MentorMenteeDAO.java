package com.mentorMentee.dao;

import com.mentorMentee.beans.EvalMenteeByMentor;
import com.mentorMentee.beans.EvalMentorByMentee;
import com.mentorMentee.beans.Login;
import com.mentorMentee.beans.Mentee;
import com.mentorMentee.beans.Objectives;

public interface MentorMenteeDAO {
	Login authenticateUser(Login loginObj) throws Exception;
	Objectives getObjDetails(Mentee menteeObj,Objectives objectivesObj) throws Exception;
	EvalMenteeByMentor getEvalMenteeByMentorDetails(Mentee menteeObj,EvalMenteeByMentor evalMenteeByMentorObj) throws Exception;
	EvalMentorByMentee getEvalMentorByMenteeDetails(Mentee menteeObj, EvalMentorByMentee evalMentorByMenteeObj) throws Exception;
	Mentee getMentorMenteeNames(Mentee menteeObj)throws Exception;
	Objectives setObjDetails(Mentee menteeObj, Objectives objectivesObj)throws Exception;
	EvalMentorByMentee setEvalMentorByMenteeDetails(Mentee menteeObj, EvalMentorByMentee evalMentorByMenteeObj)throws Exception;
	EvalMenteeByMentor setEvalMenteeByMentorDetails(Mentee menteeObj, EvalMenteeByMentor evalMenteeByMentorObj)throws Exception;
	Mentee getMentorMenteeNamesForMentor(Mentee menteeObj)throws Exception;
	Objectives setObjectivesObjReviewed(Mentee menteeObj, Objectives objectivesObj)throws Exception;
	Objectives setObjectivesActionPlan(Mentee menteeObj, Objectives objectivesObj)throws Exception;
}
