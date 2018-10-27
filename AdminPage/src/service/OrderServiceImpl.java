package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.OrderDaoImpl;
import dto.Order;
import util.Paging;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = new OrderDaoImpl();

	@Override
	public Order view(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getParam(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount(String search) {
		if("".equals(search))
			return orderDao.selectCntAll();
		else
			return orderDao.selectCntSearch(search);
	}

	@Override
	public List getPagingList(Paging paging, String search) {
		// TODO Auto-generated method stub
		return orderDao.selectPagingList(paging, search);
	}

	@Override
	public int getCurPage(HttpServletRequest req) {
		// 요청파라미터 받기
		String curPage = req.getParameter("curPage");

		// null이나 ""이 아니면 int로 리턴
		if (curPage != null && !"".equals(curPage)) {
			return Integer.parseInt(curPage);
		}

		// null이나 "" 면 0으로 반환
		return 0;
	}

	@Override
	public void editOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> getOrderAll() {
		return orderDao.selectOrderAll();
	}

	@Override
	public Order getOrderByOrderno(Order order) {
		// TODO Auto-generated method stub
		return orderDao.selectOrderByOrderno(order);
	}

}
