package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.BookMark;
import kr.or.bit.utils.DB_Close;

public class BookMarkDao {
	/*
	 * 북마크 불러오기, 북마크 추가 삭제 기능 클래스
	 */
	
	DataSource ds = null;

	public BookMarkDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public List<BookMark> getBookMark(String userId) { // id에 저장된 북마크 모두 가져오기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookMark> bmList = null;
		try {
			conn = ds.getConnection();
			String sql_get_bookmark = "select b.aptNum, s.aptSize, s.type, s.aptName, s.price from bookmark b join sale s" 
										+ "on b.aptNum = s.aptNum where userId=?";
			pstmt = conn.prepareStatement(sql_get_bookmark);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			bmList = new ArrayList<BookMark>();
			System.out.println("북마크 읽는 중");
			while(rs.next()) {
				BookMark bookmark = new BookMark();				
				bookmark.setAptNum(rs.getString(1)); //아파트 번호
				bookmark.setAptSize(rs.getString(2)); //아파트 면적
				bookmark.setType(rs.getString(3)); //아파트 유형
				bookmark.setAptName(rs.getString(4)); //아파트 이름
				bookmark.setPrice(rs.getString(5)); //아파트 가격
				
				bmList.add(bookmark);
				System.out.println("난 북마크 " + bmList);
			}
		}catch(Exception e) {
			
		}finally {
			DB_Close.close(pstmt);
			DB_Close.close(rs);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bmList;		
	}

	public int insertBookMark(BookMark bookMark) { //북마크 생성
		return 0;
	}

	public int deleteBookMark(String id) { // 북마크 삭제하기
		return 0;
	}
}
