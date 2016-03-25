package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.ChangeColorDao;
import Ynzc.YnzcAms.Model.ChangeColor;
import Ynzc.YnzcAms.Model.Page;

public class ChangeColorDaoImpl implements ChangeColorDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(ChangeColor model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(ChangeColor model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delChangeColorByIds(String ids){
		String sql="delete from ChangeColor where id in ("+ids+")";
		if(this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public ChangeColor findModelById(int id) {
		// TODO Auto-generated method stub
		List<ChangeColor> res = hibernateTemplate.find("from ChangeColor where id=" + id);
		if (res.size() > 0) {
			return (ChangeColor) res.get(0);
		} else {
			return null;
		}
	}

	public List<ChangeColor> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from ChangeColor";
			tsql="select count(*) from ChangeColor";
		}else{
			sql="from ChangeColor where (" + conditions + ")";
			tsql="select count(*) from ChangeColor where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<ChangeColor> res = query.list();
		return res;
	}

	public List<ChangeColor> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(ChangeColor.class);
	}

	public boolean updateModel(ChangeColor model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
