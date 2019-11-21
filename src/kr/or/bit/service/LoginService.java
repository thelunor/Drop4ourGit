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

		try {
			AdminDao aDao = new AdminDao();
			boolean aResult = aDao.adminLogin(id, pwd);
			if (aResult) { // 로그인 완료
				forward.setPath("Main.jsp");
				session.setAttribute("id", id);
				return forward;
			} else {
				forward.setPath("Login.jsp");
			}
			
			GenericUserDao gDao = new GenericUserDao();
			String gResult = gDao.GenericUserLogin(id, pwd);
			if (gResult.equals("black")) { // 로그인 완료
				forward.setPath("Main.jsp");
				session.setAttribute("id", id);
				return forward;
			} else {
				forward.setPath("Login2.jsp");
			}
			
			REAUserDao rDao = new REAUserDao();
			boolean rResult = rDao.REAUserLogin(id, pwd);
			if (rResult) { // 로그인 완료
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
