package dao;

import java.util.List;

import dto.Member;
import util.Paging;

public interface MemberDao {
	public int selectCntMemberByUserid(Member mem);
	public Member selectMemberByUserid(Member mem);
	public int selectCntAll();			// 멤버 수 조회
	public int selectCntSearch(String search);
	public List<Member> selectMemberAll();	// 모든 멤버 조회
	public List<Member> selectPagingList(Paging paging, String search);	// 멤버 페이징 조회
	public void updateMember(Member mem);	// 멤버 정보 수정
	public void deleteMember(Member mem);	// 멤버 삭제
}
