package kr.or.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.ReviewDao;

/**
 * Servlet implementation class DeleteReview
 */
@WebServlet("/DeleteReview")
public class DeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteReview() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
    	String reviewNum = request.getParameter("reviewNum");
    	ReviewDao dao = null;
    	int result = 0;
    	try {
			dao = new ReviewDao();
			System.out.println("reviewNum"+reviewNum);
			result = dao.deleteReview(Integer.parseInt(reviewNum));

			System.out.println("result"+result);
			if(result > 0) {
				out.print("<script>alert('댓글이 삭제 되었습니다.')</script>");
			}
    
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("댓글 delete ajax 오류");
		}
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
