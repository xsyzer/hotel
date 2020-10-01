package com.example.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
public class hello {
	
	@ResponseBody
	@RequestMapping("/hello")
	public String home() {
		return "Hello World!";
	}
}
