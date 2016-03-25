package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeOwner;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeOwnerService {
	public List<ChangeOwner> getChangeOwnerList(Page page,String conditions);
	public List<ChangeOwner> getChangeOwnerList();
	public ChangeOwner findChangeOwnerById(int id);
	public boolean addChangeOwner(ChangeOwner model);
	public boolean delChangeOwner(ChangeOwner model);
	public boolean updateChangeOwner(ChangeOwner model);	
	public boolean delChangeOwnerByIds(String ids);
}
