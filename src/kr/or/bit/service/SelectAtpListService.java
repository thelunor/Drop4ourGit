package kr.or.bit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SaleDao;
import kr.or.bit.dto.Sale;
import kr.or.bit.dto.SaleImage;

public class SelectAtpListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		System.out.println("SelectAtpListService");
		// HttpSession session = request.getSession();
		String search = request.getParameter("search");
		String ps = request.getParameter("pageSize"); //pagesize
		String cp = request.getParameter("cPage");    //current page
		System.out.println("그댄 서치 내겐 서치이이이 그댄 서치.." + search);
		Map<Sale, SaleImage> saleMap = new HashMap<Sale, SaleImage>();
		
		// String address = request.getParameter("address");
		//80215
		try {
			SaleDao dao = new SaleDao();
			
			int count = dao.selectAtpListCount(search);
			
			
			
			if(ps == null || ps.trim().equals("")){
				//default 값 설정
				ps = "5";
			}
			if(cp == null || cp.trim().equals("")){
				//default 값 설정
				cp = "1";
			}
			int pageSize = Integer.parseInt(ps);
			int cPage = Integer.parseInt(cp);
			int pageCount =0;
			
			if(count % pageSize == 0){
				pageCount = count / pageSize;
			}else{
				pageCount = (count / pageSize) +1;
			}
			saleMap = dao.selectAtpList(search, cPage, pageSize);
			
			//System.out.println(saleMap.toString());
			if (saleMap != null) {
				request.setAttribute("saleMap", saleMap);
				request.setAttribute("search", search);
				request.setAttribute("count", count);
				request.setAttribute("pageSize", pageSize);
				request.setAttribute("cPage", cPage);
				request.setAttribute("pageCount", pageCount);
			} else {
				request.setAttribute("saleMap", saleMap);
				request.setAttribute("search", "법정구 법정동");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		// session.setAttribute("address", address);
		forward.setPath("SelectAptListServiceOk.d4b");
		return forward;
	}

}