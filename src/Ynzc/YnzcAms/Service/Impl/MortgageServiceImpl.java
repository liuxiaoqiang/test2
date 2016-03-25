package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.MortgageDao;
import Ynzc.YnzcAms.Model.Mortgage;
import Ynzc.YnzcAms.Model.MortgageView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorMortgageApplicationSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Service.MortgageService;

public class MortgageServiceImpl implements MortgageService {

	private MortgageDao mortgageDao;

	public MortgageDao getMortgageDao() {
		return mortgageDao;
	}

	public void setMortgageDao(MortgageDao mortgageDao) {
		this.mortgageDao = mortgageDao;
	}

	public boolean updateMortgage(Mortgage model) {
		// TODO Auto-generated method stub
		return this.mortgageDao.updateModel(model);
	}

	public List<MortgageView> getMortgageList(Page page, String conditions,
			int userid) {
		// TODO Auto-generated method stub
		return this.mortgageDao.getAllModelList(page, conditions, userid);
	}

	public boolean addMortgage(Mortgage model) {
		// TODO Auto-generated method stub
		return this.mortgageDao.addModel(model);
	}

	public boolean delMortgageByIds(String ids) {
		return this.mortgageDao.delMortgageByIds(ids);
	}

	public boolean updateMortgageStateByIds(int state, String ids) {
		return this.mortgageDao.updateMortgageStateByIds(state, ids);
	}

	public List<Mortgage> findMortgageingByTractorinfoId(String tractorids) {
		// TODO Auto-generated method stub
		return this.mortgageDao.findMortgageingByTractorinfoId(tractorids);
	}
	public boolean auditMortgage(int state,String checkuser,String checkip,String checkcontext,String ids){
		return this.mortgageDao.auditMortgage(state, checkuser, checkip, checkcontext, ids);
	}
	public List<MortgageView> getMortgageViewListByIds(String ids){
		return this.mortgageDao.getMortgageViewListByIds(ids);
	}
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		return mortgageDao.recordReport(id);
	}
	public List<MortgageView> getMortgageList(Page page,String conditions,String regionid){
		return mortgageDao.getAllModelList(page, conditions, regionid);
	}

	public List<MortgageView> getFilingList(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return mortgageDao.getFilingList(page, conditions, regionid);
	}

	public List<MortgageView> getFilingListQuery(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return mortgageDao.getFilingListQuery(page, conditions, regionid);
	}
	public List<TractorMortgageApplicationSource> PrintMortgageReport(int id){
		return mortgageDao.PrintMortgageReport(id);
	}
}
