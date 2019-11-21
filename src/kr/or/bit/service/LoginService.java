package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.AdminDao;
import kr.or.bit.dao.GenericUserDao;
import kr.or.bit.dao.REAUserDao;

public class LoginService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);

		try {

				AdminDao dao = new AdminDao();
				boolean result = dao.adminLogin(id, pwd);

				if (result) { // 로그인 완료		
					forward.setPath("Main.jsp");
					session.setAttribute("id", id);
					
					return forward;
					
				} else {
					forward.setPath("Login.jsp");
				}								
			

			
				GenericUserDao gdao = new GenericUserDao();
				boolean gresult = gdao.GenericUserLogin(id, pwd);
				
				if (gresult) { // 로그인 완료		
					forward.setPath("Main.jsp");
					session.setAttribute("id", id);
					return forward;
				} else {
					forward.setPath("Login.jsp");
					
				}	
				
				REAUserDao rdao = new REAUserDao();
				boolean rresult = rdao.REAUserLogin(id, pwd);
				if (rresult) { // 로그인 완료		
					forward.setPath("Main.jsp");
					session.setAttribute("id", id);
					return forward;
				} else {
					forward.setPath("Login.jsp");
				}				


		} catch (Exception e) {
			System.out.println("LoginService 예외");
		}
		return forward;
	}
}