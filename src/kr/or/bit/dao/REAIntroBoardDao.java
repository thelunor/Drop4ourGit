package kr.or.bit.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.REAIntroBoard;

public class REAIntroBoardDao {

	DataSource ds = null;

	public REAIntroBoardDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
	/* 소개 페이지 넣기, 읽기, 수정, 삭제 */

	public int insertREAIntro(REAIntroBoard reaintro) { // 소개 페이지 넣기
		return 0;
	}

	public REAIntroBoard getREAIntroData() { // 소개 읽기
		return null;
	}

	public int updateREAIntro(REAIntroBoard reaintro) { // 소개 수정
		return 0;
	}

	public int deleteREAIntro(String id) { // 소개 삭제(공인중개사 id로)
		return 0;
	}
}
