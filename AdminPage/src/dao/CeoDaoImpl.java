package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Ceo;
import dto.Member;
import util.DBConn;
import util.Paging;

public class CeoDaoImpl implements CeoDao {

	// DB 연결 객체
	private static Connection conn = DBConn.getConnection(); // ���ᰴü

	@Override
	public void updateCeo(Ceo ceo) { // 사장님 수정
		String sql = "";
		sql += "UPDATE member";
		sql += " SET mem_group_no=?";
		sql += ", mem_id=?";
		sql += ", mem_pw=?";
		sql += ", mem_name=?";
		sql += ", mem_nick=?";
		sql += ", mem_birth=?";
		sql += ", mem_gen=?";
		sql += ", mem_phone=?";
		sql += ", mem_addr1=?";
		sql += ", mem_addr2=?";
		sql += ", mem_point=?";
		sql += ", mem_acc_point=?";
		sql += ", mem_grade=?";
		sql += " WHERE mem_no=?";
		
		PreparedStatement ps = null;
		
		try {
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ceo.getMem_group_no());
			
			ps.setString(2, ceo.getMem_id());
			ps.setString(3, ceo.getMem_pw());
			ps.setString(4, ceo.getMem_name());
			ps.setString(5, ceo.getMem_nick());
			
			java.sql.Date sqlDate = new Date( ceo.getMem_birth().getTime() );
			System.out.println(ceo.getMem_birth());
			System.out.println(sqlDate);
			
			ps.setDate(6, sqlDate);
			ps.setInt(7, ceo.getMem_gen());
			ps.setString(8, ceo.getMem_phone());
			ps.setString(9, ceo.getMem_addr1());
			ps.setString(10, ceo.getMem_addr2());
			ps.setInt(11, ceo.getMem_point());
			ps.setInt(12, ceo.getMem_acc_point());
			ps.setInt(13, ceo.getMem_grade());
			ps.setInt(14, ceo.getMem_no());
			
			ps.executeUpdate();
			
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

	@Override
	public void deleteCeo(Ceo ceo) { // 사장님 삭제
		String sql = "";
		sql += "UPDATE member ";
		sql += "SET mem_gen=?";
		sql += "WHERE mem_no = ?";
		
		 // mem_den이 음수이면 삭제된 걸로 처리
		ceo.setMem_gen(ceo.getMem_gen()-2);
		
		//DB 객체
		PreparedStatement ps = null;
		
		try {
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ceo.getMem_gen());
			ps.setInt(2, ceo.getMem_no());
			
			ps.executeUpdate();
			
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

	@Override
	public int selectCntAll() { // 모든 사장님 수 조회
		// 전체 게시글 수 조회 쿼리
				String sql = "";
				sql += "SELECT COUNT(*) FROM member WHERE mem_group_no=2";
				sql += " AND mem_gen>0";
				
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
	public List<Ceo> selectAll() { // 모든 사장님 조회
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ceo> selectPagingList(Paging paging, String search) { // 페이징 리스트
		// 페이징 리스트 조회 쿼리
				String sql = "";
				sql += "SELECT * FROM (";
				sql += "	SELECT ROWNUM rnum, b.* FROM (";
				sql += "		SELECT * FROM member";
				sql += "		WHERE mem_name LIKE ?";
				sql += "		AND mem_group_no=2";
				sql += " 		AND mem_gen>0";
				sql += "		ORDER BY mem_no";
				sql += "	) b";
				sql += "	ORDER BY rnum ";
				sql += ") ";
				sql += "WHERE rnum BETWEEN ? AND ?";

				// DB 객체
				PreparedStatement ps = null;
				ResultSet rs = null;

				// 최종 조회 결과 담을 List
				List<Ceo> list = new ArrayList<>();

				try {
					ps = conn.prepareStatement(sql);

					ps.setString(1, "%" + search + "%");
					ps.setInt(2, paging.getStartNo());
					ps.setInt(3, paging.getEndNo());

					rs = ps.executeQuery();

					while (rs.next()) {
						Ceo m = new Ceo();

						m.setMem_no(rs.getInt("mem_no"));
						m.setMem_id(rs.getString("mem_id"));
						m.setMem_name(rs.getString("mem_name"));
						m.setMem_birth(rs.getDate("mem_birth"));
						m.setMem_phone(rs.getString("mem_phone"));
						m.setMem_point(rs.getInt("mem_point"));
						m.setMem_addr1(rs.getString("mem_addr1"));

						// 조회 결과를 List로 생성
						list.add(m);
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
	public int selectCntSearch(String search) {
		// 검색 게시글 수 조회 쿼리
		String sql = "";
		sql += "SELECT COUNT(*) FROM member ";
		sql += "WHERE mem_name LIKE ? ";
		sql += "AND mem_group_no=2";
		sql += " AND mem_gen>0";

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
	public Ceo selectCeoByMemno(Ceo ceo) {
		String sql = "select * from member where mem_no=?";

		//DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ceo.getMem_no());
			rs = ps.executeQuery();

			rs.next();

			ceo.setMem_group_no(rs.getInt("mem_group_no"));
			ceo.setMem_id(rs.getString("mem_id"));
			ceo.setMem_pw(rs.getString("mem_pw"));
			ceo.setMem_name(rs.getString("mem_name"));
			ceo.setMem_nick(rs.getString("mem_nick"));
			ceo.setMem_birth(rs.getDate("mem_birth"));
			ceo.setMem_gen(rs.getInt("mem_gen"));
			ceo.setMem_phone(rs.getString("mem_phone"));
			ceo.setMem_addr1(rs.getString("mem_addr1"));
			ceo.setMem_addr2(rs.getString("mem_addr2"));
			ceo.setMem_point(rs.getInt("mem_point"));
			ceo.setMem_acc_point(rs.getInt("mem_acc_point"));
			ceo.setMem_grade(rs.getInt("mem_grade"));

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

		return ceo;
	}

}
