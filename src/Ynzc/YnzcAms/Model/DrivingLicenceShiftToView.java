package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivinglicenceshiftto_view")
public class DrivingLicenceShiftToView {
	private int id;//编号
	private int operationNameType;//业务名称
	private int drivingLicenceId;//驾照Id
	private int peopleInfoId;//人员Id
	private String causation;//原因
	private int proveType;//证明类型
	private String proveId;//证明身份Id
	private String shiftToAddress;//转出地址
	private String registerTransactor;//登记经办人
	private Date registerTransactorDate;//登记经办日期
	private String auditingTransactor;//审核经办人
	private Date auditingTransactorDate;//审核经办日期
	private String putOutTransactor;//打印经办人
	private Date putOutTransactorDate;//打印经办日期
	private String pigeonholeTransactor;//归档经办人
	private Date pigeonholeTransactorDate;//归档经办日期
	private int auditingShiftToFlag;//转出审核
	private Date auditingShiftToDate;//转出审核日期
	private String year;//年度
	private int state;//状态
	private int pigeonholeFlag;//是否归档
	private String pigeonholeDate;//归档时间
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private String writeUserId;//录入人
	private Date writeDate;//录入时间
	
	private String drivingLicenceNo;//驾驶号
	private int drivingLicenceTypeId;//驾照类型
	private int mark;//分数
	private Date startDate;//开始日期
	private Date endDate;//结束日期
	private int drivingLicenceFlag;//是否打印
	private Date putOutDate;//打印日期
	private int userState;//使用状态
	
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
	private String resolvingPowerFlag;//辨色力
	private String rightEyePwoer;//右眼视力
	private String rightEyeRectificationFlag;//右眼矫正
	private String leftEyePwoer;//左眼视力
	private String leftEyeRectificationFlag;//左眼矫正
	private String rightEarPwoer;//右耳听力
	private String leftEarPwoer;//左耳听力
	private String rightHandFlag;//右手
	private String leftHandFlag;//左手
	private String rightLagFlag;//右脚
	private String leftLagFlag;//左脚
	private String bodyNeck;//身体和颈椎
	private Date bodyCheckDate;//身体检查时间
	private String checkResultFlag;//检查结果
	private String checkOrganization;//检查机构
	private String checkDoctor;//检查医生
	
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
	public int getOperationNameType() {
		return operationNameType;
	}
	public void setOperationNameType(int operationNameType) {
		this.operationNameType = operationNameType;
	}
	public int getDrivingLicenceId() {
		return drivingLicenceId;
	}
	public void setDrivingLicenceId(int drivingLicenceId) {
		this.drivingLicenceId = drivingLicenceId;
	}
	public int getProveType() {
		return proveType;
	}
	public void setProveType(int proveType) {
		this.proveType = proveType;
	}
	public String getProveId() {
		return proveId;
	}
	public void setProveId(String proveId) {
		this.proveId = proveId;
	}
	public String getRegisterTransactor() {
		return registerTransactor;
	}
	public void setRegisterTransactor(String registerTransactor) {
		this.registerTransactor = registerTransactor;
	}
	public Date getRegisterTransactorDate() {
		return registerTransactorDate;
	}
	public void setRegisterTransactorDate(Date registerTransactorDate) {
		this.registerTransactorDate = registerTransactorDate;
	}
	public String getAuditingTransactor() {
		return auditingTransactor;
	}
	public void setAuditingTransactor(String auditingTransactor) {
		this.auditingTransactor = auditingTransactor;
	}
	public Date getAuditingTransactorDate() {
		return auditingTransactorDate;
	}
	public void setAuditingTransactorDate(Date auditingTransactorDate) {
		this.auditingTransactorDate = auditingTransactorDate;
	}
	public String getPutOutTransactor() {
		return putOutTransactor;
	}
	public void setPutOutTransactor(String putOutTransactor) {
		this.putOutTransactor = putOutTransactor;
	}
	public Date getPutOutTransactorDate() {
		return putOutTransactorDate;
	}
	public void setPutOutTransactorDate(Date putOutTransactorDate) {
		this.putOutTransactorDate = putOutTransactorDate;
	}
	public String getPigeonholeTransactor() {
		return pigeonholeTransactor;
	}
	public void setPigeonholeTransactor(String pigeonholeTransactor) {
		this.pigeonholeTransactor = pigeonholeTransactor;
	}
	public Date getPigeonholeTransactorDate() {
		return pigeonholeTransactorDate;
	}
	public void setPigeonholeTransactorDate(Date pigeonholeTransactorDate) {
		this.pigeonholeTransactorDate = pigeonholeTransactorDate;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getPigeonholeFlag() {
		return pigeonholeFlag;
	}
	public void setPigeonholeFlag(int pigeonholeFlag) {
		this.pigeonholeFlag = pigeonholeFlag;
	}
	public String getCausation() {
		return causation;
	}
	public void setCausation(String causation) {
		this.causation = causation;
	}
	public String getShiftToAddress() {
		return shiftToAddress;
	}
	public void setShiftToAddress(String shiftToAddress) {
		this.shiftToAddress = shiftToAddress;
	}
	public int getAuditingShiftToFlag() {
		return auditingShiftToFlag;
	}
	public void setAuditingShiftToFlag(int auditingShiftToFlag) {
		this.auditingShiftToFlag = auditingShiftToFlag;
	}
	public Date getAuditingShiftToDate() {
		return auditingShiftToDate;
	}
	public void setAuditingShiftToDate(Date auditingShiftToDate) {
		this.auditingShiftToDate = auditingShiftToDate;
	}
	public String getPigeonholeDate() {
		return pigeonholeDate;
	}
	public void setPigeonholeDate(String pigeonholeDate) {
		this.pigeonholeDate = pigeonholeDate;
	}
	public String getWriteUserId() {
		return writeUserId;
	}
	public void setWriteUserId(String writeUserId) {
		this.writeUserId = writeUserId;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}
	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}
	public int getDrivingLicenceTypeId() {
		return drivingLicenceTypeId;
	}
	public void setDrivingLicenceTypeId(int drivingLicenceTypeId) {
		this.drivingLicenceTypeId = drivingLicenceTypeId;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getDrivingLicenceFlag() {
		return drivingLicenceFlag;
	}
	public void setDrivingLicenceFlag(int drivingLicenceFlag) {
		this.drivingLicenceFlag = drivingLicenceFlag;
	}
	public Date getPutOutDate() {
		return putOutDate;
	}
	public void setPutOutDate(Date putOutDate) {
		this.putOutDate = putOutDate;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
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
	public String getResolvingPowerFlag() {
		return resolvingPowerFlag;
	}
	public void setResolvingPowerFlag(String resolvingPowerFlag) {
		this.resolvingPowerFlag = resolvingPowerFlag;
	}
	public String getRightEyePwoer() {
		return rightEyePwoer;
	}
	public void setRightEyePwoer(String rightEyePwoer) {
		this.rightEyePwoer = rightEyePwoer;
	}
	public String getRightEyeRectificationFlag() {
		return rightEyeRectificationFlag;
	}
	public void setRightEyeRectificationFlag(String rightEyeRectificationFlag) {
		this.rightEyeRectificationFlag = rightEyeRectificationFlag;
	}
	public String getLeftEyePwoer() {
		return leftEyePwoer;
	}
	public void setLeftEyePwoer(String leftEyePwoer) {
		this.leftEyePwoer = leftEyePwoer;
	}
	public String getLeftEyeRectificationFlag() {
		return leftEyeRectificationFlag;
	}
	public void setLeftEyeRectificationFlag(String leftEyeRectificationFlag) {
		this.leftEyeRectificationFlag = leftEyeRectificationFlag;
	}
	public String getRightEarPwoer() {
		return rightEarPwoer;
	}
	public void setRightEarPwoer(String rightEarPwoer) {
		this.rightEarPwoer = rightEarPwoer;
	}
	public String getLeftEarPwoer() {
		return leftEarPwoer;
	}
	public void setLeftEarPwoer(String leftEarPwoer) {
		this.leftEarPwoer = leftEarPwoer;
	}
	public String getRightHandFlag() {
		return rightHandFlag;
	}
	public void setRightHandFlag(String rightHandFlag) {
		this.rightHandFlag = rightHandFlag;
	}
	public String getLeftHandFlag() {
		return leftHandFlag;
	}
	public void setLeftHandFlag(String leftHandFlag) {
		this.leftHandFlag = leftHandFlag;
	}
	public String getRightLagFlag() {
		return rightLagFlag;
	}
	public void setRightLagFlag(String rightLagFlag) {
		this.rightLagFlag = rightLagFlag;
	}
	public String getLeftLagFlag() {
		return leftLagFlag;
	}
	public void setLeftLagFlag(String leftLagFlag) {
		this.leftLagFlag = leftLagFlag;
	}
	public String getBodyNeck() {
		return bodyNeck;
	}
	public void setBodyNeck(String bodyNeck) {
		this.bodyNeck = bodyNeck;
	}
	public Date getBodyCheckDate() {
		return bodyCheckDate;
	}
	public void setBodyCheckDate(Date bodyCheckDate) {
		this.bodyCheckDate = bodyCheckDate;
	}
	public String getCheckResultFlag() {
		return checkResultFlag;
	}
	public void setCheckResultFlag(String checkResultFlag) {
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
}
