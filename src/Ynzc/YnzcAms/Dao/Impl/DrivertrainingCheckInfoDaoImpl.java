package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivertrainingCheckInfoDao;
import Ynzc.YnzcAms.Model.DrivertrainingCheckInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfoView;

public class DrivertrainingCheckInfoDaoImpl implements
		DrivertrainingCheckInfoDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 增加教练机年检信息
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public boolean addDrivertrainingCheckInfo(
			DrivertrainingCheckInfo drivertrainingCheckInfo) {
		try {
			hibernateTemplate.save(drivertrainingCheckInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 删除教练机年检信息
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public boolean deleteDrivertrainingCheckInfo(
			DrivertrainingCheckInfo drivertrainingCheckInfo) {
		try {
			hibernateTemplate.delete(drivertrainingCheckInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 更新教练机年检信息
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public boolean updateDrivertrainingCheckInfo(
			DrivertrainingCheckInfo drivertrainingCheckInfo) {
		try {
			hibernateTemplate.update(drivertrainingCheckInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据传入id获得教练机年检信息
	 * @author wyb
	 * @date 2011-05-21
	 **/
	public DrivertrainingCheckInfo fingDrivertrainingCheckInfoById(int id) {
		List<DrivertrainingCheckInfo> res = hibernateTemplate.find("from DrivertrainingCheckInfo where id=" + id);
		if (res.size() > 0) {
			return (DrivertrainingCheckInfo) res.get(0);
		} else {
			return null;
		}
	}

}
