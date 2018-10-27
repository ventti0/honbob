package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ResWaitService;
import service.ResWaitServiceImpl;

/**
 * Servlet implementation class ResActivateController
 */
@WebServlet("/resActivate")
public class ResActivateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResWaitService resServ = new ResWaitServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int res_no = Integer.parseInt(req.getParameter("res_no")); // 활성화 상태 변수
		int curPage = Integer.parseInt(req.getParameter("curPage"));
		String search = req.getParameter("search");
		System.out.println("Test3 : " + search);
		resServ.allowRes(res_no);
		resp.sendRedirect("/admin/resWait?curPage=" + curPage + "&search=" + search);
	}
}
