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
@Table(name = "ynzc_practiceexam")
public class PracticeExam {
	private int practiceId;//编号
	private int driverStrInfoId;//学员Id
	private String drivingLicenceNo;//驾驶证号
	private String drillMasterId;//教练Id
	private String drillMasterCode;//教练Code
	private String drillMasterDate;//教练天数
	private String drillMasterMachine;//教练机
	private int drillMasterAuditingIdeaFlag;//教练审核意见
	private int unitAuditingPracticeIdeaFlag;//部门审核意见
	private int drivingLicenceAuditingIdeaFlag;//是否发放证件
	private int orgAuditingIdeaFlag;//省级审核意见
	
	private String fieldResult;//场地考试成绩
	private String examinerFieldOne;//场地主考人
	private String examinerFieldTwo;//场地监考人
	private Date fieldDate;//场地考试日期
	
	private String machineResult;//作业考试成绩
	private String examinerMachineOne;//作业主考人
	private String examinerMachineTwo;//作业监考人
	private Date machineDate;//作业考试日期
	
	private String roadResult;//公路考试成绩
	private String examinerRoadOne;//公路主考人
	private String examinerRoadTwo;//公路监考人
	private Date roadDate;//公路考试日期
	
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
	
	private int auditingPracticeResultFlag;//结论
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private String year;//年度
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPracticeId() {
		return practiceId;
	}
	public void setPracticeId(int practiceId) {
		this.practiceId = practiceId;
	}
	public int getDriverStrInfoId() {
		return driverStrInfoId;
	}
	public void setDriverStrInfoId(int driverStrInfoId) {
		this.driverStrInfoId = driverStrInfoId;
	}
	public String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}
	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}
	public String getDrillMasterId() {
		return drillMasterId;
	}
	public void setDrillMasterId(String drillMasterId) {
		this.drillMasterId = drillMasterId;
	}
	public String getDrillMasterCode() {
		return drillMasterCode;
	}
	public void setDrillMasterCode(String drillMasterCode) {
		this.drillMasterCode = drillMasterCode;
	}
	public String getDrillMasterDate() {
		return drillMasterDate;
	}
	public void setDrillMasterDate(String drillMasterDate) {
		this.drillMasterDate = drillMasterDate;
	}
	public String getDrillMasterMachine() {
		return drillMasterMachine;
	}
	public void setDrillMasterMachine(String drillMasterMachine) {
		this.drillMasterMachine = drillMasterMachine;
	}
	public int getUnitAuditingPracticeIdeaFlag() {
		return unitAuditingPracticeIdeaFlag;
	}
	public void setUnitAuditingPracticeIdeaFlag(int unitAuditingPracticeIdeaFlag) {
		this.unitAuditingPracticeIdeaFlag = unitAuditingPracticeIdeaFlag;
	}
	public int getDrillMasterAuditingIdeaFlag() {
		return drillMasterAuditingIdeaFlag;
	}
	public void setDrillMasterAuditingIdeaFlag(int drillMasterAuditingIdeaFlag) {
		this.drillMasterAuditingIdeaFlag = drillMasterAuditingIdeaFlag;
	}
	public int getDrivingLicenceAuditingIdeaFlag() {
		return drivingLicenceAuditingIdeaFlag;
	}
	public void setDrivingLicenceAuditingIdeaFlag(
			int drivingLicenceAuditingIdeaFlag) {
		this.drivingLicenceAuditingIdeaFlag = drivingLicenceAuditingIdeaFlag;
	}
	public int getOrgAuditingIdeaFlag() {
		return orgAuditingIdeaFlag;
	}
	public void setOrgAuditingIdeaFlag(int orgAuditingIdeaFlag) {
		this.orgAuditingIdeaFlag = orgAuditingIdeaFlag;
	}
	public String getFieldResult() {
		return fieldResult;
	}
	public void setFieldResult(String fieldResult) {
		this.fieldResult = fieldResult;
	}
	public String getExaminerFieldOne() {
		return examinerFieldOne;
	}
	public void setExaminerFieldOne(String examinerFieldOne) {
		this.examinerFieldOne = examinerFieldOne;
	}
	public String getExaminerFieldTwo() {
		return examinerFieldTwo;
	}
	public void setExaminerFieldTwo(String examinerFieldTwo) {
		this.examinerFieldTwo = examinerFieldTwo;
	}
	public Date getFieldDate() {
		return fieldDate;
	}
	public void setFieldDate(Date fieldDate) {
		this.fieldDate = fieldDate;
	}
	public String getMachineResult() {
		return machineResult;
	}
	public void setMachineResult(String machineResult) {
		this.machineResult = machineResult;
	}
	public String getExaminerMachineOne() {
		return examinerMachineOne;
	}
	public void setExaminerMachineOne(String examinerMachineOne) {
		this.examinerMachineOne = examinerMachineOne;
	}
	public String getExaminerMachineTwo() {
		return examinerMachineTwo;
	}
	public void setExaminerMachineTwo(String examinerMachineTwo) {
		this.examinerMachineTwo = examinerMachineTwo;
	}
	public Date getMachineDate() {
		return machineDate;
	}
	public void setMachineDate(Date machineDate) {
		this.machineDate = machineDate;
	}
	public String getRoadResult() {
		return roadResult;
	}
	public void setRoadResult(String roadResult) {
		this.roadResult = roadResult;
	}
	public String getExaminerRoadOne() {
		return examinerRoadOne;
	}
	public void setExaminerRoadOne(String examinerRoadOne) {
		this.examinerRoadOne = examinerRoadOne;
	}
	public String getExaminerRoadTwo() {
		return examinerRoadTwo;
	}
	public void setExaminerRoadTwo(String examinerRoadTwo) {
		this.examinerRoadTwo = examinerRoadTwo;
	}
	public Date getRoadDate() {
		return roadDate;
	}
	public void setRoadDate(Date roadDate) {
		this.roadDate = roadDate;
	}
	public int getAuditingPracticeResultFlag() {
		return auditingPracticeResultFlag;
	}
	public void setAuditingPracticeResultFlag(int auditingPracticeResultFlag) {
		this.auditingPracticeResultFlag = auditingPracticeResultFlag;
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
}
