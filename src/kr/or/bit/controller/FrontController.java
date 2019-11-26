package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.CheckIntroBoardService;
import kr.or.bit.service.DeleteBookMarkService;
import kr.or.bit.service.DeleteContractService;
import kr.or.bit.service.DeleteGenericUserService;
import kr.or.bit.service.DeleteREAImgService;
import kr.or.bit.service.DeleteREAIntroService;
import kr.or.bit.service.DeleteREAScheduleService;
import kr.or.bit.service.DeleteREAUserService;
import kr.or.bit.service.DeleteReviewComService;
import kr.or.bit.service.DeleteReviewService;
import kr.or.bit.service.DeleteSaleImgService;
import kr.or.bit.service.DeleteSaleService2;
import kr.or.bit.service.GetBookMarkService;
import kr.or.bit.service.GetContractService;
import kr.or.bit.service.GetGenericUserByIdService;
import kr.or.bit.service.GetGenericUserByResService;
import kr.or.bit.service.GetGenericUserMypageMainService;
import kr.or.bit.service.GetGenericUserEditService;
import kr.or.bit.service.GetREAImgService;
import kr.or.bit.service.GetREAIntroBoardContentService;
import kr.or.bit.service.GetREAIntroDataService;
import kr.or.bit.service.GetREAIntroPageService;
import kr.or.bit.service.GetREAMypageService;
import kr.or.bit.service.GetREAScheduleListByDateService;
import kr.or.bit.service.GetREAScheduleListByIdService;
import kr.or.bit.service.GetREAScheduleListByScheNumService;
import kr.or.bit.service.GetREAUserByIdService;
import kr.or.bit.service.GetREAUserByRegService;
import kr.or.bit.service.GetReviewComDataService;
import kr.or.bit.service.GetReviewListService;
import kr.or.bit.service.GetSaleDataService;
import kr.or.bit.service.GetSaleEditPageService;
import kr.or.bit.service.GetSaleImgService;
import kr.or.bit.service.GetSaleListService;
import kr.or.bit.service.InsertBookMarkService;
import kr.or.bit.service.InsertContractService;
import kr.or.bit.service.InsertGenericUserService;
import kr.or.bit.service.InsertREAImgService;
import kr.or.bit.service.InsertREAIntroService;
import kr.or.bit.service.InsertREAScheduleService;
import kr.or.bit.service.InsertREAUserService;
import kr.or.bit.service.InsertReviewComService;
import kr.or.bit.service.InsertReviewService;
import kr.or.bit.service.InsertSaleImgService;
import kr.or.bit.service.InsertSaleService;
import kr.or.bit.service.LoginService;
import kr.or.bit.service.LogoutService;
import kr.or.bit.service.SelectAllContractsService;
import kr.or.bit.service.SelectAtpListService;
import kr.or.bit.service.SelectAtpListService2;
import kr.or.bit.service.SelectGenericUserService;
import kr.or.bit.service.SelectREAUserService;
import kr.or.bit.service.UpdateBlackService;
import kr.or.bit.service.UpdateContractService;
import kr.or.bit.service.UpdateGenericUserService;
import kr.or.bit.service.UpdateREAImgService;
import kr.or.bit.service.UpdateREAIntroService;
import kr.or.bit.service.UpdateREAScheduleService;
import kr.or.bit.service.UpdateREAUserService;
import kr.or.bit.service.UpdateReviewComService;
import kr.or.bit.service.UpdateReviewService;
import kr.or.bit.service.UpdateSaleImgService;
import kr.or.bit.service.UpdateSaleService;

@WebServlet("*.d4b")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url_Command = requestURI.substring(contextPath.length());

		Action action = null;
		ActionForward forward = null;
		// 삭제=========================================
		if(url_Command.equals("/CheckIntroBoardService.d4b")) {
			action = new CheckIntroBoardService();
			forward = action.execute(request, response);

		} else if(url_Command.equals("/DeleteBookMarkService.d4b")) {
			action = new DeleteBookMarkService();
			forward = action.execute(request, response);
		
		// 삭제=========================================
		
		} else if (url_Command.equals("/DeleteContractService.d4b")) {
			try {
				action = new DeleteContractService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteGenericUserService.d4b")) {
			try {
				action = new DeleteGenericUserService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteREAImgService.d4b")) {
			try {
				action = new DeleteREAImgService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteREAIntroService.d4b")) {
			try {
				action = new DeleteREAIntroService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteREAScheduleService.d4b")) {
			try {
				action = new DeleteREAScheduleService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteREAUserService.d4b")) {
			try {
				action = new DeleteREAUserService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteReviewComService.d4b")) {
			try {
				action = new DeleteReviewComService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteReviewService.d4b")) {
			try {
				action = new DeleteReviewService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteSaleImgService.d4b")) {
			try {
				action = new DeleteSaleImgService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteSaleService.d4b")) {
			try {
				action = new DeleteSaleService2(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Get =====================================
		else if (url_Command.equals("/GetBookMarkService.d4b")) {
			try {
				action = new GetBookMarkService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetContractService.d4b")) {
			try {
				action = new GetContractService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetGenericUserEditService.d4b")) {
			try {
				action = new GetGenericUserEditService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if(url_Command.equals("/GetGenericUserMypageMainService.d4b")) {
			try {
				action = new GetGenericUserMypageMainService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (url_Command.equals("/GetGenericUserByIdService.d4b")) {
			try {
				action = new GetGenericUserByIdService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetGenericUserByResService.d4b")) {
			try {
				action = new GetGenericUserByResService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (url_Command.equals("/GetREAImgService.d4b")) {
			try {
				action = new GetREAImgService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAIntroDataService.d4b")) {
			try {
				action = new GetREAIntroDataService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAIntroPageService.d4b")) { //일반 사용자가 소개 페이지로
			try {
				action = new GetREAIntroPageService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (url_Command.equals("/GetREAIntroBoardService.d4b")) { //공인중개사가 후기 작성 페이지로
			try {
				forward = new ActionForward();
				forward.setPath("/REAIntroBoard.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAIntroBoardContentService.d4b")) {
			try {
				action = new GetREAIntroBoardContentService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAScheduleListByDateService.d4b")) {
			try {
				action = new GetREAScheduleListByDateService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAScheduleListByIdService.d4b")) {
			try {
				action = new GetREAScheduleListByIdService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAScheduleListByScheNumService.d4b")) {
			try {
				action = new GetREAScheduleListByScheNumService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAUserByIdService.d4b")) {
			try {
				action = new GetREAUserByIdService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAUserByRegService.d4b")) {
			try {
				action = new GetREAUserByRegService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetReviewComDataService.d4b")) {
			try {
				action = new GetReviewComDataService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetReviewListService.d4b")) {
			try {
				action = new GetReviewListService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetReviewListServiceOk.d4b")) {
			try {
				forward = new ActionForward();
				forward.setPath("/REAIntro.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetSaleDataService.d4b")) {
			try {
				action = new GetSaleDataService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetSaleDataServiceOk.d4b")) {
			try {
				forward = new ActionForward();
				forward.setPath("/SaleDetail.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetSaleImgService.d4b")) {
			try {
				action = new GetSaleImgService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetSaleListService.d4b")) {
			try {
				action = new GetSaleListService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetSaleEditPageService.d4b")) {
			try {
				action = new GetSaleEditPageService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/GetREAMypageService.d4b")) {
			try {
				action = new GetREAMypageService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// insert=============================================
		else if (url_Command.equals("/InsertBookMarkService.d4b")) {
			try {
				action = new InsertBookMarkService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertContractService.d4b")) {
			try {
				action = new InsertContractService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertGenericUserService.d4b")) {
			try {
				action = new InsertGenericUserService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertREAImgService.d4b")) {
			try {
				action = new InsertREAImgService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertREAIntroService.d4b")) {
			try {
				action = new InsertREAIntroService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertREAScheduleService.d4b")) {
			try {
				action = new InsertREAScheduleService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertREAUserService.d4b")) {
			try {
				action = new InsertREAUserService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertReviewComService.d4b")) {
			try {
				action = new InsertReviewComService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertReviewService.d4b")) {
			try {
				action = new InsertReviewService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertSaleImgService.d4b")) {
			try {
				action = new InsertSaleImgService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/InsertSaleService.d4b")) {
			try {
				action = new InsertSaleService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// select ================================================
		else if (url_Command.equals("/SelectAllContractsService.d4b")) {
			try {
				action = new SelectAllContractsService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/SelectREAUserService.d4b")) { // 공인중개사회원 목록보기
			try {
				action = new SelectREAUserService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/SelectREAUserOk.d4b")) { // 공인중개사회원 목록보기
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/AdminMain.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/SelectGenericUserService.d4b")) { // 개인회원 목록보기
			try {
				action = new SelectGenericUserService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/SelectGenericUserOk.d4b")) { // 개인회원 목록보기
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/AdminMain.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/SelectAptListService.d4b")) { // 아파트 목록보기
			try {
				action = new SelectAtpListService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/SelectAptListServiceOk.d4b")) { // 아파트 목록보기
			try {
				forward = new ActionForward();
				forward.setPath("/HouseListMain.jsp");
				System.out.println("SelectAptListServiceOk컨트롤러끝난부분입니당: ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		// update========================================
		else if (url_Command.equals("/UpdateBlackService.d4b")) {
			try {
				action = new UpdateBlackService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateContractService.d4b")) {
			try {
				action = new UpdateContractService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateGenericUserService.d4b")) {
			try {
				action = new UpdateGenericUserService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateREAImgService.d4b")) {
			try {
				action = new UpdateREAImgService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateREAIntroService.d4b")) {
			try {
				action = new UpdateREAIntroService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateREAScheduleService.d4b")) {
			try {
				action = new UpdateREAScheduleService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateREAUserService.d4b")) {
			try {
				action = new UpdateREAUserService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateReviewComService.d4b")) {
			try {
				action = new UpdateReviewComService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateReviewService.d4b")) {
			try {
				action = new UpdateReviewService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateSaleImgService.d4b")) {
			try {
				action = new UpdateSaleImgService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/UpdateSaleService.d4b")) {
			try {
				action = new UpdateSaleService(); //
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 로그인 관련 controller 191121 이정은
		else if (url_Command.equals("/LoginService.d4b")) {
			action = new LoginService(); //
			forward = action.execute(request, response);

		} else if (url_Command.equals("/LogoutService.d4b")) {
			action = new LogoutService();
			forward = action.execute(request, response);
		}
		// 페이지 이동관련 ==========================================

		// dispatcher =================================================
		if (forward != null) {
			if (forward.isRedirect()) { // true
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
