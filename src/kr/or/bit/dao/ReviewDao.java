package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Review;
import kr.or.bit.utils.DB_Close;

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
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO REVIEW (REVIEWNUM, USERID, REVIEWCONTENT, REVIEWDATE, REAID) " 
						+ " VALUES (SEQ_REVIEW.NEXTVAL, (SELECT USERID FROM GENERICUSER WHERE USERID=?), "
						+ " ?, SYSDATE, (SELECT REAID FROM REAUSER WHERE REAID=?))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getUserId());
			pstmt.setString(2, review.getReviewContent());
			pstmt.setString(3, review.getReaId());
			row = pstmt.executeUpdate();
			
			if (row > 0) {
				System.out.println("후기등록 성공");
			}
		} catch (Exception e) {
			System.out.println("리뷰등록 dao 예외발생");
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return row;
	}
	
	public Review getReview(String userId, String reaId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Review review = null;
		try {
			conn = ds.getConnection();
			String sql_select_review = "select userid,reviewcontent,reviewdate from review where userid=? and reaid=?";
			pstmt = conn.prepareStatement(sql_select_review);
			pstmt.setString(1, userId);
			pstmt.setString(2, reaId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				review = new Review();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date date = sdf.parse(rs.getString("reviewDate"));
	            Date reviewDate = new Date(date.getTime());
				review.setUserId(rs.getString("userid"));
				review.setReviewContent(rs.getString("reviewcontent"));
				review.setReviewDate(reviewDate);
				
			}
		}catch(Exception e) {
			
		}finally {
			
		}
		return review;
	}

	public List<Review> getReviewList(String id) { // 리뷰 리스트 가져오기(공인중개사 id로)
		/* 리뷰 리스트 가져올 때 댓글도 가져오기! */
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Review> rvList = null;
		
		try {
			conn = ds.getConnection();
			String review_sql = "SELECT RV.REVIEWNUM, RV.USERID, RV.REVIEWCONTENT, RV.REVIEWDATE, RV.REAID " + 
								"FROM REVIEW RV JOIN REAUSER RU " + 
								"ON RV.REAID = RU.REAID " + 
								"WHERE RV.REAID=? " +
								"ORDER BY RV.REVIEWNUM";
			pstmt = conn.prepareStatement(review_sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rvList = new ArrayList<Review>();
			
			while (rs.next()) {
				System.out.println("ReviewDao rs 성공");
				Review review = new Review();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date date = sdf.parse(rs.getString("reviewDate"));
	            Date reviewDate = new Date(date.getTime());
				
				review.setReviewNum(rs.getInt("reviewNum"));
				review.setUserId(rs.getString("userId"));
				review.setReviewContent(rs.getString("reviewContent"));
				review.setReviewDate(reviewDate);
				review.setReaId(rs.getString("reaId"));
				
				rvList.add(review);
//				System.out.println("ReviewDao getList rvList: " + rvList);
			}
		} catch (Exception e) {
			System.out.println("ReviewDao 예외발생");
			System.out.println(e.getMessage());
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);

			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("ReviewDao 예외발생2");
				System.out.println(e.getMessage());
			}
		}
		
		return rvList;
	}

	public int updateReview(Review review) { // 리뷰 수정
		return 0;
	}

	public int deleteReview(int reviewNum) { // 리뷰 삭제(글번호로)
		/* 리뷰 삭제시 리뷰에 댓글이 있는 경우 댓글부터 삭제해야 함! */
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow = 0;
		
		try {
			conn = ds.getConnection();
			String sql_del_review = "delete from review where reviewNum=?";
			
			pstmt = conn.prepareStatement(sql_del_review); //리뷰에 댓글 있는지 확인
			pstmt.setInt(1, reviewNum);
			resultRow = pstmt.executeUpdate();
			if(resultRow>0) {
				System.out.println("삭제 완료");
			}
			
			
		} catch (Exception e) {
			System.out.println("ReviewDao delete 예외발생");
			System.out.println(e.getMessage());
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return resultRow;
	}
	
	/*
	public int deleteReview(int reviewNum) { // 리뷰 삭제(글번호로)
		 리뷰 삭제시 리뷰에 댓글이 있는 경우 댓글부터 삭제해야 함! 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow = 0;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); //트랜잭션
			리뷰 댓글이 있는지 확인
			String sql_select_comment = "SELECT REVIEWNUM FROM reviewComment WHERE reviewNum=?";
			String sql_del_comment = "delete from reviewComment where reviewNum=?";
			String sql_del_review = "delete from review where reviewNum=?";
			
			
			pstmt = conn.prepareStatement(sql_select_comment); //리뷰에 댓글 있는지 확인
			pstmt.setInt(1, reviewNum);
			rs = pstmt.executeQuery();
			if(rs.next()) { //댓글이 있는 경우
				System.out.println("댓글 있는지 확인");

				pstmt = conn.prepareStatement(sql_del_comment); 
				pstmt.setInt(1, reviewNum);
				resultRow = pstmt.executeUpdate(); //댓글 삭제
				if(resultRow > 0 ) { //댓글이 삭제 되면 후기도 삭제함
					pstmt = conn.prepareStatement(sql_del_review);
					pstmt.setInt(1, reviewNum);
					resultRow = pstmt.executeUpdate(); //후기 삭제
					conn.commit();
				}
			}
			if(!rs.next()) { //댓글이 없는 경우 바로 후기 삭제
				pstmt = conn.prepareStatement(sql_del_review);
				pstmt.setInt(1, reviewNum);
				resultRow = pstmt.executeUpdate(); //후기 삭제
				conn.commit();
			}
			
		} catch (Exception e) {
			System.out.println("ReviewDao delete 예외발생");
			System.out.println(e.getMessage());
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return resultRow;
	}
	*/
}
