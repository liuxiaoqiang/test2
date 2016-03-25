package Ynzc.YnzcAms.Model;
/**
 * 班级
 * @author zy
 * @date 2011-04-25
 * class DriverStrInfoClass.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_driverclassinfo")
public class DriverClassInfo {
	private int id;//编号
	private String className;//班级名称
	private Date classDate;//开班时间
	private Date theoryExamDate;//理论考试时间
	private Date practiceExamDate;//实践考试时间
	private int classState;//班级状态
	private int declareFlag;//申报
	private Date declareDate;//申报时间
	private int classStrNum;//班级人数
	private int theoryExamPassStrNum;//理论通过人数
	private int theoryExamMakeUpPassStrNum;//理论补考通过人数
	private int practiceExamPassStrNum;//技术通过人数
	private int practiceExamMakeUpPassStrNum;//技术补考通过人数
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private String year;//年度
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public Date getClassDate() {
		return classDate;
	}
	public void setClassDate(Date classDate) {
		this.classDate = classDate;
	}
	public Date getTheoryExamDate() {
		return theoryExamDate;
	}
	public void setTheoryExamDate(Date theoryExamDate) {
		this.theoryExamDate = theoryExamDate;
	}
	public Date getPracticeExamDate() {
		return practiceExamDate;
	}
	public void setPracticeExamDate(Date practiceExamDate) {
		this.practiceExamDate = practiceExamDate;
	}
	public int getClassState() {
		return classState;
	}
	public void setClassState(int classState) {
		this.classState = classState;
	}
	public int getDeclareFlag() {
		return declareFlag;
	}
	public void setDeclareFlag(int declareFlag) {
		this.declareFlag = declareFlag;
	}
	public Date getDeclareDate() {
		return declareDate;
	}
	public void setDeclareDate(Date declareDate) {
		this.declareDate = declareDate;
	}
	public int getClassStrNum() {
		return classStrNum;
	}
	public void setClassStrNum(int classStrNum) {
		this.classStrNum = classStrNum;
	}
	public int getTheoryExamPassStrNum() {
		return theoryExamPassStrNum;
	}
	public void setTheoryExamPassStrNum(int theoryExamPassStrNum) {
		this.theoryExamPassStrNum = theoryExamPassStrNum;
	}
	public int getTheoryExamMakeUpPassStrNum() {
		return theoryExamMakeUpPassStrNum;
	}
	public void setTheoryExamMakeUpPassStrNum(int theoryExamMakeUpPassStrNum) {
		this.theoryExamMakeUpPassStrNum = theoryExamMakeUpPassStrNum;
	}
	public int getPracticeExamPassStrNum() {
		return practiceExamPassStrNum;
	}
	public void setPracticeExamPassStrNum(int practiceExamPassStrNum) {
		this.practiceExamPassStrNum = practiceExamPassStrNum;
	}
	public int getPracticeExamMakeUpPassStrNum() {
		return practiceExamMakeUpPassStrNum;
	}
	public void setPracticeExamMakeUpPassStrNum(int practiceExamMakeUpPassStrNum) {
		this.practiceExamMakeUpPassStrNum = practiceExamMakeUpPassStrNum;
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
