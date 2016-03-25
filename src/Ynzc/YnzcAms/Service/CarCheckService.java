package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.CarCheck;
import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;

public interface CarCheckService {
	public List<CarCheck> getAllModelList(Page page,String conditions);
	public List<CarCheck> getAllModelList();
	public CarCheck findModelById(int id);
	public boolean addCarCheck(CarCheck model);
	public boolean delModel(CarCheck model);
	public boolean updateCarCheck(CarCheck model);
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
