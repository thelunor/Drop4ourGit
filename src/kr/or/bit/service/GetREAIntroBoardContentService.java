package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.REAIntroBoardDao;
import kr.or.bit.dto.REAIntroBoard;

public class GetREAIntroBoardContentService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String reaId = (String) session.getAttribute("reaUserId");
		REAIntroBoard introBoard = null;
		REAIntroBoardDao dao = null;
		System.out.println("여기는?");
		try {
			dao = new REAIntroBoardDao();
			introBoard = dao.getREAIntroData(reaId);
			if(introBoard != null) {
				forward.setPath("REAIntroBoard_content.jsp?reaUserId="+reaId);
				request.setAttribute("introBoard", introBoard);
				System.out.println("여기 갈까?");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}

}
