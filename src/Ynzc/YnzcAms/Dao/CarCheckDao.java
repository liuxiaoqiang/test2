package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.*;

public interface CarCheckDao {
	public List<CarCheck> getAllModelList(Page page,String conditions);
	public List<CarCheck> getAllModelList();
	public CarCheck findModelById(int id);
	public boolean addModel(CarCheck model);
	public boolean delModel(CarCheck model);
	public boolean updateModel(CarCheck model);
	public List<CarCheckView> getCarCheckViewList(Page page,String conditions,int userid);
	public List<CarCheckView> getCarCheckViewList(Page page,String conditions,String regionid);
	public List<CarCheck> findCarCheckingByTractorinfoId(String tractorids);
	public boolean delCarCheckByIds(String ids);
	public boolean updateCarCheckStateByIds(int state,String ids);
	public boolean auditCarCheck(int state,String checkuser,String checkip,String checkcontext,String ids);
	public List<CarCheckView> getCarCheckViewListByIds(String ids);
	public List<CarCheckView> getFilingList(Page page,String conditions, String regionid);
	public List<CarCheckView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
}
