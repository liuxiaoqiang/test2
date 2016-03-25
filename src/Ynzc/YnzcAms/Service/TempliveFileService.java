package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TempliveFile;

public interface TempliveFileService {
	public List<TempliveFile> getAllTempliveFileList(Page page,String conditions);
	public List<TempliveFile> getAllTempliveFileList();
	public TempliveFile findTempliveFileById(int id);
	public boolean addTempliveFile(TempliveFile model);
	public boolean delTempliveFile(TempliveFile model);
	public boolean updateTempliveFile(TempliveFile model);	
}
