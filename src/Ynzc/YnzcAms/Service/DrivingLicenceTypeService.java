package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.DrivingLicenceRepair;
import Ynzc.YnzcAms.Model.DrivingLicenceRepairView;
import Ynzc.YnzcAms.Model.DrivingLicenceType;
import Ynzc.YnzcAms.Model.Page;

public interface DrivingLicenceTypeService {
	/**
	 * 分页获得驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceType> getAllDrivingLicenceType(Page page,String conditions);
	/**
	 * 获得驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceType> getAllDrivingLicenceType();
	/**
	 * 查找驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceType findDrivingLicenceTypeById(int id);
	/**
	 * 添加驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceType(DrivingLicenceType model);
	/**
	 * 删除驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceType(DrivingLicenceType model);
	/**
	 * 更改驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceType(DrivingLicenceType model);
	
}
