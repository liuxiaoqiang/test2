package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ValidateList;

public interface ValidateListService {
	/**
	 * 分页获得验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public List<ValidateList> getAllValidateList(Page page,String conditions);
	/**
	 * 获得验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public List<ValidateList> getAllModelList();
	/**
	 * 查找验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public ValidateList findValidateListById(int id);
	/**
	 * 添加验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean addValidateList(ValidateList model);
	/**
	 * 删除验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean delValidateList(ValidateList model);
	/**
	 * 更改验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean updateValidateList(ValidateList model);
	/**
	 * 验证目录序号验证
	 * @author zy
	 * @date 2011-04-18
	 **/
	public ValidateList findValidateListByDirNo(String dirNo);
}
