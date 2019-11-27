package kr.or.bit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dto.Sale;
import kr.or.bit.dto.SaleImage;

public class SelectAtpListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		System.out.println("SelectAtpListService");
		// HttpSession session = request.getSession();
		String search = request.getParameter("search");
		System.out.println(search);
		Map<Sale, SaleImage> saleMap = new HashMap<Sale, SaleImage>();
		
		// String address = request.getParameter("address");
		//80215
		try {
			SaleDao dao = new SaleDao();
			saleMap = dao.selectAtpList(search);
			int count = dao.selectAtpListCount(search);
			System.out.println("Count: " + count);
			
			//System.out.println(saleMap.toString());
			if (saleMap != null) {
				request.setAttribute("saleMap", saleMap);
				request.setAttribute("search", search);
				request.setAttribute("count", count);
			} else {
				request.setAttribute("saleMap", saleMap);
				request.setAttribute("search", "법정구 법정동");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		// session.setAttribute("address", address);
		forward.setPath("SelectAptListServiceOk.d4b");
		return forward;
	}

}