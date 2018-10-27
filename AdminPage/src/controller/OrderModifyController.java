package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.OrderDaoImpl;
import dto.Order;
import service.OrderService;
import service.OrderServiceImpl;

/**
 * Servlet implementation class OrderModifyController
 */
@WebServlet("/admin/orderModify")
public class OrderModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Order order = new Order();
	OrderService orderServ = new OrderServiceImpl();
	OrderDao orderDao = new OrderDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		order.setOrder_no(Integer.parseInt(req.getParameter("order_no")));

		order = orderServ.getOrderByOrderno(order);
		req.setAttribute("order", order);
		System.out.println(order.getPay_time());

		req.getRequestDispatcher("/view/admin/orderModify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		order = orderServ.getParam(req, resp);
		
		
	}

}
