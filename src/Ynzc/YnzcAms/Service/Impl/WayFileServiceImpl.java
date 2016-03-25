package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.WayFileDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.WayFile;
import Ynzc.YnzcAms.Service.WayFileService;

public class WayFileServiceImpl implements WayFileService {

	private WayFileDao wayFileDao;

	public WayFileDao getWayFileDao() {
		return wayFileDao;
	}

	public void setWayFileDao(WayFileDao wayFileDao) {
		this.wayFileDao = wayFileDao;
	}

	public List<WayFile> getAllWayFileList(Page page, String conditions) {
		return this.wayFileDao.getAllWayFileList(page, conditions);
	}

	public List<WayFile> getAllWayFileList() {
		return this.wayFileDao.getAllModelList();
	}

	public WayFile findWayFileById(int id) {
		return this.wayFileDao.findWayFileById(id);
	}

	public boolean addWayFile(WayFile model) {
		return this.wayFileDao.addWayFile(model);
	}

	public boolean delWayFile(WayFile model) {
		return this.wayFileDao.delWayFile(model);
	}

	public boolean updateWayFile(WayFile model) {
		return this.wayFileDao.updateWayFile(model);
	}
}
