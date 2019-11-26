package kr.or.bit.service;

import java.io.PrintWriter;

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
		PrintWriter out=null;
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");


		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		try {
			out=response.getWriter();
			AdminDao aDao = new AdminDao();
			GenericUserDao gDao = new GenericUserDao();
			REAUserDao rDao = new REAUserDao();
			String gResult = null;
			String rResult = null;

			if (aDao.adminLogin(id, pwd)) { // 관리자 로그인 성공 시
				System.out.println(aDao.adminLogin(id, pwd));
				forward.setPath("UserMain.jsp");
				session.setAttribute("userId", id);
				request.setAttribute("type", "A00");
				return forward;
			}
			gResult = gDao.GenericUserLogin(id, pwd);
			rResult = rDao.REAUserLogin(id, pwd);
			System.out.println("gResult: " + gResult);
			System.out.println("rResult: " + rResult);

			if (gResult.equals("U01") || rResult.equals("U02")) { // 블랙아닌 회원이 로그인했을 때
				if (gResult.equals("U01")) {
					session.setAttribute("userId", id);
					session.setAttribute("type", "U01"); // 일반 회원
					forward.setPath("UserMain.jsp");
					System.out.println("일반회원 로그인");
					return forward;
				} else {
					session.setAttribute("userId", id);
					session.setAttribute("type", "U02"); // 공인중개사 회원
					forward.setPath("UserMain.jsp");
					System.out.println("공인중개사 회원 로그인");
					return forward;
				}
			} else if (gResult.equals("B01") || rResult.equals("B02")) {// 블랙회원이 로그인 했을 때
				forward.setPath("BlackLogin.jsp");
				System.out.println("블랙 회원 로그인");
				return forward;
			} else {
				forward.setPath("Login.jsp"); // 아이디 또는 비밀번호가 일치하지 않을 때
				session.setAttribute("type", "000");
				System.out.println("로그인 실패");
				return forward;
			}
		} catch (Exception e) {
			System.out.println("LoginService 예외");
		}
		return forward;
	}
}
