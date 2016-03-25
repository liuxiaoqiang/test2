package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.TheoryExamDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TheoryExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExamView;
import Ynzc.YnzcAms.Service.TheoryExamService;

public class TheoryExamServiceImpl implements TheoryExamService {
	private TheoryExamDao theoryExamDao;
	public TheoryExamDao getTheoryExamDao() {
		return theoryExamDao;
	}
	public void setTheoryExamDao(TheoryExamDao theoryExamDao) {
		this.theoryExamDao = theoryExamDao;
	}
	/**
	 * 分页获得理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<TheoryExam> getAllTheoryExam(Page page,String conditions){
		return theoryExamDao.getAllTheoryExam(page, conditions);
	}
	/**
	 * 获得理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<TheoryExam> getAllTheoryExam(){
		return theoryExamDao.getAllTheoryExam();
	}
	/**
	 * 查找理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public TheoryExam findTheoryExamById(int id){
		return theoryExamDao.findTheoryExamById(id);
	}
	/**
	 * 添加理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addTheoryExam(TheoryExam model){
		return theoryExamDao.addTheoryExam(model);
	}
	/**
	 * 查找理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public TheoryExam findTheoryExamByStrId(int id){
		return theoryExamDao.findTheoryExamByStrId(id);
	}
	/**
	 * 理论未通过人数
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean TheoryExamPass(int driverClassInfoId){
		return theoryExamDao.TheoryExamPass(driverClassInfoId);
	}
	/**
	 * 删除理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delTheoryExam(TheoryExam model){
		return theoryExamDao.delTheoryExam(model);
	}
	/**
	 * 更改理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateTheoryExam(TheoryExam model){
		return theoryExamDao.updateTheoryExam(model);
	}
	/**
	 * 分页获得理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<TheoryMakeupExamView> getAllTheoryMakeupExam(Page page,String conditions,int theoryId){
		return theoryExamDao.getAllTheoryMakeupExam(page,conditions,theoryId);
	}
	public boolean addTheoryMakeupExam(TheoryMakeupExam model) {
		// TODO Auto-generated method stub
		return theoryExamDao.addTheoryMakeupExam(model);
	}
	public boolean delTheoryMakeupExam(TheoryMakeupExam model) {
		// TODO Auto-generated method stub
		return theoryExamDao.delTheoryMakeupExam(model);
	}
	public boolean updateTheoryMakeupExam(TheoryMakeupExam model) {
		// TODO Auto-generated method stub
		return theoryExamDao.updateTheoryMakeupExam(model);
	}
	public TheoryMakeupExam findTheoryMakeupExamById(int id) {
		// TODO Auto-generated method stub
		return theoryExamDao.findTheoryMakeupExamById(id);
	}
	public List<TheoryMakeupExam> getAllTheoryMakeupExam(int theoryId) {
		// TODO Auto-generated method stub
		return theoryExamDao.getAllTheoryMakeupExam(theoryId);
	}
	public List<TheoryMakeupExamView> getAllTheoryMakeupExamQuery(Page page,
			String conditions, int theoryId) {
		// TODO Auto-generated method stub
		return theoryExamDao.getAllTheoryMakeupExamQuery(page,conditions,theoryId);
	}
}
