package com.scoder.hs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scoder.hs.dto.CHUserCustom;
import com.scoder.hs.dto.Generic;
import com.scoder.hs.service.GenericService;

@Controller
@RequestMapping("/generic")
public class GenericController {
	
	@Autowired
	private GenericService genericService;
	
	@GetMapping("/genericMyPage")
	public String genMainPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		genericService.getUserInfo(chuserCustom.getUsername());
		model.addAttribute("genericUser", chuserCustom);
		return "generic/genericMyPage";
	}
	
}
