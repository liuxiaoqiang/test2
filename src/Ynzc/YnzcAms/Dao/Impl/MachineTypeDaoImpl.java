package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.MachineTypeDao;
import Ynzc.YnzcAms.Model.MachineType;
import Ynzc.YnzcAms.Model.Page;

public class MachineTypeDaoImpl implements MachineTypeDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addMachineType(MachineType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delMachineType(MachineType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public MachineType findMachineTypeById(int id) {
		// TODO Auto-generated method stub
		List<MachineType> res = hibernateTemplate.find("from MachineType where id=" + id);
		if (res.size() > 0) {
			return (MachineType) res.get(0);
		} else {
			return null;
		}
	}

	public List<MachineType> getMachineTypeList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from MachineType";
			tsql="select count(*) from MachineType";
		}else{
			sql="from MachineType where (" + conditions + ")";
			tsql="select count(*) from MachineType where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<MachineType> res = query.list();
		return res;
	}
	public List<MachineType> getAllModelList() {
		// TODO Auto-generated method stub
		//List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		//return res;
		return this.hibernateTemplate.loadAll(MachineType.class);
	}
	public boolean updateMachineType(MachineType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
