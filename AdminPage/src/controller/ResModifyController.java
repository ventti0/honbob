package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResWaitDao;
import dao.ResWaitDaoImpl;
import dto.Res;
import service.ResWaitService;
import service.ResWaitServiceImpl;

/**
 * Servlet implementation class ResModifyController
 */
@WebServlet("/admin/resModify")
public class ResModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Res res = new Res();
	ResWaitService resServ = new ResWaitServiceImpl();
	ResWaitDao resDao = new ResWaitDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		res.setRes_no(Integer.parseInt(req.getParameter("res_no")));

		res = resDao.selectResByResno(res);

		req.setAttribute("res", res);
		req.getRequestDispatcher("/view/admin/resModify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		res = resServ.getParam(req, resp);
		
		resServ.editRes(res);
		resp.sendRedirect("/admin/resModify?res_no=" + res.getRes_no());
	}
}
