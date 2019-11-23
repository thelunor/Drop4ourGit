package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dto.Sale;

public class selectAtpListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		String addr = request.getParameter("addr");	
		
		List<Sale> saleList = null;
		try {
			SaleDao dao = new SaleDao();
			saleList = dao.selectAtpList(addr);
			request.setAttribute("saleList", saleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setPath("SelectaptListService.d4b");
		return forward;
	}

}
