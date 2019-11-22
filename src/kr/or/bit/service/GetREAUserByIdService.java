package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.REAImageDao;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAUser;

public class GetREAUserByIdService implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		String reaId=request.getParameter("reaId");
		try {

			forward = new ActionForward();
			
		} catch (Exception e) {

		}
		return forward;
	}
}
