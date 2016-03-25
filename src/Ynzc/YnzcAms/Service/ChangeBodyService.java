package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeBody;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeBodyService {
	public List<ChangeBody> getChangeBodyList(Page page,String conditions);
	public List<ChangeBody> getChangeBodyList();
	public ChangeBody findChangeBodyById(int id);
	public boolean addChangeBody(ChangeBody model);
	public boolean delChangeBody(ChangeBody model);
	public boolean updateChangeBody(ChangeBody model);
	public boolean delChangeBodyByIds(String ids);
}
