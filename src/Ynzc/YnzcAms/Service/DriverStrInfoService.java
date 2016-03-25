package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.DriverStrInfo;
import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.DriverStrParticularView;
import Ynzc.YnzcAms.Model.DrivingLicenceFlowReportSource;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorExamScoreTableSource;
import Ynzc.YnzcAms.Model.TractorLicenseProcessSource;

public interface DriverStrInfoService {
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfo(Page page,String conditions,String regionId);
	
	public List<DriverStrInfoView> getAllDriverStrInfoQuery(Page page,String conditions,String regionId);
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrParticularView> getAllDriverStrParticular(Page page,String conditions,String regionId);
	
	public List<DriverStrParticularView> getAllDriverStrParticularQuery(Page page,String conditions,String regionId);
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfoInTeam(Page page,String conditions,int driverClassInfoId,String regionId);
	
	public List<DriverStrInfoView> getAllDriverStrInfoInTeamQuery(Page page,String conditions,int driverClassInfoId,String regionId);
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfoInTeam(int driverClassInfoId,String regionId,String order);
	
	public List<DriverStrInfoView> getAllDriverStrInfoInTeamQuery(int driverClassInfoId,String regionId,String order);
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfoByExaminationPass(Page page,String conditions,int flag,String regionId);
	
	public List<DriverStrInfoView> getAllDriverStrInfoByExaminationPassQuery(Page page,String conditions,int flag,String regionId);
	/**
	 * 获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfo> getAllDriverStrInfo();
	/**
	 * 查找学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverStrInfo findDriverStrInfoById(int id);
	/**
	 * 添加学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDriverStrInfo(DriverStrInfo model);
	/**
	 * 删除学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverStrInfo(DriverStrInfo model);
	/**
	 * 更改学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverStrInfo(DriverStrInfo model);
	/**
	 * 查找学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfo> findDriverStrInfoByPeopleInfoId(int id);
	/**
	 * 删除学员信息
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delDriverStrInfo(String str);
	/**
	 * 删除学员信息
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delDriverClassStrInfo(String str,int driverClassId);
	/**
	 * 批量归档
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean driverClassStrPigeonhole(String driverStrId,int flag);
	/**
	 * 删除学员信息
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delDriverStrCheck(int id);
	/**
	 * 创建报考号、档案号
	 * @author zy
	 * @date 2011-05-04
	 **/
	public String createNo(String idCard,int type,String regionId);
	/**
	 * 查找学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverStrInfo findDriverStrInfo(int peopleInfoId,int drivingLicenceTypeId);
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverStrInfo> getDriverStrInfoInTeam(int driverClassInfoId,String regionId);
	
	public List<DrivingLicenceFlowReportSource> strExam(int driverStrId);
	
	public List<TractorExamScoreTableSource> strExamInfo(int driverStrId);
	
	public List<TractorLicenseProcessSource> tractorLicenseProcess(int driverStrId,int peopleInfoId);
}
