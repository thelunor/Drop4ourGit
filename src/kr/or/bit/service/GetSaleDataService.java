package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.Sale;

public class GetSaleDataService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String aptNum =request.getParameter("aptNum");
		System.out.println("아파트 매물 번호"+aptNum);
		Sale sale = null;	
		REAUser reaUser = null;
		
		try {
			SaleDao saleDao = new SaleDao();
			REAUserDao reaDao = new REAUserDao();
			sale = new Sale();
			reaUser = new REAUser();
			sale = saleDao.getSaleDetail(aptNum); //매물 정보 가져오기
			String reaId = sale.getId();
			System.out.println("공인중개사 아이디 " +reaId);
			reaUser = reaDao.getREAUserInfo(reaId); //공인중개사 정보 가져오기
			
			if(sale !=null && reaUser !=null) {
				request.setAttribute("saleData", sale);
				request.setAttribute("reaUser", reaUser);
				forward.setPath("GetSaleDataServiceOk.d4b");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
