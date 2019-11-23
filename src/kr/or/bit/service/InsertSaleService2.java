package kr.or.bit.service;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dao.SaleDao2;
import kr.or.bit.dao.SaleImageDao;
import kr.or.bit.dto.Sale;
import kr.or.bit.dto.SaleImage;

public class InsertSaleService2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		int result = 0;
		
	
		// 1. 데이터 받기

		String aptSize = "";
		String[] aptSizes = request.getParameterValues("aptSize");

		for (String value : aptSizes) {
			aptSize = value;
		}
		// System.out.println("면적" + aptSize);
		String type = "";
		String[] types = request.getParameterValues("type");
		for (String value : types) {
			type = value;
		}
		String addr = request.getParameter("addr");
		String aptName = request.getParameter("aptName");
		String aptDong = request.getParameter("aptDong");
		String aptHo = request.getParameter("aptHo");
		int price = Integer.parseInt(request.getParameter("price"));
		String directions[] = request.getParameterValues("direction");
		String direction = "";
		for (String value : directions) {
			direction = value;
		}
		String etc = request.getParameter("etc");
		String isContract = request.getParameter("isContract");
		String id = request.getParameter("reaId"); // reaId받아오기
		
		// 2. 객체에 데이터 저장

		Sale sale = new Sale();
		sale.setAptSize(aptSize);
		sale.setType(type);
		sale.setAddr(addr);
		sale.setAptName(aptName);
		sale.setAptDong(aptDong);
		sale.setAptHo(aptHo);
		sale.setPrice(price);
		sale.setDirection(direction);
		sale.setEtc(etc);
		sale.setIsContract(isContract);
		sale.setId(id);
		
		try {
			SaleDao2 dao = new SaleDao2();
			////매물 DB에 추가
			result = dao.insertSale(sale); 
			//매물 번호 가져오기
			String aptNum = dao.getAptNumByAptInfo(sale.getAptName(), sale.getAptDong(), sale.getAptHo());
			System.out.println("매물 번호 : "+aptNum);
			sale.setAptNum(aptNum);
			System.out.println("매물 등록 후" + sale.getAptNum());
			
						
			if (result > 0) {
				forward.setPath("SaleAdd2.jsp");

			} else {
				forward.setPath("Main.jsp");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("insertSaleService 실패");
		}

		return forward;
	}
}