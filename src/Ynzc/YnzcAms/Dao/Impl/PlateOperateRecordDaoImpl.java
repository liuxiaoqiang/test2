package Ynzc.YnzcAms.Dao.Impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.PlateOperateRecordDao;
import Ynzc.YnzcAms.Model.PlateOperateRecord;

public class PlateOperateRecordDaoImpl implements PlateOperateRecordDao {

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addPlateOperateRecord(PlateOperateRecord plateOperateRecord) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(plateOperateRecord);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean DelPlateOperateRecordByReplaceRequestId(int  replaceRequestId){
		String sql="update ynzc_plateoperaterecord set flag=0 where replaceRequestId="+replaceRequestId+" and flag=1";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	

}
