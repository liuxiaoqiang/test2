package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.OwnerInfo;
import Ynzc.YnzcAms.Model.Page;

public interface OwnerInfoService {
	public List<OwnerInfo> getAllOwnerInfoList(Page page,String conditions);
	public OwnerInfo findOwnerInfoById(int id);
	public boolean addOwnerInfo(OwnerInfo model);
	public boolean delOwnerInfo(OwnerInfo model);
	public boolean updateOwnerInfo(OwnerInfo model);
	public boolean delOwnerInfoByIds(String ids);
	public OwnerInfo findOwnerInfoByWhere(String where); 
}
