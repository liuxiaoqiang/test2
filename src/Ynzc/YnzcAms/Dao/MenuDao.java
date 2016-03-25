package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Menu;

public interface MenuDao {
	
	public List<Menu> getAllModule();
	public List<Menu> getAllRoot();
	public List<Menu> getAllLeaf();
	
}
