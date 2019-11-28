package kr.or.bit.service;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.AdminDao;
import kr.or.bit.dao.REAImageDao;
import kr.or.bit.dao.REAUserDao;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAUser;


public class UpdateREAUserService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ServletContext application = request.getServletContext();
		String uploadpath = application.getRealPath("reaimg");
		HttpSession session = request.getSession();
		int size = 1024 * 1024 * 10; // 10M 네이버 계산기

		MultipartRequest multi=null;
		try {
			multi = new MultipartRequest(request, // 기존에 있는 request 객체의 주소값
					uploadpath, // 실 저장 경로 (배포경로)
					size, // 10M
					"UTF-8", new DefaultFileRenamePolicy() // 파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경))
			);
			// 1. 데이터 받기 id, pwd, name, frontResNum, backResNum, phoneNum, addr

			String reaId = (String)session.getAttribute("userId");
			String reaPwd = multi.getParameter("reaPwd");
			String reaName = multi.getParameter("reaName");
			String reaPhoneNum = multi.getParameter("reaPhoneNum");
			String officeName = multi.getParameter("officeName");
			String officeAddr = multi.getParameter("officeAddr");
			String officeDetailAddr = multi.getParameter("officeDetailAddr");
			String officeHp = multi.getParameter("officeHp");
			String regNum = multi.getParameter("regNum");
			String userCode = multi.getParameter("userCode");
			String reaImgSaveName = "reaImgSaveName"; // 중개사 이미지 저장 파일명
			String type = request.getParameter("type");
			
			Enumeration filenames = multi.getFileNames();
			String file = (String) filenames.nextElement();
			reaImgSaveName = multi.getFilesystemName(file);

			// 2. 객체에 데이터 저장
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

			REAImage reaImg = null;
			

			System.out.println("회원데이터" + user.toString());
			System.out.println("회원 사진 데이터" + reaImg.toString());
			REAUserDao reaUserDao=new REAUserDao();
			REAUser reaUser=null;

			REAImageDao imageDao=null;
			
			try {
				
				reaImg= new REAImage();
				forward = new ActionForward();
				reaUser=new REAUser();
				reaUserDao=new REAUserDao();
				reaImg=new REAImage();
				imageDao=new REAImageDao();
				
				// 3. DB 저장
				reaImg.setReaId(reaId);
				reaImg.setReaImgSaveName(reaImgSaveName);
				
				if (result > 0) {
					forward.setPath("JoinFinish.jsp");
					request.setAttribute("type", userCode);
				} else {
					forward.setPath("JoinREA.jsp");
				}
			} catch (Exception e) {
				System.out.println("회원가입 서비스 실패");
			}
		} catch (Exception e) {

		}
		return forward;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
			System.out.println("reaUser updateReaUser");
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
