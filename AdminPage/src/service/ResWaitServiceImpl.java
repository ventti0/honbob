package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResWaitDao;
import dao.ResWaitDaoImpl;
import dto.Res;
import util.Paging;

public class ResWaitServiceImpl implements ResWaitService {
	private ResWaitDao resDao = new ResWaitDaoImpl();

	@Override
	public Res view(Res res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Res getParam(HttpServletRequest req, HttpServletResponse resp) {
		Res r = new Res();
		
		r.setRes_no(Integer.parseInt(req.getParameter("res_no")));
		r.setOwner_no(Integer.parseInt(req.getParameter("owner_no")));
		r.setRes_group_no(Integer.parseInt(req.getParameter("res_group_no")));
		r.setRes_name(req.getParameter("res_name"));
		r.setRes_phone(req.getParameter("res_phone"));
		r.setRes_addr1(req.getParameter("res_addr1"));
		r.setRes_addr2(req.getParameter("res_addr2"));
		r.setRes_busi_hour(req.getParameter("res_busi_hour"));
		r.setRes_total_score(Integer.parseInt(req.getParameter("res_total_score")));
		r.setRes_total_score_cnt(Integer.parseInt(req.getParameter("res_total_score_cnt")));
		r.setRes_alone_score(Integer.parseInt(req.getParameter("res_alone_score")));
		r.setRes_alone_score_cnt(Integer.parseInt(req.getParameter("res_alone_score_cnt")));
		r.setCan_deliver(Integer.parseInt(req.getParameter("can_deliver")));
		r.setCan_park(Integer.parseInt(req.getParameter("can_park")));
		r.setCan_advance_pay(Integer.parseInt(req.getParameter("can_advance_pay")));
		r.setCan_alone_drink(Integer.parseInt(req.getParameter("can_alone_drink")));
		r.setCapacity(Integer.parseInt(req.getParameter("capacity")));
		r.setAdd_info(req.getParameter("add_info"));
		r.setComment_cnt(Integer.parseInt(req.getParameter("comment_cnt")));
		r.setActivation(Integer.parseInt(req.getParameter("activation")));
		
		return r;
	}



	@Override
	public List<Res> getPagingList(Paging paging, String search) {
		return resDao.selectPagingList(paging, search);
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
	public void editRes(Res res) {
		resDao.updateRes(res);
	}

	@Override
	public void deleteRes(Res res) {
		resDao.deleteRes(res);

	}

	@Override
	public void writeRes(Res res) {
		// TODO Auto-generated method stub

	}

	@Override
	public void allowRes(int res_no) {
		resDao.resActive(res_no);
		System.out.println("test2");
	}

	@Override
	public List<Res> getResWaitAll() {
		return resDao.selectAll();
	}

	@Override
	public int getTotalCount(String search) {
		if("".equals(search))
			return resDao.selectCntAll();
		else
			return resDao.selectCntSearch(search);
	}

}
