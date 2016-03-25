package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.HandlingSituation;

public interface HandlingSituationDao {
	public List<HandlingSituation> getAllHandlingSituationList(Page page,String conditions);
	public HandlingSituation findHandlingSituationById(int id);
	public boolean addHandlingSituation(HandlingSituation model);
	public boolean delHandlingSituation(HandlingSituation model);
	public boolean updateHandlingSituation(HandlingSituation model);
	public HandlingSituation GetHandlingSituationByCondition(String where);
	public boolean delHandlingSituationByIds(String ids);
}
