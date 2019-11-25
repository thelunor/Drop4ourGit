package kr.or.bit.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ReviewDao;
import kr.or.bit.dto.Review;

public class InsertReviewService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		// 데이터 받기: reviewNum, userId, reviewContent, reviewDate, reaId
		int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
		String userId = request.getParameter("userId");
		String reviewContent = request.getParameter("reviewContent");
		Date reviewDate = null;
		try {
			reviewDate = (Date) new SimpleDateFormat().parse(request.getParameter("reviewDate"));
		} catch (ParseException e1) {
			System.out.println("reviewDate 예외발생");
			System.out.println(e1.getMessage());
		}
		String reaId = request.getParameter("reaId");
		System.out.println("InsertReview reaId: " + reaId);
		// 객체에 데이터 저장
		Review review = new Review();
		review.setReviewNum(reviewNum);
		review.setUserId(userId);
		review.setReviewContent(reviewContent);
		review.setReviewDate(reviewDate);
		review.setReaid(reaId);
		
		// 데이터 저장 확인
		System.out.println("데이터 저장 확인: " + review.toString());
		
		try {
			// DB 저장
			ReviewDao rvdao = new ReviewDao();
			int result = rvdao.insertReview(review);
			if (result > 0) {
				forward.setPath("REAIntro.jsp");
			} else {
				forward.setPath("Main.jsp");
			}
		} catch (Exception e) {
			System.out.println("InsertReviewService 예외발생");
			System.out.println(e.getMessage());
		}
		
		return forward;
	}

}
