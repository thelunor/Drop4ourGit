package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.REAScheduleDao;
import kr.or.bit.dto.REASchedule;

public class DeleteREAScheduleService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		String scheNum = request.getParameter("scheNum");
		System.out.println(scheNum);
		HttpSession session = request.getSession();
		String reaId = request.getParameter("userId");
		System.out.println("아이디 " + reaId);

		int result = 0;
		List<REASchedule> sList = new ArrayList<REASchedule>();
		REAScheduleDao dao = null;
		System.out.println("탄다");
		try {
			dao = new REAScheduleDao();
			result = dao.deleteREASchedule(reaId, scheNum);
			System.out.println(result);
			sList = dao.getSchedule(reaId);
			System.out.println(sList);
			if (result > 0) {
				forward = new ActionForward();
	    		request.setAttribute("reaId", reaId);
	    		request.setAttribute("rList", sList);	
	    		
	    	forward.setPath("REASchedule.jsp");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return forward;
	}

}
