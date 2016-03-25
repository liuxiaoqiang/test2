package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ynzc_changerecord_view")
public class ChangeRecordView {
	private int id;
	private int tractorinfoId;
	private String changerecordtype;
	private String changerecordname;
	private String linktel;
	private int certificateid;
	private String certificatecode;
	private int unittype;
	private String address;
	private String zipcode;
	private int istemporary;
	private int temporaycertificate;
	private String temporaycertificatecode;
	private String checkinmen;
	private Date checkindate;
	private String licensemen;
	private Date licensedate;
	private String businessmen;
	private Date businessdate;
	private String checkmen;
	private int checkstate;
	private Date checkdate;
	private String checkcontent;
	private String checkip;
	private String opertator;
	private Date opertatedate;
	
	private String changerecordrealcertificate;
	private String templivefileType;
	//拖拉机视图
	private String  unitid;
	private String license;
	private Date checkeddate;
	private String recorder;
	private int status;
	private String regcerno;
	private Date tractorinforegisterdate;
	
	private String ownerinfoid;
	private String owner;
	private String realcertificatetypeid;
	private String realcertificateno;
	private String tractorinfoaddress;
	private String tempaddress;
	private String istemplived;
	private String  templivefiletypeid;
    private String timplivefileno;
    private String telephone;
    private String isUnion;
    private String tractorinfozipcode;
	
    private int technicalinspectid;
	private String tractorinfocheckresult;
	private Date tractorinfocheckexpirydate;
	private String tractorinfoinspector;
	private Date tractorinfocheckdate;
	
	private int handlingsituationid;
	private String tractorinforeviewer;
	private Date tractorinforeviewerconductdate;
	private String tractorinfoissueadmin;
	private String tractorinfoleaderreview;
	private Date leaderreviewconductdate;
	private Date tractorinfoissueadmindate;
	
	private int tractorbasicinfoid;
	private String getwayid;
	private String tractorinfomachinetypeid;
	private String machinebrandtypeid;
	private String machinebodyno;
	private String engineno;
	private String shelfno;
	private String usedfor;
	private String manufacturer;
	private String seller;
	private Date manufacturedate;
	private String tractorinfoprice;
	private String tractorinfophotourl;
	
	private int relationinfoid;
	public String tractorinfogetwayfiletypeid;
	public String getwayfileno;
	public String tractorinfoimportsfiletypeid;
	public String importsfileno;
	public String tractorinfoother;
	public String tractorinfoinsurancelistno;
	public String tractorinfoinsurancecompanyname;
	public Date tractorinfoinsurancedate;
	public Date tractorinfoexpirydate;
	
	private int registerinfoid;
	public Date registerdate;
	private Date turnindate;
	public Date issuedate;
	public String beforeregion;
	
	private int technicalparametersid;
	public String machinebodycolor;
	public String tractorinfodirectcontrol;
	public String tractorinfoenginebrandid;
	public String tractorinfofueltypeid;
	public String tractorinfotireson;
	public String tractorinfototalquality;
	public String tractorinfoallowdragtotalquality;
	public String tractorinfovicecartiresno;
	public String outsize;
	public String tractorinfocontainersize;
	public String tractorinfopower;
	public String tractorcylinderno;
	public String tractorinfowheelo;
	public String tractorinfotiressize;
	public String tractorinfoallquality;
	public String tractorinfodriverinno;
	public String tractorinfooutcarwheeldis;
	public String tractorinfowheelbase;
	public String tractorinfowheeldis;
	public String tractorinforatifiedload;
	public String tractorinfosteelspring;
	public String tractorinfooutcartiressize;
	
	private String region;
	private String regionid;
	private String useunit;
	private String responsiblemen;
	private String tractorinfolinktel;
	private String unitaddress;
	private String unitzipcode;
	private String chaptercode;
	private String platecode;
	//private int userid;
	private String userid;
	
	private String tractorinfomachinetype;
	private String tractorengineBrand;
	private String fuelname;
	private String realcertificatetype;
	private String tractorinfotemplivefileType;
	private String tractorinfogetway;
	private String getWayFileType;
	private String importsFileType;
	private String plantType;
	private int filing;
	private Date filingDate;
	
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
	public String getChangerecordtype() {
		return changerecordtype;
	}
	public void setChangerecordtype(String changerecordtype) {
		this.changerecordtype = changerecordtype;
	}
	public String getChangerecordname() {
		return changerecordname;
	}
	public void setChangerecordname(String changerecordname) {
		this.changerecordname = changerecordname;
	}
	public String getLinktel() {
		return linktel;
	}
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}
	public int getCertificateid() {
		return certificateid;
	}
	public void setCertificateid(int certificateid) {
		this.certificateid = certificateid;
	}
	public String getCertificatecode() {
		return certificatecode;
	}
	public void setCertificatecode(String certificatecode) {
		this.certificatecode = certificatecode;
	}
	public int getUnittype() {
		return unittype;
	}
	public void setUnittype(int unittype) {
		this.unittype = unittype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public int getIstemporary() {
		return istemporary;
	}
	public void setIstemporary(int istemporary) {
		this.istemporary = istemporary;
	}
	public int getTemporaycertificate() {
		return temporaycertificate;
	}
	public void setTemporaycertificate(int temporaycertificate) {
		this.temporaycertificate = temporaycertificate;
	}
	public String getTemporaycertificatecode() {
		return temporaycertificatecode;
	}
	public void setTemporaycertificatecode(String temporaycertificatecode) {
		this.temporaycertificatecode = temporaycertificatecode;
	}
	public String getCheckinmen() {
		return checkinmen;
	}
	public void setCheckinmen(String checkinmen) {
		this.checkinmen = checkinmen;
	}
	public Date getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(Date checkindate) {
		this.checkindate = checkindate;
	}
	public String getLicensemen() {
		return licensemen;
	}
	public void setLicensemen(String licensemen) {
		this.licensemen = licensemen;
	}
	public Date getLicensedate() {
		return licensedate;
	}
	public void setLicensedate(Date licensedate) {
		this.licensedate = licensedate;
	}
	public String getBusinessmen() {
		return businessmen;
	}
	public void setBusinessmen(String businessmen) {
		this.businessmen = businessmen;
	}
	public Date getBusinessdate() {
		return businessdate;
	}
	public void setBusinessdate(Date businessdate) {
		this.businessdate = businessdate;
	}
	public String getCheckmen() {
		return checkmen;
	}
	public void setCheckmen(String checkmen) {
		this.checkmen = checkmen;
	}
	public int getCheckstate() {
		return checkstate;
	}
	public void setCheckstate(int checkstate) {
		this.checkstate = checkstate;
	}
	public Date getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}
	public String getCheckcontent() {
		return checkcontent;
	}
	public void setCheckcontent(String checkcontent) {
		this.checkcontent = checkcontent;
	}
	public String getCheckip() {
		return checkip;
	}
	public void setCheckip(String checkip) {
		this.checkip = checkip;
	}
	public String getOpertator() {
		return opertator;
	}
	public void setOpertator(String opertator) {
		this.opertator = opertator;
	}
	public Date getOpertatedate() {
		return opertatedate;
	}
	public void setOpertatedate(Date opertatedate) {
		this.opertatedate = opertatedate;
	}
	public String getUnitid() {
		return unitid;
	}
	public void setUnitid(String unitid) {
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
	public String getOwnerinfoid() {
		return ownerinfoid;
	}
	public void setOwnerinfoid(String ownerinfoid) {
		this.ownerinfoid = ownerinfoid;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRealcertificatetypeid() {
		return realcertificatetypeid;
	}
	public void setRealcertificatetypeid(String realcertificatetypeid) {
		this.realcertificatetypeid = realcertificatetypeid;
	}
	public String getRealcertificateno() {
		return realcertificateno;
	}
	public void setRealcertificateno(String realcertificateno) {
		this.realcertificateno = realcertificateno;
	}
	public String getTractorinfoaddress() {
		return tractorinfoaddress;
	}
	public void setTractorinfoaddress(String tractorinfoaddress) {
		this.tractorinfoaddress = tractorinfoaddress;
	}
	public String getTempaddress() {
		return tempaddress;
	}
	public void setTempaddress(String tempaddress) {
		this.tempaddress = tempaddress;
	}
	public String getIstemplived() {
		return istemplived;
	}
	public void setIstemplived(String istemplived) {
		this.istemplived = istemplived;
	}
	public String getTemplivefiletypeid() {
		return templivefiletypeid;
	}
	public void setTemplivefiletypeid(String templivefiletypeid) {
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
	public String getIsUnion() {
		return isUnion;
	}
	public void setIsUnion(String isUnion) {
		this.isUnion = isUnion;
	}
	public String getTractorinfozipcode() {
		return tractorinfozipcode;
	}
	public void setTractorinfozipcode(String tractorinfozipcode) {
		this.tractorinfozipcode = tractorinfozipcode;
	}
	public int getTechnicalinspectid() {
		return technicalinspectid;
	}
	public void setTechnicalinspectid(int technicalinspectid) {
		this.technicalinspectid = technicalinspectid;
	}
	public String getTractorinfocheckresult() {
		return tractorinfocheckresult;
	}
	public void setTractorinfocheckresult(String tractorinfocheckresult) {
		this.tractorinfocheckresult = tractorinfocheckresult;
	}
	public Date getTractorinfocheckexpirydate() {
		return tractorinfocheckexpirydate;
	}
	public void setTractorinfocheckexpirydate(Date tractorinfocheckexpirydate) {
		this.tractorinfocheckexpirydate = tractorinfocheckexpirydate;
	}
	public String getTractorinfoinspector() {
		return tractorinfoinspector;
	}
	public void setTractorinfoinspector(String tractorinfoinspector) {
		this.tractorinfoinspector = tractorinfoinspector;
	}
	public Date getTractorinfocheckdate() {
		return tractorinfocheckdate;
	}
	public void setTractorinfocheckdate(Date tractorinfocheckdate) {
		this.tractorinfocheckdate = tractorinfocheckdate;
	}
	public int getHandlingsituationid() {
		return handlingsituationid;
	}
	public void setHandlingsituationid(int handlingsituationid) {
		this.handlingsituationid = handlingsituationid;
	}
	public String getTractorinforeviewer() {
		return tractorinforeviewer;
	}
	public void setTractorinforeviewer(String tractorinforeviewer) {
		this.tractorinforeviewer = tractorinforeviewer;
	}
	public Date getTractorinforeviewerconductdate() {
		return tractorinforeviewerconductdate;
	}
	public void setTractorinforeviewerconductdate(
			Date tractorinforeviewerconductdate) {
		this.tractorinforeviewerconductdate = tractorinforeviewerconductdate;
	}
	public String getTractorinfoissueadmin() {
		return tractorinfoissueadmin;
	}
	public void setTractorinfoissueadmin(String tractorinfoissueadmin) {
		this.tractorinfoissueadmin = tractorinfoissueadmin;
	}
	public String getTractorinfoleaderreview() {
		return tractorinfoleaderreview;
	}
	public void setTractorinfoleaderreview(String tractorinfoleaderreview) {
		this.tractorinfoleaderreview = tractorinfoleaderreview;
	}
	public Date getLeaderreviewconductdate() {
		return leaderreviewconductdate;
	}
	public void setLeaderreviewconductdate(Date leaderreviewconductdate) {
		this.leaderreviewconductdate = leaderreviewconductdate;
	}
	public Date getTractorinfoissueadmindate() {
		return tractorinfoissueadmindate;
	}
	public void setTractorinfoissueadmindate(Date tractorinfoissueadmindate) {
		this.tractorinfoissueadmindate = tractorinfoissueadmindate;
	}
	public int getTractorbasicinfoid() {
		return tractorbasicinfoid;
	}
	public void setTractorbasicinfoid(int tractorbasicinfoid) {
		this.tractorbasicinfoid = tractorbasicinfoid;
	}
	public String getGetwayid() {
		return getwayid;
	}
	public void setGetwayid(String getwayid) {
		this.getwayid = getwayid;
	}
	public String getTractorinfomachinetypeid() {
		return tractorinfomachinetypeid;
	}
	public void setTractorinfomachinetypeid(String tractorinfomachinetypeid) {
		this.tractorinfomachinetypeid = tractorinfomachinetypeid;
	}
	public String getMachinebrandtypeid() {
		return machinebrandtypeid;
	}
	public void setMachinebrandtypeid(String machinebrandtypeid) {
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
	public String getTractorinfoprice() {
		return tractorinfoprice;
	}
	public void setTractorinfoprice(String tractorinfoprice) {
		this.tractorinfoprice = tractorinfoprice;
	}
	public String getTractorinfophotourl() {
		return tractorinfophotourl;
	}
	public void setTractorinfophotourl(String tractorinfophotourl) {
		this.tractorinfophotourl = tractorinfophotourl;
	}
	public int getRelationinfoid() {
		return relationinfoid;
	}
	public void setRelationinfoid(int relationinfoid) {
		this.relationinfoid = relationinfoid;
	}
	public String getTractorinfogetwayfiletypeid() {
		return tractorinfogetwayfiletypeid;
	}
	public void setTractorinfogetwayfiletypeid(String tractorinfogetwayfiletypeid) {
		this.tractorinfogetwayfiletypeid = tractorinfogetwayfiletypeid;
	}
	public String getGetwayfileno() {
		return getwayfileno;
	}
	public void setGetwayfileno(String getwayfileno) {
		this.getwayfileno = getwayfileno;
	}
	public String getTractorinfoimportsfiletypeid() {
		return tractorinfoimportsfiletypeid;
	}
	public void setTractorinfoimportsfiletypeid(String tractorinfoimportsfiletypeid) {
		this.tractorinfoimportsfiletypeid = tractorinfoimportsfiletypeid;
	}
	public String getImportsfileno() {
		return importsfileno;
	}
	public void setImportsfileno(String importsfileno) {
		this.importsfileno = importsfileno;
	}
	public String getTractorinfoother() {
		return tractorinfoother;
	}
	public void setTractorinfoother(String tractorinfoother) {
		this.tractorinfoother = tractorinfoother;
	}
	public String getTractorinfoinsurancelistno() {
		return tractorinfoinsurancelistno;
	}
	public void setTractorinfoinsurancelistno(String tractorinfoinsurancelistno) {
		this.tractorinfoinsurancelistno = tractorinfoinsurancelistno;
	}
	public String getTractorinfoinsurancecompanyname() {
		return tractorinfoinsurancecompanyname;
	}
	public void setTractorinfoinsurancecompanyname(
			String tractorinfoinsurancecompanyname) {
		this.tractorinfoinsurancecompanyname = tractorinfoinsurancecompanyname;
	}
	public Date getTractorinfoinsurancedate() {
		return tractorinfoinsurancedate;
	}
	public void setTractorinfoinsurancedate(Date tractorinfoinsurancedate) {
		this.tractorinfoinsurancedate = tractorinfoinsurancedate;
	}
	public Date getTractorinfoexpirydate() {
		return tractorinfoexpirydate;
	}
	public void setTractorinfoexpirydate(Date tractorinfoexpirydate) {
		this.tractorinfoexpirydate = tractorinfoexpirydate;
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
	public String getTractorinfodirectcontrol() {
		return tractorinfodirectcontrol;
	}
	public void setTractorinfodirectcontrol(String tractorinfodirectcontrol) {
		this.tractorinfodirectcontrol = tractorinfodirectcontrol;
	}
	public String getTractorinfoenginebrandid() {
		return tractorinfoenginebrandid;
	}
	public void setTractorinfoenginebrandid(String tractorinfoenginebrandid) {
		this.tractorinfoenginebrandid = tractorinfoenginebrandid;
	}
	public String getTractorinfofueltypeid() {
		return tractorinfofueltypeid;
	}
	public void setTractorinfofueltypeid(String tractorinfofueltypeid) {
		this.tractorinfofueltypeid = tractorinfofueltypeid;
	}
	public String getTractorinfotireson() {
		return tractorinfotireson;
	}
	public void setTractorinfotireson(String tractorinfotireson) {
		this.tractorinfotireson = tractorinfotireson;
	}
	public String getTractorinfototalquality() {
		return tractorinfototalquality;
	}
	public void setTractorinfototalquality(String tractorinfototalquality) {
		this.tractorinfototalquality = tractorinfototalquality;
	}
	public String getTractorinfoallowdragtotalquality() {
		return tractorinfoallowdragtotalquality;
	}
	public void setTractorinfoallowdragtotalquality(
			String tractorinfoallowdragtotalquality) {
		this.tractorinfoallowdragtotalquality = tractorinfoallowdragtotalquality;
	}
	public String getTractorinfovicecartiresno() {
		return tractorinfovicecartiresno;
	}
	public void setTractorinfovicecartiresno(String tractorinfovicecartiresno) {
		this.tractorinfovicecartiresno = tractorinfovicecartiresno;
	}
	public String getOutsize() {
		return outsize;
	}
	public void setOutsize(String outsize) {
		this.outsize = outsize;
	}
	public String getTractorinfocontainersize() {
		return tractorinfocontainersize;
	}
	public void setTractorinfocontainersize(String tractorinfocontainersize) {
		this.tractorinfocontainersize = tractorinfocontainersize;
	}
	public String getTractorinfopower() {
		return tractorinfopower;
	}
	public void setTractorinfopower(String tractorinfopower) {
		this.tractorinfopower = tractorinfopower;
	}
	public String getTractorcylinderno() {
		return tractorcylinderno;
	}
	public void setTractorcylinderno(String tractorcylinderno) {
		this.tractorcylinderno = tractorcylinderno;
	}
	public String getTractorinfowheelo() {
		return tractorinfowheelo;
	}
	public void setTractorinfowheelo(String tractorinfowheelo) {
		this.tractorinfowheelo = tractorinfowheelo;
	}
	public String getTractorinfotiressize() {
		return tractorinfotiressize;
	}
	public void setTractorinfotiressize(String tractorinfotiressize) {
		this.tractorinfotiressize = tractorinfotiressize;
	}
	public String getTractorinfoallquality() {
		return tractorinfoallquality;
	}
	public void setTractorinfoallquality(String tractorinfoallquality) {
		this.tractorinfoallquality = tractorinfoallquality;
	}
	public String getTractorinfodriverinno() {
		return tractorinfodriverinno;
	}
	public void setTractorinfodriverinno(String tractorinfodriverinno) {
		this.tractorinfodriverinno = tractorinfodriverinno;
	}
	public String getTractorinfooutcarwheeldis() {
		return tractorinfooutcarwheeldis;
	}
	public void setTractorinfooutcarwheeldis(String tractorinfooutcarwheeldis) {
		this.tractorinfooutcarwheeldis = tractorinfooutcarwheeldis;
	}
	public String getTractorinfowheelbase() {
		return tractorinfowheelbase;
	}
	public void setTractorinfowheelbase(String tractorinfowheelbase) {
		this.tractorinfowheelbase = tractorinfowheelbase;
	}
	public String getTractorinfowheeldis() {
		return tractorinfowheeldis;
	}
	public void setTractorinfowheeldis(String tractorinfowheeldis) {
		this.tractorinfowheeldis = tractorinfowheeldis;
	}
	public String getTractorinforatifiedload() {
		return tractorinforatifiedload;
	}
	public void setTractorinforatifiedload(String tractorinforatifiedload) {
		this.tractorinforatifiedload = tractorinforatifiedload;
	}
	public String getTractorinfosteelspring() {
		return tractorinfosteelspring;
	}
	public void setTractorinfosteelspring(String tractorinfosteelspring) {
		this.tractorinfosteelspring = tractorinfosteelspring;
	}
	public String getTractorinfooutcartiressize() {
		return tractorinfooutcartiressize;
	}
	public void setTractorinfooutcartiressize(String tractorinfooutcartiressize) {
		this.tractorinfooutcartiressize = tractorinfooutcartiressize;
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
	public String getTractorinfolinktel() {
		return tractorinfolinktel;
	}
	public void setTractorinfolinktel(String tractorinfolinktel) {
		this.tractorinfolinktel = tractorinfolinktel;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTractorinfomachinetype() {
		return tractorinfomachinetype;
	}
	public void setTractorinfomachinetype(String tractorinfomachinetype) {
		this.tractorinfomachinetype = tractorinfomachinetype;
	}
	public String getTractorengineBrand() {
		return tractorengineBrand;
	}
	public void setTractorengineBrand(String tractorengineBrand) {
		this.tractorengineBrand = tractorengineBrand;
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
	public String getTractorinfotemplivefileType() {
		return tractorinfotemplivefileType;
	}
	public void setTractorinfotemplivefileType(String tractorinfotemplivefileType) {
		this.tractorinfotemplivefileType = tractorinfotemplivefileType;
	}
	public String getTractorinfogetway() {
		return tractorinfogetway;
	}
	public void setTractorinfogetway(String tractorinfogetway) {
		this.tractorinfogetway = tractorinfogetway;
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
	public String getChangerecordrealcertificate() {
		return changerecordrealcertificate;
	}
	public void setChangerecordrealcertificate(String changerecordrealcertificate) {
		this.changerecordrealcertificate = changerecordrealcertificate;
	}
	public String getTemplivefileType() {
		return templivefileType;
	}
	public void setTemplivefileType(String templivefileType) {
		this.templivefileType = templivefileType;
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
}
