package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ReaperPlate;
import Ynzc.YnzcAms.Model.ReaperPlateViewData;

public interface ReaperPlateService {
	public boolean isExist(String platenum,String platehead);
	public boolean InputLib(int unitid,int psid,String submitman);
	public List<ReaperPlateViewData> getPlateLibList(Page page,String conditions,int userid,int plateStatus);
	public boolean updatePlate(String platenum, String platehead);
	public List<ReaperPlateViewData> getPlateLibList(Page page, String conditions,int untilid,String mark);
	public boolean updatePlateInfo(ReaperPlate plate);
	public boolean updatePlateBatch(String numberStr, String platehead,int unitid);
	public String getMinPlateCode(int unitid);
	public List<ReaperPlate> getPlateChangeList(int userid,int type);
	public boolean delPlate(ReaperPlate plate);
	public ReaperPlate getLowNum(int userid);//wyb   2011-06-22
	public boolean updateState(String num,String plateCode,int state);//wyb   2011-06-23
}
