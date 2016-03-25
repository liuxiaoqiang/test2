package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ChangeColorDao;
import Ynzc.YnzcAms.Model.ChangeColor;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.ChangeColorService;

public class ChangeColorServiceImpl implements ChangeColorService {
	private ChangeColorDao changeColorDao;

	public ChangeColorDao getChangeColorDao() {
		return changeColorDao;
	}

	public void setChangeColorDao(ChangeColorDao changeColorDao) {
		this.changeColorDao = changeColorDao;
	}

	public List<ChangeColor> getChangeColorList(Page page, String conditions) {
		return this.changeColorDao.getAllModelList(page, conditions);
	}

	public List<ChangeColor> getChangeColorList() {
		return this.changeColorDao.getAllModelList();
	}

	public ChangeColor findChangeColorById(int id) {
		return this.changeColorDao.findModelById(id);
	}

	public boolean addChangeColor(ChangeColor model) {
		return this.changeColorDao.addModel(model);
	}

	public boolean delChangeColor(ChangeColor model) {
		return this.changeColorDao.delModel(model);
	}

	public boolean updateChangeColor(ChangeColor model) {
		return this.changeColorDao.updateModel(model);
	}

	public boolean delChangeColorByIds(String ids) {
		return this.changeColorDao.delChangeColorByIds(ids);
	}
}
