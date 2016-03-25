package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.ImportsFileDao;
import Ynzc.YnzcAms.Model.ImportsFile;
import Ynzc.YnzcAms.Model.Page;

public class ImportsFileDaoImpl implements ImportsFileDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addImportsFile(ImportsFile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delImportsFile(ImportsFile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ImportsFile findImportsFileById(int id) {
		// TODO Auto-generated method stub
		List<ImportsFile> res = hibernateTemplate.find("from ImportsFile where id=" + id);
		if (res.size() > 0) {
			return (ImportsFile) res.get(0);
		} else {
			return null;
		}
	}

	public List<ImportsFile> getAllImportsFileList(Page page,String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from ImportsFile";
			tsql="select count(*) from ImportsFile";
		}else{
			sql="from ImportsFile where (" + conditions + ")";
			tsql="select count(*) from ImportsFile where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<ImportsFile> res = query.list();
		return res;
	}
	public List<ImportsFile> getAllModelList() {
		// TODO Auto-generated method stub
		//List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		//return res;
		return this.hibernateTemplate.loadAll(ImportsFile.class);
	}
	public boolean updateImportsFile(ImportsFile model) {
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
