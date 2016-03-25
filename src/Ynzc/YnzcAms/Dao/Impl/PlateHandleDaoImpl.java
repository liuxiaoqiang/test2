package Ynzc.YnzcAms.Dao.Impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.PlateHandleDao;
import Ynzc.YnzcAms.Model.PlateHandle;

public class PlateHandleDaoImpl implements PlateHandleDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addPlateHandle(PlateHandle platehandle) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(platehandle);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
