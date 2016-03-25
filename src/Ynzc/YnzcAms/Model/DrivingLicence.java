package Ynzc.YnzcAms.Model;
/**
 * 驾照
 * @author zy
 * @date 2011-04-25
 * class DrivingLicence.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ynzc_drivinglicence")
public class DrivingLicence {
	private int id;//编号
	private int peopleInfoId;//人员Id
	private String drivingLicenceNo;//驾驶号
	private int drivingLicenceTypeId;//驾照类型
	private int mark;//分数
	private Date startDate;//开始日期
	private Date endDate;//结束日期
	private int drivingLicenceFlag;//是否打印
	private Date putOutDate;//打印日期
	private int userState;//使用状态
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	private String year;//年度
	
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
	public Date getPutOutDate() {
		return putOutDate;
	}
	public void setPutOutDate(Date putOutDate) {
		this.putOutDate = putOutDate;
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
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	public int getDrivingLicenceFlag() {
		return drivingLicenceFlag;
	}
	public void setDrivingLicenceFlag(int drivingLicenceFlag) {
		this.drivingLicenceFlag = drivingLicenceFlag;
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
