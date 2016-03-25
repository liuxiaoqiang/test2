package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.ImportsFile;
import Ynzc.YnzcAms.Model.Page;

public interface ImportsFileDao {
	public List<ImportsFile> getAllImportsFileList(Page page,String conditions);
	public List<ImportsFile> getAllModelList();
	public ImportsFile findImportsFileById(int id);
	public boolean addImportsFile(ImportsFile model);
	public boolean delImportsFile(ImportsFile model);
	public boolean updateImportsFile(ImportsFile model);	
}
