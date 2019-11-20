package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.UserDao;

public class UserLoginService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		try {
			UserDao dao = new UserDao();
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			boolean result = dao.userLogin(id, pwd);
			System.out.println(dao);
			System.out.println(id);
			System.out.println(pwd);
			System.out.println("result:"+result);
			if (result) { // 로그인 성공
				forward.setPath("Main.jsp");
				session.setAttribute("id", id);
				System.out.println(1);
			} else {
				forward.setPath("Login.jsp");
				System.out.println(2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
		}
		
		return forward;
	}

}
