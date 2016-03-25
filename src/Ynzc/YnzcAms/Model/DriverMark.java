package Ynzc.YnzcAms.Model;
/**
 * 驾照违章记录
 * @author zy
 * @date 2011-04-25
 * class DriverMark.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivermark")
public class DriverMark {
	private int id;//编号
	private int drivingLicenceId;//驾照Id
	private Date peccancyDate;//违章时间
	private String penaltyNo;//处罚No
	private int mark;//扣分
	private String tipstaff;//执法人员
	private String transactor;//经办人
	private Date transactorDate;//经办时间
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
	public int getDrivingLicenceId() {
		return drivingLicenceId;
	}
	public void setDrivingLicenceId(int drivingLicenceId) {
		this.drivingLicenceId = drivingLicenceId;
	}
	public Date getPeccancyDate() {
		return peccancyDate;
	}
	public void setPeccancyDate(Date peccancyDate) {
		this.peccancyDate = peccancyDate;
	}
	public String getPenaltyNo() {
		return penaltyNo;
	}
	public void setPenaltyNo(String penaltyNo) {
		this.penaltyNo = penaltyNo;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getTipstaff() {
		return tipstaff;
	}
	public void setTipstaff(String tipstaff) {
		this.tipstaff = tipstaff;
	}
	public String getTransactor() {
		return transactor;
	}
	public void setTransactor(String transactor) {
		this.transactor = transactor;
	}
	public Date getTransactorDate() {
		return transactorDate;
	}
	public void setTransactorDate(Date transactorDate) {
		this.transactorDate = transactorDate;
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
