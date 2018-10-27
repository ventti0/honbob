package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResWaitDaoImpl;
import dto.Res;
import service.ResWaitService;
import service.ResWaitServiceImpl;

/**
 * Servlet implementation class ResDeleteController
 */
@WebServlet("/admin/resDelete")
public class ResDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResWaitService resServ = new ResWaitServiceImpl();
	Res res = new Res();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int curPage = resServ.getCurPage(req);
		int res_no = Integer.parseInt(req.getParameter("res_no"));
		
		res.setRes_no(res_no);
		resServ.deleteRes(res);
		
		resp.sendRedirect("/admin/resWait?curPage="+curPage);
	}

}
