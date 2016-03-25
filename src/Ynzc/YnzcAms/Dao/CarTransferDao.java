package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.*;

public interface CarTransferDao {
	public CarTransfer findModelById(int id);
	public boolean addModel(CarTransfer model);
	public boolean delModel(CarTransfer model);
	public boolean updateModel(CarTransfer model);	
	public List<CarTransferView> getCarTransferViewList(Page page,String conditions,String regionId);
	public List<CarTransferView> getOutCarTransferViewList(Page page,String conditions,String regionId);
	public List<CarTransferView> getIntoCarTransferViewList(Page page,String conditions,String regionId);
	public boolean delCarTransferByIds(String ids);
	public boolean updateCarTransferStateByIds(int state,String ids);
	public boolean auditCarTransfer(int state,String checkuser,String checkip,String checkcontext,String oldlicense,String ids);
	public List<CarTransfer> findCarTransferingByTractorinfoId(String tractorids);
	public List<CarTransferView> getFilingList(Page page,String conditions, String regionid);
	public List<CarTransferView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<CarTransferView> getCarTransferViewListByIds(String ids);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<TractorRegistrationAndTurnInSource> tractorInfoTurnInReport(int tractorinfoid);
	public List<TractorTransferApplicationSource> PrintCarTransferReport(int id);
}
