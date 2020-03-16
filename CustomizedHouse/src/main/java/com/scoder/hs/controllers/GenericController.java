package com.scoder.hs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generic")
public class GenericController {
	@GetMapping("/myPage")
	public String myPage() {
		return "generic/main";
	}
}
