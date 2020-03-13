package com.scoder.hs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rea")
public class REAController {
	
	@GetMapping("/myPage")
	public String myPage() {
		System.out.println("공인중개사 마이페이지 걸려?");
		return "rea/reaIntro";
	}

}
