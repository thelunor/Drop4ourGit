package kr.or.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.ReviewDao;
import kr.or.bit.dto.Review;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class EditReview
 */
@WebServlet("/EditReview")
public class EditReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditReview() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	String reaId = request.getParameter("reaId");
    	String userId = request.getParameter("userId");
		String reviewContent = request.getParameter("reviewContent");
    			
    	Review review = null;
    	ReviewDao rvdao = null;
    	int result = 0;
    	
    	try {
    		review = new Review();
    		rvdao = new ReviewDao();
    		//수정할 때 필요한 거 : reviewNum, reviewContent!
    		//1. 일단 reviewNum 찾아오기
    		
    		
    		//2. DB에서 수정하기
    		review.setReaId(reaId);
    		review.setUserId(userId);
    		review.setReviewContent(reviewContent);
    		
    		result = rvdao.updateReview(review);
    	
    		if (result > 0) {
    		  	JSONArray jsonlist = JSONArray.fromObject(review);
    		  	out.print(jsonlist); 
    		}
    	} catch (Exception e) {
    		System.out.println("Update ajax 예외발생");
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
