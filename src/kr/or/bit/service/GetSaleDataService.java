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
		ActionForward forward = null;
		String aptName =request.getParameter("aptName");

		List<Sale> saleList = null;		
		try {
			SaleDao dao = new SaleDao();
			saleList = dao.getSaleDetail(aptName);
			request.setAttribute("saleList", saleList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		//session.setAttribute("address", address);		
		forward.setPath("GetSaleDataServiceOk.d4b");
		return forward;
	}

}
