package com.ssmdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoTest {
	
	@RequestMapping("/index")
	public String DemoTest(){
		return "demo";
	}
}
