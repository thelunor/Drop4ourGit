package com.scoder.hs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sale")
public class SaleController {

	@GetMapping("/saleListPage")
	public String saleListPage() {
		return "sale/saleListPage";
	}
	
	@GetMapping("/saleDetailPage")
	public String saleDetailPage() {
		return "sale/saleDetailPage";
	}
}
