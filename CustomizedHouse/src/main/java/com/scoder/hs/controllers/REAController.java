package com.scoder.hs.controllers;

import com.scoder.hs.service.CHUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scoder.hs.dto.CHUser;
import com.scoder.hs.dto.CHUserCustom;
import com.scoder.hs.dto.Generic;
import com.scoder.hs.dto.REA;
import com.scoder.hs.dto.REAIntroBoard;
import com.scoder.hs.dto.Sale;
import com.scoder.hs.service.GenericService;
import com.scoder.hs.service.REAService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/rea")
@Slf4j
public class REAController {
	
	@Autowired
	private REAService reaService;
	
	@Autowired
	private CHUserService chUserService;
	
	@GetMapping("/reaMain")
	public String mainPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		REA rea = reaService.getReaInfo(chuserCustom.getUsername());
		model.addAttribute("user", chuserCustom);
		model.addAttribute("rea", rea);
		
		//공인중개사 소개 & 후기 없을 때 어떻게 처리할 지 넣기
		
		//공인중개사 소개 가져오기!
		REAIntroBoard reaIntroBoard = reaService.getReaIntro(chuserCustom.getUsername());
				
		model.addAttribute("reaIntroBoard", reaIntroBoard);
		
		//공인중개사 후기 가져오기
		
		return "rea/reaMain";
	}
	@GetMapping("/myPage")
	public String myPage() {
		return "rea/myPage";
	}
	@GetMapping("/introPage")
	public String introPage() {
		return "rea/reaIntroPage";
	}
	@PostMapping("/introPageWrite")
	public String introPageWrite() {
		System.out.println("소개페이지 글쓰기 타니?");
		String path = "";

		//@AuthenticationPrincipal CHUserCustom chuserCustom, REAIntroBoard reaIntroBoard
		
//		boolean result = reaService.saveReaIntro(reaIntroBoard);
//		if(result) {
//			path = "redirect:/rea/reaMain";
//		} else {
//			path = "redirect:/rea/introPageWrite";
//		}
		return path;
	}
	
	@GetMapping("/reaSale")
	public String salePage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		//공인중개사 정보 가져와서 뿌리기
		REA rea = reaService.getReaInfo(chuserCustom.getUsername());
		model.addAttribute("user", chuserCustom);
		model.addAttribute("rea", rea);
		return "rea/reaSalePage";
	}
	
	@GetMapping("/addSale")
	public String addSalePage() {
		return "rea/saleAddPage";
	}
	
	//매물 등록하기
	@PostMapping("/addSale")
	public String addSale(Sale sale, @AuthenticationPrincipal CHUserCustom chuserCustom) {
		System.out.println("매물 등록!");
		System.out.println(sale.toString());
		//서비스 연결 -> db 저장
		boolean result = reaService.saveSale(sale);
		System.out.println("매물 저장 됨?");
		
		
		return "rea/saleAddPage";
	}
	
	
	/**
	 * 공인중개사 정보  수정페이지로 이동
	 * @author 이정은
	 * @since 2020/03/27 
	 * @param chuserCustom
	 * @param model
	 * @return "generic/reaEditPage";
	 */
	@GetMapping("/reaEditPage")
	public String userEditPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		CHUser chUser = chUserService.getCHUserInfo(chuserCustom.getUsername()); //CHUser
		model.addAttribute("chUser", chUser);
		REA rea  = reaService.getReaInfo(chuserCustom.getUsername());

		System.out.println("GET chUser: " + chUser.toString());
		System.out.println("GET chuserCustom: " + chuserCustom.toString());
		System.out.println("GET rea: " + rea.toString());
		model.addAttribute("rea", rea);
		return "rea/reaEditPage";
	}
	
	/**
	 * 회원정보 데이터 수정
	 * @author 이정은
	 * @since 2020/03/24 
	 * @param chuserCustom
	 * @param chUser
	 * @param generic
	 * @return "generic/genericEditSuccess";
	 */
	@PostMapping("/reaInfoEdit")
	public String reaInfoEdit(@AuthenticationPrincipal CHUserCustom chuserCustom, CHUser chUser, REA rea) {
		boolean result = false;
		System.out.println("POST chUser: " + chUser.toString());
		System.out.println("POST chuserCustom: " + chuserCustom.toString());
		System.out.println("POST rea: " + rea.toString());
		try {
			System.out.println("chuserCustom.getUsername(): " + chuserCustom.getUsername());
			result = reaService.EditREAUser(chUser, rea, chuserCustom.getUsername());
		} catch (Exception e) {
			System.out.println("Controller signUpGenericUser 예외발생: " + e.getMessage());
		}
		return "redirect:/rea/reaEditSuccess";
	}

	/**
	 * 공인중개사 정보 수정 성공 페이지
	 * @author 이정은
	 * @since 2020/03/24  
	 * @return "/rea/reaEditSuccess";
	 */
	@GetMapping("/reaEditSuccess")
	public String reaEditSuccess() {
		return "/rea/reaEditSuccess";
	}
	
	/**
	 * 일정관리 페이지 이동
	 * @return
	 */
	@GetMapping("/reaSchedulePage")
	public String reaSchedulePage() {
		return "rea/reaSchedulePage";
	}
}
