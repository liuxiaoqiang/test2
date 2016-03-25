package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.*;

public interface TractorReplacementInfoDao {
	public boolean addTractorReplacementInfo(TractorReplacementInfo model);//add
	public List<TractorReplacementInfo> getTractorReplacementInfoList(Page page, String conditions);//select
	public boolean updateTractorReplacementInfo(TractorReplacementInfo model);//update
	public List<TractorReplacementInfo> findTractorReplacementInfoByTractorinfoId(String tractorids);
	public List<TractorReplacementInfoView> getTractorReplacementInfoView(Page page, String conditions,int userid);
	public boolean delTractorReplacementInfoByIds(String ids);
	public boolean updateTractorReplacementInfoStateByIds(int state,String ids);
	public boolean auditReplacementInfo(int state,String checkuser,String checkcontext,String ids);
	public List<TractorReplacementInfoView> findTractorReplacementInfoByIds(String replaceIds);
	public List<TractorReplacementInfoView> getFilingList(Page page,String conditions, String regionid);
	public List<TractorReplacementInfoView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<TractorReplacementInfoView> getTractorReplacementInfoView(Page page,String conditions,String regionid);
	public List<TractorReplacementInfoView> getTractorReplacementInfoViewListByIds(String ids);
	public List<TractorReplacementApplicationSource> PrintReplacementReport(int id);
}
