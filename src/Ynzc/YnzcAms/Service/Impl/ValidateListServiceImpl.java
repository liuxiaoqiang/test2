package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ValidateListDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ValidateList;
import Ynzc.YnzcAms.Model.ValidateListReportSource;
import Ynzc.YnzcAms.Service.ValidateListService;

public class ValidateListServiceImpl implements ValidateListService {
	private ValidateListDao validateListDao;

	public ValidateListDao getValidateListDao() {
		return validateListDao;
	}

	public void setValidateListDao(ValidateListDao validateListDao) {
		this.validateListDao = validateListDao;
	}

	/**
	 * 添加验证目录
	 * 
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean addValidateList(ValidateList model) {
		// TODO Auto-generated method stub
		return validateListDao.addValidateList(model);
	}

	/**
	 * 删除验证目录
	 * 
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean delValidateList(ValidateList model) {
		// TODO Auto-generated method stub
		return validateListDao.delValidateList(model);
	}

	/**
	 * 查找验证目录
	 * 
	 * @author zy
	 * @date 2011-04-18
	 **/
	public ValidateList findValidateListById(int id) {
		// TODO Auto-generated method stub
		return validateListDao.findValidateListById(id);
	}

	/**
	 * 获得验证目录
	 * 
	 * @author zy
	 * @date 2011-04-18
	 **/
	public List<ValidateList> getAllModelList() {
		// TODO Auto-generated method stub
		return validateListDao.getAllModelList();
	}

	/**
	 * 分页获得验证目录
	 * 
	 * @author zy
	 * @date 2011-04-18
	 **/
	public List<ValidateList> getAllValidateList(Page page, String conditions) {
		// TODO Auto-generated method stub
		return validateListDao.getAllValidateList(page, conditions);
	}

	/**
	 * 更改验证目录
	 * 
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean updateValidateList(ValidateList model) {
		// TODO Auto-generated method stub
		return validateListDao.updateValidateList(model);
	}

	/**
	 * 验证目录序号验证
	 * 
	 * @author zy
	 * @date 2011-04-18
	 **/
	public ValidateList findValidateListByDirNo(String dirNo) {
		// TODO Auto-generated method stub
		return validateListDao.findValidateListByDirNo(dirNo);
	}

	public List<ValidateListReportSource> getVList() {
		// TODO Auto-generated method stub
		return validateListDao.getVList();
	}
}
