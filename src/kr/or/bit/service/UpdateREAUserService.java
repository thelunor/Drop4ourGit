package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.REAImageDao;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAUser;


public class UpdateREAUserService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		REAUser reaUser=null;
		REAUserDao reaUserDao=null;
		String reaId=request.getParameter("reaId");
		String reaPwd=request.getParameter("reaPwd");
		String reaName=request.getParameter("reaName");
		String reaPhoneNum=request.getParameter("reaPhoneNum");
		String officeName=request.getParameter("officeName");
		String officeAddr=request.getParameter("officeAddr");
		String officeDetailAddr=request.getParameter("officeDetailAddr");
		String officeHp=request.getParameter("officeHp");
		String regNum=request.getParameter("regNum");
		String userCode=request.getParameter("userCode");
		String reaImgSaveName=request.getParameter("reaImgSaveName");
		System.out.println(reaId);
		REAImage reaImg=null;
		REAImageDao imageDao=null;
		String type = request.getParameter("type");
		System.out.println("타입타입");
		
		try {
			forward = new ActionForward();
			reaUser=new REAUser();
			reaUserDao=new REAUserDao();
			reaImg=new REAImage();
			imageDao=new REAImageDao();
			
			reaUser.setReaId(reaId);
			reaUser.setReaPwd(reaPwd);
			reaUser.setReaName(reaName);
			reaUser.setReaPhoneNum(reaPhoneNum);
			reaUser.setOfficeName(officeName);
			reaUser.setOfficeAddr(officeAddr);
			reaUser.setOfficeDetailAddr(officeDetailAddr);
			reaUser.setOfficeHp(officeHp);
			reaUser.setRegNum(regNum);
			reaUser.setUserCode(userCode);
			int reaResult =reaUserDao.updateREAUser(reaUser);
			System.out.println(reaResult);
			reaImg.setReaImgSaveName(reaImgSaveName);
			
			int imgResult= imageDao.updateREAImg(reaImg);
			System.out.println(imgResult);
			
			if (reaResult !=0 || imgResult !=0) {
				System.out.println("업데이트 성공");
				//request.setAttribute("reaUser", reaUser);
				//request.setAttribute("reaImg", reaImg);
				forward.setPath("GetREAMypageService.d4b?type="+type);
			} else {
				System.out.println("조회 실패");
				forward.setPath("/AdminMain.jsp");
			}
		} catch (Exception e) {

		}
		return forward;
	}

}
