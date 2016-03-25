package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_settime")
public class SetTime {
	private int id;//编号
	private int carRegisterTime;//拖拉机注册登记审核时间，以分钟计时,初始值为0分钟
	private int carCheckTime;//拖拉机年度检验审核时间，以分钟计时,初始值为0分钟
	private int carChangeTime;//拖拉机变更登记审核时间，以分钟计时,初始值为0分钟
	private int carTransferTime;//拖拉机转移登记审核时间，以分钟计时,初始值为0分钟
	private int carReplaceTime;//拖拉机补领、补换牌证审核时间，以分钟计时,初始值为0分钟
	private int carModifyRecordTime;//拖拉机变更备案登记审核时间，以分钟计时,初始值为0分钟
	private int carMortgageTime;//拖拉机抵押登记审核时间，以分钟计时,初始值为0分钟
	private int carLogoutTime;//拖拉机注销登记审核时间，以分钟计时,初始值为0分钟
	private int licenseChangeTime;//驾照变更审核时间，以分钟计时,初始值为0分钟
	private int licenseEndTime;//驾照期满审核时间，以分钟计时,初始值为0分钟
	private int licenseDefaceTime;//驾照污损审核时间，以分钟计时,初始值为0分钟
	private int licenseReplaceTime;//驾照补证审核时间，以分钟计时,初始值为0分钟
	private int licenseInTime;//驾照转入审核时间，以分钟计时,初始值为0分钟
	private int licenseOutTime;//驾照转出审核时间，以分钟计时,初始值为0分钟
	private int licenseLogoutTime;//驾照注销审核时间，以分钟计时,初始值为0分钟
	private int unitid;//监理单位id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCarRegisterTime() {
		return carRegisterTime;
	}
	public void setCarRegisterTime(int carRegisterTime) {
		this.carRegisterTime = carRegisterTime;
	}
	public int getCarCheckTime() {
		return carCheckTime;
	}
	public void setCarCheckTime(int carCheckTime) {
		this.carCheckTime = carCheckTime;
	}
	public int getCarChangeTime() {
		return carChangeTime;
	}
	public void setCarChangeTime(int carChangeTime) {
		this.carChangeTime = carChangeTime;
	}
	public int getCarTransferTime() {
		return carTransferTime;
	}
	public void setCarTransferTime(int carTransferTime) {
		this.carTransferTime = carTransferTime;
	}
	public int getCarReplaceTime() {
		return carReplaceTime;
	}
	public void setCarReplaceTime(int carReplaceTime) {
		this.carReplaceTime = carReplaceTime;
	}
	public int getCarModifyRecordTime() {
		return carModifyRecordTime;
	}
	public void setCarModifyRecordTime(int carModifyRecordTime) {
		this.carModifyRecordTime = carModifyRecordTime;
	}
	public int getCarMortgageTime() {
		return carMortgageTime;
	}
	public void setCarMortgageTime(int carMortgageTime) {
		this.carMortgageTime = carMortgageTime;
	}
	public int getCarLogoutTime() {
		return carLogoutTime;
	}
	public void setCarLogoutTime(int carLogoutTime) {
		this.carLogoutTime = carLogoutTime;
	}
	public int getLicenseChangeTime() {
		return licenseChangeTime;
	}
	public void setLicenseChangeTime(int licenseChangeTime) {
		this.licenseChangeTime = licenseChangeTime;
	}
	public int getLicenseEndTime() {
		return licenseEndTime;
	}
	public void setLicenseEndTime(int licenseEndTime) {
		this.licenseEndTime = licenseEndTime;
	}
	public int getLicenseDefaceTime() {
		return licenseDefaceTime;
	}
	public void setLicenseDefaceTime(int licenseDefaceTime) {
		this.licenseDefaceTime = licenseDefaceTime;
	}
	public int getLicenseReplaceTime() {
		return licenseReplaceTime;
	}
	public void setLicenseReplaceTime(int licenseReplaceTime) {
		this.licenseReplaceTime = licenseReplaceTime;
	}
	public int getLicenseInTime() {
		return licenseInTime;
	}
	public void setLicenseInTime(int licenseInTime) {
		this.licenseInTime = licenseInTime;
	}
	public int getLicenseOutTime() {
		return licenseOutTime;
	}
	public void setLicenseOutTime(int licenseOutTime) {
		this.licenseOutTime = licenseOutTime;
	}
	public int getLicenseLogoutTime() {
		return licenseLogoutTime;
	}
	public void setLicenseLogoutTime(int licenseLogoutTime) {
		this.licenseLogoutTime = licenseLogoutTime;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
}
