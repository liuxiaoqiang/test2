package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.TractorBasicInfoDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorBasicInfo;

public class TractorBasicInfoDaoImpl implements TractorBasicInfoDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addTractorBasicInfo(TractorBasicInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delTractorBasicInfo(TractorBasicInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delTractorBasicInfoByIds(String ids){
		String sql="delete from TractorBasicInfo where id in ("+ids+")";
		int result=this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	public TractorBasicInfo findTractorBasicInfoById(int id) {
		// TODO Auto-generated method stub
		List<TractorBasicInfo> res = hibernateTemplate.find("from TractorBasicInfo where id=" + id);
		if (res.size() > 0) {
			return (TractorBasicInfo) res.get(0);
		} else {
			return null;
		}
	}
	public TractorBasicInfo findTractorBasicInfoByWhere(String where){
		List<TractorBasicInfo> res = hibernateTemplate.find("from TractorBasicInfo where " + where);
		if (res.size() > 0) {
			return (TractorBasicInfo) res.get(0);
		} else {
			return null;
		}
	}
	public List<TractorBasicInfo> getAllTractorBasicInfoList(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from TractorBasicInfo";
			tsql="select count(*) from TractorBasicInfo";
		}else{
			sql="from TractorBasicInfo where (" + conditions + ")";
			tsql="select count(*) from TractorBasicInfo where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<TractorBasicInfo> res = query.list();
		return res;
	}

	public boolean updateTractorBasicInfo(TractorBasicInfo model) {
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
