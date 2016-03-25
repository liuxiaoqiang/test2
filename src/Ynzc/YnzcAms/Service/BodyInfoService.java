package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.BodyInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleBodyInfoReportSource;
import Ynzc.YnzcAms.Model.PeopleBodyReportSource;
import Ynzc.YnzcAms.Model.PeopleBodyView;

public interface BodyInfoService {
	/**
	 * 分页获得身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PeopleBodyView> getAllBodyInfo(Page page,String conditions,int userId);
	/**
	 * 获得身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<BodyInfo> getAllBodyInfo();
	/**
	 * 查找身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public BodyInfo findBodyInfoById(int id);
	/**
	 * 添加身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addBodyInfo(BodyInfo model);
	/**
	 * 删除身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delBodyInfo(BodyInfo model);
	/**
	 * 更改身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateBodyInfo(BodyInfo model);
	/**
	 * 查找用户健康信息
	 * @author zy
	 * @date 2011-04-28
	 **/
	public BodyInfo findBodyInfoByPeopleInfoId(int peopleInfoId);
	/**
	 * 删除身体状况信息
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delMoreBodyInfo(String str);
	/**
	 * 删除检查
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delBodyCheck(int id);
	
	public List<PeopleBodyReportSource> getAllBodyInfo(int id);
	
	public List<PeopleBodyInfoReportSource> getBodyInfo(int id);
}
