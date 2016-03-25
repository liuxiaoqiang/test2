package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.NewPlate;
import Ynzc.YnzcAms.Model.Page;

public interface NewPlateDao {

	public List<NewPlate> getAllNewPlate(Page page,int psid,String conditions,int type);
	public List<NewPlate> getAllNewPlateHandle(Page page, int psid,String conditions);
	public List<NewPlate> getAllMadePlate(Page page,int psid,String conditions);
	public boolean addAPlate(NewPlate np);
	public boolean delAPlate(NewPlate np);
	public boolean addPlateBat(int start,int end,String platenumhead,int psid,int isaddnew);
	public boolean delAllPlate(int psid);
	public boolean updateNewPlate(NewPlate np);
	public boolean flagAll(int psid);
	public boolean allotAll(int psid);
	public  boolean laidAll(int psid);
	public List<NewPlate> getAllNewPlateInfo(int psid);
}
