package kr.or.bit.dao;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.SaleImage;

public class SaleImageDao {
	DataSource ds = null;

	public SaleImageDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public int insertSaleImg(SaleImage saleImg) { // 매물 이미지 DB 넣기
		return 0;
	}

	public List<SaleImage> getSaleImg(String aptNum) { // 매물 이미지 불러오기 (매물 번호로)
		return null;
	}

	public int updateSaleImg(SaleImage saleImg) { // 매물 이미지 수정
		return 0;
	}

	public int deleteSaleImg(String aptNum) { // 매물 이미지 삭제 (매물 번호로)
		return 0;
	}

}
