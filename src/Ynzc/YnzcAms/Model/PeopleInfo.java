package Ynzc.YnzcAms.Model;
/**
 * 人员信息
 * @author zy
 * @date 2011-04-25
 * class PeopleInfo.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_peopleinfo")
public class PeopleInfo {
	private int id;//编号
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
	private int bodyInfoId;//身体状况信息Id
	private String year;//年度
	private int unitId;//单位Id
	private String regionId;//行政区划Id
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
	public int getBodyInfoId() {
		return bodyInfoId;
	}
	public void setBodyInfoId(int bodyInfoId) {
		this.bodyInfoId = bodyInfoId;
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
