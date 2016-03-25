package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.TractorInfoViewDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorInfoView;
import Ynzc.YnzcAms.Service.TractorInfoViewService;

public class TractorInfoViewServiceImpl implements TractorInfoViewService {
	private TractorInfoViewDao tractorInfoViewDao;

	public TractorInfoViewDao getTractorInfoViewDao() {
		return tractorInfoViewDao;
	}

	public void setTractorInfoViewDao(TractorInfoViewDao tractorInfoViewDao) {
		this.tractorInfoViewDao = tractorInfoViewDao;
	}

	public List<TractorInfoView> getTractorInfoViewList(Page page,
			String conditions, int userid) {
		return this.tractorInfoViewDao.getTractorInfoViewList(page, conditions,
				userid);
	}

	public List<TractorInfoView> getCarChangeTractorInfoViewList(Page page,
			String conditions, int userid) {
		return this.tractorInfoViewDao.getCarChangeTractorInfoViewList(page,
				conditions, userid);
	}

	public boolean updateExpirydate() {
		return this.tractorInfoViewDao.updateExpirydate();
	}

	public TractorInfoView findTractorInfoViewByWhere(String plate, String code,String regionid) {
		return this.tractorInfoViewDao.findTractorInfoViewByWhere(plate, code,regionid);
	}
	public TractorInfoView findTractorInfoViewById(int id){
		return this.tractorInfoViewDao.findTractorInfoViewById(id);
	}
	public List<TractorInfoView> getCarCheckTractorInfoViewList(Page page,
			String conditions, int userid, int state) {
		// TODO Auto-generated method stub
		return this.tractorInfoViewDao.getCarCheckTractorInfoViewList(page, conditions, userid, state);
	}

	public List<TractorInfoView> getTractorInfoViewList(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return this.tractorInfoViewDao.getTractorInfoViewList(page, conditions, regionid);
	}

	public List<TractorInfoView> getFilingList(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return this.tractorInfoViewDao.getFilingList(page, conditions, regionid);
	}

	public List<TractorInfoView> getFilingListQuery(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return this.tractorInfoViewDao.getFilingListQuery(page, conditions, regionid);
	}


}
