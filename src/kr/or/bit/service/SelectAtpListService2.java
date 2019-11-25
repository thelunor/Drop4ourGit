package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao2;
import kr.or.bit.dto.Sale;
import kr.or.bit.dto.SaleImage;

public class SelectAtpListService2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		// HttpSession session = request.getSession();
		String search = request.getParameter("search");
		System.out.println(search);
		Map<List<String>, List<SaleImage>> saleMap = null; // <매물번호, sale 객체>
		List<String> aptNum = new ArrayList<String>();
		// String address = request.getParameter("address");

		try {
			SaleDao2 dao = new SaleDao2();
			aptNum = dao.getAptNumByAddr(search);
			
			saleMap = (Map<List<String>, List<SaleImage>>) dao.selectAptImgList(search,aptNum);
			//System.out.println(saleMap.toString());
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