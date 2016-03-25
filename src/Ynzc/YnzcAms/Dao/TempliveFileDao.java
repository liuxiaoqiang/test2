package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TempliveFile;

public interface TempliveFileDao {
	public List<TempliveFile> getAllTempliveFileList(Page page,String conditions);
	public List<TempliveFile> getAllModelList();
	public TempliveFile findTempliveFileById(int id);
	public boolean addTempliveFile(TempliveFile model);
	public boolean delTempliveFile(TempliveFile model);
	public boolean updateTempliveFile(TempliveFile model);	
}
