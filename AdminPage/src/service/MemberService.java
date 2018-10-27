package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Ceo;
import dto.Member;
import util.Paging;

public interface MemberService {
	public Member view(Member mem); // 회원 상세 조회

	public Member getParam(HttpServletRequest req, HttpServletResponse resp);

	public boolean login(Member mem);

	public Member getMemberByUserid(Member mem);

	public List<Member> getMemberAll(); // 모든 회원 조회

	public void editMember(Member mem); // 회원 정보 수정

	public void deleteMember(Member mem); // 회원 정보 삭제

	// 요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);

	// 전체 게시글 수 조회(검색 포함)
	public int getTotalCount(String search);
	
	public List getPagingList(Paging paging, String search);
}