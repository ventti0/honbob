package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import dto.Res;
import service.MemberService;
import service.MemberServiceImpl;
import service.ResWaitService;
import service.ResWaitServiceImpl;
import util.Paging;

/**
 * Servlet implementation class ResListController
 */
@WebServlet("/admin/resWait")
public class ResWaitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ResWaitService resWaitService = new ResWaitServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		int curPage = resWaitService.getCurPage(req);

		String search = req.getParameter("search");
		System.out.println("test 1 : "+search);
		if (search == null) // 검색인지 확인
			search = "";
		System.out.println(search);
		int totalCount = resWaitService.getTotalCount(search);
		System.out.println("totalcnt : " + totalCount);
		Paging paging = new Paging(totalCount, curPage);

		List<Res> resWaitList = resWaitService.getPagingList(paging, search);
		System.out.println(resWaitList.size());
		req.setAttribute("list", resWaitList);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("paging", paging);
		req.setAttribute("search", search);
		System.out.println("test 2 : "+search);

		req.getRequestDispatcher("/view/admin/resWaitList.jsp").forward(req, resp);
	}
}
