package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeRecord;
import Ynzc.YnzcAms.Model.ChangeRecordView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;

public interface ChangeRecordDao {
	public List<ChangeRecordView> getAllModelList(Page page,String conditions,int userid);
	public List<ChangeRecord> getAllModelList();
	public ChangeRecord findModelById(int id);
	public boolean addModel(ChangeRecord model);
	public boolean delModel(ChangeRecord model);
	public boolean updateModel(ChangeRecord model);
	public List<ChangeRecord> findChangeRecordingByTractorinfoId(String tractorids);	
	public boolean delChangeRecordByIds(String ids);
	public boolean updateChangeRecordStateByIds(int state,String ids);
	public boolean auditChangeRecord(int state,String checkuser,String checkip,String checkcontext,String ids);
	public List<ChangeRecordView> getChangeRecordViewListByIds(String ids);
	public List<ChangeRecordView> getFilingList(Page page,String conditions, String regionid);
	public List<ChangeRecordView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<ChangeRecordView> getAllModelList(Page page,String conditions,String regionid);
}
