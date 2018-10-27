package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/admin/memberDelete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Member member = new Member();
	MemberDao memDao = new MemberDaoImpl();
	MemberService memServ = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		//int curPage = Integer.parseInt(req.getParameter("curPage"));
		//System.out.println(curPage);
		member.setMem_no(mem_no);
		memServ.deleteMember(member);
		
		//req.setAttribute("curPage", curPage);
		
		//req.getRequestDispatcher("/admin/member").forward(req, resp);
		resp.sendRedirect("/admin/member");
	}

}
