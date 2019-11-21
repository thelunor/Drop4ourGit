package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.UserDao;
import kr.or.bit.dto.GenericUser;

public class InsertGenericUserService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();

		//1. 데이터 받기 id, pwd, name, frontResNum, backResNum, phoneNum, addr
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String frontResNum = request.getParameter("frontResNum");
		String backResNum = request.getParameter("backResNum");
		String phoneNum = request.getParameter("phoneNum");
		String addr = request.getParameter("addr");
		String detailAddr = request.getParameter("detailAddr");
		

		//2. 객체에 데이터 저장
		GenericUser user = new GenericUser();
		user.setId(id);
		user.setPwd(pwd);
		user.setName(name);
		user.setFrontResNum(frontResNum);
		user.setBackResNum(backResNum);
		user.setPhoneNum(phoneNum);
		user.setAddr(addr);
		user.setDetailAddr(detailAddr);
		
		try {
			//3. DB 저장
			UserDao dao = new UserDao();
			int result = dao.insertGenericUser(user);
			if(result > 0) {
				forward.setPath("Main.jsp");
			}else {
				forward.setPath("JoinMember.jsp");
			}
		}catch(Exception e) {
			System.out.println("회원가입 서비스 실패");
		}
		
		return forward;
	}
}