package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.*;

public interface LoyoutDao {
	public List<LogoutView> getAllModelList(Page page,String conditions,int userid);
	public Loyout findModelById(int id);
	public boolean addModel(Loyout model);
	public boolean delModel(Loyout model);
	public boolean updateModel(Loyout model);
	public List<Loyout> findLoyoutByTractorinfoId(String tractorids);
	public boolean delLoyoutByIds(String ids);
	public boolean updateLoyoutStateByIds(int state,String ids);
    public int getMaxLoginNumber();
    public List<LogoutView> getLogoutViewListByIds(String ids);
    public List<LogoutView> getFilingList(Page page,String conditions, String regionid);
    public List<LogoutView> getFilingListQuery(Page page,String conditions, String regionid);
    public List<TractorRegistrationRecordProcessSource> recordReport(int id);
    public List<LogoutView> getAllModelList(Page page,String conditions,String regionid);
    public List<TractorScrapApplicationSource> PrintLogoutReport(int id);
    
}
