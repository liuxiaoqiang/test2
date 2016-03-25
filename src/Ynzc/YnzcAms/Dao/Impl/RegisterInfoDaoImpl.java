package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RegisterInfo;

public class RegisterInfoDaoImpl implements Ynzc.YnzcAms.Dao.RegisterInfoDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addRegisterInfo(RegisterInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delRegisterInfo(RegisterInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delRegisterInfoByIds(String ids){
		String sql="delete from RegisterInfo where id in ("+ids+")";
		int result=this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	public RegisterInfo findRegisterInfoById(int id) {
		// TODO Auto-generated method stub
		List<RegisterInfo> res = hibernateTemplate.find("from RegisterInfo where id=" + id);
		if (res.size() > 0) {
			return (RegisterInfo) res.get(0);
		} else {
			return null;
		}
	}

	public List<RegisterInfo> getAllRegisterInfoList(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from RegisterInfo";
			tsql="select count(*) from RegisterInfo";
		}else{
			sql="from RegisterInfo where (" + conditions + ")";
			tsql="select count(*) from RegisterInfo where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<RegisterInfo> res = query.list();
		return res;
	}

	public boolean updateRegisterInfo(RegisterInfo model) {
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
