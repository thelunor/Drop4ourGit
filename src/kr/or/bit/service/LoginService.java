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
			if (aResult) { // 관리자 로그인 성공 시
				forward.setPath("Main.jsp");
				session.setAttribute("adminId", id);
				return forward;
			}
			GenericUserDao gDao = new GenericUserDao();
			REAUserDao rDao = new REAUserDao();
			String gResult = gDao.GenericUserLogin(id, pwd);
			String rResult = rDao.REAUserLogin(id, pwd);
			System.out.println("gResult: "  + gResult);
			System.out.println("rResult: " +  rResult);
			
			if (gResult.equals("U01") || rResult.equals("U02")) { //블랙아닌 회원이 로그인했을 때
				if(gResult.equals("U01")) {
					session.setAttribute("genericUserId", id);
					request.setAttribute("type", "U01"); //일반 회원
					forward.setPath("User_Main.jsp");
					System.out.println("일반회원 로그인 성공");
				}else {
					session.setAttribute("reaUserId", id);
					request.setAttribute("type", "U02"); //공인중개사 회원
					forward.setPath("User_Main.jsp");
					System.out.println("공인중개사 회원 로그인 성공");

				}
				return forward;
			} else if (gResult.equals("black") || rResult.equals("black")) {//블랙회원이 로그인 했을 때
				forward.setPath("BlackLogin.jsp");
				return forward;
			} else {
				forward.setPath("Login.jsp");  //아이디 또는 비밀번호가 일치하지 않을 때
				return forward;
			}
		} catch (Exception e) {
			System.out.println("LoginService 예외");
		}
		return forward;
	}
}
