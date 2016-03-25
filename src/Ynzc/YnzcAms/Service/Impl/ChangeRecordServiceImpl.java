package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ChangeRecordDao;
import Ynzc.YnzcAms.Model.ChangeRecord;
import Ynzc.YnzcAms.Model.ChangeRecordView;
import Ynzc.YnzcAms.Model.Loyout;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Service.ChangeRecordService;

public class ChangeRecordServiceImpl implements ChangeRecordService {
	private ChangeRecordDao changeRecordDao;

	public ChangeRecordDao getChangeRecordDao() {
		return changeRecordDao;
	}

	public void setChangeRecordDao(ChangeRecordDao changeRecordDao) {
		this.changeRecordDao = changeRecordDao;
	}

	public boolean addChangeRecord(ChangeRecord model) {
		// TODO Auto-generated method stub
		return this.changeRecordDao.addModel(model);
	}

	public List<ChangeRecordView> getChangeRecordList(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return changeRecordDao.getAllModelList(page, conditions, userid);
	}

	public boolean updateChangeRecord(ChangeRecord model) {
		// TODO Auto-generated method stub
		return this.changeRecordDao.updateModel(model);
	}

	public boolean delChangeRecordByIds(String ids) {
		return this.changeRecordDao.delChangeRecordByIds(ids);
	}

	public boolean updateChangeRecordStateByIds(int state, String ids) {
		return this.changeRecordDao.updateChangeRecordStateByIds(state, ids);
	}

	public List<ChangeRecord> findChangeRecordingByTractorinfoId(String tractorids) {
		// TODO Auto-generated method stub
		return this.changeRecordDao.findChangeRecordingByTractorinfoId(tractorids);
	}
	public boolean auditChangeRecord(int state,String checkuser,String checkip,String checkcontext,String ids){
		return this.changeRecordDao.auditChangeRecord(state, checkuser, checkip, checkcontext, ids);
	}
	public List<ChangeRecordView> getChangeRecordViewListByIds(String ids){
		return this.changeRecordDao.getChangeRecordViewListByIds(ids);
	}
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		return changeRecordDao.recordReport(id);
	}
	public List<ChangeRecordView> getChangeRecordList(Page page,String conditions,String regionid){
		return changeRecordDao.getAllModelList(page, conditions, regionid);
	}

	public List<ChangeRecordView> getFilingList(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return changeRecordDao.getFilingList(page, conditions, regionid);
	}

	public List<ChangeRecordView> getFilingListQuery(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return changeRecordDao.getFilingListQuery(page, conditions, regionid);
	}
}
