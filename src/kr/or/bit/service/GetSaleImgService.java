package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleImageDao;
import kr.or.bit.dto.SaleImage;

public class GetSaleImgService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String aptNum = request.getParameter("aptNum"); //매물 번호 받아오기
		SaleImage saleImg = new SaleImage();
		try {
			SaleImageDao dao = new SaleImageDao();
			saleImg = dao.getSaleImg(aptNum);

			if(saleImg!=null) {
				System.out.println("매물 사진 가져오기 성공");
				request.setAttribute("saleImg", saleImg);
				forward.setPath("SaleEdit2.jsp?aptNum="+aptNum);
			}
			
			
		}catch(Exception e) {
			
		}
		
		return forward;
	}

}
