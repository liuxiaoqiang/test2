package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.CarChange;
import Ynzc.YnzcAms.Model.CarChangeView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorAlterApplicationSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;

public interface CarChangeService {
	public List<CarChange> getCarChangeList(Page page,String conditions);
	public List<CarChange> getCarChangeList();
	public CarChange findCarChangeById(int id);
	public boolean addCarChange(CarChange model);
	public boolean delCarChange(CarChange model);
	public boolean updateCarChange(CarChange model);
	public boolean delCarChangeByIds(String ids);
	public List<CarChange> findCarChangeingByTractorinfoId(String tractorids);
	public List<CarChangeView> getCarChangeViewList(Page page,String conditions,int userid);
	public List<CarChangeView> getCarChangeViewList(Page page,String conditions,String regionid);
	public boolean updateCarChangeByIds(String ids);
	public List<CarChangeView> getCarChangeViewListByIds(String ids);
	public List<CarChangeView> getFilingList(Page page,String changeType,String conditions, String regionid);
	public List<CarChangeView> getFilingListQuery(Page page,String changeType,String conditions, String regionid);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<TractorAlterApplicationSource> PrintCarChangeReport(int id);
}
