package Ynzc.YnzcAms.Dao.Impl;
/**
 * 验证目录DaoImpl
 * @author zy
 * @date 2011-04-18
 * class ValidateListDaoImpl.java
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.ValidateListDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UserReportSource;
import Ynzc.YnzcAms.Model.ValidateList;
import Ynzc.YnzcAms.Model.ValidateListReportSource;

public class ValidateListDaoImpl implements ValidateListDao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 添加验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean addValidateList(ValidateList model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 删除验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean delValidateList(ValidateList model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 查找验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public ValidateList findValidateListById(int id) {
		// TODO Auto-generated method stub
		List<ValidateList> res = hibernateTemplate.find("from ValidateList where id=" + id);
		if (res.size() > 0) {
			return (ValidateList) res.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 验证目录序号验证
	 * @author zy
	 * @date 2011-04-18
	 **/
	public ValidateList findValidateListByDirNo(String dirNo) {
		// TODO Auto-generated method stub
		List<ValidateList> res = hibernateTemplate.find("from ValidateList where dirNo=" + dirNo);
		if (res.size() > 0) {
			return (ValidateList) res.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 获得验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public List<ValidateList> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(ValidateList.class);
	}

	/**
	 * 分页获得验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public List<ValidateList> getAllValidateList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from ValidateList";
			tsql="select count(*) from ValidateList";
		}else{
			sql="from ValidateList where (" + conditions + ")";
			tsql="select count(*) from ValidateList where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<ValidateList> res = query.list();
		return res;
	}

	/**
	 * 更改验证目录
	 * @author zy
	 * @date 2011-04-18
	 **/
	public boolean updateValidateList(ValidateList model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ValidateListReportSource> getVList() {
		// TODO Auto-generated method stub
		String sql="select dirNo,machineType,setRow,productor,productorAddress,productorSeller,machineNo,carColor,productorPost,license,productorTel,sellerTelephone,shapeSize,axisSize,wheelSize,fuelTypeId,directControl,wheelNo,tiresSize,totalQuality,tilt,steelSpring,containerSize,power,drivers,topspeed,engineBrandId,driverInNo,loadQuality,allQuality,fuelCost,photoDir from  ynzc_validatelist where id=6";
		List<ValidateListReportSource> res=hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ValidateListReportSource.class)).list();
		return res;
	}

}
