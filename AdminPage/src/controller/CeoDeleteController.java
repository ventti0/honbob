package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CeoDao;
import dao.CeoDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Ceo;
import dto.Member;
import service.CeoService;
import service.CeoServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class CeoDeleteController
 */
@WebServlet("/admin/ceoDelete")
public class CeoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Ceo ceo = new Ceo();
	CeoDao ceoDao = new CeoDaoImpl();
	CeoService ceoServ = new CeoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int curPage = ceoServ.getCurPage(req);
		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		//int curPage = Integer.parseInt(req.getParameter("curPage"));
		//System.out.println(curPage);
		ceo.setMem_no(mem_no);
		ceoServ.deleteCeo(ceo);
		
		//req.setAttribute("curPage", curPage);
		
		//req.getRequestDispatcher("/admin/member").forward(req, resp);
		resp.sendRedirect("/admin/ceo?curPage=" + curPage);
	}
	
}
