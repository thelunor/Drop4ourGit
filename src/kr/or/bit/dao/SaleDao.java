package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		ResultSet rs = null;
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); //트랜잭션 처리
			
			//매물 테이블에 객체 넣기
			String sql_insert_sale = "insert into sale(aptNum, aptSize, type, addr, aptName, aptDong, aptHo, price, direction, etc, isContract,reaId)" + 
								" values(seq_aptNum.nextval, ?,(select type from type where type=?),?,?,?,?,?,?,?,?,(select reaid from reauser where reaid=?))";
			pstmt = conn.prepareStatement(sql_insert_sale);
			pstmt.setString(1, sale.getAptSize());
			pstmt.setString(2, sale.getType());
			pstmt.setString(3, sale.getAddr());
			pstmt.setString(4, sale.getAptName());
			pstmt.setString(5, sale.getAptDong());
			pstmt.setString(6, sale.getAptHo());
			pstmt.setInt(7, sale.getPrice());
			pstmt.setString(8, sale.getDirection());
			pstmt.setString(9, sale.getEtc());
			pstmt.setString(10, sale.getIsContract());
			pstmt.setString(11, sale.getId());
			resultRow = pstmt.executeUpdate();
			System.out.println("resultRow" + resultRow);
			if(resultRow>0) {
				conn.commit();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return resultRow;
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
