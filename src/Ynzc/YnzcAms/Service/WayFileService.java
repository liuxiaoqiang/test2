package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.WayFile;

public interface WayFileService {
	public List<WayFile> getAllWayFileList(Page page,String conditions);
	public List<WayFile> getAllWayFileList();
	public WayFile findWayFileById(int id);
	public boolean addWayFile(WayFile model);
	public boolean delWayFile(WayFile model);
	public boolean updateWayFile(WayFile model);	
}
