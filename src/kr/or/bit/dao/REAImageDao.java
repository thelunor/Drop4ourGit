package kr.or.bit.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.SaleImage;

public class REAImageDao {
	DataSource ds = null;

	public REAImageDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	/* 공인중개사 이미지 넣기, 이미지 불러오기, 이미지 수정하기, 이미지 삭제(공인중개사 id로) */
	public int insertREAImg(REAImage reaImg) { // 공인중개사 이미지 넣기
		return 0;
	}

	public REAImage getREAImg(String id) { // 공인중개사 이미지 불러오기 (공인중개사 아이디로)
		return null;
	}

	public int updateREAImg(REAImage reaImg) { // 공인중개사 이미지 수정
		return 0;
	}

	public int deleteREAImg(String id) { // 공인중개사 이미지 삭제(공인중개사 id로)
		return 0;
	}
}
