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
@Table(name = "ynzc_theorymakeupexam")
public class TheoryMakeupExam {
	private int theoryMakeupId;//编号
	private int theoryId;//正考编号
	private String theoryMakeupResult;//补考成绩
	private String examinerTheoryMakeupOne;//补考主考人
	private String examinerTheoryMakeupTwo;//补考监考人
	private Date theoryMakeupDate;//补考时间
	private int auditingIdeaTheoryMakeupFlag;//审核意见
	private String transactorMakeup;//经办人
	private int unitAuditingIdeaTheoryMakeupFlag;//部门审核意见
	private Date unitAuditingIdeaTheoryMakeupDate;//部门审核时间
	private int auditingResultTheoryMakeupFlag;//结论
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private String year;//年度
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getTheoryMakeupId() {
		return theoryMakeupId;
	}
	public void setTheoryMakeupId(int theoryMakeupId) {
		this.theoryMakeupId = theoryMakeupId;
	}
	public int getTheoryId() {
		return theoryId;
	}
	public void setTheoryId(int theoryId) {
		this.theoryId = theoryId;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getTransactorMakeup() {
		return transactorMakeup;
	}
	public void setTransactorMakeup(String transactorMakeup) {
		this.transactorMakeup = transactorMakeup;
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
	public String getTheoryMakeupResult() {
		return theoryMakeupResult;
	}
	public void setTheoryMakeupResult(String theoryMakeupResult) {
		this.theoryMakeupResult = theoryMakeupResult;
	}
	public String getExaminerTheoryMakeupOne() {
		return examinerTheoryMakeupOne;
	}
	public void setExaminerTheoryMakeupOne(String examinerTheoryMakeupOne) {
		this.examinerTheoryMakeupOne = examinerTheoryMakeupOne;
	}
	public String getExaminerTheoryMakeupTwo() {
		return examinerTheoryMakeupTwo;
	}
	public void setExaminerTheoryMakeupTwo(String examinerTheoryMakeupTwo) {
		this.examinerTheoryMakeupTwo = examinerTheoryMakeupTwo;
	}
	public Date getTheoryMakeupDate() {
		return theoryMakeupDate;
	}
	public void setTheoryMakeupDate(Date theoryMakeupDate) {
		this.theoryMakeupDate = theoryMakeupDate;
	}
	public int getAuditingIdeaTheoryMakeupFlag() {
		return auditingIdeaTheoryMakeupFlag;
	}
	public void setAuditingIdeaTheoryMakeupFlag(int auditingIdeaTheoryMakeupFlag) {
		this.auditingIdeaTheoryMakeupFlag = auditingIdeaTheoryMakeupFlag;
	}
	public int getUnitAuditingIdeaTheoryMakeupFlag() {
		return unitAuditingIdeaTheoryMakeupFlag;
	}
	public void setUnitAuditingIdeaTheoryMakeupFlag(
			int unitAuditingIdeaTheoryMakeupFlag) {
		this.unitAuditingIdeaTheoryMakeupFlag = unitAuditingIdeaTheoryMakeupFlag;
	}
	public Date getUnitAuditingIdeaTheoryMakeupDate() {
		return unitAuditingIdeaTheoryMakeupDate;
	}
	public void setUnitAuditingIdeaTheoryMakeupDate(
			Date unitAuditingIdeaTheoryMakeupDate) {
		this.unitAuditingIdeaTheoryMakeupDate = unitAuditingIdeaTheoryMakeupDate;
	}
	public int getAuditingResultTheoryMakeupFlag() {
		return auditingResultTheoryMakeupFlag;
	}
	public void setAuditingResultTheoryMakeupFlag(int auditingResultTheoryMakeupFlag) {
		this.auditingResultTheoryMakeupFlag = auditingResultTheoryMakeupFlag;
	}
}
