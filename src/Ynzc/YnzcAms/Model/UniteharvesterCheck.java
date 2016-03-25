package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ynzc_uniteharvestercheck")
public class UniteharvesterCheck {
	private int id;
	private int harvesterId;
	private String checkResult;
	private Date checkDate;
	private Date checkLiveDate;
	private String checkman;
	private String checkUnitName;
	private String insuranceCode;
	private Date insurancedate;
	private Date insuranceLivedate;
	private String insuranceName;
	private String checkRegisterMan;
	private Date checkRegisterdate;
	private String checkPaizhengMan;
	private Date checkPaizhengDate;
	private String checkLingDaoMan;
	private Date checkLingDaodate;
	private int insuranceType;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHarvesterId() {
		return harvesterId;
	}
	public void setHarvesterId(int harvesterId) {
		this.harvesterId = harvesterId;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Date getCheckLiveDate() {
		return checkLiveDate;
	}
	public void setCheckLiveDate(Date checkLiveDate) {
		this.checkLiveDate = checkLiveDate;
	}
	public String getCheckman() {
		return checkman;
	}
	public void setCheckman(String checkman) {
		this.checkman = checkman;
	}
	public String getCheckUnitName() {
		return checkUnitName;
	}
	public void setCheckUnitName(String checkUnitName) {
		this.checkUnitName = checkUnitName;
	}
	public String getInsuranceCode() {
		return insuranceCode;
	}
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}
	public Date getInsurancedate() {
		return insurancedate;
	}
	public void setInsurancedate(Date insurancedate) {
		this.insurancedate = insurancedate;
	}
	public Date getInsuranceLivedate() {
		return insuranceLivedate;
	}
	public void setInsuranceLivedate(Date insuranceLivedate) {
		this.insuranceLivedate = insuranceLivedate;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getCheckRegisterMan() {
		return checkRegisterMan;
	}
	public void setCheckRegisterMan(String checkRegisterMan) {
		this.checkRegisterMan = checkRegisterMan;
	}
	public Date getCheckRegisterdate() {
		return checkRegisterdate;
	}
	public void setCheckRegisterdate(Date checkRegisterdate) {
		this.checkRegisterdate = checkRegisterdate;
	}
	public String getCheckPaizhengMan() {
		return checkPaizhengMan;
	}
	public void setCheckPaizhengMan(String checkPaizhengMan) {
		this.checkPaizhengMan = checkPaizhengMan;
	}
	public Date getCheckPaizhengDate() {
		return checkPaizhengDate;
	}
	public void setCheckPaizhengDate(Date checkPaizhengDate) {
		this.checkPaizhengDate = checkPaizhengDate;
	}
	public String getCheckLingDaoMan() {
		return checkLingDaoMan;
	}
	public void setCheckLingDaoMan(String checkLingDaoMan) {
		this.checkLingDaoMan = checkLingDaoMan;
	}
	public Date getCheckLingDaodate() {
		return checkLingDaodate;
	}
	public void setCheckLingDaodate(Date checkLingDaodate) {
		this.checkLingDaodate = checkLingDaodate;
	}
	public int getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(int insuranceType) {
		this.insuranceType = insuranceType;
	}
}
