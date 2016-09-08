package com.mentorMentee.controller;

import com.mentorMentee.dao.TestConnection;
import com.mentorMentee.beans.Login;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController1 { 
	
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public void runTestMethod(@RequestBody Login loginObj) {
		System.out.println("=====In runTestMethod=====");
		System.out.println("=====Body Email====="+loginObj.getEmail());
		System.out.println("=====Body Pass====="+loginObj.getPass());
		System.out.println("=====Body Role====="+loginObj.getRole());
		TestConnection.testMethod();
	}
}

