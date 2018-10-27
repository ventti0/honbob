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
 * Servlet implementation class CeoModifyController
 */
@WebServlet("/admin/ceoModify")
public class CeoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Ceo ceo = new Ceo();
	CeoDao ceoDao = new CeoDaoImpl();
	CeoService ceoServ = new CeoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ceo.setMem_no(Integer.parseInt(req.getParameter("mem_no")));
		ceo = ceoServ.getCeoByMemno(ceo);
		req.setAttribute("ceo", ceo);

		req.getRequestDispatcher("/view/admin/ceoModify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청 파라미터 한글 인코딩 설정 : UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 파라미터 가져오기
		ceo = ceoServ.getParam(req, resp);

		ceoServ.editCeo(ceo);

		resp.sendRedirect("/admin/ceoModify?mem_no=" + ceo.getMem_no());

	}

}
