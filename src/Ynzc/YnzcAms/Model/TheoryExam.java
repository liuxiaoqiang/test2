package Ynzc.YnzcAms.Model;
/**
 * 理论考试
 * @author zy
 * @date 2011-04-25
 * class TheoryExam.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_theoryexam")
public class TheoryExam {
	private int theoryId;//编号
	private int driverStrInfoId;//学员Id
	private String theoryResult;//考试成绩
	private String examinerOne;//主考人
	private String examinerTwo;//监考人
	private Date theoryDate;//正考时间
	private String theoryMakeupResult;//考试成绩
	private String examinerMakeupOne;//主考人
	private String examinerMakeupTwo;//监考人
	private Date theoryMakeupDate;//正考时间
	private int auditingTheoryIdeaFlag;//审核意见
	private String transactor;//经办人
	private int unitTheoryAuditingIdeaFlag;//部门审核意见
	private Date unitTheoryAuditingIdeaDate;
	private int auditingTheoryResultFlag;//结论
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private String year;//年度
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getTheoryId() {
		return theoryId;
	}
	public void setTheoryId(int theoryId) {
		this.theoryId = theoryId;
	}
	public String getTheoryMakeupResult() {
		return theoryMakeupResult;
	}
	public void setTheoryMakeupResult(String theoryMakeupResult) {
		this.theoryMakeupResult = theoryMakeupResult;
	}
	public String getExaminerMakeupOne() {
		return examinerMakeupOne;
	}
	public void setExaminerMakeupOne(String examinerMakeupOne) {
		this.examinerMakeupOne = examinerMakeupOne;
	}
	public String getExaminerMakeupTwo() {
		return examinerMakeupTwo;
	}
	public void setExaminerMakeupTwo(String examinerMakeupTwo) {
		this.examinerMakeupTwo = examinerMakeupTwo;
	}
	public Date getTheoryMakeupDate() {
		return theoryMakeupDate;
	}
	public void setTheoryMakeupDate(Date theoryMakeupDate) {
		this.theoryMakeupDate = theoryMakeupDate;
	}
	public int getDriverStrInfoId() {
		return driverStrInfoId;
	}
	public void setDriverStrInfoId(int driverStrInfoId) {
		this.driverStrInfoId = driverStrInfoId;
	}
	public String getTheoryResult() {
		return theoryResult;
	}
	public void setTheoryResult(String theoryResult) {
		this.theoryResult = theoryResult;
	}
	public String getExaminerOne() {
		return examinerOne;
	}
	public void setExaminerOne(String examinerOne) {
		this.examinerOne = examinerOne;
	}
	public String getExaminerTwo() {
		return examinerTwo;
	}
	public void setExaminerTwo(String examinerTwo) {
		this.examinerTwo = examinerTwo;
	}
	public Date getTheoryDate() {
		return theoryDate;
	}
	public void setTheoryDate(Date theoryDate) {
		this.theoryDate = theoryDate;
	}
	public int getAuditingTheoryIdeaFlag() {
		return auditingTheoryIdeaFlag;
	}
	public void setAuditingTheoryIdeaFlag(int auditingTheoryIdeaFlag) {
		this.auditingTheoryIdeaFlag = auditingTheoryIdeaFlag;
	}
	public String getTransactor() {
		return transactor;
	}
	public void setTransactor(String transactor) {
		this.transactor = transactor;
	}
	public int getUnitTheoryAuditingIdeaFlag() {
		return unitTheoryAuditingIdeaFlag;
	}
	public void setUnitTheoryAuditingIdeaFlag(int unitTheoryAuditingIdeaFlag) {
		this.unitTheoryAuditingIdeaFlag = unitTheoryAuditingIdeaFlag;
	}
	public Date getUnitTheoryAuditingIdeaDate() {
		return unitTheoryAuditingIdeaDate;
	}
	public void setUnitTheoryAuditingIdeaDate(Date unitTheoryAuditingIdeaDate) {
		this.unitTheoryAuditingIdeaDate = unitTheoryAuditingIdeaDate;
	}
	public int getAuditingTheoryResultFlag() {
		return auditingTheoryResultFlag;
	}
	public void setAuditingTheoryResultFlag(int auditingTheoryResultFlag) {
		this.auditingTheoryResultFlag = auditingTheoryResultFlag;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getWriteUserId() {
		return writeUserId;
	}
	public void setWriteUserId(int writeUserId) {
		this.writeUserId = writeUserId;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
}
