package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
@Entity
@Table(name = "ynzc_tractorinfo_view")
public class TractorInfoView {
	private int id;
	private int  unitid;
	private String license;
	private Date checkeddate;
	private String recorder;
	private int status;
	private String regcerno;
	private Date tractorinforegisterdate;
	private int filing;
	private Date filingDate;
	private String changeType;
	
	//private int ownerinfoid;
	private int ownerinfoid;
	private String owner;
	private int realcertificatetypeid;
//	private String realcertificatetypeid;
	private String realcertificateno;
	private String address;
	private String tempaddress;
    private int istemplived;
//	private String istemplived;
    private int templivefiletypeid;
//	private String  templivefiletypeid;
    private String timplivefileno;
    private String telephone;
    private int isUnion;
//    private String isUnion;
    private String zipCode;
	
    private int technicalinspectid;
	private String checkresult;
	private Date checkexpirydate;
	private String inspector;
	private Date checkdate;
	private String disqualification; 
    private String showinitialinspectionresult;
    private String showdisqualification;
    private String showexaminationresult;
    private String engineinitialinspectionresult;
    private String enginedisqualification;
    private String engineexaminationresult;
    private String conveyorinitialinspectionresult;
    private String conveyordisqualification;
    private String conveyorexaminationresult;
    private String steeringinitialinspectionresult;
    private String steeringdisqualification;
    private String steeringexaminationresult;
    private String flyhostinitialinspectionresult;
    private String flyhostdisqualification;
    private String flyhostexaminationresult;
    private String flytrailerinitialinspectionresult;
    private String flytrailerdisqualification;
    private String flytrailerexaminationresult;
    private String brakhostinitialinspectionresult;
    private String brakhostdisqualification;
    private String brakhostexaminationresult;
    private String braktrailerinitialinspectionresult;
    private String braktrailerdisqualification;
    private String braktrailerexaminationresult;
    private String lighthostinitialinspectionresult;
    private String lighthostdisqualification;
    private String lighthostexaminationresult;
    private String lighttrailerinitialinspectionresult;
    private String lighttrailerdisqualification;
    private String lighttrailerexaminationresult;    
    private String tractioninitialinspectionresult;
    private String tractiondisqualification;
    private String tractionexaminationresult;
	
	private int handlingsituationid;
	private String reviewer;
	private Date reviewerconductdate;
	private String issueadmin;
	private String leaderreview;
	private Date leaderreviewconductdate;
	private Date issueadmindate;
	
	private int tractorbasicinfoid;
	private int getwayid;
//	private String getwayid;
	private int machinetypeid;
//	private String machinetypeid;
	private int machinebrandtypeid;
//	private String machinebrandtypeid;
	private String machinebodyno;
	private String engineno;
	private String shelfno;
	private String usedfor;
	private String manufacturer;
	private String seller;
	private Date manufacturedate;
	private String price;
	private String photourl;
	
	private int relationinfoid;
	public int getwayfiletypeid;
//	public String getwayfiletypeid;
	public String getwayfileno;
	public int importsfiletypeid;
//	public String importsfiletypeid;
	public String importsfileno;
	public String other;
	public String insurancelistno;
	public String insurancecompanyname;
	public Date insurancedate;
	public Date expirydate;
	
	private int registerinfoid;
	public Date registerdate;
	private Date turnindate;
	public Date issuedate;
	public String beforeregion;
	
	private int technicalparametersid;
	public String machinebodycolor;
	public String directcontrol;
	public int enginebrandid;
	public int fueltypeid;
	public int tiresno;
	public int totalquality;
	public int allowdragtotalquality;
	public int vicecartiresno;
//	public String enginebrandid;
//	public String fueltypeid;
//	public String tiresno;
//	public String totalquality;
//	public String allowdragtotalquality;
//	public String vicecartiresno;
	public String outsize;
	public String containersize;
	public String power;
	public int cylinderno;
	public int wheelno;	
//	public String cylinderno;
//	public String wheelno;
	public String tiressize;
	public int allquality;
	public int driverinno;
//	public String allquality;
//	public String driverinno;
	public String outcarwheeldis;
	public String wheelbase;
	public String wheeldis;
	public int ratifiedload;
	public int steelspring;
//	public String ratifiedload;
//	public String steelspring;
	public String outcartiressize;
	
	private String region;
	private String regionid;
	private String useunit;
	private String responsiblemen;
	private String linktel;
	private String unitaddress;
	private String unitzipcode;
	private String chaptercode;
	private String platecode;
	private int userid;
	//private String userid;
	
	private String machinetype;
	private String engineBrand;
	private String fuelname;
	private String realcertificatetype;
	private String templivefileType;
	private String getway;
	private String getWayFileType;
	private String importsFileType;
	private String plantType;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Date getCheckeddate() {
		return checkeddate;
	}
	public void setCheckeddate(Date checkeddate) {
		this.checkeddate = checkeddate;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRegcerno() {
		return regcerno;
	}
	public void setRegcerno(String regcerno) {
		this.regcerno = regcerno;
	}
	public Date getTractorinforegisterdate() {
		return tractorinforegisterdate;
	}
	public void setTractorinforegisterdate(Date tractorinforegisterdate) {
		this.tractorinforegisterdate = tractorinforegisterdate;
	}
	public int getFiling() {
		return filing;
	}
	public void setFiling(int filing) {
		this.filing = filing;
	}
	public Date getFilingDate() {
		return filingDate;
	}
	public void setFilingDate(Date filingDate) {
		this.filingDate = filingDate;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public int getOwnerinfoid() {
		return ownerinfoid;
	}
	public void setOwnerinfoid(int ownerinfoid) {
		this.ownerinfoid = ownerinfoid;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getRealcertificatetypeid() {
		return realcertificatetypeid;
	}
	public void setRealcertificatetypeid(int realcertificatetypeid) {
		this.realcertificatetypeid = realcertificatetypeid;
	}
	public String getRealcertificateno() {
		return realcertificateno;
	}
	public void setRealcertificateno(String realcertificateno) {
		this.realcertificateno = realcertificateno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTempaddress() {
		return tempaddress;
	}
	public void setTempaddress(String tempaddress) {
		this.tempaddress = tempaddress;
	}
	public int getIstemplived() {
		return istemplived;
	}
	public void setIstemplived(int istemplived) {
		this.istemplived = istemplived;
	}
	public int getTemplivefiletypeid() {
		return templivefiletypeid;
	}
	public void setTemplivefiletypeid(int templivefiletypeid) {
		this.templivefiletypeid = templivefiletypeid;
	}
	public String getTimplivefileno() {
		return timplivefileno;
	}
	public void setTimplivefileno(String timplivefileno) {
		this.timplivefileno = timplivefileno;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getIsUnion() {
		return isUnion;
	}
	public void setIsUnion(int isUnion) {
		this.isUnion = isUnion;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getTechnicalinspectid() {
		return technicalinspectid;
	}
	public void setTechnicalinspectid(int technicalinspectid) {
		this.technicalinspectid = technicalinspectid;
	}
	public String getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}
	public Date getCheckexpirydate() {
		return checkexpirydate;
	}
	public void setCheckexpirydate(Date checkexpirydate) {
		this.checkexpirydate = checkexpirydate;
	}
	public String getInspector() {
		return inspector;
	}
	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	public Date getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}
	public String getDisqualification() {
		return disqualification;
	}
	public void setDisqualification(String disqualification) {
		this.disqualification = disqualification;
	}
	public String getShowinitialinspectionresult() {
		return showinitialinspectionresult;
	}
	public void setShowinitialinspectionresult(String showinitialinspectionresult) {
		this.showinitialinspectionresult = showinitialinspectionresult;
	}
	public String getShowdisqualification() {
		return showdisqualification;
	}
	public void setShowdisqualification(String showdisqualification) {
		this.showdisqualification = showdisqualification;
	}
	public String getShowexaminationresult() {
		return showexaminationresult;
	}
	public void setShowexaminationresult(String showexaminationresult) {
		this.showexaminationresult = showexaminationresult;
	}
	public String getEngineinitialinspectionresult() {
		return engineinitialinspectionresult;
	}
	public void setEngineinitialinspectionresult(
			String engineinitialinspectionresult) {
		this.engineinitialinspectionresult = engineinitialinspectionresult;
	}
	public String getEnginedisqualification() {
		return enginedisqualification;
	}
	public void setEnginedisqualification(String enginedisqualification) {
		this.enginedisqualification = enginedisqualification;
	}
	public String getEngineexaminationresult() {
		return engineexaminationresult;
	}
	public void setEngineexaminationresult(String engineexaminationresult) {
		this.engineexaminationresult = engineexaminationresult;
	}
	public String getConveyorinitialinspectionresult() {
		return conveyorinitialinspectionresult;
	}
	public void setConveyorinitialinspectionresult(
			String conveyorinitialinspectionresult) {
		this.conveyorinitialinspectionresult = conveyorinitialinspectionresult;
	}
	public String getConveyordisqualification() {
		return conveyordisqualification;
	}
	public void setConveyordisqualification(String conveyordisqualification) {
		this.conveyordisqualification = conveyordisqualification;
	}
	public String getConveyorexaminationresult() {
		return conveyorexaminationresult;
	}
	public void setConveyorexaminationresult(String conveyorexaminationresult) {
		this.conveyorexaminationresult = conveyorexaminationresult;
	}
	public String getSteeringinitialinspectionresult() {
		return steeringinitialinspectionresult;
	}
	public void setSteeringinitialinspectionresult(
			String steeringinitialinspectionresult) {
		this.steeringinitialinspectionresult = steeringinitialinspectionresult;
	}
	public String getSteeringdisqualification() {
		return steeringdisqualification;
	}
	public void setSteeringdisqualification(String steeringdisqualification) {
		this.steeringdisqualification = steeringdisqualification;
	}
	public String getSteeringexaminationresult() {
		return steeringexaminationresult;
	}
	public void setSteeringexaminationresult(String steeringexaminationresult) {
		this.steeringexaminationresult = steeringexaminationresult;
	}
	public String getFlyhostinitialinspectionresult() {
		return flyhostinitialinspectionresult;
	}
	public void setFlyhostinitialinspectionresult(
			String flyhostinitialinspectionresult) {
		this.flyhostinitialinspectionresult = flyhostinitialinspectionresult;
	}
	public String getFlyhostdisqualification() {
		return flyhostdisqualification;
	}
	public void setFlyhostdisqualification(String flyhostdisqualification) {
		this.flyhostdisqualification = flyhostdisqualification;
	}
	public String getFlyhostexaminationresult() {
		return flyhostexaminationresult;
	}
	public void setFlyhostexaminationresult(String flyhostexaminationresult) {
		this.flyhostexaminationresult = flyhostexaminationresult;
	}
	public String getFlytrailerinitialinspectionresult() {
		return flytrailerinitialinspectionresult;
	}
	public void setFlytrailerinitialinspectionresult(
			String flytrailerinitialinspectionresult) {
		this.flytrailerinitialinspectionresult = flytrailerinitialinspectionresult;
	}
	public String getFlytrailerdisqualification() {
		return flytrailerdisqualification;
	}
	public void setFlytrailerdisqualification(String flytrailerdisqualification) {
		this.flytrailerdisqualification = flytrailerdisqualification;
	}
	public String getFlytrailerexaminationresult() {
		return flytrailerexaminationresult;
	}
	public void setFlytrailerexaminationresult(String flytrailerexaminationresult) {
		this.flytrailerexaminationresult = flytrailerexaminationresult;
	}
	public String getBrakhostinitialinspectionresult() {
		return brakhostinitialinspectionresult;
	}
	public void setBrakhostinitialinspectionresult(
			String brakhostinitialinspectionresult) {
		this.brakhostinitialinspectionresult = brakhostinitialinspectionresult;
	}
	public String getBrakhostdisqualification() {
		return brakhostdisqualification;
	}
	public void setBrakhostdisqualification(String brakhostdisqualification) {
		this.brakhostdisqualification = brakhostdisqualification;
	}
	public String getBrakhostexaminationresult() {
		return brakhostexaminationresult;
	}
	public void setBrakhostexaminationresult(String brakhostexaminationresult) {
		this.brakhostexaminationresult = brakhostexaminationresult;
	}
	public String getBraktrailerinitialinspectionresult() {
		return braktrailerinitialinspectionresult;
	}
	public void setBraktrailerinitialinspectionresult(
			String braktrailerinitialinspectionresult) {
		this.braktrailerinitialinspectionresult = braktrailerinitialinspectionresult;
	}
	public String getBraktrailerdisqualification() {
		return braktrailerdisqualification;
	}
	public void setBraktrailerdisqualification(String braktrailerdisqualification) {
		this.braktrailerdisqualification = braktrailerdisqualification;
	}
	public String getBraktrailerexaminationresult() {
		return braktrailerexaminationresult;
	}
	public void setBraktrailerexaminationresult(String braktrailerexaminationresult) {
		this.braktrailerexaminationresult = braktrailerexaminationresult;
	}
	public String getLighthostinitialinspectionresult() {
		return lighthostinitialinspectionresult;
	}
	public void setLighthostinitialinspectionresult(
			String lighthostinitialinspectionresult) {
		this.lighthostinitialinspectionresult = lighthostinitialinspectionresult;
	}
	public String getLighthostdisqualification() {
		return lighthostdisqualification;
	}
	public void setLighthostdisqualification(String lighthostdisqualification) {
		this.lighthostdisqualification = lighthostdisqualification;
	}
	public String getLighthostexaminationresult() {
		return lighthostexaminationresult;
	}
	public void setLighthostexaminationresult(String lighthostexaminationresult) {
		this.lighthostexaminationresult = lighthostexaminationresult;
	}
	public String getLighttrailerinitialinspectionresult() {
		return lighttrailerinitialinspectionresult;
	}
	public void setLighttrailerinitialinspectionresult(
			String lighttrailerinitialinspectionresult) {
		this.lighttrailerinitialinspectionresult = lighttrailerinitialinspectionresult;
	}
	public String getLighttrailerdisqualification() {
		return lighttrailerdisqualification;
	}
	public void setLighttrailerdisqualification(String lighttrailerdisqualification) {
		this.lighttrailerdisqualification = lighttrailerdisqualification;
	}
	public String getLighttrailerexaminationresult() {
		return lighttrailerexaminationresult;
	}
	public void setLighttrailerexaminationresult(
			String lighttrailerexaminationresult) {
		this.lighttrailerexaminationresult = lighttrailerexaminationresult;
	}
	public String getTractioninitialinspectionresult() {
		return tractioninitialinspectionresult;
	}
	public void setTractioninitialinspectionresult(
			String tractioninitialinspectionresult) {
		this.tractioninitialinspectionresult = tractioninitialinspectionresult;
	}
	public String getTractiondisqualification() {
		return tractiondisqualification;
	}
	public void setTractiondisqualification(String tractiondisqualification) {
		this.tractiondisqualification = tractiondisqualification;
	}
	public String getTractionexaminationresult() {
		return tractionexaminationresult;
	}
	public void setTractionexaminationresult(String tractionexaminationresult) {
		this.tractionexaminationresult = tractionexaminationresult;
	}
	public int getHandlingsituationid() {
		return handlingsituationid;
	}
	public void setHandlingsituationid(int handlingsituationid) {
		this.handlingsituationid = handlingsituationid;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public Date getReviewerconductdate() {
		return reviewerconductdate;
	}
	public void setReviewerconductdate(Date reviewerconductdate) {
		this.reviewerconductdate = reviewerconductdate;
	}
	public String getIssueadmin() {
		return issueadmin;
	}
	public void setIssueadmin(String issueadmin) {
		this.issueadmin = issueadmin;
	}
	public String getLeaderreview() {
		return leaderreview;
	}
	public void setLeaderreview(String leaderreview) {
		this.leaderreview = leaderreview;
	}
	public Date getLeaderreviewconductdate() {
		return leaderreviewconductdate;
	}
	public void setLeaderreviewconductdate(Date leaderreviewconductdate) {
		this.leaderreviewconductdate = leaderreviewconductdate;
	}
	public Date getIssueadmindate() {
		return issueadmindate;
	}
	public void setIssueadmindate(Date issueadmindate) {
		this.issueadmindate = issueadmindate;
	}
	public int getTractorbasicinfoid() {
		return tractorbasicinfoid;
	}
	public void setTractorbasicinfoid(int tractorbasicinfoid) {
		this.tractorbasicinfoid = tractorbasicinfoid;
	}
	public int getGetwayid() {
		return getwayid;
	}
	public void setGetwayid(int getwayid) {
		this.getwayid = getwayid;
	}
	public int getMachinetypeid() {
		return machinetypeid;
	}
	public void setMachinetypeid(int machinetypeid) {
		this.machinetypeid = machinetypeid;
	}
	public int getMachinebrandtypeid() {
		return machinebrandtypeid;
	}
	public void setMachinebrandtypeid(int machinebrandtypeid) {
		this.machinebrandtypeid = machinebrandtypeid;
	}
	public String getMachinebodyno() {
		return machinebodyno;
	}
	public void setMachinebodyno(String machinebodyno) {
		this.machinebodyno = machinebodyno;
	}
	public String getEngineno() {
		return engineno;
	}
	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
	public String getShelfno() {
		return shelfno;
	}
	public void setShelfno(String shelfno) {
		this.shelfno = shelfno;
	}
	public String getUsedfor() {
		return usedfor;
	}
	public void setUsedfor(String usedfor) {
		this.usedfor = usedfor;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Date getManufacturedate() {
		return manufacturedate;
	}
	public void setManufacturedate(Date manufacturedate) {
		this.manufacturedate = manufacturedate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	public int getRelationinfoid() {
		return relationinfoid;
	}
	public void setRelationinfoid(int relationinfoid) {
		this.relationinfoid = relationinfoid;
	}
	public int getGetwayfiletypeid() {
		return getwayfiletypeid;
	}
	public void setGetwayfiletypeid(int getwayfiletypeid) {
		this.getwayfiletypeid = getwayfiletypeid;
	}
	public String getGetwayfileno() {
		return getwayfileno;
	}
	public void setGetwayfileno(String getwayfileno) {
		this.getwayfileno = getwayfileno;
	}
	public int getImportsfiletypeid() {
		return importsfiletypeid;
	}
	public void setImportsfiletypeid(int importsfiletypeid) {
		this.importsfiletypeid = importsfiletypeid;
	}
	public String getImportsfileno() {
		return importsfileno;
	}
	public void setImportsfileno(String importsfileno) {
		this.importsfileno = importsfileno;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getInsurancelistno() {
		return insurancelistno;
	}
	public void setInsurancelistno(String insurancelistno) {
		this.insurancelistno = insurancelistno;
	}
	public String getInsurancecompanyname() {
		return insurancecompanyname;
	}
	public void setInsurancecompanyname(String insurancecompanyname) {
		this.insurancecompanyname = insurancecompanyname;
	}
	public Date getInsurancedate() {
		return insurancedate;
	}
	public void setInsurancedate(Date insurancedate) {
		this.insurancedate = insurancedate;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public int getRegisterinfoid() {
		return registerinfoid;
	}
	public void setRegisterinfoid(int registerinfoid) {
		this.registerinfoid = registerinfoid;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public Date getTurnindate() {
		return turnindate;
	}
	public void setTurnindate(Date turnindate) {
		this.turnindate = turnindate;
	}
	public Date getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}
	public String getBeforeregion() {
		return beforeregion;
	}
	public void setBeforeregion(String beforeregion) {
		this.beforeregion = beforeregion;
	}
	public int getTechnicalparametersid() {
		return technicalparametersid;
	}
	public void setTechnicalparametersid(int technicalparametersid) {
		this.technicalparametersid = technicalparametersid;
	}
	public String getMachinebodycolor() {
		return machinebodycolor;
	}
	public void setMachinebodycolor(String machinebodycolor) {
		this.machinebodycolor = machinebodycolor;
	}
	public String getDirectcontrol() {
		return directcontrol;
	}
	public void setDirectcontrol(String directcontrol) {
		this.directcontrol = directcontrol;
	}
	public int getEnginebrandid() {
		return enginebrandid;
	}
	public void setEnginebrandid(int enginebrandid) {
		this.enginebrandid = enginebrandid;
	}
	public int getFueltypeid() {
		return fueltypeid;
	}
	public void setFueltypeid(int fueltypeid) {
		this.fueltypeid = fueltypeid;
	}
	public int getTiresno() {
		return tiresno;
	}
	public void setTiresno(int tiresno) {
		this.tiresno = tiresno;
	}
	public int getTotalquality() {
		return totalquality;
	}
	public void setTotalquality(int totalquality) {
		this.totalquality = totalquality;
	}
	public int getAllowdragtotalquality() {
		return allowdragtotalquality;
	}
	public void setAllowdragtotalquality(int allowdragtotalquality) {
		this.allowdragtotalquality = allowdragtotalquality;
	}
	public int getVicecartiresno() {
		return vicecartiresno;
	}
	public void setVicecartiresno(int vicecartiresno) {
		this.vicecartiresno = vicecartiresno;
	}
	public String getOutsize() {
		return outsize;
	}
	public void setOutsize(String outsize) {
		this.outsize = outsize;
	}
	public String getContainersize() {
		return containersize;
	}
	public void setContainersize(String containersize) {
		this.containersize = containersize;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getCylinderno() {
		return cylinderno;
	}
	public void setCylinderno(int cylinderno) {
		this.cylinderno = cylinderno;
	}
	public int getWheelno() {
		return wheelno;
	}
	public void setWheelno(int wheelno) {
		this.wheelno = wheelno;
	}
	public String getTiressize() {
		return tiressize;
	}
	public void setTiressize(String tiressize) {
		this.tiressize = tiressize;
	}
	public int getAllquality() {
		return allquality;
	}
	public void setAllquality(int allquality) {
		this.allquality = allquality;
	}
	public int getDriverinno() {
		return driverinno;
	}
	public void setDriverinno(int driverinno) {
		this.driverinno = driverinno;
	}
	public String getOutcarwheeldis() {
		return outcarwheeldis;
	}
	public void setOutcarwheeldis(String outcarwheeldis) {
		this.outcarwheeldis = outcarwheeldis;
	}
	public String getWheelbase() {
		return wheelbase;
	}
	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}
	public String getWheeldis() {
		return wheeldis;
	}
	public void setWheeldis(String wheeldis) {
		this.wheeldis = wheeldis;
	}
	public int getRatifiedload() {
		return ratifiedload;
	}
	public void setRatifiedload(int ratifiedload) {
		this.ratifiedload = ratifiedload;
	}
	public int getSteelspring() {
		return steelspring;
	}
	public void setSteelspring(int steelspring) {
		this.steelspring = steelspring;
	}
	public String getOutcartiressize() {
		return outcartiressize;
	}
	public void setOutcartiressize(String outcartiressize) {
		this.outcartiressize = outcartiressize;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionid() {
		return regionid;
	}
	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}
	public String getUseunit() {
		return useunit;
	}
	public void setUseunit(String useunit) {
		this.useunit = useunit;
	}
	public String getResponsiblemen() {
		return responsiblemen;
	}
	public void setResponsiblemen(String responsiblemen) {
		this.responsiblemen = responsiblemen;
	}
	public String getLinktel() {
		return linktel;
	}
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}
	public String getUnitaddress() {
		return unitaddress;
	}
	public void setUnitaddress(String unitaddress) {
		this.unitaddress = unitaddress;
	}
	public String getUnitzipcode() {
		return unitzipcode;
	}
	public void setUnitzipcode(String unitzipcode) {
		this.unitzipcode = unitzipcode;
	}
	public String getChaptercode() {
		return chaptercode;
	}
	public void setChaptercode(String chaptercode) {
		this.chaptercode = chaptercode;
	}
	public String getPlatecode() {
		return platecode;
	}
	public void setPlatecode(String platecode) {
		this.platecode = platecode;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMachinetype() {
		return machinetype;
	}
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	public String getEngineBrand() {
		return engineBrand;
	}
	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}
	public String getFuelname() {
		return fuelname;
	}
	public void setFuelname(String fuelname) {
		this.fuelname = fuelname;
	}
	public String getRealcertificatetype() {
		return realcertificatetype;
	}
	public void setRealcertificatetype(String realcertificatetype) {
		this.realcertificatetype = realcertificatetype;
	}
	public String getTemplivefileType() {
		return templivefileType;
	}
	public void setTemplivefileType(String templivefileType) {
		this.templivefileType = templivefileType;
	}
	public String getGetway() {
		return getway;
	}
	public void setGetway(String getway) {
		this.getway = getway;
	}
	public String getGetWayFileType() {
		return getWayFileType;
	}
	public void setGetWayFileType(String getWayFileType) {
		this.getWayFileType = getWayFileType;
	}
	public String getImportsFileType() {
		return importsFileType;
	}
	public void setImportsFileType(String importsFileType) {
		this.importsFileType = importsFileType;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

}