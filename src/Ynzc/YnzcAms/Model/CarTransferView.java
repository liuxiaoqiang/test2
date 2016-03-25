package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_cartransfer_view")
public class CarTransferView {
	private int id;
	private int tractorinfoId;
	private String transfertype;
	private String orginregionid;
	private String orginregionname;
	private int orginunitid;
	private String orginunitname;
	private String currentregionid;
	private String regionname;
	private int currentunitid;
	private String unitname;
	private Date applydate;
	private String applymen;
	private String applyip;
	private String checkmen;
	private Date checkdate;
	private String checkip;
	private int checkresult;
	private String checkcontext;
	//原车牌号码
	private String oldlicense;
	private int applytype;

	//拖拉机视图
	private int  unitid;
	private String license;
	private Date checkeddate;
	private String recorder;
	private int status;
	private String regcerno;
	private Date tractorinforegisterdate;
	
	private int ownerinfoid;
	private String owner;
	private int realcertificatetypeid;
	private String realcertificateno;
	private String tractorinfoaddress;
	private String tempaddress;
	private String istemplived;
	private int  templivefiletypeid;
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
	private int tractorinfomachinetypeid;
	private int machinebrandtypeid;
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
	public int tractorinfogetwayfiletypeid;
	public String getwayfileno;
	public int tractorinfoimportsfiletypeid;
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
	public int tractorinfoenginebrandid;
	public int tractorinfofueltypeid;
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
	private int userid;
	
	private String tractorinfomachinetype;
	private String tractorengineBrand;
	private String fuelname;
	private String realcertificatetype;
	private String tractorinfotemplivefileType;
	private String tractorinfogetway;
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

	public int getTractorinfoId() {
		return tractorinfoId;
	}

	public void setTractorinfoId(int tractorinfoId) {
		this.tractorinfoId = tractorinfoId;
	}

	public String getTransfertype() {
		return transfertype;
	}

	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
	}

	public String getOrginregionid() {
		return orginregionid;
	}

	public void setOrginregionid(String orginregionid) {
		this.orginregionid = orginregionid;
	}

	public String getOrginregionname() {
		return orginregionname;
	}

	public void setOrginregionname(String orginregionname) {
		this.orginregionname = orginregionname;
	}

	public int getOrginunitid() {
		return orginunitid;
	}

	public void setOrginunitid(int orginunitid) {
		this.orginunitid = orginunitid;
	}

	public String getOrginunitname() {
		return orginunitname;
	}

	public void setOrginunitname(String orginunitname) {
		this.orginunitname = orginunitname;
	}

	public String getCurrentregionid() {
		return currentregionid;
	}

	public void setCurrentregionid(String currentregionid) {
		this.currentregionid = currentregionid;
	}

	public String getRegionname() {
		return regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public int getCurrentunitid() {
		return currentunitid;
	}

	public void setCurrentunitid(int currentunitid) {
		this.currentunitid = currentunitid;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getApplymen() {
		return applymen;
	}

	public void setApplymen(String applymen) {
		this.applymen = applymen;
	}

	public String getApplyip() {
		return applyip;
	}

	public void setApplyip(String applyip) {
		this.applyip = applyip;
	}

	public String getCheckmen() {
		return checkmen;
	}

	public void setCheckmen(String checkmen) {
		this.checkmen = checkmen;
	}

	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	public String getCheckip() {
		return checkip;
	}

	public void setCheckip(String checkip) {
		this.checkip = checkip;
	}

	public int getCheckresult() {
		return checkresult;
	}

	public void setCheckresult(int checkresult) {
		this.checkresult = checkresult;
	}

	public String getCheckcontext() {
		return checkcontext;
	}

	public void setCheckcontext(String checkcontext) {
		this.checkcontext = checkcontext;
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

	public int getTractorinfomachinetypeid() {
		return tractorinfomachinetypeid;
	}

	public void setTractorinfomachinetypeid(int tractorinfomachinetypeid) {
		this.tractorinfomachinetypeid = tractorinfomachinetypeid;
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

	public int getTractorinfogetwayfiletypeid() {
		return tractorinfogetwayfiletypeid;
	}

	public void setTractorinfogetwayfiletypeid(int tractorinfogetwayfiletypeid) {
		this.tractorinfogetwayfiletypeid = tractorinfogetwayfiletypeid;
	}

	public String getGetwayfileno() {
		return getwayfileno;
	}

	public void setGetwayfileno(String getwayfileno) {
		this.getwayfileno = getwayfileno;
	}

	public int getTractorinfoimportsfiletypeid() {
		return tractorinfoimportsfiletypeid;
	}

	public void setTractorinfoimportsfiletypeid(int tractorinfoimportsfiletypeid) {
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

	public int getTractorinfoenginebrandid() {
		return tractorinfoenginebrandid;
	}

	public void setTractorinfoenginebrandid(int tractorinfoenginebrandid) {
		this.tractorinfoenginebrandid = tractorinfoenginebrandid;
	}

	public int getTractorinfofueltypeid() {
		return tractorinfofueltypeid;
	}

	public void setTractorinfofueltypeid(int tractorinfofueltypeid) {
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
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

	public String getOldlicense() {
		return oldlicense;
	}

	public void setOldlicense(String oldlicense) {
		this.oldlicense = oldlicense;
	}

	public int getApplytype() {
		return applytype;
	}

	public void setApplytype(int applytype) {
		this.applytype = applytype;
	}

    
}
