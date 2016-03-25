package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.DriverMark;
import Ynzc.YnzcAms.Model.Page;

public interface DriverMarkService {
	/**
	 * 分页获得驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverMark> getAllDriverMark(Page page,String conditions,String regionId);
	/**
	 * 获得驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverMark> getAllDriverMark();
	/**
	 * 查找驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverMark findDriverMarkById(int id);
	/**
	 * 添加驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDriverMark(DriverMark model);
	/**
	 * 删除驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverMark(DriverMark model);
	/**
	 * 更改驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverMark(DriverMark model);
}
