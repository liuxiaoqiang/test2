package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DriverClassTeamDao;
import Ynzc.YnzcAms.Model.DriverClassTeam;
import Ynzc.YnzcAms.Model.DrivingSkillExamProveSource;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DriverClassTeamService;

public class DriverClassTeamServiceImpl implements DriverClassTeamService {
	private DriverClassTeamDao driverClassTeamDao;
	public DriverClassTeamDao getDriverClassTeamDao() {
		return driverClassTeamDao;
	}
	public void setDriverClassTeamDao(DriverClassTeamDao driverClassTeamDao) {
		this.driverClassTeamDao = driverClassTeamDao;
	}
	/**
	 * 分页获得班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassTeam> getAllDriverClassTeam(Page page,String conditions){
		return driverClassTeamDao.getAllDriverClassTeam(page, conditions);
	}
	/**
	 * 获得验证班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassTeam> getAllDriverClassTeam(){
		return driverClassTeamDao.getAllDriverClassTeam();
	}
	/**
	 * 分页获得班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public String getAllDriverStr(String driverClassId){
		return driverClassTeamDao.getAllDriverStr(driverClassId);
	}
	/**
	 * 查找班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverClassTeam findDriverClassTeamById(int id){
		return driverClassTeamDao.findDriverClassTeamById(id);
	}
	/**
	 * 添加班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDriverClassTeam(DriverClassTeam model){
		return driverClassTeamDao.addDriverClassTeam(model);
	}
	/**
	 * 删除班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverClassTeam(DriverClassTeam model){
		return driverClassTeamDao.delDriverClassTeam(model);
	}
	/**
	 * 更改班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverClassTeam(DriverClassTeam model){
		return driverClassTeamDao.updateDriverClassTeam(model);
	}
	/**
	 * 删除班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverClassTeam(int driverClassId,int driverStrInfoId){
		return driverClassTeamDao.delDriverClassTeam(driverClassId,driverStrInfoId);
	}
	/**
	 * 批量更改学员状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverStrState(int type,int strState,String driverStrInfoId){
		return driverClassTeamDao.updateDriverStrState(type,strState,driverStrInfoId);
	}
	/**
	 * 准考证发放
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean putOutPermit(int driverClassId,String driverStrId,int type){
		return driverClassTeamDao.putOutPermit(driverClassId, driverStrId,type);
	}
	public boolean putOutPermit(int driverClassId) {
		// TODO Auto-generated method stub
		return driverClassTeamDao.putOutPermit(driverClassId);
	}
	public boolean putOutUnPermit(int driverClassId, String driverStrId,
			int type) {
		// TODO Auto-generated method stub
		return driverClassTeamDao.putOutUnPermit(driverClassId, driverStrId,type);
	}
	public List<DrivingSkillExamProveSource> getStrAllowCertificateInfo(int id,int classInfoId) {
		// TODO Auto-generated method stub
		return driverClassTeamDao.getStrAllowCertificateInfo(id,classInfoId);
	}
}
