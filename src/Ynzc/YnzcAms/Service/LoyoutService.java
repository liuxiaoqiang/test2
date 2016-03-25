package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.LogoutView;
import Ynzc.YnzcAms.Model.Loyout;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorScrapApplicationSource;

public interface LoyoutService {
	public List<LogoutView> getLoyoutList(Page page,String conditions,int userid);
	public boolean addLoyout(Loyout model);
	public boolean updateLoyout(Loyout model);
	public boolean updateLoyoutStateByIds(int state, String ids);
	public boolean delLoyoutByIds(String ids);
	public List<Loyout> findLoyoutByTractorinfoId(String tractorids);
	public int getMaxLoginNumber();
	public List<LogoutView> getLogoutViewListByIds(String ids);
    public List<LogoutView> getFilingList(Page page,String conditions, String regionid);
    public List<LogoutView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<LogoutView> getLoyoutList(Page page,String conditions,String regionid);
	public List<TractorScrapApplicationSource> PrintLogoutReport(int id);
}
