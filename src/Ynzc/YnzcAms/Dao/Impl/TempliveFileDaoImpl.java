package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.TempliveFileDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TempliveFile;

public class TempliveFileDaoImpl implements TempliveFileDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addTempliveFile(TempliveFile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delTempliveFile(TempliveFile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public TempliveFile findTempliveFileById(int id) {
		// TODO Auto-generated method stub
		List<TempliveFile> res = hibernateTemplate.find("from TempliveFile where id=" + id);
		if (res.size() > 0) {
			return (TempliveFile) res.get(0);
		} else {
			return null;
		}
	}

	public List<TempliveFile> getAllTempliveFileList(Page page,String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from TempliveFile";
			tsql="select count(*) from TempliveFile";
		}else{
			sql="from TempliveFile where (" + conditions + ")";
			tsql="select count(*) from TempliveFile where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<TempliveFile> res = query.list();
		return res;
	}
	public List<TempliveFile> getAllModelList() {
		// TODO Auto-generated method stub
		//List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		//return res;
		return this.hibernateTemplate.loadAll(TempliveFile.class);
	}
	public boolean updateTempliveFile(TempliveFile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
