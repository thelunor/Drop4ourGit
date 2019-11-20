package kr.or.bit.dao;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Sale;

public class SaleDao {

	DataSource ds = null;

	public SaleDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public int insertSale(Sale sale) { // 매물 넣기
		return 0;
	}

	public Sale getSaleData(String aptNum) { // 매물 한개 읽기 (매물 번호로)
		return null;
	}

	public List<Sale> getSaleList(String id) { // 매물 리스트 출력(공인중개사 아이디로)
		return null;
	}

	public int updateSale(Sale sale) { // 매물 수정
		return 0;
	}

	public int deleteSale(String aptNum) { // 매물 삭제(매물 번호로)
		return 0;
	}
}
