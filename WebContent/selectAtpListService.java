package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dto.Sale;

public class selectAtpListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		//HttpSession session = request.getSession();
		String search=request.getParameter("search");
		List<Sale> saleList = null;
		//String address = request.getParameter("address");
		
		try {
			SaleDao dao = new SaleDao();
			saleList = dao.selectAtpList(search);
			request.setAttribute("saleList", saleList);
			request.setAttribute("search", search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		//session.setAttribute("address", address);		
		forward.setPath("SelectaptListServiceOk.d4b");
		return forward;
	}

}
