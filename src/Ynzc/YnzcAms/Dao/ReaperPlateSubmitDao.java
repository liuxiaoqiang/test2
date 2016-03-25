package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ReaperPlateSubmit;

public interface ReaperPlateSubmitDao {

	public List<ReaperPlateSubmit> getAllSubmit(Page page,int unitid);
	public boolean addNewSubmit(ReaperPlateSubmit ps);
	public boolean delSubmit(ReaperPlateSubmit ps);
	public boolean updateSubmit(ReaperPlateSubmit ps);
	public List<ReaperPlateSubmit> getAllSubmitWaitMade(Page page);
	public boolean laidAll(ReaperPlateSubmit ps);
	public ReaperPlateSubmit findPlateSubmit(int status,int unitid);
}