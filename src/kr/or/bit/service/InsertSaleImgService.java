package kr.or.bit.service;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dao.SaleImageDao;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.Sale;
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
      
      ArrayList<String> saleImgSaveNames = new ArrayList<String>();
      ArrayList<String> saleImgOriginNames = new ArrayList<String>();
      try {
         multi = new MultipartRequest(request, // 기존에 있는 request 객체의 주소값
               uploadpath, // 실 저장 경로 (배포경로)
               size, // 10M
               "UTF-8", new DefaultFileRenamePolicy() // 파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경))
         );
        
         Enumeration filenames = multi.getFileNames();
         while(filenames.hasMoreElements()) {
             String name = (String) filenames.nextElement();
             saleImgSaveNames.add(multi.getFilesystemName(name));
             saleImgOriginNames.add(multi.getOriginalFileName(name));
         }

         String aptNum =request.getParameter("aptNum");

         SaleImage saleImg1 = new SaleImage();
		 saleImg1.setSaleImgSaveName(saleImgSaveNames.get(0));
		 saleImg1.setSaleImgOriginName(saleImgOriginNames.get(0));
		 saleImg1.setAptNum(aptNum);
		 
		 SaleImage saleImg2 = new SaleImage();
		 saleImg2.setSaleImgSaveName(saleImgSaveNames.get(1));
		 saleImg2.setSaleImgOriginName(saleImgOriginNames.get(1));
		 saleImg2.setAptNum(aptNum);
		 
		 SaleImage saleImg3 = new SaleImage();
		 saleImg3.setSaleImgSaveName(saleImgSaveNames.get(2));
		 saleImg3.setSaleImgOriginName(saleImgOriginNames.get(2));
		 saleImg3.setAptNum(aptNum);
		 
         SaleImageDao dao = new SaleImageDao();

         result = dao.insertSaleImg(saleImg1);
         result = dao.insertSaleImg(saleImg2);
         result = dao.insertSaleImg(saleImg3);
         
         System.out.println("제발"+result);
         
 		PrintWriter out = response.getWriter();
 		out.print("휴");

      }catch (Exception e) {

   }
   return forward;

   }
}