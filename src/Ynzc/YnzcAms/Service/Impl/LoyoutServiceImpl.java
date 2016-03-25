package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.LoyoutDao;
import Ynzc.YnzcAms.Model.LogoutView;
import Ynzc.YnzcAms.Model.Loyout;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorScrapApplicationSource;
import Ynzc.YnzcAms.Service.LoyoutService;

public class LoyoutServiceImpl implements LoyoutService {
	private LoyoutDao loyoutDao;

	public LoyoutDao getLoyoutDao() {
		return loyoutDao;
	}

	public void setLoyoutDao(LoyoutDao loyoutDao) {
		this.loyoutDao = loyoutDao;
	}

	public List<LogoutView> getLoyoutList(Page page, String conditions,
			int userid) {
		// TODO Auto-generated method stub
		return loyoutDao.getAllModelList(page, conditions, userid);
	}

	public boolean updateLoyout(Loyout model) {
		// TODO Auto-generated method stub
		return loyoutDao.updateModel(model);
	}

	public boolean addLoyout(Loyout model) {
		// TODO Auto-generated method stub
		return this.loyoutDao.addModel(model);
	}

	public boolean delLoyoutByIds(String ids) {
		return this.loyoutDao.delLoyoutByIds(ids);
	}

	public boolean updateLoyoutStateByIds(int state, String ids) {
		return this.loyoutDao.updateLoyoutStateByIds(state, ids);
	}

	public List<Loyout> findLoyoutByTractorinfoId(String tractorids) {
		// TODO Auto-generated method stub
		return this.loyoutDao.findLoyoutByTractorinfoId(tractorids);
	}
	 public int getMaxLoginNumber(){
		 return this.loyoutDao.getMaxLoginNumber();
	 }
	 public List<LogoutView> getLogoutViewListByIds(String ids){
		 return this.loyoutDao.getLogoutViewListByIds(ids);
	 }

	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		return loyoutDao.recordReport(id);
	}
	public List<LogoutView> getLoyoutList(Page page,String conditions,String regionid){
		return loyoutDao.getAllModelList(page, conditions, regionid);
	}

	public List<LogoutView> getFilingList(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return loyoutDao.getFilingList(page, conditions, regionid);
	}

	public List<LogoutView> getFilingListQuery(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return loyoutDao.getFilingListQuery(page, conditions, regionid);
	}
	public List<TractorScrapApplicationSource> PrintLogoutReport(int id){
		return loyoutDao.PrintLogoutReport(id);
	}
}
