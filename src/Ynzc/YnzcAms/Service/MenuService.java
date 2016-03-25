package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Menu;

public interface MenuService {
	
	//MenuService
	public List<Menu> getAllModule();
	public List<Menu> getAllRoot();
	public List<Menu> getAllLeaf();
	
}
