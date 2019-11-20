package kr.or.bit.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.REAUser;

public class REAUserDao {
	DataSource ds = null;

	public REAUserDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public int updateREAUser(REAUser user) { // 중개사회원 수정
		return 0;
	}
}
