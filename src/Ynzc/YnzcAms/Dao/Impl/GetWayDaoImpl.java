package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.GetWayDao;
import Ynzc.YnzcAms.Model.GetWay;
import Ynzc.YnzcAms.Model.Page;

public class GetWayDaoImpl implements GetWayDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addGetWay(GetWay model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delGetWay(GetWay model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public GetWay findGetWayById(int id) {
		// TODO Auto-generated method stub
		List<GetWay> res = hibernateTemplate.find("from GetWay where id=" + id);
		if (res.size() > 0) {
			return (GetWay) res.get(0);
		} else {
			return null;
		}
	}

	public List<GetWay> getAllGetWayList(Page page,String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from GetWay";
			tsql="select count(*) from GetWay";
		}else{
			sql="from GetWay where (" + conditions + ")";
			tsql="select count(*) from GetWay where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<GetWay> res = query.list();
		return res;
	}
	public List<GetWay> getAllModelList() {
		// TODO Auto-generated method stub
		//List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		//return res;
		return this.hibernateTemplate.loadAll(GetWay.class);
	}
	public boolean updateGetWay(GetWay model) {
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
