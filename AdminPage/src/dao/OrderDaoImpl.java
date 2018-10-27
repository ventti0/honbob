package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Order;
import util.DBConn;
import util.Paging;

public class OrderDaoImpl implements OrderDao {

	// DB 연결 객체
	private static Connection conn = DBConn.getConnection(); // ���ᰴü

	@Override
	public int selectCntAll() {
		// 전체 게시글 수 조회 쿼리
		String sql = "";
		sql += "SELECT COUNT(*) FROM order_tb";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			rs.next();

			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	@Override
	public List selectPagingList(Paging paging, String search) {
		// 페이징 리스트 조회 쿼리
		String sql = "";
		sql += " select * from (";
		sql += " select rownum rnum, b.* from (";
		sql += " select order_no, mem_name, res_name, menu_name";
		sql += " , quantity, order_sum, owner_check, pay_time";
		sql += " from order_tb o";
		sql += " , member m, restaurant r, res_menu rm";
		sql += " , pay p";
		sql += " where o.mem_no=m.mem_no";
		sql += " AND o.res_no=r.res_no";
		sql += " AND r.res_no=rm.res_no";
		sql += " AND o.pay_no=p.pay_no";
		sql += " AND o.menu_no=rm.menu_no";
		sql += " AND m.mem_name like ?";
		sql += " order by order_no desc";
		sql += " ) b";
		sql += " order by rnum";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 최종 조회 결과 담을 List
		List list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + search + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());

			rs = ps.executeQuery();

			while (rs.next()) {
				Order o = new Order();

				o.setOrder_no(rs.getInt("order_no"));
				o.setMem_name(rs.getString("mem_name"));
				o.setRes_name(rs.getString("res_name"));
				o.setMenu_name(rs.getString("menu_name"));
				o.setQuantity(rs.getInt("quantity"));
				o.setOrder_sum(rs.getInt("order_sum"));
				o.setOwner_check(rs.getInt("owner_check"));
				o.setPay_time(rs.getDate("pay_time"));

				// 조회 결과를 List로 생성
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public Order selectOrderByOrderno(Order order) {
		String sql = "";
		sql += "select order_no, mem_name, res_name, menu_name";
		sql += " , quantity, order_sum, owner_check, pay_time";
		sql += " from order_tb o";
		sql += " , member m, restaurant r, res_menu rm";
		sql += " , pay p";
		sql += " where o.mem_no=m.mem_no";
		sql += " AND o.res_no=r.res_no";
		sql += " AND r.res_no=rm.res_no";
		sql += " AND o.pay_no=p.pay_no";
		sql += " AND o.menu_no=rm.menu_no";
		sql += " AND o.order_no=?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getOrder_no());
			rs = ps.executeQuery();
			
			rs.next();
			
			order.setMem_name(rs.getString("mem_name"));
			order.setRes_name(rs.getString("res_name"));
			order.setMenu_name(rs.getString("menu_name"));
			order.setQuantity(rs.getInt("quantity"));
			order.setOrder_sum(rs.getInt("order_sum"));
			order.setOwner_check(rs.getInt("owner_check"));
			order.setPay_time(rs.getDate("pay_time"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return order;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> selectOrderAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCntSearch(String search) {
		// 검색 게시글 수 조회 쿼리
		String sql = "";
		sql += "select count(*) from order_tb o, member m";
		sql += " where o.mem_no=m.mem_no";
		sql += " and m.mem_name like ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + search + "%");
			rs = ps.executeQuery();

			rs.next();

			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

}
