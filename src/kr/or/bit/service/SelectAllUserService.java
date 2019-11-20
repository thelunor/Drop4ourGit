package kr.or.bit.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.UserDao;
import kr.or.bit.dto.Users;

public class SelectAllUserService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		List<Users> userList = null;
		try {
			UserDao dao = new UserDao();
			userList = dao.selectAllUser();
			request.setAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setPath("/SelectAllUserOkService.d4b");
		return forward;
	}

}
