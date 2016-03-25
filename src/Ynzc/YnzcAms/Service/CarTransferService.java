package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.CarTransfer;
import Ynzc.YnzcAms.Model.CarTransferView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationAndTurnInSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorTransferApplicationSource;

public interface CarTransferService {

	public CarTransfer findModelById(int id);
	public boolean addCarTransfer(CarTransfer model);
	public boolean delModel(CarTransfer model);
	public boolean updateCarTransfer(CarTransfer model);	
	public List<CarTransferView> getCarTransferViewList(Page page,String conditions,String regionId);
	public boolean delCarTransferByIds(String ids);
	public boolean updateCarTransferStateByIds(int state,String ids);
	public List<CarTransfer> findCarTransferingByTractorinfoId(String tractorids);
	public boolean auditCarTransfer(int state,String checkuser,String checkip,String checkcontext,String oldlicense,String ids);
	public List<CarTransferView> getFilingList(Page page,String conditions, String regionid);
	public List<CarTransferView> getFilingListQuery(Page page,String conditions, String regionid);
	public List<CarTransferView> getOutCarTransferViewList(Page page,String conditions,String regionId);
	public List<CarTransferView> getIntoCarTransferViewList(Page page,String conditions,String regionId);
	public List<CarTransferView> getCarTransferViewListByIds(String ids);
	public List<TractorRegistrationRecordProcessSource> recordReport(int id);
	public List<TractorRegistrationAndTurnInSource> tractorInfoTurnInReport(int tractorinfoid);
	public List<TractorTransferApplicationSource> PrintCarTransferReport(int id);
}
