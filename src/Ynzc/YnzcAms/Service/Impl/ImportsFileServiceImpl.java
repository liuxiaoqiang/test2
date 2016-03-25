package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ImportsFileDao;
import Ynzc.YnzcAms.Model.ImportsFile;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.ImportsFileService;

public class ImportsFileServiceImpl implements ImportsFileService {

	private ImportsFileDao importsFileDao;

	public ImportsFileDao getImportsFileDao() {
		return importsFileDao;
	}

	public void setImportsFileDao(ImportsFileDao importsFileDao) {
		this.importsFileDao = importsFileDao;
	}

	public List<ImportsFile> getAllImportsFileList(Page page, String conditions) {
		return this.importsFileDao.getAllImportsFileList(page, conditions);
	}

	public List<ImportsFile> getAllImportsFileList() {
		return this.importsFileDao.getAllModelList();
	}

	public ImportsFile findImportsFileById(int id) {
		return this.importsFileDao.findImportsFileById(id);
	}

	public boolean addImportsFile(ImportsFile model) {
		return this.importsFileDao.addImportsFile(model);
	}

	public boolean delImportsFile(ImportsFile model) {
		return this.importsFileDao.delImportsFile(model);
	}

	public boolean updateImportsFile(ImportsFile model) {
		return this.importsFileDao.updateImportsFile(model);
	}
}
