package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Mortgage;
import Ynzc.YnzcAms.Model.MortgageView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorMortgageApplicationSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;

public interface MortgageService {
	public List<MortgageView> getMortgageList(Page page,String conditions,int userid);
	public boolean addMortgage(Mortgage model);
	public boolean updateMortgage(Mortgage model);
	public List<Mortgage> findMortgageingByTractorinfoId(String tractorids);
	public boolean updateMortgageStateByIds(int state, String ids);
	public boolean delMortgageByIds(String ids);
	public boolean auditMortgage(int state,String checkuser,String checkip,String checkcontext,String ids);
	public List<MortgageView> getMortgageViewListByIds(String ids);
	public List<MortgageView> getFilingList(Page page,String conditions, String regionid);
	public List<MortgageView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<MortgageView> getMortgageList(Page page,String conditions,String regionid);
	public List<TractorMortgageApplicationSource> PrintMortgageReport(int id);
}
