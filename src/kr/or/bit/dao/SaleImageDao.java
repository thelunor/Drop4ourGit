package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public int insertSaleImage(SaleImage saleImg, String aptNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); //트랜잭션 처리
			
			
			//1. 매물 사진 테이블에 객체 저장(aptNum 제외)
			String sql_insert_sale =
			"insert into saleImage(saleImgNum, saleImgSaveName, saleImgOriginName) values(seq_saleImg.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql_insert_sale);
			pstmt.setString(1, saleImg.getSaleImgSaveName());
			pstmt.setString(2, saleImg.getSaleImgOriginName());
			resultRow = pstmt.executeUpdate();
			
			//2. sale 테이블에서 아파트 이름, 동, 호수 가져오기
			String sql_select_aptInfo = "";
			
			if(resultRow>0) {
				conn.commit();
				System.out.println("commit완료");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return resultRow;
	}

}
