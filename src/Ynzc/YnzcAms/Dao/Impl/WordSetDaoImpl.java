package Ynzc.YnzcAms.Dao.Impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.WordSetDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.WordSet;

public class WordSetDaoImpl implements WordSetDao{
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean updateWordSet(WordSet wordset){
		try {
			hibernateTemplate.update(wordset);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public List<WordSet> getAllWordSet(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from WordSet";
			tsql="select count(*) from WordSet";
		}else{
			sql="from WordSet where (" + conditions + ")";
			tsql="select count(*) from WordSet where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<WordSet> res = query.list();
		return res;
	}

	public WordSet findWordSetByWordType(String wordType) {
		// TODO Auto-generated method stub
		List<WordSet> res=hibernateTemplate.getSessionFactory().openSession().createSQLQuery("select * from ynzc_wordset where wordtype='"+wordType+"'").addEntity(WordSet.class).list();
		if(res.size()>0){
			return (WordSet)res.get(0);
		}else{
			return null;
		}
	}
	
		public boolean addWordSet(WordSet wordset) {
		try {
			hibernateTemplate.save(wordset);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delWordSet(WordSet wordset) {
		try {
			hibernateTemplate.delete(wordset);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public WordSet findWordSetByWordTypeandUnitid(String wordType,int unitid) {
		// TODO Auto-generated method stub
		List<WordSet> res=hibernateTemplate.getSessionFactory().openSession().createSQLQuery("select * from ynzc_wordset where wordtype='"+wordType+"' and unitid='"+unitid+"'").addEntity(WordSet.class).list();
		if(res.size()>0){
			return (WordSet)res.get(0);
		}else{
			return null;
		}
	}
}
