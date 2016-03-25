package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.CarTransferDao;
import Ynzc.YnzcAms.Model.CarTransfer;
import Ynzc.YnzcAms.Model.CarTransferView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationAndTurnInSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorTransferApplicationSource;
import Ynzc.YnzcAms.Service.CarTransferService;

public class CarTransferServiceImpl implements CarTransferService {

	private CarTransferDao carTransferDao;

	public CarTransferDao getCarTransferDao() {
		return carTransferDao;
	}

	public void setCarTransferDao(CarTransferDao carTransferDao) {
		this.carTransferDao = carTransferDao;
	}

	public CarTransfer findCarTransferById(int id) {
		return this.carTransferDao.findModelById(id);
	}

	public boolean addCarTransfer(CarTransfer model) {
		return this.carTransferDao.addModel(model);
	}

	public boolean delCarTransfer(CarTransfer model) {
		return this.carTransferDao.delModel(model);
	}

	public boolean updateCarTransfer(CarTransfer model) {
		return this.carTransferDao.updateModel(model);
	}

	public List<CarTransferView> getCarTransferViewList(Page page,
			String conditions,String regionId) {
		return this.carTransferDao.getCarTransferViewList(page, conditions,
				regionId);
	}

	/**
	 * 根据ID批量删除转移信息
	 * 
	 * @author kw
	 * @date 2011-05-17
	 **/
	public boolean delCarTransferByIds(String ids) {
		return this.carTransferDao.delCarTransferByIds(ids);
	}

	/**
	 * 根据ID批量更新转移信息状态为指定状态
	 * 
	 * @author kw
	 * @date 2011-05-17
	 **/
	public boolean updateCarTransferStateByIds(int state, String ids) {
		return this.carTransferDao.updateCarTransferStateByIds(state, ids);
	}

	public boolean auditCarTransfer(int state, String checkuser,
			String checkip, String checkcontext, String oldlicense,String ids) {
		return this.carTransferDao.auditCarTransfer(state, checkuser, checkip,
				checkcontext, oldlicense,ids);
	}
	/**
	 * 根据拖拉机ID查询是否有正在处理的业务
	 * 
	 * @author kw
	 * @date 2011-05-26
	 **/
	public List<CarTransfer> findCarTransferingByTractorinfoId(String tractorids){
		return this.carTransferDao.findCarTransferingByTractorinfoId(tractorids);
	}
	public CarTransfer findModelById(int id) {
		// TODO Auto-generated method stub
		return this.carTransferDao.findModelById(id);
	}

	public boolean addModel(CarTransfer model) {
		// TODO Auto-generated method stub
		return this.carTransferDao.addModel(model);
	}

	public boolean delModel(CarTransfer model) {
		// TODO Auto-generated method stub
		return this.carTransferDao.delModel(model);
	}

	public boolean updateModel(CarTransfer model) {
		// TODO Auto-generated method stub
		return this.carTransferDao.updateModel(model);
	}
	public List<CarTransferView> getOutCarTransferViewList(Page page,String conditions,String regionId){
		return this.carTransferDao.getOutCarTransferViewList(page, conditions, regionId);
	}
	public List<CarTransferView> getIntoCarTransferViewList(Page page,String conditions,String regionId){
		return this.carTransferDao.getIntoCarTransferViewList(page, conditions, regionId);
	}
	public List<CarTransferView> getCarTransferViewListByIds(String ids){
		return this.carTransferDao.getCarTransferViewListByIds(ids);
	}
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		return carTransferDao.recordReport(id);
	}
	public List<TractorRegistrationAndTurnInSource> tractorInfoTurnInReport(int tractorinfoid){
		return carTransferDao.tractorInfoTurnInReport(tractorinfoid);
	}

	public List<CarTransferView> getFilingList(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		return this.carTransferDao.getFilingList(page, conditions, regionid);
	}

	public List<CarTransferView> getFilingListQuery(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		return this.carTransferDao.getFilingListQuery(page, conditions, regionid);
	}
	public List<TractorTransferApplicationSource> PrintCarTransferReport(int id){
		return this.carTransferDao.PrintCarTransferReport(id);
	}
}
