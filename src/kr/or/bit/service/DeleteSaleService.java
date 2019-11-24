package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao2;

public class DeleteSaleService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	    ActionForward forward = null;
	    String aptNum = request.getParameter("aptNum");
	    HttpSession session = request.getSession();
	    String reaId = (String) request.getAttribute("reaUserId");
	    int result = 0;
	    try {
	    	SaleDao2 dao = new SaleDao2();
	    	result = dao.deleteSale(aptNum);
	    	if(result > 0) {
	    		forward = new ActionForward();
	    		forward.setPath("Main.jsp");
	    		/*GetREAUserByIdService.d4b?reaUserId=?"+reaId*/
	    	}
	    }catch(Exception e) {
	    	
	    }
		return forward;
	}

}
