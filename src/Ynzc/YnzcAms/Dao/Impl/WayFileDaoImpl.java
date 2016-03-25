package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.WayFileDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.WayFile;

public class WayFileDaoImpl implements WayFileDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addWayFile(WayFile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delWayFile(WayFile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public WayFile findWayFileById(int id) {
		// TODO Auto-generated method stub
		List<WayFile> res = hibernateTemplate.find("from WayFile where id=" + id);
		if (res.size() > 0) {
			return (WayFile) res.get(0);
		} else {
			return null;
		}
	}

	public List<WayFile> getAllWayFileList(Page page,String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from WayFile";
			tsql="select count(*) from WayFile";
		}else{
			sql="from WayFile where (" + conditions + ")";
			tsql="select count(*) from WayFile where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<WayFile> res = query.list();
		return res;
	}
	public List<WayFile> getAllModelList() {
		// TODO Auto-generated method stub
		//List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		//return res;
		return this.hibernateTemplate.loadAll(WayFile.class);
	}
	public boolean updateWayFile(WayFile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
