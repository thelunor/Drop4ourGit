//package kr.or.bit.ajax;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kr.or.bit.action.ActionForward;
//import kr.or.bit.dao.SaleDao;
//import kr.or.bit.dto.Sale;
//import kr.or.bit.dto.SaleImage;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
///**
// * Servlet implementation class InfiniteScroll
// */
//@WebServlet("/InfiniteScroll")
//public class InfiniteScroll extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public InfiniteScroll() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
//		PrintWriter out = response.getWriter();
//		SaleDao dao = null;
//		String search = request.getParameter("search");
//		System.out.println(search);
//		Map<Sale, SaleImage> saleMap = new HashMap<Sale, SaleImage>();
//		try {
//			dao = new SaleDao();
//			saleMap = dao.selectAtpList(search);
//			//System.out.println(saleMap.toString());
//
//			// System.out.println(saleMap.toString());
//			if (saleMap != null) {
//				JSONObject jsonlist = new JSONObject();
//				for (Map.Entry<Sale, SaleImage> entry : saleMap.entrySet()) {
//					Sale key = entry.getKey();
//					SaleImage value = entry.getValue();
//					jsonlist.put(key, value);
//					System.out.println(jsonlist.toString());
//				}
//				
////				System.out.println(jsonlist.toString());
//				out.print(jsonlist);
//			} else {
//				System.out.println("InfiniteScroll Ajax 오류");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doProcess(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doProcess(request, response);
//	}
//
//}
