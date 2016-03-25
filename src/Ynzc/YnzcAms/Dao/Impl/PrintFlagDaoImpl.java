package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.PrintFlagDao;
import Ynzc.YnzcAms.Model.Certificate;
import Ynzc.YnzcAms.Model.PlateOperateRecord;
import Ynzc.YnzcAms.Model.PrintFlag;

public class PrintFlagDaoImpl implements PrintFlagDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addPrintFlag(PrintFlag printFlag) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(printFlag);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean DelPrintFlag(int tractroinfoId,int pintType){
		String sql="update ynzc_printflag set flag=0 where tractroinfoId="+tractroinfoId+" and flag=1 and pintType="+pintType;	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public PrintFlag GetPrintFlag(int tractorinfoId,int printType){
		List<PrintFlag> res = hibernateTemplate.find("from PrintFlag where tractroinfoId=" + tractorinfoId+" and printType="+printType+" and flag=1");
		if (res.size() > 0) {
			return (PrintFlag) res.get(0);
		} else {
			return null;
		}
	}
}
