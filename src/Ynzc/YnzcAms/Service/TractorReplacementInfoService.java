package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorReplacementApplicationSource;
import Ynzc.YnzcAms.Model.TractorReplacementInfo;
import Ynzc.YnzcAms.Model.TractorReplacementInfoView;

public interface TractorReplacementInfoService {
	public boolean addTractorReplacementInfo(TractorReplacementInfo model);
	public List<TractorReplacementInfo> getTractorReplacementInfoList(Page page, String conditions);
	public boolean updateTractorReplacementInfo(TractorReplacementInfo model);
	public List<TractorReplacementInfoView> getTractorReplacementInfoView(Page page, String conditions,int userid);
	public List<TractorReplacementInfo> findTractorReplacementInfoByTractorinfoId(String tractorids);
	public boolean delTractorReplacementInfoByIds(String ids);
	public boolean updateTractorReplacementInfoStateByIds(int state,String ids);
	public boolean auditReplacementInfo(int state,String checkuser,String checkcontext,String ids);
	public List<TractorReplacementInfoView> findTractorReplacementInfoByIds(String replaceIds);
	public List<TractorReplacementInfoView> getFilingList(Page page,String conditions, String regionid);
	public List<TractorReplacementInfoView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<TractorReplacementInfoView> getTractorReplacementInfoView(Page page, String conditions,String regionid);
	public List<TractorReplacementInfoView> getTractorReplacementInfoViewListByIds(String ids);
	public List<TractorReplacementApplicationSource> PrintReplacementReport(int id);
}
