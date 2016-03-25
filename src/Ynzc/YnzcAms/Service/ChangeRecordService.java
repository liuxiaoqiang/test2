package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeRecord;
import Ynzc.YnzcAms.Model.ChangeRecordView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;

public interface ChangeRecordService {
	public List<ChangeRecordView> getChangeRecordList(Page page,String conditions,int userid);
	public boolean addChangeRecord(ChangeRecord model);
	public boolean updateChangeRecord(ChangeRecord model);	
	public boolean updateChangeRecordStateByIds(int state, String ids);
	public boolean delChangeRecordByIds(String ids);
	public List<ChangeRecord> findChangeRecordingByTractorinfoId(String tractorids);
	public boolean auditChangeRecord(int state,String checkuser,String checkip,String checkcontext,String ids);
	public List<ChangeRecordView> getChangeRecordViewListByIds(String ids);
	public List<ChangeRecordView> getFilingList(Page page,String conditions, String regionid);
	public List<ChangeRecordView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<ChangeRecordView> getChangeRecordList(Page page,String conditions,String regionid);
}
