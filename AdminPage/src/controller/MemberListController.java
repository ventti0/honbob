package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;
import util.Paging;

/**
 * Servlet implementation class memberListController
 */
@WebServlet("/admin/member")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 현재 페이지 번호 얻기
		int curPage = memberService.getCurPage(req);
			
		String search = req.getParameter("search");
		if(search == null) // 검색인지 확인
			search = "";

		
		// 페이징 객체
		int totalCount = memberService.getTotalCount(search);

		Paging paging = new Paging(totalCount, curPage);

		List<Member> memberList = memberService.getPagingList(paging, search);
		req.setAttribute("memberList", memberList);
		
		req.setAttribute("totalCount", totalCount);

		// 페이징 객체 MODEL로 추가
		req.setAttribute("paging", paging);
		req.setAttribute("search", search);

		req.getRequestDispatcher("/view/admin/memberList.jsp").forward(req, resp);
	}

}
