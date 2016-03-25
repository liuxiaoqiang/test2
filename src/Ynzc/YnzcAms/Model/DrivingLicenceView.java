package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivinglicence_view")
public class DrivingLicenceView {
	private int id;//编号
	private int peopleInfoId;//人员Id
	private int bodyInfoId;//身体信息Id
	private String drivingLicenceNo;//驾驶号
	private String drivingLicenceTypeId;//驾照类型
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}
	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}
	public String getDrivingLicenceTypeId() {
		return drivingLicenceTypeId;
	}
	public void setDrivingLicenceTypeId(String drivingLicenceTypeId) {
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
}
