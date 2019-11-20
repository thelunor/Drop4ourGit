package kr.or.bit.dao;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.BookMark;

public class BookMarkDao {
	/*
	 * 북마크 불러오기, 북마크 추가 삭제 기능 클래스
	 */
	
	DataSource ds = null;

	public BookMarkDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public List<BookMark> getBookMark(String id) { // id에 저장된 북마크 모두 가져오기
		return null;
	}

	public int insertBookMark(BookMark bookMark) { //북마크 생성
		return 0;
	}

	public int deleteBookMark(String id) { // 북마크 삭제하기
		return 0;
	}
}
