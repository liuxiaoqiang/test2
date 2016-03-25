package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.TempliveFileDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TempliveFile;
import Ynzc.YnzcAms.Service.TempliveFileService;

public class TempliveFileServiceImpl implements TempliveFileService {

	private TempliveFileDao templiveFileDao;

	public TempliveFileDao getTempliveFileDao() {
		return templiveFileDao;
	}

	public void setTempliveFileDao(TempliveFileDao templiveFileDao) {
		this.templiveFileDao = templiveFileDao;
	}

	public List<TempliveFile> getAllTempliveFileList(Page page,
			String conditions) {
		return this.templiveFileDao.getAllTempliveFileList(page, conditions);
	}

	public List<TempliveFile> getAllTempliveFileList() {
		return this.templiveFileDao.getAllModelList();
	}

	public TempliveFile findTempliveFileById(int id) {
		return this.templiveFileDao.findTempliveFileById(id);
	}

	public boolean addTempliveFile(TempliveFile model) {
		return this.templiveFileDao.addTempliveFile(model);
	}

	public boolean delTempliveFile(TempliveFile model) {
		return this.templiveFileDao.delTempliveFile(model);
	}

	public boolean updateTempliveFile(TempliveFile model) {
		return this.templiveFileDao.updateTempliveFile(model);
	}
}
