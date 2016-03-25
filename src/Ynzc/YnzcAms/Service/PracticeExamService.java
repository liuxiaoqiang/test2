package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PracticeExam;
import Ynzc.YnzcAms.Model.PracticeMakeupExam;
import Ynzc.YnzcAms.Model.PracticeMakeupExamView;

public interface PracticeExamService {
	/**
	 * 分页获得实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PracticeExam> getAllPracticeExam(Page page,String conditions);
	/**
	 * 获得实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PracticeExam> getAllPracticeExam();
	/**
	 * 查找实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public PracticeExam findPracticeExamById(int id);
	/**
	 * 查找理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public PracticeExam findPracticeExamByStrId(int id);
	/**
	 * 添加实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addPracticeExam(PracticeExam model);
	/**
	 * 删除实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delPracticeExam(PracticeExam model);
	/**
	 * 更改实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updatePracticeExam(PracticeExam model);
	/**
	 * 班级状态改变
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean PracticeExamPass(int driverClassId);
	/**
	 * 分页获得实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<PracticeMakeupExamView> getAllPracticeMakeupExam(Page page,String conditions,int practiceId);
	
	public List<PracticeMakeupExamView> getAllPracticeMakeupExamQuery(Page page,String conditions,int practiceId);
	/**
	 * 添加实践考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addPracticeMakeupExam(PracticeMakeupExam model);
	
	public List<PracticeMakeupExam> getAllPracticeMakeupExam(int practiceId);
}
