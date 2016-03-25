package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.CarCheckDao;
import Ynzc.YnzcAms.Model.CarCheck;
import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Service.CarCheckService;

public class CarCheckServiceImpl implements CarCheckService {
	private CarCheckDao carCheckDao;

	public CarCheckDao getCarCheckDao() {
		return carCheckDao;
	}

	public void setCarCheckDao(CarCheckDao carCheckDao) {
		this.carCheckDao = carCheckDao;
	}

	public List<CarCheck> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		return this.carCheckDao.getAllModelList(page, conditions);
	}

	public List<CarCheck> getAllModelList() {
		// TODO Auto-generated method stub
		return this.carCheckDao.getAllModelList();
	}

	public CarCheck findModelById(int id) {
		// TODO Auto-generated method stub
		return this.carCheckDao.findModelById(id);
	}

	public boolean addCarCheck(CarCheck model) {
		// TODO Auto-generated method stub
		return this.carCheckDao.addModel(model);
	}

	public boolean delModel(CarCheck model) {
		// TODO Auto-generated method stub
		return this.carCheckDao.delModel(model);
	}

	public boolean updateCarCheck(CarCheck model) {
		// TODO Auto-generated method stub
		return this.carCheckDao.updateModel(model);
	}

	public List<CarCheckView> getCarCheckViewList(Page page, String conditions,
			int userid) {
		// TODO Auto-generated method stub
		return this.carCheckDao.getCarCheckViewList(page, conditions, userid);
	}

	public List<CarCheck> findCarCheckingByTractorinfoId(String tractorids) {
		// TODO Auto-generated method stub
		return this.carCheckDao.findCarCheckingByTractorinfoId(tractorids);
	}

	public boolean delCarCheckByIds(String ids) {
		// TODO Auto-generated method stub
		return this.carCheckDao.delCarCheckByIds(ids);
	}

	public boolean updateCarCheckStateByIds(int state, String ids) {
		// TODO Auto-generated method stub
		return this.carCheckDao.updateCarCheckStateByIds(state, ids);
	}

	public boolean auditCarCheck(int state, String checkuser, String checkip,
			String checkcontext, String ids) {
		// TODO Auto-generated method stub
		return this.carCheckDao.auditCarCheck(state, checkuser, checkip, checkcontext, ids);
	}
	public List<CarCheckView> getCarCheckViewListByIds(String ids){
		return this.carCheckDao.getCarCheckViewListByIds(ids);
	}

	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		return carCheckDao.recordReport(id);
	}

	public List<CarCheckView> getCarCheckViewList(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return carCheckDao.getCarCheckViewList(page, conditions, regionid);
	}

	public List<CarCheckView> getFilingList(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return carCheckDao.getFilingList(page, conditions, regionid);
	}

	public List<CarCheckView> getFilingListQuery(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return carCheckDao.getFilingListQuery(page, conditions, regionid);
	}
	
}
