package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.*;

public interface MortgageDao {
	public List<MortgageView> getAllModelList(Page page,String conditions,int userid);
	public List<Mortgage> getAllModelList();
	public Mortgage findModelById(int id);
	public boolean addModel(Mortgage model);
	public boolean delModel(Mortgage model);
	public boolean updateModel(Mortgage model);
	public List<Mortgage> findMortgageingByTractorinfoId(String tractorids);
	public boolean delMortgageByIds(String ids);
	public boolean updateMortgageStateByIds(int state,String ids);
	public boolean auditMortgage(int state,String checkuser,String checkip,String checkcontext,String ids);
	public List<MortgageView> getMortgageViewListByIds(String ids);
	public List<MortgageView> getFilingList(Page page,String conditions, String regionid);
	public List<MortgageView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<MortgageView> getAllModelList(Page page,String conditions,String regionid);
	public List<TractorMortgageApplicationSource> PrintMortgageReport(int id);
}
