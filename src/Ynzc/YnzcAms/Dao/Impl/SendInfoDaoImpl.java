package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.SendInfoDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.SendInformation;
import Ynzc.YnzcAms.Model.User;

public class SendInfoDaoImpl implements SendInfoDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<SendInformation> getSendInfoAll(Page page, String condition,
			int userid) {
		// TODO Auto-generated method stub
		String sql = "", tsql = "";
		if (condition.equals("")) {
			sql = "from SendInformation where sendUserId='" + userid
					+ "' and replyId=0 order by sendDate desc";
			tsql = "select count(*) from SendInformation where sendUserId='"
					+ userid + "' and replyId=0";
		} else {
			sql = "from SendInformation where sendUserId='" + userid
					+ "' and replyId=0 and (" + condition + ") order by sendDate desc";
			tsql = "select count(*) from SendInformation where sendUserId='"
					+ userid + "' and (" + condition + ") and replyId=0";
		}
		Query query = this.getHibernateTemplate().getSessionFactory()
				.openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0)
				.toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<SendInformation> res = query.list();
		return res;
	}

	public boolean delSendInfo(SendInformation sendInfomation) {
		try {
			hibernateTemplate.delete(sendInfomation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateSendInformation(SendInformation sendInfomation) {
		try {
			hibernateTemplate.update(sendInfomation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addSendInfomation(SendInformation sendInfomation) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(sendInfomation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<SendInformation> getSendInfoNewsAll(Page page, String condition) {
		String sql = "", tsql = "";
		if (condition.equals("")) {
			sql = "from SendInformation where type='最新公告' order by sendDate desc";
			tsql = "select count(*) from SendInformation";
		} else {
			sql = "from SendInformation where (" + condition
					+ ") and type='最新公告'";
			tsql = "select count(*) from SendInformation where (" + condition
					+ ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory()
				.openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0)
				.toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<SendInformation> res = query.list();
		return res;
	}

	public List<SendInformation> getSendInfoMessageAll(Page page,
			String condition) {
		String sql = "", tsql = "";
		if (condition.equals("")) {
			sql = "from SendInformation where type='在线交流' and replyId=0 order by sendDate desc";
			tsql = "select count(*) from SendInformation";
		} else {
			sql = "from SendInformation where (" + condition
					+ ") and type='在线交流' and replyId=0";
			tsql = "select count(*) from SendInformation where (" + condition
					+ ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory()
				.openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0)
				.toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<SendInformation> res = query.list();
		return res;
	}

	public List<SendInformation> getSendInfoMessageIdList(int id) {
		String sql = "from SendInformation where replyId=" + id;
		List<SendInformation> send = hibernateTemplate.find(sql);
		return send;
	}

	public boolean delReply(int themeid) {
		// TODO Auto-generated method stub
		String sql="delete from ynzc_sendinformation where replyId="+themeid;
		try{
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
