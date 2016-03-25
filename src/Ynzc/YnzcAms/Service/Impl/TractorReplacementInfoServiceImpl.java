package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.TractorReplacementInfoDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorReplacementApplicationSource;
import Ynzc.YnzcAms.Model.TractorReplacementInfo;
import Ynzc.YnzcAms.Model.TractorReplacementInfoView;
import Ynzc.YnzcAms.Service.TractorReplacementInfoService;

public class TractorReplacementInfoServiceImpl implements
		TractorReplacementInfoService {

	private TractorReplacementInfoDao tractorReplacementInfoDao;

	public TractorReplacementInfoDao getTractorReplacementInfoDao() {
		return tractorReplacementInfoDao;
	}

	public void setTractorReplacementInfoDao(
			TractorReplacementInfoDao tractorReplacementInfoDao) {
		this.tractorReplacementInfoDao = tractorReplacementInfoDao;
	}

	public boolean addTractorReplacementInfo(TractorReplacementInfo model) {
		// TODO Auto-generated method stub
		return tractorReplacementInfoDao.addTractorReplacementInfo(model);
	}

	public List<TractorReplacementInfo> getTractorReplacementInfoList(
			Page page, String conditions) {
		return tractorReplacementInfoDao.getTractorReplacementInfoList(page,
				conditions);
	}

	public boolean updateTractorReplacementInfo(TractorReplacementInfo model) {
		return tractorReplacementInfoDao.updateTractorReplacementInfo(model);
	}

	public List<TractorReplacementInfo> findTractorReplacementInfoByTractorinfoId(
			String tractorids) {
		// TODO Auto-generated method stub
		return this.tractorReplacementInfoDao
				.findTractorReplacementInfoByTractorinfoId(tractorids);
	}

	public List<TractorReplacementInfoView> getTractorReplacementInfoView(
			Page page, String conditions,int userid) {
		// TODO Auto-generated method stub
		return tractorReplacementInfoDao.getTractorReplacementInfoView(page,
				conditions,userid);
	}
	public boolean delTractorReplacementInfoByIds(String ids){
		return this.getTractorReplacementInfoDao().delTractorReplacementInfoByIds(ids);
	}
	public boolean updateTractorReplacementInfoStateByIds(int state,String ids){
		return this.getTractorReplacementInfoDao().updateTractorReplacementInfoStateByIds(state, ids);
	}
	public boolean auditReplacementInfo(int state,String checkuser,String checkcontext,String ids){
		return this.tractorReplacementInfoDao.auditReplacementInfo(state, checkuser, checkcontext, ids);
	}
	public List<TractorReplacementInfoView> findTractorReplacementInfoByIds(String replaceIds){
		return this.tractorReplacementInfoDao.findTractorReplacementInfoByIds(replaceIds);
	}
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		return tractorReplacementInfoDao.recordReport(id);
	}
	public List<TractorReplacementInfoView> getTractorReplacementInfoView(Page page, String conditions,String regionid){
		return tractorReplacementInfoDao.getTractorReplacementInfoView(page, conditions, regionid);
	}
	public List<TractorReplacementInfoView> getTractorReplacementInfoViewListByIds(String ids){
		return tractorReplacementInfoDao.getTractorReplacementInfoViewListByIds(ids);
	}

	public List<TractorReplacementInfoView> getFilingList(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return tractorReplacementInfoDao.getFilingList(page, conditions, regionid);
	}

	public List<TractorReplacementInfoView> getFilingListQuery(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return tractorReplacementInfoDao.getFilingListQuery(page, conditions, regionid);
	}
	public List<TractorReplacementApplicationSource> PrintReplacementReport(int id){
		return tractorReplacementInfoDao.PrintReplacementReport(id);
	}
}
