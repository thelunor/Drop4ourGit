package kr.or.bit.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dao.SaleImageDao;
import kr.or.bit.dto.Sale;
import kr.or.bit.dto.SaleImage;

public class SelectAtpListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		// HttpSession session = request.getSession();
		String search = request.getParameter("search");
		System.out.println("찍힘");
		Map<Sale, List<SaleImage>> saleMap = null;
		// String address = request.getParameter("address");

		try {
			SaleDao dao = new SaleDao();
			saleMap = dao.selectAtpList(search);
			System.out.println(saleMap.toString());
			if (saleMap != null) {
				request.setAttribute("saleList", saleMap);
				request.setAttribute("search", search);
			} else {
				request.setAttribute("saleList", saleMap);
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