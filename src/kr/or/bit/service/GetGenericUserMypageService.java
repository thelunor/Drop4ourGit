package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.GenericUserDao;
import kr.or.bit.dao.REAImageDao;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dto.GenericUser;

public class GetGenericUserMypageService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		GenericUser user = new GenericUser();
		GenericUserDao dao = null;
		String genericUserId = (String)session.getAttribute("genericUserId");
		try {

			forward = new ActionForward();
			dao = new GenericUserDao();
			user = dao.getGenericMypage(genericUserId);
			
			if (user != null) {
				System.out.println("일반 회원 정보 조회 성공");
				request.setAttribute("genericUser", user);
				forward.setPath("GenericUserEdit.jsp");
			} else {
				System.out.println("조회 실패");
				forward.setPath("MypageMain.jsp");
			}
		} catch (Exception e) {

		}
		return forward;
	}
}
