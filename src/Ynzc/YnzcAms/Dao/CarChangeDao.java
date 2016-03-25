package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.*;

public interface CarChangeDao {
	public List<CarChange> getAllModelList(Page page,String conditions);
	public List<CarChange> getAllModelList();
	public CarChange findModelById(int id);
	public boolean addModel(CarChange model);
	public boolean delModel(CarChange model);
	public boolean updateModel(CarChange model);
	public List<CarChangeView> getCarChangeViewList(Page page,String conditions,int userid);
	public List<CarChangeView> getCarChangeViewList(Page page,String conditions,String regionid);
	public List<CarChange> findCarChangeingByTractorinfoId(String tractorids);
	public boolean delCarChangeByIds(String ids);
	public boolean updateCarChangeByIds(String ids);
	public List<CarChangeView> getCarChangeViewListByIds(String ids);
	public List<CarChangeView> getFilingList(Page page,String changeType,String conditions, String regionid);
	public List<CarChangeView> getFilingListQuery(Page page,String changeType,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<TractorAlterApplicationSource> PrintCarChangeReport(int id);
}
