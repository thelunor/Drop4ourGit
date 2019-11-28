package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Sale;
import kr.or.bit.dto.SaleImage;
import kr.or.bit.dto.SaleList;
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
			pstmt.setString(7, sale.getPrice());
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
	
	/*
	
	public Map<String, List<SaleImage>> selectAptList(String addr){ //주소로 map 객체 만들기
		//1. String 배열에 매물 번호 넣기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String[] a = String[] {3};
		List<String> aptNum = new ArrayList<String>(); //addr로 aptNum 찾기
		List<SaleImage> saleImgList = new ArrayList<SaleImage>();
		try {
			conn = ds.getConnection();
			String sql_select_aptNum = "select s.aptnum, i.saleimgsavename from sale s join saleimage i on (s.aptNum=i.aptNum) where addr like ?";
			pstmt = conn.prepareStatement(sql_select_aptNum);
			pstmt.setString(1, "%"+addr+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SaleImage saleImg = new SaleImage();
				
				aptNum.add(rs.getString(1));
				saleImg.setSaleImgSaveName(rs.getString(2));
				saleImgList.add(saleImg);
			}
		
			
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
		//2. List에 sale 넣기
		return null;
	}

	
	public Map<List<String>, List<SaleImage>> selectAptImgList(String addr, String aptNum){ //주소로 map 객체 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<List<String>, List<SaleImage>> mapList = new Map<List<String>, List<SaleImage>>();
		List<SaleImage> saleImgList = new ArrayList<SaleImage>();
		String inputAptNum = "";
		try {
			conn = ds.getConnection();
			String sql_select_aptNum = "select s.aptnum, i.saleimgsavename from sale s join saleimage i on (s.aptNum=i.aptNum) where addr like ? and s.aptNum=?";
			pstmt = conn.prepareStatement(sql_select_aptNum);
			pstmt.setString(1, "%"+addr+"%");
			pstmt.setString(2, aptNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SaleImage saleImg = new SaleImage();
				inputAptNum = rs.getString(1);//매물 번호 KEY값으로 저장
				saleImg.setSaleImgSaveName(rs.getString(2));
				saleImgList.add(saleImg);				
				mapList.put(rs.getString(1), saleImgList);
			}
			System.out.println(mapList.containsKey(inputAptNum));
			System.out.println(mapList.get(inputAptNum));
				
		}catch(Exception e) {
			
		}finally {
			
		}
		
		//2. List에 sale 넣기
		return null;
	}
		*/
	
	public List<String> getAptNumByAddr(String addr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> aptNumList = new ArrayList<String>();
		String aptNum="";
		try {
			conn = ds.getConnection();
			String sql = "select aptNum from sale where addr like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+addr+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				aptNum = rs.getString("aptNum");
				aptNumList.add(aptNum);
			}
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
		return aptNumList;
	}
	
	public Sale getSaleDataByAptNum(String aptNum) { // 매물 한개 읽기 (매물 번호로)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Sale sale = null;
		try {
			conn = ds.getConnection();
			String sql_select_aptInfo = "select aptnum, aptsize, type, addr, aptname, aptdong, aptho, price, direction, etc, iscontract, reaid, roadaddr from sale"
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
				sale.setPrice(rs.getString("price"));
				sale.setDirection(rs.getString("direction"));
				sale.setEtc(rs.getString("etc"));
				sale.setIsContract(rs.getString("isContract"));
				sale.setId(rs.getString("reaId"));
				sale.setRoadAddr(rs.getString("roadAddr"));

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
		Sale sale = null;
		
		try {
			conn = ds.getConnection();
			String sql_select_sale = "select aptnum,aptsize,type,addr,aptname,aptdong,aptho,price,iscontract from sale where reaid=? ORDER BY aptnum desc";
			pstmt = conn.prepareStatement(sql_select_sale);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			saleList = new ArrayList<Sale>();
			while(rs.next()) {
				sale = new Sale();
				sale.setAptNum(rs.getString("aptNum")); //매물번호				
				sale.setAptSize(rs.getString("aptSize")); //면적
				sale.setType(rs.getString("type")); //유형
				sale.setAddr(rs.getString("addr")); //주소
				sale.setAptName(rs.getString("aptName")); //아파트이름
				sale.setAptDong(rs.getString("aptDong")); //동
				sale.setAptHo(rs.getString("aptHo")); //호수
				sale.setPrice(rs.getString("price")); //매매가
				sale.setIsContract(rs.getString("isContract"));
				saleList.add(sale);
			}
			System.out.println("몇개야?"+saleList.size());

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
			String sql_update_sale = "update sale set aptsize=?,type=(select type from type where type=?),addr=?,aptname=?,aptdong=?,aptho=?,price=?,direction=?,etc=?,iscontract=?,roadAddr=?"
					+" where aptnum=?";
			pstmt = conn.prepareStatement(sql_update_sale);
			pstmt.setString(1, sale.getAptSize());
			pstmt.setString(2, sale.getType());
			pstmt.setString(3, sale.getAddr());
			pstmt.setString(4, sale.getAptName());
			pstmt.setString(5, sale.getAptDong());
			pstmt.setString(6, sale.getAptHo());
			pstmt.setString(7, sale.getPrice());
			pstmt.setString(8, sale.getDirection());
			pstmt.setString(9, sale.getEtc());
			pstmt.setString(10, sale.getIsContract());
			pstmt.setString(11, sale.getRoadAddr());
			pstmt.setString(12, sale.getAptNum());
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

	public int deleteSale(String aptNum) { // 매물 삭제(매물 번호로) (2019/11/25/알파카)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			String sql_delete_saleImg = "delete from saleImage where aptnum=?";
			String sql_delete_sale = "delete from sale where aptnum=?";
			
			pstmt = conn.prepareStatement(sql_delete_saleImg);
			pstmt.setString(1, aptNum);
			resultRow = pstmt.executeUpdate();
			System.out.println("resultRow 1 "+resultRow);
						
			pstmt = conn.prepareStatement(sql_delete_sale);
			pstmt.setString(1, aptNum);
			resultRow = pstmt.executeUpdate();
			System.out.println("resultRow 2 "+resultRow);


			
			if(resultRow>0) {
				conn.commit();
				System.out.println("매물 삭제 완료");

			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("delete sale dao 오류");
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
				sale.setPrice(rs.getString("price"));

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

	
	
	
	public List<SaleList> getSaleListList(String addr){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SaleList saleList = null;
		List<SaleList> saleListList = new ArrayList<SaleList>();
		try {
			conn = ds.getConnection();
			String sql = "select s.aptnum, s.aptsize, s.price, i.saleimgnum, i.saleimgsavename from sale s join saleimage i on (s.aptNum=i.aptNum) where addr like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+addr+"%");
			System.out.println("rs입성전");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("여기?");
				saleList = new SaleList();
				saleList.setAptNum(rs.getString(1));
				saleList.setSize(rs.getString(2));
				saleList.setPrice(rs.getString(3));
				saleList.setSaleimgnum(rs.getString(4));
				saleList.setSaleimgsavename(rs.getString(5));
				saleListList.add(saleList);
			}
			System.out.println("리스트1"+saleListList.get(0));
			System.out.println("리스트2"+saleListList.get(1));
			System.out.println("리스트3"+saleListList.get(2));
			System.out.println("리스트4"+saleListList.get(3));
			System.out.println("리스트5"+saleListList.get(4));
			System.out.println("리스트6"+saleListList.get(5));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saleListList;

	}
	
	
}
