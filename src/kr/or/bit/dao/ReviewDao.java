package kr.or.bit.dao;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Review;

public class ReviewDao {
	/*
	 * 작성자 : 일반회원 리뷰 등록, 리뷰 리스트 출력, 리뷰 수정, 리뷰 삭제
	 */
	DataSource ds = null;

	public ReviewDao() throws NamingException {
	      Context context = new InitialContext();
	      ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	   }

	public int insertReview(Review review) {
		return 0;
	}

	public List<Review> getReviewList(String id) { // 리뷰 리스트 가져오기(공인중개사 id로)
		/* 리뷰 리스트 가져올 때 댓글도 가져오기! */

		return null;
	}

	public int updateReview(Review review) { // 리뷰 수정
		return 0;
	}

	public int deleteReview(int reviewNum) { // 리뷰 삭제(글번호로)
		/* 리뷰 삭제시 리뷰에 댓글이 있는 경우 댓글부터 삭제해야 함! */
		return 0;
	}
}
