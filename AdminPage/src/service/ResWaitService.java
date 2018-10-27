package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Res;
import util.Paging;

public interface ResWaitService {
	public Res view(Res res);	// 공지사항 상세 조회
	public Res getParam(HttpServletRequest req, HttpServletResponse resp);
	public int getTotalCount(String search);
	public List<Res> getPagingList(Paging paging, String search);
	public List<Res> getResWaitAll(); // 모든 맛집 등록 대기 조회
	public int getCurPage(HttpServletRequest req);
	public void editRes(Res res);	// 맛집 수정
	public void deleteRes(Res res);	// 맛집 제거
	public void writeRes(Res res);	// 맛집 추가
	public void allowRes(int res_no); // 맛집 승인 메소드
	// 공지사항 검색 메소드
}
