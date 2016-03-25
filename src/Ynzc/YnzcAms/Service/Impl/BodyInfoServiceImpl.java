package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.BodyInfoDao;
import Ynzc.YnzcAms.Model.BodyInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleBodyInfoReportSource;
import Ynzc.YnzcAms.Model.PeopleBodyReportSource;
import Ynzc.YnzcAms.Model.PeopleBodyView;
import Ynzc.YnzcAms.Service.BodyInfoService;

public class BodyInfoServiceImpl implements BodyInfoService {
	private BodyInfoDao BodyInfoDao;
	public BodyInfoDao getBodyInfoDao() {
		return BodyInfoDao;
	}
	public void setBodyInfoDao(BodyInfoDao bodyInfoDao) {
		BodyInfoDao = bodyInfoDao;
	}
	public List<PeopleBodyView> getAllBodyInfo(Page page,String conditions,int userId){
		return BodyInfoDao.getAllBodyInfo(page, conditions,userId);
	}
	/**
	 * 获得身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<BodyInfo> getAllBodyInfo(){
		return BodyInfoDao.getAllBodyInfo();
	}
	/**
	 * 查找身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public BodyInfo findBodyInfoById(int id){
		return BodyInfoDao.findBodyInfoById(id);
	}
	/**
	 * 添加身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addBodyInfo(BodyInfo model){
		return BodyInfoDao.addBodyInfo(model);
	}
	/**
	 * 删除身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delBodyInfo(BodyInfo model){
		return BodyInfoDao.delBodyInfo(model);
	}
	/**
	 * 更改身体状况信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateBodyInfo(BodyInfo model){
		return BodyInfoDao.updateBodyInfo(model);
	}
	/**
	 * 查找用户健康信息
	 * @author zy
	 * @date 2011-04-28
	 **/
	public BodyInfo findBodyInfoByPeopleInfoId(int peopleInfoId){
		return BodyInfoDao.findBodyInfoByPeopleInfoId(peopleInfoId);
	}
	/**
	 * 删除身体状况信息
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delMoreBodyInfo(String str){
		return BodyInfoDao.delMoreBodyInfo(str);
	}
	/**
	 * 删除检查
	 * @author zy
	 * @date 2011-05-04
	 **/
	public boolean delBodyCheck(int id){
		return BodyInfoDao.delBodyCheck(id);
	}
	
	public List<PeopleBodyReportSource> getAllBodyInfo(int id) {
		// TODO Auto-generated method stub
		return BodyInfoDao.getAllBodyInfo(id);
	}
	public List<PeopleBodyInfoReportSource> getBodyInfo(int id) {
		// TODO Auto-generated method stub
		return BodyInfoDao.getBodyInfo(id);
	}
}
