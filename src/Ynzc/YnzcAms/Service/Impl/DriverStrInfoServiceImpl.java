package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DriverStrInfoDao;
import Ynzc.YnzcAms.Model.DriverStrInfo;
import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.DriverStrParticularView;
import Ynzc.YnzcAms.Model.DrivingLicenceFlowReportSource;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorExamScoreTableSource;
import Ynzc.YnzcAms.Model.TractorLicenseProcessSource;
import Ynzc.YnzcAms.Service.DriverStrInfoService;

public class DriverStrInfoServiceImpl implements DriverStrInfoService {
	private DriverStrInfoDao driverStrInfoDao;
	public DriverStrInfoDao getDriverStrInfoDao() {
		return driverStrInfoDao;
	}
	public void setDriverStrInfoDao(DriverStrInfoDao driverStrInfoDao) {
		this.driverStrInfoDao = driverStrInfoDao;
	}
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfo(Page page,String conditions,String regionId){
		return driverStrInfoDao.getAllDriverStrInfo(page, conditions,regionId);
	}
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfoByExaminationPass(Page page,String conditions,int flag,String regionId){
		return driverStrInfoDao.getAllDriverStrInfoByExaminationPass(page, conditions,flag,regionId);
	}
	/**
	 * 获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfo> getAllDriverStrInfo(){
		return driverStrInfoDao.getAllDriverStrInfo();
	}
	/**
	 * 查找学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverStrInfo findDriverStrInfoById(int id){
		return driverStrInfoDao.findDriverStrInfoById(id);
	}
	/**
	 * 添加学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDriverStrInfo(DriverStrInfo model){
		return driverStrInfoDao.addDriverStrInfo(model);
	}
	/**
	 * 删除学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverStrInfo(DriverStrInfo model){
		return driverStrInfoDao.delDriverStrInfo(model);
	}
	/**
	 * 更改学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverStrInfo(DriverStrInfo model){
		return driverStrInfoDao.updateDriverStrInfo(model);
	}
	/**
	 * 查找学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfo> findDriverStrInfoByPeopleInfoId(int id){
		return driverStrInfoDao.findDriverStrInfoByPeopleInfoId(id);
	}
	/**
	 * 删除学员信息
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delDriverStrInfo(String str){
		return driverStrInfoDao.delDriverStrInfo(str);
	}
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfoInTeam(Page page,String conditions,int driverClassInfoId,String regionId){
		return driverStrInfoDao.getAllDriverStrInfoInTeam(page, conditions, driverClassInfoId,regionId);
	}
	/**
	 * 删除学员信息
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delDriverClassStrInfo(String str,int driverClassId){
		return driverStrInfoDao.delDriverClassStrInfo(str, driverClassId);
	}
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrParticularView> getAllDriverStrParticular(Page page,String conditions,String regionId){
		return driverStrInfoDao.getAllDriverStrParticular(page, conditions,regionId);
	}
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfoInTeam(int driverClassInfoId,String regionId,String order){
		return driverStrInfoDao.getAllDriverStrInfoInTeam(driverClassInfoId,regionId,order);
	}
	/**
	 * 批量归档
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean driverClassStrPigeonhole(String driverStrId,int flag){
		return driverStrInfoDao.driverClassStrPigeonhole(driverStrId,flag);
	}
	/**
	 * 删除学员信息
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delDriverStrCheck(int id){
		return driverStrInfoDao.delDriverStrCheck(id);
	}
	
	public String createNo(String idCard, int type,String regionId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.createNo(idCard,type,regionId);
	}
	public DriverStrInfo findDriverStrInfo(int peopleInfoId,
			int drivingLicenceTypeId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.findDriverStrInfo(peopleInfoId, drivingLicenceTypeId);
	}
	public List<DriverStrInfo> getDriverStrInfoInTeam(int driverClassInfoId,
			String regionId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.getDriverStrInfoInTeam(driverClassInfoId, regionId);
	}
	public List<DrivingLicenceFlowReportSource> strExam(int driverStrId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.strExam(driverStrId);
	}
	public List<TractorExamScoreTableSource> strExamInfo(int driverStrId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.strExamInfo(driverStrId);
	}
	public List<TractorLicenseProcessSource> tractorLicenseProcess(
			int driverStrId,int peopleInfoId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.tractorLicenseProcess(driverStrId,peopleInfoId);
	}
	public List<DriverStrInfoView> getAllDriverStrInfoByExaminationPassQuery(
			Page page, String conditions, int flag, String regionId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.getAllDriverStrInfoByExaminationPassQuery(page,conditions,flag,regionId);
	}
	public List<DriverStrInfoView> getAllDriverStrInfoInTeamQuery(Page page,
			String conditions, int driverClassInfoId, String regionId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.getAllDriverStrInfoInTeamQuery(page,conditions,driverClassInfoId,regionId);
	}
	public List<DriverStrInfoView> getAllDriverStrInfoInTeamQuery(
			int driverClassInfoId, String regionId, String order) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.getAllDriverStrInfoInTeamQuery(driverClassInfoId,regionId,order);
	}
	public List<DriverStrInfoView> getAllDriverStrInfoQuery(Page page,
			String conditions, String regionId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.getAllDriverStrInfoQuery(page,conditions,regionId);
	}
	public List<DriverStrParticularView> getAllDriverStrParticularQuery(
			Page page, String conditions, String regionId) {
		// TODO Auto-generated method stub
		return driverStrInfoDao.getAllDriverStrParticularQuery(page,conditions,regionId);
	}
}
