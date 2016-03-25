package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorInfoView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.User;

public interface TractorInfoViewDao {
	public List<TractorInfoView> getTractorInfoViewList(Page page,String conditions,int userid);
	public List<TractorInfoView> getTractorInfoViewList(Page page,String conditions,String regionid);
	public List<TractorInfoView> getCarChangeTractorInfoViewList(Page page,String conditions,int userid);
	public List<TractorInfoView> getCarCheckTractorInfoViewList(Page page,String conditions,int userid,int state);
	public TractorInfoView findTractorInfoViewByWhere(String plate,String code,String regionid);
	public TractorInfoView findTractorInfoViewById(int id);
	public List<TractorInfoView> getFilingList(Page page,String conditions, String regionid);
	public List<TractorInfoView> getFilingListQuery(Page page,String conditions, String regionid);
	public boolean updateExpirydate();
}
