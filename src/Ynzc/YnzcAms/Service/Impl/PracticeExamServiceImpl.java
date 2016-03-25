package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.PracticeExamDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PracticeExam;
import Ynzc.YnzcAms.Model.PracticeMakeupExam;
import Ynzc.YnzcAms.Model.PracticeMakeupExamView;
import Ynzc.YnzcAms.Service.PracticeExamService;

public class PracticeExamServiceImpl implements PracticeExamService {
	private PracticeExamDao practiceExamDao;
	public PracticeExamDao getPracticeExamDao() {
		return practiceExamDao;
	}
	public void setPracticeExamDao(PracticeExamDao practiceExamDao) {
		this.practiceExamDao = practiceExamDao;
	}
	/**
	 * 分页获得实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PracticeExam> getAllPracticeExam(Page page,String conditions){
		return practiceExamDao.getAllPracticeExam(page, conditions);
	}
	/**
	 * 获得实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PracticeExam> getAllPracticeExam(){
		return practiceExamDao.getAllPracticeExam();
	}
	/**
	 * 查找实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public PracticeExam findPracticeExamById(int id){
		return practiceExamDao.findPracticeExamById(id);
	}
	/**
	 * 查找实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public PracticeExam findPracticeExamByStrId(int id){
		return practiceExamDao.findPracticeExamByStrId(id);
	}
	/**
	 * 实践未通过人数
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean PracticeExamPass(int driverClassId){
		return practiceExamDao.PracticeExamPass(driverClassId);
	}
	/**
	 * 添加实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addPracticeExam(PracticeExam model){
		return practiceExamDao.addPracticeExam(model);
	}
	/**
	 * 删除实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delPracticeExam(PracticeExam model){
		return practiceExamDao.delPracticeExam(model);
	}
	/**
	 * 更改实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updatePracticeExam(PracticeExam model){
		return practiceExamDao.updatePracticeExam(model);
	}
	public boolean addPracticeMakeupExam(PracticeMakeupExam model) {
		// TODO Auto-generated method stub
		return practiceExamDao.addPracticeMakeupExam(model);
	}
	public List<PracticeMakeupExamView> getAllPracticeMakeupExam(Page page,
			String conditions, int practiceId) {
		// TODO Auto-generated method stub
		return practiceExamDao.getAllPracticeMakeupExam(page,conditions,practiceId);
	}
	public List<PracticeMakeupExam> getAllPracticeMakeupExam(int practiceId) {
		// TODO Auto-generated method stub
		return practiceExamDao.getAllPracticeMakeupExam(practiceId);
	}
	public List<PracticeMakeupExamView> getAllPracticeMakeupExamQuery(
			Page page, String conditions, int practiceId) {
		// TODO Auto-generated method stub
		return practiceExamDao.getAllPracticeMakeupExam(page,conditions,practiceId);
	}
}
