package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ynzc_uiteharvesterrepair_view")
public class UniteharvesterRepairView {
	private int id;
	private String harvesterCode;
	private String harvesterOwner;
	private String harvesterGuanXiaDi;
	private String telephoneNum;
	private String liveAddress;
	private String livePostCode;
	private String tempAddress;
	private String tempPostCode;
	private int certitype;
	private String certiCode;
	private int liveType;
	private String liveCode;
	private int harvesterType;
	private String harvesterGetWay;
	private String harvesterChangPaiType;
	private int harvesterQuality;
	private int harvesterSitNum;
	private String harvesterEngineCode;
	private String harvesterBodyColor;
	private String harvesterBodyCode;
	private String comeProofType;
	private String importType;
	private String otherType;
	private int applicationType;
	private String harvesterPhotoUrl;
	private Date registerDate;
	private String registerMan;
	private String unitid;
	private int harvesterState;
	private int repairid;
	private int repairPapes;
	private String repairWhy;
	private String repairType;
	private int repairApplicationtype;
	private String repairRegisterman;
	private Date repairRegistdate;
	private String repairNote;
	private String platecode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHarvesterCode() {
		return harvesterCode;
	}
	public void setHarvesterCode(String harvesterCode) {
		this.harvesterCode = harvesterCode;
	}
	public String getHarvesterOwner() {
		return harvesterOwner;
	}
	public void setHarvesterOwner(String harvesterOwner) {
		this.harvesterOwner = harvesterOwner;
	}
	public String getHarvesterGuanXiaDi() {
		return harvesterGuanXiaDi;
	}
	public void setHarvesterGuanXiaDi(String harvesterGuanXiaDi) {
		this.harvesterGuanXiaDi = harvesterGuanXiaDi;
	}
	public String getTelephoneNum() {
		return telephoneNum;
	}
	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getLivePostCode() {
		return livePostCode;
	}
	public void setLivePostCode(String livePostCode) {
		this.livePostCode = livePostCode;
	}
	public String getTempAddress() {
		return tempAddress;
	}
	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}
	public String getTempPostCode() {
		return tempPostCode;
	}
	public void setTempPostCode(String tempPostCode) {
		this.tempPostCode = tempPostCode;
	}
	public int getCertitype() {
		return certitype;
	}
	public void setCertitype(int certitype) {
		this.certitype = certitype;
	}
	public String getCertiCode() {
		return certiCode;
	}
	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}
	public int getLiveType() {
		return liveType;
	}
	public void setLiveType(int liveType) {
		this.liveType = liveType;
	}
	public String getLiveCode() {
		return liveCode;
	}
	public void setLiveCode(String liveCode) {
		this.liveCode = liveCode;
	}
	public int getHarvesterType() {
		return harvesterType;
	}
	public void setHarvesterType(int harvesterType) {
		this.harvesterType = harvesterType;
	}
	public String getHarvesterGetWay() {
		return harvesterGetWay;
	}
	public void setHarvesterGetWay(String harvesterGetWay) {
		this.harvesterGetWay = harvesterGetWay;
	}
	public String getHarvesterChangPaiType() {
		return harvesterChangPaiType;
	}
	public void setHarvesterChangPaiType(String harvesterChangPaiType) {
		this.harvesterChangPaiType = harvesterChangPaiType;
	}
	public int getHarvesterQuality() {
		return harvesterQuality;
	}
	public void setHarvesterQuality(int harvesterQuality) {
		this.harvesterQuality = harvesterQuality;
	}
	public int getHarvesterSitNum() {
		return harvesterSitNum;
	}
	public void setHarvesterSitNum(int harvesterSitNum) {
		this.harvesterSitNum = harvesterSitNum;
	}
	public String getHarvesterEngineCode() {
		return harvesterEngineCode;
	}
	public void setHarvesterEngineCode(String harvesterEngineCode) {
		this.harvesterEngineCode = harvesterEngineCode;
	}
	public String getHarvesterBodyColor() {
		return harvesterBodyColor;
	}
	public void setHarvesterBodyColor(String harvesterBodyColor) {
		this.harvesterBodyColor = harvesterBodyColor;
	}
	public String getHarvesterBodyCode() {
		return harvesterBodyCode;
	}
	public void setHarvesterBodyCode(String harvesterBodyCode) {
		this.harvesterBodyCode = harvesterBodyCode;
	}
	public String getComeProofType() {
		return comeProofType;
	}
	public void setComeProofType(String comeProofType) {
		this.comeProofType = comeProofType;
	}
	public String getImportType() {
		return importType;
	}
	public void setImportType(String importType) {
		this.importType = importType;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public int getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(int applicationType) {
		this.applicationType = applicationType;
	}
	public String getHarvesterPhotoUrl() {
		return harvesterPhotoUrl;
	}
	public void setHarvesterPhotoUrl(String harvesterPhotoUrl) {
		this.harvesterPhotoUrl = harvesterPhotoUrl;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getRegisterMan() {
		return registerMan;
	}
	public void setRegisterMan(String registerMan) {
		this.registerMan = registerMan;
	}
	public String getUnitid() {
		return unitid;
	}
	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}
	public int getHarvesterState() {
		return harvesterState;
	}
	public void setHarvesterState(int harvesterState) {
		this.harvesterState = harvesterState;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getRepairid() {
		return repairid;
	}
	public void setRepairid(int repairid) {
		this.repairid = repairid;
	}
	public int getRepairPapes() {
		return repairPapes;
	}
	public void setRepairPapes(int repairPapes) {
		this.repairPapes = repairPapes;
	}
	public String getRepairWhy() {
		return repairWhy;
	}
	public void setRepairWhy(String repairWhy) {
		this.repairWhy = repairWhy;
	}
	public String getRepairType() {
		return repairType;
	}
	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}
	public int getRepairApplicationtype() {
		return repairApplicationtype;
	}
	public void setRepairApplicationtype(int repairApplicationtype) {
		this.repairApplicationtype = repairApplicationtype;
	}
	public String getRepairRegisterman() {
		return repairRegisterman;
	}
	public void setRepairRegisterman(String repairRegisterman) {
		this.repairRegisterman = repairRegisterman;
	}
	public Date getRepairRegistdate() {
		return repairRegistdate;
	}
	public void setRepairRegistdate(Date repairRegistdate) {
		this.repairRegistdate = repairRegistdate;
	}
	public String getRepairNote() {
		return repairNote;
	}
	public void setRepairNote(String repairNote) {
		this.repairNote = repairNote;
	}
	public String getPlatecode() {
		return platecode;
	}
	public void setPlatecode(String platecode) {
		this.platecode = platecode;
	}
}
