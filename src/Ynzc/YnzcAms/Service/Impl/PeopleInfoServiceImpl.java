package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.PeopleInfoDao;
import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleBodyView;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.PeopleReportSource;
import Ynzc.YnzcAms.Service.PeopleInfoService;

public class PeopleInfoServiceImpl implements PeopleInfoService {
	private PeopleInfoDao peopleInfoDao;
	public PeopleInfoDao getPeopleInfoDao() {
		return peopleInfoDao;
	}
	public void setPeopleInfoDao(PeopleInfoDao peopleInfoDao) {
		this.peopleInfoDao = peopleInfoDao;
	}
	/**
	 * 分页获得人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PeopleInfo> getAllPeopleInfo(Page page,String conditions,int userId){
		return peopleInfoDao.getAllPeopleInfo(page, conditions,userId);
	}
	/**
	 * 获得人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PeopleInfo> getAllPeopleInfo(){
		return peopleInfoDao.getAllPeopleInfo();
	}
	/**
	 * 查找人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public PeopleInfo findPeopleInfoById(int id){
		return peopleInfoDao.findPeopleInfoById(id);
	}
	/**
	 * 添加人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addPeopleInfo(PeopleInfo model){
		return peopleInfoDao.addPeopleInfo(model);
	}
	/**
	 * 删除人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delPeopleInfo(PeopleInfo model){
		return peopleInfoDao.delPeopleInfo(model);
	}
	/**
	 * 更改人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updatePeopleInfo(PeopleInfo model){
		return peopleInfoDao.updatePeopleInfo(model);
	}
	/**
	 * 查找身份证重复
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean findPeopleInfoByIdCard(String idCard){
		return peopleInfoDao.findPeopleInfoByIdCard(idCard);
	}
	/**
	 * 分页获得人员信息
	 * @author zy
	 * @date 2011-04-29
	 **/
	public List<PeopleInfo> getAllPeopleInfoToSelect(Page page,String conditions,int userId){
		return peopleInfoDao.getAllPeopleInfoToSelect(page, conditions,userId);
	}
	/**
	 * 分页获得人员信息
	 * @author zy
	 * @date 2011-04-29
	 **/
	public List<DriverStrInfoView> getAllDriverStrInfoToSelect(Page page,String conditions,int userId){
		return peopleInfoDao.getAllDriverStrInfoToSelect(page, conditions,userId);
	}
	/**
	 * 查找人员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public PeopleBodyView findDriverStrInfoByPeopleId(int id){
		return peopleInfoDao.findDriverStrInfoByPeopleId(id);
	}
	/**
	 * 删除检查
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delUpdatePeopleCheck(int id){
		return peopleInfoDao.delUpdatePeopleCheck(id);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delPeopleInfo(String ids){
		return peopleInfoDao.delPeopleInfo(ids);
	}
	
	public boolean findPeopleInfoByIdStay(String idStay) {
		// TODO Auto-generated method stub
		return peopleInfoDao.findPeopleInfoByIdStay(idStay);
	}
	
	public List<PeopleReportSource> findPeopleinfo(int id) {
		// TODO Auto-generated method stub
		return peopleInfoDao.findPeopleinfo(id);
	}
	public List<PeopleReportSource> findOperationPeopleinfo(int id) {
		// TODO Auto-generated method stub
		return peopleInfoDao.findOperationPeopleinfo(id);
	}
}
