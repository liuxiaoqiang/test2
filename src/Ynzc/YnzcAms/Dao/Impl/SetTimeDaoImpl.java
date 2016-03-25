package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.SetTimeDao;
import Ynzc.YnzcAms.Model.SetTime;

public class SetTimeDaoImpl implements SetTimeDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean updateSetTime(SetTime settime) {
		try {
			hibernateTemplate.update(settime);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public SetTime findSetTimeByUnitId(int unitId) {
		List<SetTime> res = hibernateTemplate.find("from SetTime where unitid=" + unitId);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}

	public boolean saveSetTime(SetTime model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
