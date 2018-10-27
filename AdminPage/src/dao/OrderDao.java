package dao;

import java.util.List;

import dto.Order;
import dto.Res;
import util.Paging;

public interface OrderDao {
	public int selectCntAll();	// 전체 주문 수 조회
	public List<Order> selectPagingList(Paging paging, String search);	// 주문 페이징 조회
	public List<Order> selectOrderAll(); // 모든 결제 조회
	public Order selectOrderByOrderno(Order order); // 주문 상세조회 반환
	public int selectCntSearch(String search); // 검색 주문 수 조회
	public void updateOrder(Order order);	// 주문 수정
	public void deleteOrder(Order order);	// 주문 삭제
	// 맛집 검색 메소드
}
