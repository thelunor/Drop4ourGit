package kr.or.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.ReviewDao;
import kr.or.bit.dto.Review;
import net.sf.json.JSONArray;

@WebServlet("/SelectReview")
public class SelectReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectReview() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	
    	PrintWriter out = response.getWriter();
    	String reaId = request.getParameter("reaId");
		String ps = request.getParameter("pageSize"); // pagesize
		String cp = request.getParameter("cp"); // current page
		String type = request.getParameter("type");
    	ReviewDao rvDao = null;
    	List<Review> rvlist = null;
    	
    	try {
    		
    		rvDao = new ReviewDao();
    		rvlist = new ArrayList<Review>();
    		
    		int count = rvDao.
			if (ps == null || ps.trim().equals("")) {
				// default 값 설정
				ps = "5";
			}
			if (cp == null || cp.trim().equals("")) {
				// default 값 설정
				cp = "1";
			}
			int pageSize = Integer.parseInt(ps);
			int cPage = Integer.parseInt(cp);
			int pageCount = 0;

			if (count % pageSize == 0) {
				pageCount = count / pageSize;
			} else {
				pageCount = (count / pageSize) + 1;
			}
			saleMap = dao.selectAtpList(search, cPage, pageSize);
    		
    		
    		
    		rvlist = rvdao.getReviewList(reaId);
    		JSONArray jsonlist = JSONArray.fromObject(rvlist);
    		out.print(jsonlist);
    		
    	} catch (Exception e) {
    		System.out.println("Review ajax 예외발생");
			System.out.println(e.getMessage());
		}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
