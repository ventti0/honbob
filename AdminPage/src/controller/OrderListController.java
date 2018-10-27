package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import dto.Order;
import service.MemberService;
import service.MemberServiceImpl;
import service.OrderService;
import service.OrderServiceImpl;
import util.Paging;

/**
 * Servlet implementation class OrderListController
 */
@WebServlet("/admin/order")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrderService orderService = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 현재 페이지 번호 얻기
		int curPage = orderService.getCurPage(req);

		String search = req.getParameter("search");
		if (search == null) // 검색인지 확인
			search = "";
		System.out.println();
		// 페이징 객체
		int totalCount = orderService.getTotalCount(search);

		Paging paging = new Paging(totalCount, curPage);
		
		List orderList = orderService.getPagingList(paging, search);
		
		req.setAttribute("list", orderList);
		
		req.setAttribute("totalCount", totalCount);

		// 페이징 객체 MODEL로 추가
		req.setAttribute("paging", paging);
		req.setAttribute("search", search);

	

		req.getRequestDispatcher("/view/admin/order.jsp").forward(req, resp);
	}
}
