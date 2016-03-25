package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.GetWayDao;
import Ynzc.YnzcAms.Model.GetWay;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.GetWayService;

public class GetWayServiceImpl implements GetWayService {
	
	private GetWayDao getWayDao;
	
	public GetWayDao getGetWayDao() {
		return getWayDao;
	}

	public void setGetWayDao(GetWayDao getWayDao) {
		this.getWayDao = getWayDao;
	}

	public List<GetWay> getAllGetWayList(Page page, String conditions) {
		return this.getWayDao.getAllGetWayList(page, conditions);
	}

	public List<GetWay> getAllGetWayList() {
		return this.getWayDao.getAllModelList();
	}
	public GetWay findGetWayById(int id)
	{
		return this.getWayDao.findGetWayById(id);
	}
	public boolean addGetWay(GetWay model)
	{
		return this.getWayDao.addGetWay(model);
	}
	public boolean delGetWay(GetWay model)
	{
		return this.getWayDao.delGetWay(model);
	}
	public boolean updateGetWay(GetWay model)
	{
		return this.getWayDao.updateGetWay(model);
	}
	
}
