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
	
	@GetMapping("/genMainPage")
	public String genMainPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		model.addAttribute("user", chuserCustom);
		return "generic/main";
	}
	@GetMapping("/myPage")
	public String myPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		genericService.getGenericInfo(chuserCustom.getUsername());
		//System.out.println("객체로 담긴 정보는?"+generic.toString());
		//model.addAttribute("userData", generic);
		//마이페이지에서 정보가져오기 
		
		return "generic/myPage";
	}
}
