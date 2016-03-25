package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TheoryExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExamView;

public interface TheoryExamService {
	/**
	 * 分页获得理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<TheoryExam> getAllTheoryExam(Page page,String conditions);
	/**
	 * 获得理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<TheoryExam> getAllTheoryExam();
	/**
	 * 查找理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public TheoryExam findTheoryExamById(int id);
	/**
	 * 查找理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public TheoryExam findTheoryExamByStrId(int id);
	/**
	 * 添加理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addTheoryExam(TheoryExam model);
	/**
	 * 删除理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delTheoryExam(TheoryExam model);
	/**
	 * 更改理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateTheoryExam(TheoryExam model);
	
	/**
	 * 理论未通过人数
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean TheoryExamPass(int driverClassInfoId);
	/**
	 * 分页获得理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<TheoryMakeupExamView> getAllTheoryMakeupExam(Page page,String conditions,int theoryId);
	
	public List<TheoryMakeupExamView> getAllTheoryMakeupExamQuery(Page page,String conditions,int theoryId);
	/**
	 * 添加理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addTheoryMakeupExam(TheoryMakeupExam model);
	/**
	 * 更改理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateTheoryMakeupExam(TheoryMakeupExam model);
	/**
	 * 删除理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delTheoryMakeupExam(TheoryMakeupExam model);
	/**
	 * 查找理论考试
	 * @author zy
	 * @date 2011-04-26
	 **/
	public TheoryMakeupExam findTheoryMakeupExamById(int id);
	
	public List<TheoryMakeupExam> getAllTheoryMakeupExam(int theoryId);
}
