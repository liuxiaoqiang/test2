package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_driverstrparticular_view")
public class DriverStrParticularView {
	private int id;//编号
	private int peopleInfoId;//人员信息Id
	private int bodyInfoId;//身体信息Id
	private String archivesNo;//档案号
	private String fosterType;//培养类型
	private int applicationFlag;//审查
	private String drivingLicenceTypeId;//申请型号
	private String applicationAddress;//申请地址
	private int applicationUserId;
	private Date applicationDate;
	private Date drivingLicenceFirst;//初领驾证
	private String examinationCode;//报考号
	private int strState;//学员状态
	private int pigeonholeFlag;//是否归档
	private Date pigeonholeDate;//归档时间
	private int theoryId;//理论Id
	private int theoryFlag;//理论结论
	private int practiceId;//技术Id
	private int practiceFlag;//技术结论
	private String theoryResult;//考试成绩
	private String examinerOne;//主考人
	private String examinerTwo;//监考人
	private Date theoryDate;//正考时间
	private String auditingTheoryIdeaFlag;//审核意见
	private String transactor;//经办人
	private String unitTheoryAuditingIdeaFlag;//部门审核意见
	private Date unitTheoryAuditingIdeaDate;
	private int auditingTheoryResultFlag;//结论
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
	private int auditingPracticeResultFlag;//结论
	private String peopleName;//名字
	private String sex;//性别
	private Date birthday;//出生日期
	private String idCard;//身份证
	private String idStay;//暂住证
	private String address;//家庭地址
	private String linkAddress;//联系地址
	private String linkTel;//联系电话
	private String postalcode;//邮政编码
	private String nativePlace;//籍贯
	private String degree;//文化程度
	private String picture;//照片
	private String hight;//身高
	private int resolvingPowerFlag;//辨色力
	private String rightEyePwoer;//右眼视力
	private int rightEyeRectificationFlag;//右眼矫正
	private String leftEyePwoer;//左眼视力
	private int leftEyeRectificationFlag;//左眼矫正
	private int rightEarPwoer;//右耳听力
	private int leftEarPwoer;//左耳听力
	private int rightHandFlag;//右手
	private int leftHandFlag;//左手
	private int rightLagFlag;//右脚
	private int leftLagFlag;//左脚
	private int bodyNeck;//身体和颈椎
	private Date bodyCheckDate;//身体检查时间
	private int checkResultFlag;//检查结果
	private String checkOrganization;//检查机构
	private String checkDoctor;//检查医生
	private String year;//年度
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPeopleInfoId() {
		return peopleInfoId;
	}
	public void setPeopleInfoId(int peopleInfoId) {
		this.peopleInfoId = peopleInfoId;
	}
	public int getBodyInfoId() {
		return bodyInfoId;
	}
	public void setBodyInfoId(int bodyInfoId) {
		this.bodyInfoId = bodyInfoId;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public String getFosterType() {
		return fosterType;
	}
	public void setFosterType(String fosterType) {
		this.fosterType = fosterType;
	}
	public int getApplicationFlag() {
		return applicationFlag;
	}
	public void setApplicationFlag(int applicationFlag) {
		this.applicationFlag = applicationFlag;
	}
	public String getDrivingLicenceTypeId() {
		return drivingLicenceTypeId;
	}
	public void setDrivingLicenceTypeId(String drivingLicenceTypeId) {
		this.drivingLicenceTypeId = drivingLicenceTypeId;
	}
	public String getApplicationAddress() {
		return applicationAddress;
	}
	public void setApplicationAddress(String applicationAddress) {
		this.applicationAddress = applicationAddress;
	}
	public String getExaminationCode() {
		return examinationCode;
	}
	public void setExaminationCode(String examinationCode) {
		this.examinationCode = examinationCode;
	}
	public int getStrState() {
		return strState;
	}
	public void setStrState(int strState) {
		this.strState = strState;
	}
	public int getPigeonholeFlag() {
		return pigeonholeFlag;
	}
	public void setPigeonholeFlag(int pigeonholeFlag) {
		this.pigeonholeFlag = pigeonholeFlag;
	}
	public Date getPigeonholeDate() {
		return pigeonholeDate;
	}
	public void setPigeonholeDate(Date pigeonholeDate) {
		this.pigeonholeDate = pigeonholeDate;
	}
	public int getTheoryId() {
		return theoryId;
	}
	public void setTheoryId(int theoryId) {
		this.theoryId = theoryId;
	}
	public int getTheoryFlag() {
		return theoryFlag;
	}
	public void setTheoryFlag(int theoryFlag) {
		this.theoryFlag = theoryFlag;
	}
	public int getPracticeId() {
		return practiceId;
	}
	public void setPracticeId(int practiceId) {
		this.practiceId = practiceId;
	}
	public int getPracticeFlag() {
		return practiceFlag;
	}
	public void setPracticeFlag(int practiceFlag) {
		this.practiceFlag = practiceFlag;
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
	public String getAuditingTheoryIdeaFlag() {
		return auditingTheoryIdeaFlag;
	}
	public void setAuditingTheoryIdeaFlag(String auditingTheoryIdeaFlag) {
		this.auditingTheoryIdeaFlag = auditingTheoryIdeaFlag;
	}
	public String getTransactor() {
		return transactor;
	}
	public void setTransactor(String transactor) {
		this.transactor = transactor;
	}
	public String getUnitTheoryAuditingIdeaFlag() {
		return unitTheoryAuditingIdeaFlag;
	}
	public void setUnitTheoryAuditingIdeaFlag(String unitTheoryAuditingIdeaFlag) {
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
	public int getDrillMasterAuditingIdeaFlag() {
		return drillMasterAuditingIdeaFlag;
	}
	public void setDrillMasterAuditingIdeaFlag(int drillMasterAuditingIdeaFlag) {
		this.drillMasterAuditingIdeaFlag = drillMasterAuditingIdeaFlag;
	}
	public int getUnitAuditingPracticeIdeaFlag() {
		return unitAuditingPracticeIdeaFlag;
	}
	public void setUnitAuditingPracticeIdeaFlag(int unitAuditingPracticeIdeaFlag) {
		this.unitAuditingPracticeIdeaFlag = unitAuditingPracticeIdeaFlag;
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
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getIdStay() {
		return idStay;
	}
	public void setIdStay(String idStay) {
		this.idStay = idStay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getHight() {
		return hight;
	}
	public void setHight(String hight) {
		this.hight = hight;
	}
	public int getResolvingPowerFlag() {
		return resolvingPowerFlag;
	}
	public void setResolvingPowerFlag(int resolvingPowerFlag) {
		this.resolvingPowerFlag = resolvingPowerFlag;
	}
	public String getRightEyePwoer() {
		return rightEyePwoer;
	}
	public void setRightEyePwoer(String rightEyePwoer) {
		this.rightEyePwoer = rightEyePwoer;
	}
	public int getRightEyeRectificationFlag() {
		return rightEyeRectificationFlag;
	}
	public void setRightEyeRectificationFlag(int rightEyeRectificationFlag) {
		this.rightEyeRectificationFlag = rightEyeRectificationFlag;
	}
	public String getLeftEyePwoer() {
		return leftEyePwoer;
	}
	public void setLeftEyePwoer(String leftEyePwoer) {
		this.leftEyePwoer = leftEyePwoer;
	}
	public int getLeftEyeRectificationFlag() {
		return leftEyeRectificationFlag;
	}
	public void setLeftEyeRectificationFlag(int leftEyeRectificationFlag) {
		this.leftEyeRectificationFlag = leftEyeRectificationFlag;
	}
	public int getRightEarPwoer() {
		return rightEarPwoer;
	}
	public void setRightEarPwoer(int rightEarPwoer) {
		this.rightEarPwoer = rightEarPwoer;
	}
	public int getLeftEarPwoer() {
		return leftEarPwoer;
	}
	public void setLeftEarPwoer(int leftEarPwoer) {
		this.leftEarPwoer = leftEarPwoer;
	}
	public int getRightHandFlag() {
		return rightHandFlag;
	}
	public void setRightHandFlag(int rightHandFlag) {
		this.rightHandFlag = rightHandFlag;
	}
	public int getLeftHandFlag() {
		return leftHandFlag;
	}
	public void setLeftHandFlag(int leftHandFlag) {
		this.leftHandFlag = leftHandFlag;
	}
	public int getRightLagFlag() {
		return rightLagFlag;
	}
	public void setRightLagFlag(int rightLagFlag) {
		this.rightLagFlag = rightLagFlag;
	}
	public int getLeftLagFlag() {
		return leftLagFlag;
	}
	public void setLeftLagFlag(int leftLagFlag) {
		this.leftLagFlag = leftLagFlag;
	}
	public int getBodyNeck() {
		return bodyNeck;
	}
	public void setBodyNeck(int bodyNeck) {
		this.bodyNeck = bodyNeck;
	}
	public Date getBodyCheckDate() {
		return bodyCheckDate;
	}
	public void setBodyCheckDate(Date bodyCheckDate) {
		this.bodyCheckDate = bodyCheckDate;
	}
	public int getCheckResultFlag() {
		return checkResultFlag;
	}
	public void setCheckResultFlag(int checkResultFlag) {
		this.checkResultFlag = checkResultFlag;
	}
	public String getCheckOrganization() {
		return checkOrganization;
	}
	public void setCheckOrganization(String checkOrganization) {
		this.checkOrganization = checkOrganization;
	}
	public String getCheckDoctor() {
		return checkDoctor;
	}
	public void setCheckDoctor(String checkDoctor) {
		this.checkDoctor = checkDoctor;
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
	public int getApplicationUserId() {
		return applicationUserId;
	}
	public void setApplicationUserId(int applicationUserId) {
		this.applicationUserId = applicationUserId;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public Date getDrivingLicenceFirst() {
		return drivingLicenceFirst;
	}
	public void setDrivingLicenceFirst(Date drivingLicenceFirst) {
		this.drivingLicenceFirst = drivingLicenceFirst;
	}
}
