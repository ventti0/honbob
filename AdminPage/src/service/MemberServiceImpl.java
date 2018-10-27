package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;
import util.Paging;

public class MemberServiceImpl implements MemberService {
	private MemberDao memDao = new MemberDaoImpl();

	@Override
	public Member getParam(HttpServletRequest req, HttpServletResponse resp) {
		Member mem = new Member();

		mem.setMem_no(Integer.parseInt(req.getParameter("mem_no")));
		mem.setMem_group_no(Integer.parseInt(req.getParameter("mem_group_no")));
		mem.setMem_id(req.getParameter("mem_id"));
		mem.setMem_pw(req.getParameter("mem_pw"));
		
		mem.setMem_name(req.getParameter("mem_name"));
		mem.setMem_nick(req.getParameter("mem_nick"));
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		try {
			mem.setMem_birth(f.parse(req.getParameter("mem_birth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mem.setMem_gen(Integer.parseInt(req.getParameter("mem_gen")));
		mem.setMem_phone(req.getParameter("mem_phone"));
		mem.setMem_addr1(req.getParameter("mem_addr1"));
		mem.setMem_addr2(req.getParameter("mem_addr2"));
		mem.setMem_point(Integer.parseInt(req.getParameter("mem_point")));
		mem.setMem_acc_point(Integer.parseInt(req.getParameter("mem_acc_point")));
		mem.setMem_grade(Integer.parseInt(req.getParameter("mem_grade")));
		
		return mem;
	}

	@Override
	public boolean login(Member mem) {

		boolean login = false;
		if (memDao.selectCntMemberByUserid(mem) > 0)
			login = true;
		return login;
	}

	@Override
	public Member getMemberByUserid(Member mem) {

		return memDao.selectMemberByUserid(mem);
	}

	@Override
	public List<Member> getMemberAll() {

		List<Member> list = memDao.selectMemberAll(); // 모든 회원 조회

		return list;
	}

	@Override
	public void editMember(Member mem) { // 회원 수정
		memDao.updateMember(mem);
	}

	@Override
	public void deleteMember(Member mem) { // 회원 삭제
		mem = memDao.selectMemberByUserid(mem);
		
		memDao.deleteMember(mem);
	}

	@Override
	public Member view(Member mem) { // 회원 상세 뷰
		return memDao.selectMemberByUserid(mem);
	}

	@Override
	public int getCurPage(HttpServletRequest req) {
		// 요청파라미터 받기
		String curPage = req.getParameter("curPage");

		// null이나 ""이 아니면 int로 리턴
		if (curPage != null && !"".equals(curPage)) {
			return Integer.parseInt(curPage);
		}

		// null이나 "" 면 0으로 반환
		return 0;
	}

	@Override
	public int getTotalCount(String search) {
		
		if("".equals(search))
			return memDao.selectCntAll();
		else
			return memDao.selectCntSearch(search);
	}

	@Override
	public List getPagingList(Paging paging, String search) {
		return memDao.selectPagingList(paging, search);
	}

}
