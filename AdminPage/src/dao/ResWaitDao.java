package dao;

import java.util.List;

import dto.Res;
import util.Paging;

public interface ResWaitDao {
	public int selectCntAll();	// 전체 맛집 대기리스트 수 조회
	public int selectCntSearch(String search);
	public List<Res> selectPagingList(Paging paging, String search);	// 맛집 대기 리스트 페이징 조회
	public List<Res> selectAll(); // 맛집 대기리스트 조회
	public Res selectResByResno(Res res); // 맛집 대기리스트 상세조회 반환
	public void insertRes(Res res);	// 맛집 대기리스트 추가
	public void updateRes(Res res);	// 맛집 대기리스트 수정 및 맛집 승인
	public void deleteRes(Res res);	// 맛집 대기리스트 삭제
	public void resActive(int res_no); // 맛집 번호로 조회해서 승인하는 메소드
	// 맛집 검색 메소드
}
