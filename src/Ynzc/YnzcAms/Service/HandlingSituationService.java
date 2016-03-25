package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.HandlingSituation;
import Ynzc.YnzcAms.Model.Page;

public interface HandlingSituationService {
	public List<HandlingSituation> getAllHandlingSituationList(Page page,String conditions);
	public HandlingSituation findHandlingSituationById(int id);
	public boolean addHandlingSituation(HandlingSituation model);
	public boolean delHandlingSituation(HandlingSituation model);
	public boolean updateHandlingSituation(HandlingSituation model);
	public boolean delHandlingSituationByIds(String ids);
	public HandlingSituation GetHandlingSituationByCondition(String where);
}
