package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.NewReaperPlate;
import Ynzc.YnzcAms.Model.Page;

public interface NewReaperPlateDao {

	public List<NewReaperPlate> getAllNewPlate(Page page,int psid,String conditions,int type);
	public List<NewReaperPlate> getAllNewPlateHandle(Page page, int psid,String conditions);
	public List<NewReaperPlate> getAllMadePlate(Page page,int psid,String conditions);
	public boolean addAPlate(NewReaperPlate np);
	public boolean delAPlate(NewReaperPlate np);
	public boolean addPlateBat(int start,int end,String platenumhead,int psid);
	public boolean delAllPlate(int psid);
	public boolean updateNewPlate(NewReaperPlate np);
	public boolean flagAll(int psid);
	public boolean allotAll(int psid);
	public  boolean laidAll(int psid);
	public List<NewReaperPlate> getAllNewPlateInfo(int psid);
}
