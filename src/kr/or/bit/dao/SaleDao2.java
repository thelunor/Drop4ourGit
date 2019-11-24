package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Sale;
import kr.or.bit.dto.SaleImage;
import kr.or.bit.utils.DB_Close;

public class SaleDao2 {

	DataSource ds = null;

	public SaleDao2() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public int insertSale(Sale sale) { // 매물 넣기
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("타앙아아아아입: "+sale.toString());
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			
			//매물 테이블에 객체 넣기
			String sql_insert_sale = "insert into sale(aptNum, aptSize, type, addr, aptName, aptDong, aptHo, price, direction, etc, isContract,reaId)" + 
								"values(seq_aptNum.nextval,?,(select type from type where type=?),?,?,?,?,?,?,?,?,(select reaid from reauser where reaid=?))";
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
			
			
			if(resultRow>0) {
				System.out.println("매물 정보 DB 등록 성공");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultRow;
	}
	
//	public int insertImg(SaleImage saleImage) { // 매물 이미지 넣기
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int resultRow = 0;
///		try {
//			conn = ds.getConnection();
//			conn.setAutoCommit(false); //트랜잭션 처리
//			
//			//매물 테이블에 객체 넣기
//			
//			//1. 매물 테이블에서 매물 번호 가져오기 
//			String sql_max_aptNum = "select max(aptnum) as maxNum from sale";
//			pstmt = conn.prepareStatement(sql_max_aptNum);
//			
//			
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				String aptMax=rs.getString("maxNum");
//				System.out.println(aptMax);
//			} else {
//				System.out.println("rs가 없어욤...");
//			}
//			
//			System.out.println("resultRow: " + resultRow);
//			if(resultRow>1) {
//				conn.commit();
//			}
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return resultRow;
//	}

	public Sale getSaleDataByAptNum(String aptNum) { // 매물 한개 읽기 (매물 번호로)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Sale sale = null;
		try {
			conn = ds.getConnection();
			String sql_select_aptInfo = "select aptnum, aptsize, type, addr, aptname, aptdong, aptho, price, direction, etc, iscontract, reaid from sale"
					+" where aptnum=?";
			pstmt = conn.prepareStatement(sql_select_aptInfo);
			pstmt.setString(1, aptNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sale = new Sale();
				sale.setAptNum(rs.getString("aptNum"));
				sale.setAptSize(rs.getString("aptSize"));
				sale.setType(rs.getString("type"));
				sale.setAddr(rs.getString("addr"));
				sale.setAptName(rs.getString("aptName"));
				sale.setAptDong(rs.getString("aptDong"));
				sale.setAptHo(rs.getString("aptHo"));
				sale.setPrice(Integer.parseInt(rs.getString("price")));
				sale.setDirection(rs.getString("direction"));
				sale.setEtc(rs.getString("etc"));
				sale.setIsContract(rs.getString("isContract"));
				sale.setId(rs.getString("reaId"));

			}
			System.out.println("DB에서 온 아파트 정보" + sale.toString());

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return sale;
	}
	
	public String getAptNumByAptInfo(String aptName, String aptDong, String aptHo) { // 매물 번호 읽기 (아파트 이름, 동, 호수로)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String aptNum = "";
		try {
			conn = ds.getConnection();
			String sql_select_aptInfo = "select aptnum from sale where aptname=? and aptdong=? and aptho=?";
			pstmt = conn.prepareStatement(sql_select_aptInfo);
			pstmt.setString(1, aptName);
			pstmt.setString(2, aptDong);
			pstmt.setString(3, aptHo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				aptNum = rs.getString("aptNum");
			}
			System.out.println(aptNum);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return aptNum;
	}

	public List<Sale> getSaleList(String id) { // 매물 리스트 출력(공인중개사 아이디로)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Sale> saleList = null;
		
		try {
			conn = ds.getConnection();
			String sql_select_sale = "select aptnum,aptsize,type,addr,aptname,aptdong,aptho,price,iscontract from sale where reaid=?";
			pstmt = conn.prepareStatement(sql_select_sale);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			saleList = new ArrayList<Sale>();
			while(rs.next()) {
				Sale sale = new Sale();
				sale.setAptNum(rs.getString("aptNum")); //매물번호				
				sale.setAptSize(rs.getString("aptSize")); //면적
				sale.setType(rs.getString("type")); //유형
				sale.setAddr(rs.getString("addr")); //주소
				sale.setAptName(rs.getString("aptName")); //아파트이름
				sale.setAptDong(rs.getString("aptDong")); //동
				sale.setAptHo(rs.getString("aptHo")); //호수
				sale.setPrice(Integer.parseInt(rs.getString("price"))); //매매가
				sale.setIsContract(rs.getString("isContract"));
				saleList.add(sale);
				System.out.println("saleDao2 완료");
			}
		}catch(Exception e) {
			
		}finally {
			DB_Close.close(pstmt);
			DB_Close.close(rs);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saleList;
	}

	public int updateSale(Sale sale) { // 매물 수정 (2019/11/24/알파카)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			
			//매물 테이블에 객체 넣기
			String sql_update_sale = "update sale set aptsize=?,type=(select type from type where type=?),addr=?,aptname=?,aptdong=?,aptho=?,price=?,direction=?,etc=?,iscontract=?"
					+" where aptnum=?";
			pstmt = conn.prepareStatement(sql_update_sale);
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
			pstmt.setString(11, sale.getAptNum());
			resultRow = pstmt.executeUpdate();
			
			if(resultRow>0) {
				System.out.println("매물 정보 DB 수정 성공");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultRow;
	}

	public int deleteSale(String aptNum) { // 매물 삭제(매물 번호로)
		return 0;
	}
	
	public ArrayList<Sale> selectAtpList(String addr) { // 주소로 아파트 이름, 아파트 동, 아파트 가격 조회(매물 보는 첫 페이지)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Sale> saleList = null;
		String sql_select_aptList = "select aptname, aptdong, price from sale where addr=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql_select_aptList);
			pstmt.setString(1, addr);
			rs = pstmt.executeQuery();
			saleList = new ArrayList<Sale>();

			while (rs.next()) {
				Sale sale = new Sale();
				sale.setAptName(rs.getString("aptName")); // 아파트 이름
				sale.setAptDong(rs.getString("aptDong")); // 아파트 동
				sale.setPrice(rs.getInt("price"));

				saleList.add(sale);
			}
		System.out.println(saleList);	
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saleList;

	}

}
