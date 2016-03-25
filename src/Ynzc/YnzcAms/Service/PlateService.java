package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Plate;
import Ynzc.YnzcAms.Model.PlateViewData;

public interface PlateService {	
	public boolean InputLib(int unitid,int psid,String submitman);
	public List<Plate> getPlateLibList(Page page,String conditions,int userid,int plateStatus);
	public boolean updatePlate(String platenum, String platehead);
	public List<Plate> getPlateLibList(Page page, String conditions,String regionid,String mark);
	public boolean updatePlateBatch(String numberStr, String platehead,int unitid);
	public String getMinPlateCode(String regionId);
	public boolean UpdatePlateCodeStateByCode(int state,String platecodes);
	public boolean UpdatePlateCodeStateByCodeAndHead(int state,String platecode);
	public boolean delPlate(Plate plate);
	public boolean updatePlateStatus(String platenum, String platehead,String regionId, int status);
	
	public boolean isExist(String platenum,String platehead);
	public Plate getPlate(String platenum,String platehead);
	public List<Plate> getPlateChangeList(Page page, String conditions,String regionId,int type);
	public List<Plate> getPlateByPid(Page page,String pid,String conditions);
	public boolean addPlate(Plate plate);
	public boolean updatePlateInfo(Plate plate);
	public boolean addPlateBat(int start,int end,String platenumhead,String regionId,String pid,int status);
	public List<Plate> getPlateDoList(int type);
	public List<Plate> getPlateDoList(String pid);
	public int getPlateNum(String platehead,int status);
	public int getPlateNumByRegion(String regionId,int status);
	public List<Plate> getPlateList(Page pate,String start,String end,String regionid);
}
