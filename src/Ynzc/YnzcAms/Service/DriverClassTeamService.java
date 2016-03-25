package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.DriverClassTeam;
import Ynzc.YnzcAms.Model.DrivingSkillExamProveSource;
import Ynzc.YnzcAms.Model.Page;

public interface DriverClassTeamService {
	/**
	 * 分页获得班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassTeam> getAllDriverClassTeam(Page page,String conditions);
	/**
	 * 分页获得班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public String getAllDriverStr(String driverClassId);
	/**
	 * 获得验证班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassTeam> getAllDriverClassTeam();
	/**
	 * 查找班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverClassTeam findDriverClassTeamById(int id);
	/**
	 * 添加班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDriverClassTeam(DriverClassTeam model);
	/**
	 * 删除班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverClassTeam(DriverClassTeam model);
	/**
	 * 更改班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverClassTeam(DriverClassTeam model);
	/**
	 * 删除班级组
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverClassTeam(int driverClassId,int driverStrInfoId);
	/**
	 * 批量更改学员状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverStrState(int type,int strState,String driverStrInfoId);
	/**
	 * 准考证发放
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean putOutPermit(int driverClassId,String driverStrId,int type);
	/**
	 * 准考证发放
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean putOutPermit(int driverClassId);
	/**
	 * 准考证发放
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean putOutUnPermit(int driverClassId,String driverStrId,int type);
	
	public List<DrivingSkillExamProveSource> getStrAllowCertificateInfo(int id,int classInfoId);
}
