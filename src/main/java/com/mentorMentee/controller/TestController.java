package com.mentorMentee.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TestController { 
	@RequestMapping(method = RequestMethod.GET)
	public void runTestMethod1() {
		System.out.println("=====In runTestMethod1=====");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void runTestMethod2() {
		System.out.println("=====In runTestMethod2=====");
	}
}
