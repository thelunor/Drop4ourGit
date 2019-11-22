package kr.or.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.SaleDao;
import kr.or.bit.dto.Sale;
import net.sf.json.JSONArray;


@WebServlet("/SaleData")
public class SaleData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SaleData() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	      request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
		  PrintWriter out = response.getWriter();
		  String addr = request.getParameter("addr");
	  	  ArrayList<Sale> saleList;
	  	  
		try {
		  	  SaleDao dao = new SaleDao();
			
			saleList = dao.searchSale(addr);
			System.out.println(saleList);
	  	    JSONArray jsonlist = JSONArray.fromObject(saleList);
	  	    out.print(jsonlist);
	  	    System.out.println(jsonlist);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
