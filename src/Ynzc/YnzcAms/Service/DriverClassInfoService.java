package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.DriverClassInfo;
import Ynzc.YnzcAms.Model.DriverClassStrView;
import Ynzc.YnzcAms.Model.Page;

public interface DriverClassInfoService {
	/**
	 * 分页获得班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassInfo> getAllDriverClassInfo(Page page,String conditions,String regionId);
	/**
	 * 分页获得班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassInfo> getAllDriverClassInfoPass(Page page,String conditions,String regionId);
	/**
	 * 分页获得班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassStrView> getAllDriverClassInfoByDriverClassId(Page page,String conditions,int driverClassId);
	/**
	 * 获得班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassInfo> getAllDriverClassInfo();
	/**
	 * 查找班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverClassInfo findDriverClassInfoById(int id);
	/**
	 * 查找班级
	 * @author zy
	 * @date 2011-05-05
	 **/
	public DriverClassInfo findDriverClassInfoByName(String name,String regionId);
	/**
	 * 添加班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDriverClassInfo(DriverClassInfo model);
	/**
	 * 删除班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverClassInfo(DriverClassInfo model);
	/**
	 * 更改班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverClassInfo(DriverClassInfo model);
	/**
	 * 班级审核
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean driverClassInfoDeclare(int type,int classState,String driverClassInfoId);
	/**
	 * 班级学员审核check
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean driverClassInfoDeclare(int driverClassInfoId);
	
	public List<DriverClassStrView> getAllDriverClassInfoByDriverClassIdQuery(Page page,
			String conditions, int driverClassId);
}
