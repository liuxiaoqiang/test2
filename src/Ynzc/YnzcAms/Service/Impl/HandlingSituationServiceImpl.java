package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.HandlingSituationDao;
import Ynzc.YnzcAms.Model.HandlingSituation;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.HandlingSituationService;

public class HandlingSituationServiceImpl implements HandlingSituationService {

	private HandlingSituationDao handlingSituationDao;

	public HandlingSituationDao getHandlingSituationDao() {
		return handlingSituationDao;
	}

	public void setHandlingSituationDao(
			HandlingSituationDao handlingSituationDao) {
		this.handlingSituationDao = handlingSituationDao;
	}

	public List<HandlingSituation> getAllHandlingSituationList(Page page,
			String conditions) {
		return this.handlingSituationDao.getAllHandlingSituationList(page,
				conditions);
	}

	public HandlingSituation findHandlingSituationById(int id) {
		return this.handlingSituationDao.findHandlingSituationById(id);
	}

	public boolean addHandlingSituation(HandlingSituation model) {
		return this.handlingSituationDao.addHandlingSituation(model);
	}

	public boolean delHandlingSituation(HandlingSituation model) {
		return this.handlingSituationDao.delHandlingSituation(model);
	}

	public boolean updateHandlingSituation(HandlingSituation model) {
		return this.handlingSituationDao.updateHandlingSituation(model);
	}

	public boolean delHandlingSituationByIds(String ids) {
		return this.handlingSituationDao.delHandlingSituationByIds(ids);
	}

	public HandlingSituation GetHandlingSituationByCondition(String where) {
		return this.handlingSituationDao.GetHandlingSituationByCondition(where);
	}
}
