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
import kr.or.bit.dao.ReviewDao;
import kr.or.bit.dto.REAImage;
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
		
		try {
			forward = new ActionForward();
			readao = new REAUserDao();
			imgdao = new REAImageDao();
			rvList = new ArrayList<Review>();
			rvdao = new ReviewDao();
			
			reaUser = readao.getREAMypage(reaId);
			reaImg = imgdao.getREAImg(reaId);
			rvList = rvdao.getReviewList(reaId);
			System.out.println(rvList.toString());
			
			request.setAttribute("reaUser", reaUser);
			request.setAttribute("reaImg", reaImg);
			request.setAttribute("rvList", rvList);
			System.out.println("정상진행");
		} catch (Exception e) {
			System.out.println("getREAIntroService 예외발생");
			System.out.println(e.getMessage());
		}
		forward.setPath("GetReviewListService.d4b");
		
		return forward;
	}

}
