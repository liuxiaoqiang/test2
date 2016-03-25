package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivertrainingcheck")
public class DrivertrainingCheckInfo {
	private int id;
	private int DrivertrainingId;//教练车id
	private String checkResult;
	private String CheckMan;
	private Date checkDate;
	private String ChangeRecord;
	private Date checkLiveDate;
	private String insurceType;
	private int InsurceMark;
	private String EnteyMan;
	private Date EntryDate;
	private String checkUnitName;
	private String insurceCode;
	private String InsurceName;
	private Date InsurceDate;
	private Date InsurceActiveDate;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDrivertrainingId() {
		return DrivertrainingId;
	}
	public void setDrivertrainingId(int drivertrainingId) {
		DrivertrainingId = drivertrainingId;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getCheckMan() {
		return CheckMan;
	}
	public void setCheckMan(String checkMan) {
		CheckMan = checkMan;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public String getChangeRecord() {
		return ChangeRecord;
	}
	public void setChangeRecord(String changeRecord) {
		ChangeRecord = changeRecord;
	}
	public String getInsurceType() {
		return insurceType;
	}
	public void setInsurceType(String insurceType) {
		this.insurceType = insurceType;
	}
	public int getInsurceMark() {
		return InsurceMark;
	}
	public void setInsurceMark(int insurceMark) {
		InsurceMark = insurceMark;
	}
	public Date getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(Date entryDate) {
		EntryDate = entryDate;
	}
	public String getCheckUnitName() {
		return checkUnitName;
	}
	public void setCheckUnitName(String checkUnitName) {
		this.checkUnitName = checkUnitName;
	}
	public String getInsurceCode() {
		return insurceCode;
	}
	public void setInsurceCode(String insurceCode) {
		this.insurceCode = insurceCode;
	}
	public String getInsurceName() {
		return InsurceName;
	}
	public void setInsurceName(String insurceName) {
		InsurceName = insurceName;
	}
	public Date getInsurceDate() {
		return InsurceDate;
	}
	public void setInsurceDate(Date insurceDate) {
		InsurceDate = insurceDate;
	}
	public Date getInsurceActiveDate() {
		return InsurceActiveDate;
	}
	public void setInsurceActiveDate(Date insurceActiveDate) {
		InsurceActiveDate = insurceActiveDate;
	}
	public Date getCheckLiveDate() {
		return checkLiveDate;
	}
	public void setCheckLiveDate(Date checkLiveDate) {
		this.checkLiveDate = checkLiveDate;
	}
	public String getEnteyMan() {
		return EnteyMan;
	}
	public void setEnteyMan(String enteyMan) {
		EnteyMan = enteyMan;
	}
}
