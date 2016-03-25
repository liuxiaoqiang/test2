package Ynzc.YnzcAms.Dao;
/**
 * 人员信息Dao
 * @author zy
 * @date 2011-04-26
 * class DriverStrInfoDao.java
 */
import java.util.List;

import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleBodyView;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.PeopleReportSource;

public interface PeopleInfoDao {
	/**
	 * 分页获得人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PeopleInfo> getAllPeopleInfo(Page page,String conditions,int userId);
	/**
	 * 获得人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PeopleInfo> getAllPeopleInfo();
	/**
	 * 查找人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public PeopleInfo findPeopleInfoById(int id);
	/**
	 * 添加人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addPeopleInfo(PeopleInfo model);
	/**
	 * 删除人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delPeopleInfo(PeopleInfo model);
	/**
	 * 更改人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updatePeopleInfo(PeopleInfo model);
	
	/**
	 * 查找身份证重复
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean findPeopleInfoByIdCard(String idCard);
	/**
	 * 查找身份证重复
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean findPeopleInfoByIdStay(String idStay);
	/**
	 * 分页获得人员信息
	 * @author zy
	 * @date 2011-04-29
	 **/
	public List<PeopleInfo> getAllPeopleInfoToSelect(Page page,String conditions,int userId);
	/**
	 * 分页获得人员信息
	 * @author zy
	 * @date 2011-04-29
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfoToSelect(Page page,String conditions,int userId);
	/**
	 * 查找人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public PeopleBodyView findDriverStrInfoByPeopleId(int id);
	/**
	 * 查找人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PeopleReportSource> findPeopleinfo(int id);
	/**
	 * 删除检查
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delUpdatePeopleCheck(int id);
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delPeopleInfo(String ids);
	
	public List<PeopleReportSource> findOperationPeopleinfo(int id);
}
