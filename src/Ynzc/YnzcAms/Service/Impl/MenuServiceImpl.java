package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.MenuDao;
import Ynzc.YnzcAms.Model.Menu;
import Ynzc.YnzcAms.Service.MenuService;

public class MenuServiceImpl implements MenuService{
	
	private MenuDao menuDao;
	
	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List<Menu> getAllModule() {
		// TODO Auto-generated method stub
		return menuDao.getAllModule();
	}

	public List<Menu> getAllRoot() {
		// TODO Auto-generated method stub
		return menuDao.getAllRoot();
	}

	public List<Menu> getAllLeaf() {
		// TODO Auto-generated method stub
		return menuDao.getAllLeaf();
	}
}
