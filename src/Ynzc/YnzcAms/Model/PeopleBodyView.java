package Ynzc.YnzcAms.Model;
/**
 * 人员视图
 * @author zy
 * @date 2011-05-05
 * class PeopleBodyView.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_peoplebody_view")
public class PeopleBodyView {
	private int id;//人员Id
	private int peopleInfoId;//人员信息Id
	private int bodyInfoId;//身体信息Id
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
}
