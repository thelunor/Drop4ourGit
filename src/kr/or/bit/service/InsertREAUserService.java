package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.AdminDao;
import kr.or.bit.dto.GenericUser;
import kr.or.bit.dto.REAUser;

public class InsertREAUserService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();

		//1. 데이터 받기 id, pwd, name, frontResNum, backResNum, phoneNum, addr
		String reaId = request.getParameter("reaId");
		String reaPwd = request.getParameter("reaPwd");
		String reaName = request.getParameter("reaName");
		String reaPhoneNum = request.getParameter("reaPhoneNum");
		String officeName = request.getParameter("officeName");
		String officeAddr = request.getParameter("officeAddr");
		String officeDetailAddr = request.getParameter("officeDetailAddr");
		String officeHp = request.getParameter("officeHp");
		String regNum = request.getParameter("regNum");
		String userCode = request.getParameter("userCode");
		
		

		//2. 객체에 데이터 저장
		REAUser user = new REAUser();
		user.setReaId(reaId);
		user.setReaPwd(reaPwd);
		user.setReaName(reaName);
		user.setReaPhoneNum(reaPhoneNum);
		user.setOfficeName(officeName);
		user.setOfficeAddr(officeAddr);
		user.setOfficeDetailAddr(officeDetailAddr);
		user.setOfficeHp(officeHp);
		user.setRegNum(regNum);
		user.setUserCode(userCode);
		
		System.out.println("데이터" + user.toString());
		
		try {
			//3. DB 저장
			AdminDao dao = new AdminDao();
			int result = dao.insertREAUser(user);
			if(result > 0) {
				forward.setPath("Main.jsp");
			}else {
				forward.setPath("JoinREA.jsp");
			}
		}catch(Exception e) {
			System.out.println("회원가입 서비스 실패");
		}
		
		return forward;
	}
}