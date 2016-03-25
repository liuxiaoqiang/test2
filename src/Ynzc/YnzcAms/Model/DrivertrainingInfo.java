package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivertraining")
public class DrivertrainingInfo {
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
	private int unitid;
	private int carType;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}
}
