package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.DrivingLicenceReportSource;
import Ynzc.YnzcAms.Model.DrivingLicenceView;
import Ynzc.YnzcAms.Model.Page;

public interface DrivingLicenceService {
	/**
	 * 分页获得驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceView> getAllDrivingLicence(Page page,String conditions,String regionId);
	
	public List<DrivingLicenceView> getAllDrivingLicenceQuery(Page page,String conditions,String regionId);
	/**
	 * 获得驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicence> getAllDrivingLicence();
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicence findDrivingLicenceById(int id);
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceView> findDrivingLicenceViewById(int id);
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
//	public List<DrivingLicenceReportSource> findDrivingLicenceViewPutOut(int id);
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean findDrivingLicenceById(int peopleInfoId,int drivingLicenceType,String drivingLicenceNo);
	/**
	 * 添加驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicence(DrivingLicence model);
	/**
	 * 删除驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicence(DrivingLicence model);
	/**
	 * 更改驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicence(DrivingLicence model);
	/**
	 * 批量打印
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicencePutOut(String id);
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicence findDrivingLicenceByDrivingLicenceNo(String drivingLicenceNo);
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicence(String ids);
	/**
	 * 业务办理检查
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean checkDrivingLicenceOperation(String id);
	/**
	 * 驾照打印
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceReportSource> drivingLicenceReportSource(String id,String peopleInfoId,String drivingLicenceTypeId,int type);
	
	public boolean Expirydate();
}
