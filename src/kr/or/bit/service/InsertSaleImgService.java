package kr.or.bit.service;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.ajax.SaleImgUpload;
import kr.or.bit.dao.AdminDao;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.SaleImage;

public class InsertSaleImgService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ServletContext application = request.getServletContext();
		String uploadpath = application.getRealPath("reaimg");
		int result = 0;
		int size = 1024 * 1024 * 10; // 10M 네이버 계산기

		MultipartRequest multi=null;
		try {
			multi = new MultipartRequest(request, // 기존에 있는 request 객체의 주소값
					uploadpath, // 실 저장 경로 (배포경로)
					size, // 10M
					"UTF-8", new DefaultFileRenamePolicy() // 파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경))
			);
			// 1. 데이터 받기 id, pwd, name, frontResNum, backResNum, phoneNum, addr

		
			String reaImgOriginName1 = ""; // 중개사 이미지 원본 파일명
			String reaImgSaveName1 = ""; // 중개사 이미지 저장 파일명
			String reaImgOriginName2 = ""; // 중개사 이미지 원본 파일명
			String reaImgSaveName2 = ""; // 중개사 이미지 저장 파일명
			String reaImgOriginName3 = ""; // 중개사 이미지 원본 파일명
			String reaImgSaveName3 = ""; // 중개사 이미지 저장 파일명
			
			Enumeration filenames = multi.getFileNames();
			String file1 = (String) filenames.nextElement();
			reaImgSaveName1 = multi.getFilesystemName(file1);
			reaImgOriginName1 = multi.getOriginalFileName(file1);
			
			String file2 = (String) filenames.nextElement();
			reaImgSaveName2 = multi.getFilesystemName(file2);
			reaImgOriginName2 = multi.getOriginalFileName(file2);
			
			String file3 = (String) filenames.nextElement();
			reaImgSaveName3 = multi.getFilesystemName(file3);
			reaImgOriginName3 = multi.getOriginalFileName(file3);
			
			SaleImage saleImg = new SaleImage();
			
			// 2. 객체에 데이터 저장
			



			try {
				// 3. DB 저장
				
				if (result > 0) {
					forward.setPath("Main.jsp");
				} else {
					forward.setPath("JoinREA.jsp");
				}
			} catch (Exception e) {
				System.out.println("회원가입 서비스 실패");
			}


	}catch (Exception e) {

	}
	return forward;

	}
}