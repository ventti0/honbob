package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Member;
import dto.Res;
import util.DBConn;
import util.Paging;

public class ResWaitDaoImpl implements ResWaitDao {

	// DB 연결 객체
	private static Connection conn = DBConn.getConnection(); // ���ᰴü

	@Override
	public int selectCntAll() {
		// 검색 게시글 수 조회 쿼리
		String sql = "";
		sql += "SELECT COUNT(*) FROM restaurant ";
		sql += " WHERE activation>=0";
		sql += "ORDER BY res_no";

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
	public List<Res> selectPagingList(Paging paging, String search) {
		// 페이징 리스트 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT ROWNUM rnum, b.* FROM (";
		sql += "		SELECT * FROM restaurant";
		sql += "		WHERE res_name LIKE ?";
		sql += " 		AND activation>=0";
		sql += "		ORDER BY res_no";
		sql += "	) b";
		sql += "	ORDER BY rnum ";
		sql += ") ";
		sql += "WHERE rnum BETWEEN ? AND ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 최종 조회 결과 담을 List
		List<Res> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + search + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());

			rs = ps.executeQuery();

			while (rs.next()) {
				Res r = new Res();

				r.setRes_no(rs.getInt("res_no"));
				r.setOwner_no(rs.getInt("owner_no"));
				r.setRes_group_no(rs.getInt("res_group_no"));
				r.setRes_name(rs.getString("res_name"));
				r.setRes_phone(rs.getString("res_phone"));
				r.setRes_addr1(rs.getString("res_addr1"));
				r.setRes_addr2(rs.getString("res_addr2"));
				r.setRes_busi_hour(rs.getString("res_busi_hour"));
				r.setRes_total_score(rs.getInt("res_total_score"));
				r.setRes_total_score_cnt(rs.getInt("res_total_score_cnt"));
				r.setRes_alone_score(rs.getInt("res_alone_score"));
				r.setRes_alone_score_cnt(rs.getInt("res_alone_score_cnt"));
				r.setCan_deliver(rs.getInt("can_deliver"));
				r.setCan_park(rs.getInt("can_park"));
				r.setCan_advance_pay(rs.getInt("can_advance_pay"));
				r.setCan_alone_drink(rs.getInt("can_alone_drink"));
				r.setCapacity(rs.getInt("capacity"));
				r.setAdd_info(rs.getString("add_info"));
				r.setComment_cnt(rs.getInt("comment_cnt"));
				r.setActivation(rs.getInt("activation"));

				// 조회 결과를 List로 생성
				list.add(r);
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
	public Res selectResByResno(Res r) {
		String sql = "";
		sql += "SELECT * FROM restaurant ";
		sql += "WHERE res_no=?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, r.getRes_no());

			rs = ps.executeQuery();

			rs.next();

			r.setRes_no(rs.getInt("res_no"));
			r.setOwner_no(rs.getInt("owner_no"));
			r.setRes_group_no(rs.getInt("res_group_no"));
			r.setRes_name(rs.getString("res_name"));
			r.setRes_phone(rs.getString("res_phone"));
			r.setRes_addr1(rs.getString("res_addr1"));
			r.setRes_addr2(rs.getString("res_addr2"));
			r.setRes_busi_hour(rs.getString("res_busi_hour"));
			r.setRes_total_score(rs.getInt("res_total_score"));
			r.setRes_total_score_cnt(rs.getInt("res_total_score_cnt"));
			r.setRes_alone_score(rs.getInt("res_alone_score"));
			r.setRes_alone_score_cnt(rs.getInt("res_alone_score_cnt"));
			r.setCan_deliver(rs.getInt("can_deliver"));
			r.setCan_park(rs.getInt("can_park"));
			r.setCan_advance_pay(rs.getInt("can_advance_pay"));
			r.setCan_alone_drink(rs.getInt("can_alone_drink"));
			r.setCapacity(rs.getInt("capacity"));
			r.setAdd_info(rs.getString("add_info"));
			r.setComment_cnt(rs.getInt("comment_cnt"));
			r.setActivation(rs.getInt("activation"));

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
		return r;
	}

	@Override
	public void updateRes(Res res) {
		String sql = "";
		sql += "UPDATE restaurant";
		sql += " SET";
		sql += " owner_no=?";
		sql += " ,res_group_no=?";
		sql += " ,res_name=?";
		sql += " ,res_phone=?";
		sql += " ,res_addr1=?";
		sql += " ,res_addr2=?";
		sql += " ,res_busi_hour=?";
		sql += " ,res_total_score=?";
		sql += " ,res_total_score_cnt=?";
		sql += " ,res_alone_score=?";
		sql += " ,res_alone_score_cnt=?";
		sql += " ,can_deliver=?";
		sql += " ,can_park=?";
		sql += " ,can_advance_pay=?";
		sql += " ,can_alone_drink=?";
		sql += " ,capacity=?";
		sql += " ,add_info=?";
		sql += " ,comment_cnt=?";
		sql += " ,activation=?";
		sql += " WHERE res_no=?";
		
		PreparedStatement ps = null;
		
		try {
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, res.getOwner_no());
			ps.setInt(2, res.getRes_group_no());
			ps.setString(3, res.getRes_name());
			ps.setString(4, res.getRes_phone());
			ps.setString(5, res.getRes_addr1());
			ps.setString(6, res.getRes_addr2());
			ps.setString(7, res.getRes_busi_hour());
			ps.setInt(8, res.getRes_total_score());
			ps.setInt(9, res.getRes_total_score_cnt());
			ps.setInt(10, res.getRes_alone_score());
			ps.setInt(11, res.getRes_alone_score_cnt());
			
			ps.setInt(12, res.getCan_deliver());
			ps.setInt(13, res.getCan_park());
			ps.setInt(14, res.getCan_advance_pay());
			ps.setInt(15, res.getCan_alone_drink());
			ps.setInt(16, res.getCapacity());
			ps.setString(17, res.getAdd_info());
			ps.setInt(18, res.getComment_cnt());
			ps.setInt(19, res.getActivation());
			ps.setInt(20, res.getRes_no());
			
			ps.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void deleteRes(Res res) {
		String sql ="";
		sql += "UPDATE restaurant ";
		sql += " SET activation=?";
		sql += " WHERE res_no=?";
		
		// activation이 음수이면 삭제된 걸로 처리
		res.setActivation(res.getActivation()-2);
		
		PreparedStatement ps = null;
		
		try {
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, res.getActivation());
			ps.setInt(2, res.getRes_no());
			
			ps.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void insertRes(Res res) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Res> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCntSearch(String search) {
		// 검색 게시글 수 조회 쿼리
		String sql = "";
		sql += "SELECT COUNT(*) FROM restaurant ";
		sql += "WHERE res_name LIKE ? ";
		sql += " AND activation>=0";
		sql += "ORDER BY res_no";

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

	@Override
	public void resActive(int res_no) {

		String sql = "";
		sql += "update restaurant";
		sql += " set activation = case";
		sql += "	when activation = 1 then 0";
		sql += "	when activation = 0 then 1";
		sql += "	end";
		sql += " where res_no=?";

		PreparedStatement ps = null;

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);

			ps.setInt(1, res_no);
			System.out.println(res_no);
			System.out.println("test3");
			ps.executeUpdate();
			System.out.println("test4");

			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
