package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); //트랜잭션 처리
			//1. 거래유형에 거래유형 넣기
			String sql_insert_type = "insert into type(type) values(?)";
			pstmt = conn.prepareStatement(sql_insert_type);
			pstmt.setString(1, sale.getType());
			resultRow = pstmt.executeUpdate();
			
			
			//2. 공인중개사 id 가져와서 객체에 넣기
			//String sql_insert_sale = "insert into sale"
			
			String sql_select_reaId = "select reaId from reaUser where reaId=?";
			pstmt = conn.prepareStatement(sql_select_reaId);
			pstmt.setString(1, "");
					
			//3. 매물 테이블에 객체 넣기
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//1. 매물 번호 부여하기
		
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
