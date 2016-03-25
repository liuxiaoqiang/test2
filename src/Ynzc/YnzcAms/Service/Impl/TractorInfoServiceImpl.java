package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.TractorInfoDao;
import Ynzc.YnzcAms.Model.CarInfomationSource;
import Ynzc.YnzcAms.Model.CarMoveReportSource;
import Ynzc.YnzcAms.Model.CarSafetyRoportSource;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalDataSource;
import Ynzc.YnzcAms.Model.TractorEnregisterCertificateReportSource;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorInfoRegisterYear;
import Ynzc.YnzcAms.Model.TractorRegistrationAndTurnInSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Service.TractorInfoService;

public  class TractorInfoServiceImpl implements TractorInfoService {

	private TractorInfoDao tractorInfoDao;

	public TractorInfoDao getTractorInfoDao() {
		return tractorInfoDao;
	}

	public void setTractorInfoDao(TractorInfoDao tractorInfoDao) {
		this.tractorInfoDao = tractorInfoDao;
	}

	public List<TractorInfo> getAllTractorInfoList(Page page, String conditions) {
		return this.tractorInfoDao.getAllTractorInfoList(page, conditions);
	}

	public TractorInfo findTractorInfoById(int id) {
		return this.tractorInfoDao.findTractorInfoById(id);
	}

	public boolean addTractorInfo(TractorInfo model) {
		return this.tractorInfoDao.addTractorInfo(model);
	}

	public boolean delTractorInfo(TractorInfo model) {
		return this.tractorInfoDao.delTractorInfo(model);
	}

	public boolean delTractorInfoByIds(String ids) {
		return this.tractorInfoDao.delTractorInfoByIds(ids);
	}

	public boolean updateTractorInfo(TractorInfo model) {
		return this.tractorInfoDao.updateTractorInfo(model);
	}

	public boolean updateTractorStateByIds(int state, String ids,
			String condtion) {
		return this.tractorInfoDao
				.updateTractorStateByIds(state, ids, condtion);
	}
	public boolean auditTractorInfo(int state,String ids){
		return this.tractorInfoDao.auditTractorInfo(state, ids);
	}
	public boolean auditTractorInfoFiling(int filing,String ids){
		return this.tractorInfoDao.auditTractorInfoFiling(filing, ids);
	}
	public boolean updateLicenseById(String license,int id){
		return this.tractorInfoDao.updateLicenseById(license, id);
	}
	public List<TractorInfo> getTractorInfoListByIds(String ids){
		return this.tractorInfoDao.getTractorInfoListByIds(ids);
	}

	public boolean GuiDang(String ids,int type) {
		// TODO Auto-generated method stub
		return tractorInfoDao.GuiDang(ids,type);
	}

	public List<CarInfomationSource> tractorInfoReport(int id) {
		// TODO Auto-generated method stub
		return tractorInfoDao.tractorInfoReport(id);
	}

	public List<TractorRegistrationAndTurnInSource> tractorInfoReportTwo(int id) {
		// TODO Auto-generated method stub
		return tractorInfoDao.tractorInfoReportTwo(id);
	}

	public List<TechnicalDataSource> tractorInfoReportThree(int id) {
		// TODO Auto-generated method stub
		return tractorInfoDao.tractorInfoReportThree(id);
	}

	public List<CarSafetyRoportSource> tractorInfoReportFour(int id) {
		// TODO Auto-generated method stub
		return tractorInfoDao.tractorInfoReportFour(id);
	}

	public List<TractorRegistrationRecordProcessSource> tractorInfoReportFive(
			int id) {
		// TODO Auto-generated method stub
		return tractorInfoDao.tractorInfoReportFive(id);
	}

	public List<CarMoveReportSource> tractorSteerReport(int id) {
		// TODO Auto-generated method stub
		return tractorInfoDao.tractorSteerReport(id);
	}

	public List<TractorEnregisterCertificateReportSource> TractorEnregisterCertificate(
			int id) {
		// TODO Auto-generated method stub
		return tractorInfoDao.TractorEnregisterCertificate(id);
	}

	public String getRegcerno(String regcerno) {
		return tractorInfoDao.getRegcerno(regcerno);
	}
	public List<TractorInfoRegisterYear> getRegisterYear(){
		return tractorInfoDao.getRegisterYear();
	}
	public boolean isExitsTractorInfoByCode(String lincse,String regionId){
		return tractorInfoDao.isExitsTractorInfoByCode(lincse, regionId);
	}
}
