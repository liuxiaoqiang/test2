package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.CarInfomationSource;
import Ynzc.YnzcAms.Model.CarMoveReportSource;
import Ynzc.YnzcAms.Model.CarSafetyRoportSource;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalDataSource;
import Ynzc.YnzcAms.Model.TractorEnregisterCertificateReportSource;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorInfoRegisterYear;
import Ynzc.YnzcAms.Model.TractorRegistrationAndTurnInSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;

public interface TractorInfoDao {
	public List<TractorInfo> getAllTractorInfoList(Page page,String conditions);
	public TractorInfo findTractorInfoById(int id);
	public boolean addTractorInfo(TractorInfo model);
	public boolean delTractorInfo(TractorInfo model);
	public boolean updateTractorInfo(TractorInfo model);
	public boolean delTractorInfoByIds(String ids);
	public boolean updateTractorStateByIds(int state,String ids,String condtion);
	public boolean auditTractorInfo(int state,String ids);
	public boolean auditTractorInfoFiling(int filing,String ids);
	public boolean updateLicenseById(String license,int id);
	public List<TractorInfo> getTractorInfoListByIds(String ids);
	public boolean GuiDang(String ids,int type);
	public List<CarInfomationSource> tractorInfoReport(int id);
	public List<TractorRegistrationAndTurnInSource> tractorInfoReportTwo(int id);
	public List<TechnicalDataSource> tractorInfoReportThree(int id);
	public List<CarSafetyRoportSource> tractorInfoReportFour(int id); 
	public List<TractorRegistrationRecordProcessSource> tractorInfoReportFive(int id);
	public List<CarMoveReportSource> tractorSteerReport(int id);
	public List<TractorEnregisterCertificateReportSource> TractorEnregisterCertificate(int id);
	public String getRegcerno(String regcerno);
	public List<TractorInfoRegisterYear> getRegisterYear();
	public boolean isExitsTractorInfoByCode(String lincse,String regionId);
}
