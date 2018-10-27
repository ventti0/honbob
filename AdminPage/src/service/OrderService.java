package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Order;
import util.Paging;

public interface OrderService {
	public Order view(Order order);	// 결제 상세 조회
	public Order getParam(HttpServletRequest req, HttpServletResponse resp);
	public int getTotalCount(String search);
	public List getPagingList(Paging paging, String search); // 결제 페이징 조회
	public List<Order> getOrderAll(); // 모든 결제 조회
	public int getCurPage(HttpServletRequest req);
	public void editOrder(Order order);
	public void deleteOrder(Order order);
	public void writeOrder(Order order);
	public Order getOrderByOrderno(Order order);
}
