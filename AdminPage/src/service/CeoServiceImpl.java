package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CeoDao;
import dao.CeoDaoImpl;
import dto.Ceo;
import util.Paging;

public class CeoServiceImpl implements CeoService {
	private CeoDao ceoDao = new CeoDaoImpl();

	@Override
	public List<Ceo> getCeoAll() {
		return ceoDao.selectAll();
	}

	@Override
	public void editCeo(Ceo ceo) {
		ceoDao.updateCeo(ceo);
	}

	@Override
	public void deleteCeo(Ceo ceo) {
		ceo = ceoDao.selectCeoByMemno(ceo);
		
		ceoDao.deleteCeo(ceo);
	}

	@Override
	public Ceo view(Ceo ceo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ceo getParam(HttpServletRequest req, HttpServletResponse resp) {
		Ceo ceo = new Ceo();

		ceo.setMem_no(Integer.parseInt(req.getParameter("mem_no")));
		ceo.setMem_group_no(Integer.parseInt(req.getParameter("mem_group_no")));
		ceo.setMem_id(req.getParameter("mem_id"));
		ceo.setMem_pw(req.getParameter("mem_pw"));
		
		ceo.setMem_name(req.getParameter("mem_name"));
		ceo.setMem_nick(req.getParameter("mem_nick"));
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		try {
			ceo.setMem_birth(f.parse(req.getParameter("mem_birth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ceo.setMem_gen(Integer.parseInt(req.getParameter("mem_gen")));
		ceo.setMem_phone(req.getParameter("mem_phone"));
		ceo.setMem_addr1(req.getParameter("mem_addr1"));
		ceo.setMem_addr2(req.getParameter("mem_addr2"));
		ceo.setMem_point(Integer.parseInt(req.getParameter("mem_point")));
		ceo.setMem_acc_point(Integer.parseInt(req.getParameter("mem_acc_point")));
		ceo.setMem_grade(Integer.parseInt(req.getParameter("mem_grade")));
		
		return ceo;
	}


	@Override
	public List<Ceo> getPagingList(Paging paging, String search) {
		return ceoDao.selectPagingList(paging, search);
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
	public Ceo getCeoByCeoname(Ceo Ceo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount(String search) {
		if("".equals(search))
			return ceoDao.selectCntAll();
		else
			return ceoDao.selectCntSearch(search);
	}

	@Override
	public Ceo getCeoByMemno(Ceo ceo) {
		return ceoDao.selectCeoByMemno(ceo);
	}

}
