package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivertraining_info_view")
public class DrivertrainingInfoView {
	private int id;
	private int tractorinfoId;
	private String UnitName;
	private String UnitAddress;
	private String UnitCode;
	private String Telephone;
	private String postCode;
	private String CardCode;
	private String tractorinfoIdCode;
	private String LetterCode;
	private String AuditOption;
	private Date auditDate;
	private String agentMan;
	private Date agentDate;
	private String Owner;
	private Date ApplicationTime;
	private String unitid;
	private String carType;
	
	private int drivingcheckid;
	private String checkResult;
	private String CheckMan;
	private Date checkDate;
	private Date checkLiveDate;
	private String ChangeRecord;
	private String insurceType;
	private int InsurceMark;
	private String EnteyMan;
	private Date EntryDate;
	private String checkUnitName;
	private String insurceCode;
	private String InsurceName;
	private Date InsurceDate;
	private Date InsurceActiveDate;
	private String platecode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTractorinfoId() {
		return tractorinfoId;
	}
	public void setTractorinfoId(int tractorinfoId) {
		this.tractorinfoId = tractorinfoId;
	}
	public String getUnitName() {
		return UnitName;
	}
	public void setUnitName(String unitName) {
		UnitName = unitName;
	}
	public String getUnitAddress() {
		return UnitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		UnitAddress = unitAddress;
	}
	public String getUnitCode() {
		return UnitCode;
	}
	public void setUnitCode(String unitCode) {
		UnitCode = unitCode;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCardCode() {
		return CardCode;
	}
	public void setCardCode(String cardCode) {
		CardCode = cardCode;
	}
	public String getTractorinfoIdCode() {
		return tractorinfoIdCode;
	}
	public void setTractorinfoIdCode(String tractorinfoIdCode) {
		this.tractorinfoIdCode = tractorinfoIdCode;
	}
	public String getLetterCode() {
		return LetterCode;
	}
	public void setLetterCode(String letterCode) {
		LetterCode = letterCode;
	}
	public String getAuditOption() {
		return AuditOption;
	}
	public void setAuditOption(String auditOption) {
		AuditOption = auditOption;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getAgentMan() {
		return agentMan;
	}
	public void setAgentMan(String agentMan) {
		this.agentMan = agentMan;
	}
	public Date getAgentDate() {
		return agentDate;
	}
	public void setAgentDate(Date agentDate) {
		this.agentDate = agentDate;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public Date getApplicationTime() {
		return ApplicationTime;
	}
	public void setApplicationTime(Date applicationTime) {
		ApplicationTime = applicationTime;
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
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getDrivingcheckid() {
		return drivingcheckid;
	}
	public void setDrivingcheckid(int drivingcheckid) {
		this.drivingcheckid = drivingcheckid;
	}
	public String getPlatecode() {
		return platecode;
	}
	public void setPlatecode(String platecode) {
		this.platecode = platecode;
	}
	public String getUnitid() {
		return unitid;
	}
	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
}
