package Ynzc.YnzcAms.Model;
/**
 * 学员视图
 * @author zy
 * @date 2011-05-05
 * class DriverStrInfoView.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_driverclassstr_view")
public class DriverClassStrView {
	private int id;//编号
	private int driverClassId;//班级Id
	private int driverStrInfoId;//学员Id
	private int peopleInfoId;//人员信息Id
	private int bodyInfoId;//身体信息Id
	private int theoryPermitFlag;//理论准考证
	private int practicePermitFlag;//实践准考证
	private String className;//班级名称
	private Date classDate;//开班时间
	private Date theoryExamDate;//理论考试时间
	private Date practiceExamDate;//实践考试时间
	private int classState;//班级状态
	private int declareFlag;//申报
	private Date declareDate;//申报时间
	private int classStrNum;//班级人数
	private String archivesNo;//档案号
	private String fosterType;//培养类型
	private String applicationFlag;//审查
	private String drivingLicenceTypeId;//申请型号
	private String applicationAddress;//申请地址
	private String examinationCode;//报考号
	private int strState;//学员状态
	private String pigeonholeFlag;//是否归档
	private Date pigeonholeDate;//归档时间
	private int theoryId;
	private int theoryFlag;
	private int practiceId;
	private int practiceFlag;
	private int theoryMakeUpNum;//理论补考次数
	private int practiceMakeUpNum;//技术补考次数
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
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	private int unitId;//单位Id
	private String regionId;//行政区划Id
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
	public int getDriverClassId() {
		return driverClassId;
	}
	public void setDriverClassId(int driverClassId) {
		this.driverClassId = driverClassId;
	}
	public int getDriverStrInfoId() {
		return driverStrInfoId;
	}
	public void setDriverStrInfoId(int driverStrInfoId) {
		this.driverStrInfoId = driverStrInfoId;
	}
	public int getTheoryPermitFlag() {
		return theoryPermitFlag;
	}
	public void setTheoryPermitFlag(int theoryPermitFlag) {
		this.theoryPermitFlag = theoryPermitFlag;
	}
	public int getPracticePermitFlag() {
		return practicePermitFlag;
	}
	public void setPracticePermitFlag(int practicePermitFlag) {
		this.practicePermitFlag = practicePermitFlag;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
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
	public String getApplicationFlag() {
		return applicationFlag;
	}
	public void setApplicationFlag(String applicationFlag) {
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
	public String getPigeonholeFlag() {
		return pigeonholeFlag;
	}
	public void setPigeonholeFlag(String pigeonholeFlag) {
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
	public int getTheoryMakeUpNum() {
		return theoryMakeUpNum;
	}
	public void setTheoryMakeUpNum(int theoryMakeUpNum) {
		this.theoryMakeUpNum = theoryMakeUpNum;
	}
	public int getPracticeMakeUpNum() {
		return practiceMakeUpNum;
	}
	public void setPracticeMakeUpNum(int practiceMakeUpNum) {
		this.practiceMakeUpNum = practiceMakeUpNum;
	}
}
