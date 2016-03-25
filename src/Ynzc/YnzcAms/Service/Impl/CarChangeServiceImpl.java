package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.CarChangeDao;
import Ynzc.YnzcAms.Model.CarChange;
import Ynzc.YnzcAms.Model.CarChangeView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorAlterApplicationSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Service.CarChangeService;

public class CarChangeServiceImpl implements CarChangeService {
	private CarChangeDao carChangeDao;

	public CarChangeDao getCarChangeDao() {
		return carChangeDao;
	}

	public void setCarChangeDao(CarChangeDao carChangeDao) {
		this.carChangeDao = carChangeDao;
	}

	public List<CarChange> getCarChangeList(Page page, String conditions) {
		return this.carChangeDao.getAllModelList(page, conditions);
	}

	public List<CarChange> getCarChangeList() {
		return this.carChangeDao.getAllModelList();
	}

	public CarChange findCarChangeById(int id) {
		return this.carChangeDao.findModelById(id);
	}

	public boolean addCarChange(CarChange model) {
		return this.carChangeDao.addModel(model);
	}

	public boolean delCarChange(CarChange model) {
		return this.carChangeDao.delModel(model);
	}

	public boolean updateCarChange(CarChange model) {
		return this.carChangeDao.updateModel(model);
	}

	public List<CarChangeView> getCarChangeViewList(Page page,
			String conditions, int userid) {
		return this.carChangeDao.getCarChangeViewList(page, conditions, userid);
	}

	public boolean updateCarChangeByIds(String ids) {
		return this.carChangeDao.updateCarChangeByIds(ids);
	}

	public boolean delCarChangeByIds(String ids) {
		return this.carChangeDao.delCarChangeByIds(ids);
	}

	public List<CarChange> findCarChangeingByTractorinfoId(String tractorids) {
		// TODO Auto-generated method stub
		return this.carChangeDao.findCarChangeingByTractorinfoId(tractorids);
	}
	public List<CarChangeView> getCarChangeViewListByIds(String ids){
		return this.carChangeDao.getCarChangeViewListByIds(ids);
	}

	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		return carChangeDao.recordReport(id);
	}

	public List<CarChangeView> getCarChangeViewList(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return carChangeDao.getCarChangeViewList(page, conditions, regionid);
	}

	public List<CarChangeView> getFilingList(Page page, String changeType,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return carChangeDao.getFilingList(page, changeType,conditions, regionid);
	}

	public List<CarChangeView> getFilingListQuery(Page page, String changeType,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return carChangeDao.getFilingListQuery(page, changeType,conditions, regionid);
	}
	public List<TractorAlterApplicationSource> PrintCarChangeReport(int id){
		return carChangeDao.PrintCarChangeReport(id);
	}
}
