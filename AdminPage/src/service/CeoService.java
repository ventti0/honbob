package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Ceo;
import dto.Member;
import util.Paging;


public interface CeoService {
	public Ceo view(Ceo ceo);	// Ceo 상세 조회
	public Ceo getParam(HttpServletRequest req, HttpServletResponse resp);
	public int getTotalCount(String search); // 전체 게시글 수 조회(검색 포함)
	public List<Ceo> getPagingList(Paging paging, String search); // ceo 페이징 조회(검색 포함)
	public int getCurPage(HttpServletRequest req);
	public Ceo getCeoByCeoname(Ceo Ceo);	// 사장님 이름으로 조회
	public List<Ceo> getCeoAll();	// 모든 사장님 조회
	public void editCeo(Ceo ceo);	// 사장님 정보 수정
	public void deleteCeo(Ceo ceo);	// 사장님 정보 삭제
	public Ceo getCeoByMemno(Ceo ceo);
	
}
