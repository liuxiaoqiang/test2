package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PlateSubmit;

public interface PlateSubmitDao {

	public List<PlateSubmit> getAllSubmit(Page page,int unitid,int status);
	public boolean addNewSubmit(PlateSubmit ps);
	public boolean delSubmit(PlateSubmit ps);
	public boolean updateSubmit(PlateSubmit ps);
	public List<PlateSubmit> getAllSubmitWaitMade(Page page);
	public boolean laidAll(PlateSubmit ps);
	public PlateSubmit findPlateSubmit(int status,int unitid);
	public boolean updateSubmitData(String pid);
	public PlateSubmit findPlateSubmit(int id);
}