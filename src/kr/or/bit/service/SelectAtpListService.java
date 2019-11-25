package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dto.Sale;

public class SelectAtpListService implements Action{

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
			if(saleList!=null) {
				System.out.println("saleList!=null");
				request.setAttribute("saleList", saleList);
				request.setAttribute("search", search);
			} else {
				System.out.println("saleList!=null 가 아니란 말이오~");
				request.setAttribute("saleList", saleList);
				request.setAttribute("search", "법정구 법정동");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		//session.setAttribute("address", address);		
		forward.setPath("SelectAptListServiceOk.d4b");
		return forward;
	}

}