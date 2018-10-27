package dao;

import java.util.List;

import dto.Ceo;
import dto.Member;
import util.Paging;

public interface CeoDao {
	public int selectCntAll();			// 사장님 수 조회
	public int selectCntSearch(String search);
	public List<Ceo> selectAll();	// 모든 ceo 조회
	public List<Ceo> selectPagingList(Paging paging, String search);	// 사장님 페이징 조회
	public void updateCeo(Ceo ceo);		// ceo 정보 수정
	public void deleteCeo(Ceo ceo);		// ceo 삭제
	public Ceo selectCeoByMemno(Ceo ceo); // Memno로 ceo 조회

}
