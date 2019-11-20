package kr.or.bit.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.GenericUser;

public class GenericUserDao {
	
	DataSource ds = null;

	   public GenericUserDao() throws NamingException {
	      Context context = new InitialContext();
	      ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	   }
	public int updateGenericUser(GenericUser user) { // 일반회원 수정
		return 0;
	}
}
