package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.AdminDao;

public class AdminLogin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		try {
			AdminDao dao = new AdminDao();

			String id = request.getParameter("adminId");
			String pwd = request.getParameter("adminPwd");

			boolean result = dao.adminLogin(id, pwd);

			if (result) { // 로그인 완료
				forward.setPath("Main.jsp");
				session.setAttribute("adminId", id);
			} else {
				forward.setPath("/Login.jsp");
			}

		} catch (Exception e) {
			System.out.println("LoginService 예외");
		}
		return forward;
	}
}
