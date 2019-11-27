package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.REAImageDao;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dao.SaleDao2;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.Sale;

public class GetREAMypageService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		REAUser reaUser = new REAUser();
		REAImage reaImg=new REAImage();
		List<Sale> saleList = new ArrayList<Sale>();
		REAUserDao reaDao = null;
		REAImageDao imgDao=null;
		SaleDao2 saleDao = null;
		HttpSession session = request.getSession();
		String reaId = (String)session.getAttribute("userId");
		String type=(String)request.getAttribute("type");
		System.out.println("reaId 임돠"+reaId);
		try {

			forward = new ActionForward();
			reaDao = new REAUserDao();
			imgDao = new REAImageDao();
			saleDao = new SaleDao2();
			reaUser = reaDao.getREAMypage(reaId);
			reaImg =imgDao.getREAImg(reaId);
			saleList = saleDao.getSaleList(reaId);
			System.out.println("사용자" + reaUser.toString());
			System.out.println("사용자 이미지" + reaImg.toString());
			System.out.println(saleList.toString());
			//System.out.println("매물리스트"+saleList.get(0));
			if (reaUser != null && reaImg != null && saleList != null ) {
				request.setAttribute("reaUser", reaUser);
				request.setAttribute("reaImg", reaImg);
				request.setAttribute("saleList", saleList);
				request.setAttribute("type", type);
				forward.setPath("REAMypage.jsp");
			} else {
				System.out.println("조회 실패");
				forward.setPath("/AdminMain.jsp");
			}
		} catch (Exception e) {

		}
		return forward;
	}
}
