package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.GenericUserDao;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dao.ReviewDao;
import kr.or.bit.dto.GenericUser;
import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.Review;

public class SelectReviewService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		List<Review> rvlist = null;
		String id = request.getParameter("reaId"); // reaId 받아오기
		
		try {
			ReviewDao rvdao = new ReviewDao();
			
			rvlist = rvdao.getReviewList(id);
			
		} catch (Exception e) {
			System.out.println("review service 예외발생");
			System.out.println(e.getMessage());
		}
		forward = new ActionForward();
		forward.setPath("SelectReviewOk.d4b");
		
		return forward;
	}

}
