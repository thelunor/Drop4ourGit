package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.REAImageDao;
import kr.or.bit.dao.REAIntroBoardDao;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dao.ReviewDao;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAIntroBoard;
import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.Review;

public class GetREAIntroDataService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		REAUser reaUser = null;
		REAImage reaImg = null;
		REAUserDao readao = null;
		REAImageDao imgdao = null;
		HttpSession session = request.getSession();
		String reaId = (String) session.getAttribute("reaUserId");											
		List<Review> rvList = null;
		ReviewDao rvdao = null;
		REAIntroBoard reaIntro = null;
		REAIntroBoardDao reaIntrodao = null;
		
		try {
			forward = new ActionForward();
			readao = new REAUserDao();
			imgdao = new REAImageDao();
			rvList = new ArrayList<Review>();
			rvdao = new ReviewDao();
			reaIntrodao = new REAIntroBoardDao();
			
			reaUser = readao.getREAMypage(reaId);
			reaImg = imgdao.getREAImg(reaId);
			rvList = rvdao.getReviewList(reaId);
			reaIntro = reaIntrodao.getREAIntroData(reaId);
			System.out.println("reaUser: " + reaUser);
			System.out.println("rvList: " + rvList);
			System.out.println("reaIntro: " + reaIntro);
			if(reaUser != null && reaImg != null && rvList != null) {
				request.setAttribute("reaUser", reaUser);
				request.setAttribute("reaImg", reaImg);
				request.setAttribute("rvList", rvList);
				request.setAttribute("reaIntro", reaIntro);
				forward.setPath("REAIntro.jsp");
			}
		} catch (Exception e) {
			System.out.println("getREAIntroService 예외발생");
			System.out.println(e.getMessage());
		}
		
		return forward;
	}

}
