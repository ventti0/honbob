package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Ceo;
import dto.Member;
import service.CeoService;
import service.CeoServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import util.Paging;

/**
 * Servlet implementation class CeoListController
 */
@WebServlet("/admin/ceo")
public class CeoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CeoService ceoService = new CeoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int curPage = ceoService.getCurPage(req);

		String search = req.getParameter("search");
		if (search == null) // 검색인지 확인
			search = "";
	
		/////////////////////////////
		// 페이징 객체
		int totalCount = ceoService.getTotalCount(search);

		System.out.println(search);
		Paging paging = new Paging(totalCount, curPage);

		List<Ceo> ceoList = ceoService.getPagingList(paging, search);
		req.setAttribute("ceoList", ceoList);
		
		req.setAttribute("totalCount", totalCount);
		System.out.println(totalCount);
		// 페이징 객체 MODEL로 추가
		req.setAttribute("paging", paging);
		req.setAttribute("search", search);

		req.getRequestDispatcher("/view/admin/ceoList.jsp").forward(req, resp);


	}
}
