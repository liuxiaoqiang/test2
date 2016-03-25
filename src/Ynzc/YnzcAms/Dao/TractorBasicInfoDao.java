package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorBasicInfo;

public interface TractorBasicInfoDao {
	public List<TractorBasicInfo> getAllTractorBasicInfoList(Page page,String conditions);
	public TractorBasicInfo findTractorBasicInfoById(int id);
	public boolean addTractorBasicInfo(TractorBasicInfo model);
	public boolean delTractorBasicInfo(TractorBasicInfo model);
	public boolean updateTractorBasicInfo(TractorBasicInfo model);	
	public TractorBasicInfo findTractorBasicInfoByWhere(String where);
	public boolean delTractorBasicInfoByIds(String ids);
}
