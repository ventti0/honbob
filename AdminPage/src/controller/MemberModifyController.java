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
 * Servlet implementation class MemberModifyController
 */
@WebServlet("/admin/memberModify")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Member member = new Member();
	MemberDao memDao = new MemberDaoImpl();
	MemberService memServ = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		member.setMem_no(Integer.parseInt(req.getParameter("mem_no")));
		member = memServ.getMemberByUserid(member);
		req.setAttribute("member", member);

		req.getRequestDispatcher("/view/admin/memberModify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청 파라미터 한글 인코딩 설정 : UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 파라미터 가져오기
		member = memServ.getParam(req, resp);
		System.out.println("test5 : " + member.getMem_name());
		memServ.editMember(member);

		resp.sendRedirect("/admin/memberModify?mem_no=" + member.getMem_no());

	}
}
