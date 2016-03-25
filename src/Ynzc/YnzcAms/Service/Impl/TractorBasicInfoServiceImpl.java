package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.TractorBasicInfoDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorBasicInfo;
import Ynzc.YnzcAms.Service.TractorBasicInfoService;

public class TractorBasicInfoServiceImpl implements TractorBasicInfoService {
	private TractorBasicInfoDao tractorBasicInfoDao;

	public TractorBasicInfoDao getTractorBasicInfoDao() {
		return tractorBasicInfoDao;
	}

	public void setTractorBasicInfoDao(TractorBasicInfoDao tractorBasicInfoDao) {
		this.tractorBasicInfoDao = tractorBasicInfoDao;
	}

	public List<TractorBasicInfo> getAllTractorBasicInfoList(Page page,
			String conditions) {
		return this.tractorBasicInfoDao.getAllTractorBasicInfoList(page,
				conditions);
	}

	public TractorBasicInfo findTractorBasicInfoById(int id) {
		return this.tractorBasicInfoDao.findTractorBasicInfoById(id);
	}

	public boolean addTractorBasicInfo(TractorBasicInfo model) {
		return this.tractorBasicInfoDao.addTractorBasicInfo(model);
	}

	public boolean delTractorBasicInfo(TractorBasicInfo model) {
		return this.tractorBasicInfoDao.delTractorBasicInfo(model);
	}

	public boolean updateTractorBasicInfo(TractorBasicInfo model) {
		return this.tractorBasicInfoDao.updateTractorBasicInfo(model);
	}

	public boolean delTractorBasicInfoByIds(String ids) {
		return this.tractorBasicInfoDao.delTractorBasicInfoByIds(ids);
	}
	
	public TractorBasicInfo findTractorBasicInfoByWhere(String where){
		return this.tractorBasicInfoDao.findTractorBasicInfoByWhere(where);
	}
}
