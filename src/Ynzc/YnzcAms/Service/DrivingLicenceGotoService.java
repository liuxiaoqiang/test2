package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.DrivingLicenceGoto;
import Ynzc.YnzcAms.Model.DrivingLicenceGotoView;
import Ynzc.YnzcAms.Model.Page;

public interface DrivingLicenceGotoService {
	/**
	 * 分页获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceGotoView> getAllDrivingLicenceGoto(Page page,String conditions,String regionId);
	
	public List<DrivingLicenceGotoView> getAllDrivingLicenceGotoQuery(Page page,String conditions,String regionId);
	/**
	 * 获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceGoto> getAllDrivingLicenceGoto();
	/**
	 * 查找驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceGoto findDrivingLicenceGotoById(int id);
	/**
	 * 查找驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceGotoView> findDrivingLicenceGotoViewById(int id);
	/**
	 * 添加驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceGoto(DrivingLicenceGoto model);
	/**
	 * 删除驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceGoto(DrivingLicenceGoto model);
	/**
	 * 更改驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceGoto(DrivingLicenceGoto model);
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceGotoState(String ids,int state);
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceGoto(String ids);
}
