package Ynzc.YnzcAms.Model;
/**
 * 实践考试
 * @author zy
 * @date 2011-04-25
 * class PracticeExam.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_practicemakeupexam")
public class PracticeMakeupExam {
	private int practiceMakeupId;//编号
	private int practiceId;//正考Id
	private int makeupExamType;//不靠类型
	private String drillMasterMakeupId;//教练Id
	private String drillMasterMakeupCode;//教练Code
	private String drillMasterMakeupDate;//教练天数
	private String drillMasterMachineMakeup;//教练机
	private int drillMasterAuditingIdeaMakeupFlag;//教练审核意见
	private int unitAuditingPracticeIdeaMakeupFlag;//部门审核意见
	private int drivingLicenceAuditingIdeaMakeupFlag;//是否发放证件
	private int orgAuditingIdeaMakeupFlag;//省级审核意见
	private String fieldMakeupResult;//场地考试成绩
	private String examinerMakeupFieldOne;//场地主考人
	private String examinerMakeupFieldTwo;//场地监考人
	private Date fieldMakeupDate;//场地考试日期
	private String machineMakeupResult;//作业考试成绩
	private String examinerMakeupMachineOne;//作业主考人
	private String examinerMakeupMachineTwo;//作业监考人
	private Date machineMakeupDate;//作业考试日期
	private String roadMakeupResult;//公路考试成绩
	private String examinerMakeupRoadOne;//公路主考人
	private String examinerMakeupRoadTwo;//公路监考人
	private Date roadMakeupDate;//公路考试日期
	private int auditingPracticeResultMakeupFlag;//结论
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private String year;//年度
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPracticeMakeupId() {
		return practiceMakeupId;
	}
	public void setPracticeMakeupId(int practiceMakeupId) {
		this.practiceMakeupId = practiceMakeupId;
	}
	public int getPracticeId() {
		return practiceId;
	}
	public void setPracticeId(int practiceId) {
		this.practiceId = practiceId;
	}
	public int getMakeupExamType() {
		return makeupExamType;
	}
	public void setMakeupExamType(int makeupExamType) {
		this.makeupExamType = makeupExamType;
	}
	public String getFieldMakeupResult() {
		return fieldMakeupResult;
	}
	public void setFieldMakeupResult(String fieldMakeupResult) {
		this.fieldMakeupResult = fieldMakeupResult;
	}
	public String getExaminerMakeupFieldOne() {
		return examinerMakeupFieldOne;
	}
	public void setExaminerMakeupFieldOne(String examinerMakeupFieldOne) {
		this.examinerMakeupFieldOne = examinerMakeupFieldOne;
	}
	public String getExaminerMakeupFieldTwo() {
		return examinerMakeupFieldTwo;
	}
	public void setExaminerMakeupFieldTwo(String examinerMakeupFieldTwo) {
		this.examinerMakeupFieldTwo = examinerMakeupFieldTwo;
	}
	public Date getFieldMakeupDate() {
		return fieldMakeupDate;
	}
	public void setFieldMakeupDate(Date fieldMakeupDate) {
		this.fieldMakeupDate = fieldMakeupDate;
	}
	public String getMachineMakeupResult() {
		return machineMakeupResult;
	}
	public void setMachineMakeupResult(String machineMakeupResult) {
		this.machineMakeupResult = machineMakeupResult;
	}
	public String getExaminerMakeupMachineOne() {
		return examinerMakeupMachineOne;
	}
	public void setExaminerMakeupMachineOne(String examinerMakeupMachineOne) {
		this.examinerMakeupMachineOne = examinerMakeupMachineOne;
	}
	public String getExaminerMakeupMachineTwo() {
		return examinerMakeupMachineTwo;
	}
	public void setExaminerMakeupMachineTwo(String examinerMakeupMachineTwo) {
		this.examinerMakeupMachineTwo = examinerMakeupMachineTwo;
	}
	public Date getMachineMakeupDate() {
		return machineMakeupDate;
	}
	public void setMachineMakeupDate(Date machineMakeupDate) {
		this.machineMakeupDate = machineMakeupDate;
	}
	public String getRoadMakeupResult() {
		return roadMakeupResult;
	}
	public void setRoadMakeupResult(String roadMakeupResult) {
		this.roadMakeupResult = roadMakeupResult;
	}
	public String getExaminerMakeupRoadOne() {
		return examinerMakeupRoadOne;
	}
	public void setExaminerMakeupRoadOne(String examinerMakeupRoadOne) {
		this.examinerMakeupRoadOne = examinerMakeupRoadOne;
	}
	public String getExaminerMakeupRoadTwo() {
		return examinerMakeupRoadTwo;
	}
	public void setExaminerMakeupRoadTwo(String examinerMakeupRoadTwo) {
		this.examinerMakeupRoadTwo = examinerMakeupRoadTwo;
	}
	public Date getRoadMakeupDate() {
		return roadMakeupDate;
	}
	public void setRoadMakeupDate(Date roadMakeupDate) {
		this.roadMakeupDate = roadMakeupDate;
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
	public String getDrillMasterMakeupId() {
		return drillMasterMakeupId;
	}
	public void setDrillMasterMakeupId(String drillMasterMakeupId) {
		this.drillMasterMakeupId = drillMasterMakeupId;
	}
	public String getDrillMasterMakeupCode() {
		return drillMasterMakeupCode;
	}
	public void setDrillMasterMakeupCode(String drillMasterMakeupCode) {
		this.drillMasterMakeupCode = drillMasterMakeupCode;
	}
	public String getDrillMasterMakeupDate() {
		return drillMasterMakeupDate;
	}
	public void setDrillMasterMakeupDate(String drillMasterMakeupDate) {
		this.drillMasterMakeupDate = drillMasterMakeupDate;
	}
	public String getDrillMasterMachineMakeup() {
		return drillMasterMachineMakeup;
	}
	public void setDrillMasterMachineMakeup(String drillMasterMachineMakeup) {
		this.drillMasterMachineMakeup = drillMasterMachineMakeup;
	}
	public int getDrillMasterAuditingIdeaMakeupFlag() {
		return drillMasterAuditingIdeaMakeupFlag;
	}
	public void setDrillMasterAuditingIdeaMakeupFlag(
			int drillMasterAuditingIdeaMakeupFlag) {
		this.drillMasterAuditingIdeaMakeupFlag = drillMasterAuditingIdeaMakeupFlag;
	}
	public int getUnitAuditingPracticeIdeaMakeupFlag() {
		return unitAuditingPracticeIdeaMakeupFlag;
	}
	public void setUnitAuditingPracticeIdeaMakeupFlag(
			int unitAuditingPracticeIdeaMakeupFlag) {
		this.unitAuditingPracticeIdeaMakeupFlag = unitAuditingPracticeIdeaMakeupFlag;
	}
	public int getDrivingLicenceAuditingIdeaMakeupFlag() {
		return drivingLicenceAuditingIdeaMakeupFlag;
	}
	public void setDrivingLicenceAuditingIdeaMakeupFlag(
			int drivingLicenceAuditingIdeaMakeupFlag) {
		this.drivingLicenceAuditingIdeaMakeupFlag = drivingLicenceAuditingIdeaMakeupFlag;
	}
	public int getOrgAuditingIdeaMakeupFlag() {
		return orgAuditingIdeaMakeupFlag;
	}
	public void setOrgAuditingIdeaMakeupFlag(int orgAuditingIdeaMakeupFlag) {
		this.orgAuditingIdeaMakeupFlag = orgAuditingIdeaMakeupFlag;
	}
	public int getAuditingPracticeResultMakeupFlag() {
		return auditingPracticeResultMakeupFlag;
	}
	public void setAuditingPracticeResultMakeupFlag(
			int auditingPracticeResultMakeupFlag) {
		this.auditingPracticeResultMakeupFlag = auditingPracticeResultMakeupFlag;
	}
}
