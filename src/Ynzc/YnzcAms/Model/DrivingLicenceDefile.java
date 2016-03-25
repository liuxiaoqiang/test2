package Ynzc.YnzcAms.Model;
/**
 * 污损换证
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceDefile.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivinglicencedefile")
public class DrivingLicenceDefile {
	private int id;//编号
	private int operationNameType;//业务名称
	private int drivingLicenceId;//驾照Id
	private String causation;//原因
	private int proveType;//证明类型
	private String proveId;//证明身份Id
	private int auditingDefileFlag;//污损审核
	private Date auditingDefileDate;//污损审核日期
	private String registerTransactor;//登记经办人
	private Date registerTransactorDate;//登记经办日期
	private String auditingTransactor;//审核经办人
	private Date auditingTransactorDate;//审核经办日期
	private String putOutTransactor;//打印经办人
	private Date putOutTransactorDate;//打印经办日期
	private String pigeonholeTransactor;//归档经办人
	private Date pigeonholeTransactorDate;//归档经办日期
	private String year;//年度
	private int state;//状态
	private int pigeonholeFlag;//是否归档
	private Date pigeonholeDate;//归档时间
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
	public String getCausation() {
		return causation;
	}
	public void setCausation(String causation) {
		this.causation = causation;
	}
	public int getAuditingDefileFlag() {
		return auditingDefileFlag;
	}
	public void setAuditingDefileFlag(int auditingDefileFlag) {
		this.auditingDefileFlag = auditingDefileFlag;
	}
	public Date getAuditingDefileDate() {
		return auditingDefileDate;
	}
	public void setAuditingDefileDate(Date auditingDefileDate) {
		this.auditingDefileDate = auditingDefileDate;
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
	public Date getPigeonholeDate() {
		return pigeonholeDate;
	}
	public void setPigeonholeDate(Date pigeonholeDate) {
		this.pigeonholeDate = pigeonholeDate;
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
