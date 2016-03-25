package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.HandlingSituationDao;
import Ynzc.YnzcAms.Model.HandlingSituation;
import Ynzc.YnzcAms.Model.Page;

public class HandlingSituationDaoImpl implements HandlingSituationDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addHandlingSituation(HandlingSituation model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delHandlingSituation(HandlingSituation model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delHandlingSituationByIds(String ids){
		String sql="delete from HandlingSituation where id in ("+ids+")";
		int result=hibernateTemplate.getSessionFactory().openSession().createQuery(sql).executeUpdate();
		if(result>0){
			return true;
		}
		else{
			return false;
		}
	}
	public HandlingSituation findHandlingSituationById(int id) {
		// TODO Auto-generated method stub
		List<HandlingSituation> res = hibernateTemplate.find("from HandlingSituation where id=" + id);
		if (res.size() > 0) {
			return (HandlingSituation) res.get(0);
		} else {
			return null;
		}
	}
	public HandlingSituation GetHandlingSituationByCondition(String where)
	{
		List<HandlingSituation> res = hibernateTemplate.find("from HandlingSituation where " + where);
		if (res.size() > 0) {
			return (HandlingSituation) res.get(0);
		} else {
			return null;
		}		
	}
	public List<HandlingSituation> getAllHandlingSituationList(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from HandlingSituation";
			tsql="select count(*) from HandlingSituation";
		}else{
			sql="from HandlingSituation where (" + conditions + ")";
			tsql="select count(*) from HandlingSituation where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<HandlingSituation> res = query.list();
		return res;
	}

	public boolean updateHandlingSituation(HandlingSituation model) {
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
