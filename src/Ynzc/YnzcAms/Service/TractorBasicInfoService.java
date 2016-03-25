package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorBasicInfo;

public interface TractorBasicInfoService {
	public List<TractorBasicInfo> getAllTractorBasicInfoList(Page page,String conditions);
	public TractorBasicInfo findTractorBasicInfoById(int id);
	public boolean addTractorBasicInfo(TractorBasicInfo model);
	public boolean delTractorBasicInfo(TractorBasicInfo model);
	public boolean updateTractorBasicInfo(TractorBasicInfo model);	
	public boolean delTractorBasicInfoByIds(String ids);
	public TractorBasicInfo findTractorBasicInfoByWhere(String where);
}
