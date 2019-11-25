package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.REAImageDao;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dao.ReviewDao;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.Review;

public class GetReviewListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		REAUser reaUser = new REAUser();
		REAImage reaImg = new REAImage();
		REAUserDao rdao = null;
		REAImageDao imgdao = null;
		ReviewDao rvdao = null;
		List<Review> rvlist = null;
		HttpSession session = request.getSession();
		String reaId = (String) session.getAttribute("reaId");
		
		try {
			forward = new ActionForward();
			rdao = new REAUserDao();
			imgdao = new REAImageDao();
			rvdao = new ReviewDao();
			reaUser = rdao.getREAUserInfo(reaId);
			reaImg = imgdao.getREAImg(reaId);
			rvlist = rvdao.getReviewList(reaId);
			request.setAttribute("rvList", rvlist);
		} catch (Exception e) {
			System.out.println("review service 예외발생");
			System.out.println(e.getMessage());
		}
		forward = new ActionForward();
		forward.setPath("SelectReviewOk.d4b");
		
		return forward;
	}

}
