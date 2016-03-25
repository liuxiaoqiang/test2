package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.MenuDao;
import Ynzc.YnzcAms.Model.Menu;

public class MenuDaoImpl implements MenuDao {

	private HibernateTemplate hibernateTemplate;
	
	public List<Menu> getAllModule() {
		// TODO Auto-generated method stub
		List<Menu> res=hibernateTemplate.find("from Menu where fatherid=0");
		return res;
	}

	public List<Menu> getAllRoot() {
		// TODO Auto-generated method stub
		List<Menu> res=hibernateTemplate.find("from Menu where fatherid<>0 and isleaf=0");
		return res;
	}
	
	public List<Menu> getAllLeaf() {
		// TODO Auto-generated method stub
		List<Menu> res=hibernateTemplate.find("from Menu where isleaf=1");
		return res;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
