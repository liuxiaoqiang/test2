package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorInfoView;

public interface TractorInfoViewService {
	public List<TractorInfoView> getTractorInfoViewList(Page page, String conditions,int userid);
	public List<TractorInfoView> getTractorInfoViewList(Page page, String conditions,String regionid);
	public TractorInfoView findTractorInfoViewByWhere(String plate,String code,String regionid);
	public TractorInfoView findTractorInfoViewById(int id);
	public List<TractorInfoView> getCarChangeTractorInfoViewList(Page page,String conditions,int userid);
	public List<TractorInfoView> getCarCheckTractorInfoViewList(Page page,String conditions,int userid,int state);
	public List<TractorInfoView> getFilingList(Page page,String conditions, String regionid);
	public List<TractorInfoView> getFilingListQuery(Page page,String conditions, String regionid);
	public boolean updateExpirydate();
}
