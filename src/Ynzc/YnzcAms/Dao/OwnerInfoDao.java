package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.OwnerInfo;

public interface OwnerInfoDao {
	public List<OwnerInfo> getAllOwnerInfoList(Page page,String conditions);
	public OwnerInfo findOwnerInfoById(int id);
	public boolean addOwnerInfo(OwnerInfo model);
	public boolean delOwnerInfo(OwnerInfo model);
	public boolean updateOwnerInfo(OwnerInfo model);	
	public OwnerInfo findOwnerInfoByWhere(String where); 
	public boolean delOwnerInfoByIds(String ids);
}
