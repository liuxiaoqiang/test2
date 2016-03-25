package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_carcheck_view")
public class CarCheckView {
	private int id;
	private int tractorinfoId;
	private int orgintractorstate;
	private String orgincheckresult;
	private String orgindisqualification;
	private Date orgincheckexpirydate;
	private String orgininspector;
	private Date orgincheckdate;
	private String orginshowinitialinspectionresult;
	private String orginshowdisqualification;
	private String orginshowexaminationresult;
	private String orginengineinitialinspectionresult;
	private String orginenginedisqualification;
	private String orginengineexaminationresult;
	private String orginconveyorinitialinspectionresult;
	private String orginconveyordisqualification;
	private String orginconveyorexaminationresult;
	private String orginsteeringinitialinspectionresult;
	private String orginsteeringdisqualification;
	private String orginsteeringexaminationresult;
	private String orginflyhostinitialinspectionresult;
	private String orginflyhostdisqualification;
	private String orginflyhostexaminationresult;
	private String orginflytrailerinitialinspectionresult;
	private String orginflytrailerdisqualification;
	private String orginflytrailerexaminationresult;
	private String orginbrakhostinitialinspectionresult;
	private String orginbrakhostdisqualification;
	private String orginbrakhostexaminationresult;
	private String orginbraktrailerinitialinspectionresult;
	private String orginbraktrailerdisqualification;
	private String orginbraktrailerexaminationresult;
	private String orginlighthostinitialinspectionresult;
	private String orginlighthostdisqualification;
	private String orginlighthostexaminationresult;
	private String orginlighttrailerinitialinspectionresult;
	private String orginlighttrailerdisqualification;
	private String orginlighttrailerexaminationresult;
	private String orgintractioninitialinspectionresult;
	private String orgintractiondisqualification;
	private String orgintractionexaminationresult;
	private String orgininsurancelistno;
	private Date orgininsurancedate;
	private String orgininsurancecompanyname;
	private Date orginexpirydate;
	
	private String inspectorresult;
	private Date checkexpirydate;
	private String inspector;
	private Date inspectordate;
	private String checkcompanyname;
	private String currentdisqualification;
	private String currentshowinitialinspectionresult;
	private String currentshowdisqualification;
	private String currentshowexaminationresult;
	private String currentengineinitialinspectionresult;
	private String currentenginedisqualification;
	private String currentengineexaminationresult;
	private String currentconveyorinitialinspectionresult;
	private String currentconveyordisqualification;
	private String currentconveyorexaminationresult;
	private String currentsteeringinitialinspectionresult;
	private String currentsteeringdisqualification;
	private String currentsteeringexaminationresult;
	private String currentflyhostinitialinspectionresult;
	private String currentflyhostdisqualification;
	private String currentflyhostexaminationresult;
	private String currentflytrailerinitialinspectionresult;
	private String currentflytrailerdisqualification;
	private String currentflytrailerexaminationresult;
	private String currentbrakhostinitialinspectionresult;
	private String currentbrakhostdisqualification;
	private String currentbrakhostexaminationresult;
	private String currentbraktrailerinitialinspectionresult;
	private String currentbraktrailerdisqualification;
	private String currentbraktrailerexaminationresult;
	private String currentlighthostinitialinspectionresult;
	private String currentlighthostdisqualification;
	private String currentlighthostexaminationresult;
	private String currentlighttrailerinitialinspectionresult;
	private String currentlighttrailerdisqualification;
	private String currentlighttrailerexaminationresult;
	private String currenttractioninitialinspectionresult;
	private String currenttractiondisqualification;
	private String currenttractionexaminationresult;
	private String insurancelistno;
	private Date insurancedate;
	private String insurancecompanyname;
	private Date expirydate;
	private String reviewer;
	private Date reviewerconductdate;
	private String issueadmin;
	private Date issueadmindate;
	private String leaderreview;
	private Date leaderreviewdate;
	private String operateuser;
	private Date operatedate;
	private String checkuser;
	private Date checkdate;
	private String checkip;
	private int checkresult;
	private String checkcontext;
	private int checktype;
	
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
	private String changeType;
	
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

	public int getOrgintractorstate() {
		return orgintractorstate;
	}
	public void setOrgintractorstate(int orgintractorstate) {
		this.orgintractorstate = orgintractorstate;
	}
	public String getInspectorresult() {
		return inspectorresult;
	}
	public void setInspectorresult(String inspectorresult) {
		this.inspectorresult = inspectorresult;
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
	public Date getInspectordate() {
		return inspectordate;
	}
	public void setInspectordate(Date inspectordate) {
		this.inspectordate = inspectordate;
	}
	public String getCheckcompanyname() {
		return checkcompanyname;
	}
	public void setCheckcompanyname(String checkcompanyname) {
		this.checkcompanyname = checkcompanyname;
	}
	public String getInsurancelistno() {
		return insurancelistno;
	}
	public void setInsurancelistno(String insurancelistno) {
		this.insurancelistno = insurancelistno;
	}
	public Date getInsurancedate() {
		return insurancedate;
	}
	public void setInsurancedate(Date insurancedate) {
		this.insurancedate = insurancedate;
	}
	public String getInsurancecompanyname() {
		return insurancecompanyname;
	}
	public void setInsurancecompanyname(String insurancecompanyname) {
		this.insurancecompanyname = insurancecompanyname;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
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
	public Date getIssueadmindate() {
		return issueadmindate;
	}
	public void setIssueadmindate(Date issueadmindate) {
		this.issueadmindate = issueadmindate;
	}
	public String getLeaderreview() {
		return leaderreview;
	}
	public void setLeaderreview(String leaderreview) {
		this.leaderreview = leaderreview;
	}
	public Date getLeaderreviewdate() {
		return leaderreviewdate;
	}
	public void setLeaderreviewdate(Date leaderreviewdate) {
		this.leaderreviewdate = leaderreviewdate;
	}
	public String getOperateuser() {
		return operateuser;
	}
	public void setOperateuser(String operateuser) {
		this.operateuser = operateuser;
	}
	public Date getOperatedate() {
		return operatedate;
	}
	public void setOperatedate(Date operatedate) {
		this.operatedate = operatedate;
	}
	public String getCheckuser() {
		return checkuser;
	}
	public void setCheckuser(String checkuser) {
		this.checkuser = checkuser;
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
	public int getChecktype() {
		return checktype;
	}
	public void setChecktype(int checktype) {
		this.checktype = checktype;
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
	public String getOrgincheckresult() {
		return orgincheckresult;
	}
	public void setOrgincheckresult(String orgincheckresult) {
		this.orgincheckresult = orgincheckresult;
	}
	public String getOrgindisqualification() {
		return orgindisqualification;
	}
	public void setOrgindisqualification(String orgindisqualification) {
		this.orgindisqualification = orgindisqualification;
	}

	public String getOrgininspector() {
		return orgininspector;
	}
	public void setOrgininspector(String orgininspector) {
		this.orgininspector = orgininspector;
	}
	public Date getOrgincheckdate() {
		return orgincheckdate;
	}
	public void setOrgincheckdate(Date orgincheckdate) {
		this.orgincheckdate = orgincheckdate;
	}
	public String getOrginshowinitialinspectionresult() {
		return orginshowinitialinspectionresult;
	}
	public void setOrginshowinitialinspectionresult(
			String orginshowinitialinspectionresult) {
		this.orginshowinitialinspectionresult = orginshowinitialinspectionresult;
	}
	public String getOrginshowdisqualification() {
		return orginshowdisqualification;
	}
	public void setOrginshowdisqualification(String orginshowdisqualification) {
		this.orginshowdisqualification = orginshowdisqualification;
	}
	public String getOrginshowexaminationresult() {
		return orginshowexaminationresult;
	}
	public void setOrginshowexaminationresult(String orginshowexaminationresult) {
		this.orginshowexaminationresult = orginshowexaminationresult;
	}
	public String getOrginengineinitialinspectionresult() {
		return orginengineinitialinspectionresult;
	}
	public void setOrginengineinitialinspectionresult(
			String orginengineinitialinspectionresult) {
		this.orginengineinitialinspectionresult = orginengineinitialinspectionresult;
	}
	public String getOrginenginedisqualification() {
		return orginenginedisqualification;
	}
	public void setOrginenginedisqualification(String orginenginedisqualification) {
		this.orginenginedisqualification = orginenginedisqualification;
	}
	public String getOrginengineexaminationresult() {
		return orginengineexaminationresult;
	}
	public void setOrginengineexaminationresult(String orginengineexaminationresult) {
		this.orginengineexaminationresult = orginengineexaminationresult;
	}
	public String getOrginconveyorinitialinspectionresult() {
		return orginconveyorinitialinspectionresult;
	}
	public void setOrginconveyorinitialinspectionresult(
			String orginconveyorinitialinspectionresult) {
		this.orginconveyorinitialinspectionresult = orginconveyorinitialinspectionresult;
	}
	public String getOrginconveyordisqualification() {
		return orginconveyordisqualification;
	}
	public void setOrginconveyordisqualification(
			String orginconveyordisqualification) {
		this.orginconveyordisqualification = orginconveyordisqualification;
	}
	public String getOrginconveyorexaminationresult() {
		return orginconveyorexaminationresult;
	}
	public void setOrginconveyorexaminationresult(
			String orginconveyorexaminationresult) {
		this.orginconveyorexaminationresult = orginconveyorexaminationresult;
	}
	public String getOrginsteeringinitialinspectionresult() {
		return orginsteeringinitialinspectionresult;
	}
	public void setOrginsteeringinitialinspectionresult(
			String orginsteeringinitialinspectionresult) {
		this.orginsteeringinitialinspectionresult = orginsteeringinitialinspectionresult;
	}
	public String getOrginsteeringdisqualification() {
		return orginsteeringdisqualification;
	}
	public void setOrginsteeringdisqualification(
			String orginsteeringdisqualification) {
		this.orginsteeringdisqualification = orginsteeringdisqualification;
	}
	public String getOrginsteeringexaminationresult() {
		return orginsteeringexaminationresult;
	}
	public void setOrginsteeringexaminationresult(
			String orginsteeringexaminationresult) {
		this.orginsteeringexaminationresult = orginsteeringexaminationresult;
	}
	public String getOrginflyhostinitialinspectionresult() {
		return orginflyhostinitialinspectionresult;
	}
	public void setOrginflyhostinitialinspectionresult(
			String orginflyhostinitialinspectionresult) {
		this.orginflyhostinitialinspectionresult = orginflyhostinitialinspectionresult;
	}
	public String getOrginflyhostdisqualification() {
		return orginflyhostdisqualification;
	}
	public void setOrginflyhostdisqualification(String orginflyhostdisqualification) {
		this.orginflyhostdisqualification = orginflyhostdisqualification;
	}
	public String getOrginflyhostexaminationresult() {
		return orginflyhostexaminationresult;
	}
	public void setOrginflyhostexaminationresult(
			String orginflyhostexaminationresult) {
		this.orginflyhostexaminationresult = orginflyhostexaminationresult;
	}
	public String getOrginflytrailerinitialinspectionresult() {
		return orginflytrailerinitialinspectionresult;
	}
	public void setOrginflytrailerinitialinspectionresult(
			String orginflytrailerinitialinspectionresult) {
		this.orginflytrailerinitialinspectionresult = orginflytrailerinitialinspectionresult;
	}
	public String getOrginflytrailerdisqualification() {
		return orginflytrailerdisqualification;
	}
	public void setOrginflytrailerdisqualification(
			String orginflytrailerdisqualification) {
		this.orginflytrailerdisqualification = orginflytrailerdisqualification;
	}
	public String getOrginflytrailerexaminationresult() {
		return orginflytrailerexaminationresult;
	}
	public void setOrginflytrailerexaminationresult(
			String orginflytrailerexaminationresult) {
		this.orginflytrailerexaminationresult = orginflytrailerexaminationresult;
	}
	public String getOrginbrakhostinitialinspectionresult() {
		return orginbrakhostinitialinspectionresult;
	}
	public void setOrginbrakhostinitialinspectionresult(
			String orginbrakhostinitialinspectionresult) {
		this.orginbrakhostinitialinspectionresult = orginbrakhostinitialinspectionresult;
	}
	public String getOrginbrakhostdisqualification() {
		return orginbrakhostdisqualification;
	}
	public void setOrginbrakhostdisqualification(
			String orginbrakhostdisqualification) {
		this.orginbrakhostdisqualification = orginbrakhostdisqualification;
	}
	public String getOrginbrakhostexaminationresult() {
		return orginbrakhostexaminationresult;
	}
	public void setOrginbrakhostexaminationresult(
			String orginbrakhostexaminationresult) {
		this.orginbrakhostexaminationresult = orginbrakhostexaminationresult;
	}
	public String getOrginbraktrailerinitialinspectionresult() {
		return orginbraktrailerinitialinspectionresult;
	}
	public void setOrginbraktrailerinitialinspectionresult(
			String orginbraktrailerinitialinspectionresult) {
		this.orginbraktrailerinitialinspectionresult = orginbraktrailerinitialinspectionresult;
	}
	public String getOrginbraktrailerdisqualification() {
		return orginbraktrailerdisqualification;
	}
	public void setOrginbraktrailerdisqualification(
			String orginbraktrailerdisqualification) {
		this.orginbraktrailerdisqualification = orginbraktrailerdisqualification;
	}
	public String getOrginbraktrailerexaminationresult() {
		return orginbraktrailerexaminationresult;
	}
	public void setOrginbraktrailerexaminationresult(
			String orginbraktrailerexaminationresult) {
		this.orginbraktrailerexaminationresult = orginbraktrailerexaminationresult;
	}
	public String getOrginlighthostinitialinspectionresult() {
		return orginlighthostinitialinspectionresult;
	}
	public void setOrginlighthostinitialinspectionresult(
			String orginlighthostinitialinspectionresult) {
		this.orginlighthostinitialinspectionresult = orginlighthostinitialinspectionresult;
	}
	public String getOrginlighthostdisqualification() {
		return orginlighthostdisqualification;
	}
	public void setOrginlighthostdisqualification(
			String orginlighthostdisqualification) {
		this.orginlighthostdisqualification = orginlighthostdisqualification;
	}
	public String getOrginlighthostexaminationresult() {
		return orginlighthostexaminationresult;
	}
	public void setOrginlighthostexaminationresult(
			String orginlighthostexaminationresult) {
		this.orginlighthostexaminationresult = orginlighthostexaminationresult;
	}
	public String getOrginlighttrailerinitialinspectionresult() {
		return orginlighttrailerinitialinspectionresult;
	}
	public void setOrginlighttrailerinitialinspectionresult(
			String orginlighttrailerinitialinspectionresult) {
		this.orginlighttrailerinitialinspectionresult = orginlighttrailerinitialinspectionresult;
	}
	public String getOrginlighttrailerdisqualification() {
		return orginlighttrailerdisqualification;
	}
	public void setOrginlighttrailerdisqualification(
			String orginlighttrailerdisqualification) {
		this.orginlighttrailerdisqualification = orginlighttrailerdisqualification;
	}
	public String getOrginlighttrailerexaminationresult() {
		return orginlighttrailerexaminationresult;
	}
	public void setOrginlighttrailerexaminationresult(
			String orginlighttrailerexaminationresult) {
		this.orginlighttrailerexaminationresult = orginlighttrailerexaminationresult;
	}
	public String getOrgintractioninitialinspectionresult() {
		return orgintractioninitialinspectionresult;
	}
	public void setOrgintractioninitialinspectionresult(
			String orgintractioninitialinspectionresult) {
		this.orgintractioninitialinspectionresult = orgintractioninitialinspectionresult;
	}
	public String getOrgintractiondisqualification() {
		return orgintractiondisqualification;
	}
	public void setOrgintractiondisqualification(
			String orgintractiondisqualification) {
		this.orgintractiondisqualification = orgintractiondisqualification;
	}
	public String getOrgintractionexaminationresult() {
		return orgintractionexaminationresult;
	}
	public void setOrgintractionexaminationresult(
			String orgintractionexaminationresult) {
		this.orgintractionexaminationresult = orgintractionexaminationresult;
	}
	public String getOrgininsurancelistno() {
		return orgininsurancelistno;
	}
	public void setOrgininsurancelistno(String orgininsurancelistno) {
		this.orgininsurancelistno = orgininsurancelistno;
	}
	public Date getOrgininsurancedate() {
		return orgininsurancedate;
	}
	public void setOrgininsurancedate(Date orgininsurancedate) {
		this.orgininsurancedate = orgininsurancedate;
	}
	public String getOrgininsurancecompanyname() {
		return orgininsurancecompanyname;
	}
	public void setOrgininsurancecompanyname(String orgininsurancecompanyname) {
		this.orgininsurancecompanyname = orgininsurancecompanyname;
	}

	public String getCurrentdisqualification() {
		return currentdisqualification;
	}
	public void setCurrentdisqualification(String currentdisqualification) {
		this.currentdisqualification = currentdisqualification;
	}
	public String getCurrentshowinitialinspectionresult() {
		return currentshowinitialinspectionresult;
	}
	public void setCurrentshowinitialinspectionresult(
			String currentshowinitialinspectionresult) {
		this.currentshowinitialinspectionresult = currentshowinitialinspectionresult;
	}
	public String getCurrentshowdisqualification() {
		return currentshowdisqualification;
	}
	public void setCurrentshowdisqualification(String currentshowdisqualification) {
		this.currentshowdisqualification = currentshowdisqualification;
	}
	public String getCurrentshowexaminationresult() {
		return currentshowexaminationresult;
	}
	public void setCurrentshowexaminationresult(String currentshowexaminationresult) {
		this.currentshowexaminationresult = currentshowexaminationresult;
	}
	public String getCurrentengineinitialinspectionresult() {
		return currentengineinitialinspectionresult;
	}
	public void setCurrentengineinitialinspectionresult(
			String currentengineinitialinspectionresult) {
		this.currentengineinitialinspectionresult = currentengineinitialinspectionresult;
	}
	public String getCurrentenginedisqualification() {
		return currentenginedisqualification;
	}
	public void setCurrentenginedisqualification(
			String currentenginedisqualification) {
		this.currentenginedisqualification = currentenginedisqualification;
	}
	public String getCurrentengineexaminationresult() {
		return currentengineexaminationresult;
	}
	public void setCurrentengineexaminationresult(
			String currentengineexaminationresult) {
		this.currentengineexaminationresult = currentengineexaminationresult;
	}
	public String getCurrentconveyorinitialinspectionresult() {
		return currentconveyorinitialinspectionresult;
	}
	public void setCurrentconveyorinitialinspectionresult(
			String currentconveyorinitialinspectionresult) {
		this.currentconveyorinitialinspectionresult = currentconveyorinitialinspectionresult;
	}
	public String getCurrentconveyordisqualification() {
		return currentconveyordisqualification;
	}
	public void setCurrentconveyordisqualification(
			String currentconveyordisqualification) {
		this.currentconveyordisqualification = currentconveyordisqualification;
	}
	public String getCurrentconveyorexaminationresult() {
		return currentconveyorexaminationresult;
	}
	public void setCurrentconveyorexaminationresult(
			String currentconveyorexaminationresult) {
		this.currentconveyorexaminationresult = currentconveyorexaminationresult;
	}
	public String getCurrentsteeringinitialinspectionresult() {
		return currentsteeringinitialinspectionresult;
	}
	public void setCurrentsteeringinitialinspectionresult(
			String currentsteeringinitialinspectionresult) {
		this.currentsteeringinitialinspectionresult = currentsteeringinitialinspectionresult;
	}
	public String getCurrentsteeringdisqualification() {
		return currentsteeringdisqualification;
	}
	public void setCurrentsteeringdisqualification(
			String currentsteeringdisqualification) {
		this.currentsteeringdisqualification = currentsteeringdisqualification;
	}
	public String getCurrentsteeringexaminationresult() {
		return currentsteeringexaminationresult;
	}
	public void setCurrentsteeringexaminationresult(
			String currentsteeringexaminationresult) {
		this.currentsteeringexaminationresult = currentsteeringexaminationresult;
	}
	public String getCurrentflyhostinitialinspectionresult() {
		return currentflyhostinitialinspectionresult;
	}
	public void setCurrentflyhostinitialinspectionresult(
			String currentflyhostinitialinspectionresult) {
		this.currentflyhostinitialinspectionresult = currentflyhostinitialinspectionresult;
	}
	public String getCurrentflyhostdisqualification() {
		return currentflyhostdisqualification;
	}
	public void setCurrentflyhostdisqualification(
			String currentflyhostdisqualification) {
		this.currentflyhostdisqualification = currentflyhostdisqualification;
	}
	public String getCurrentflyhostexaminationresult() {
		return currentflyhostexaminationresult;
	}
	public void setCurrentflyhostexaminationresult(
			String currentflyhostexaminationresult) {
		this.currentflyhostexaminationresult = currentflyhostexaminationresult;
	}
	public String getCurrentflytrailerinitialinspectionresult() {
		return currentflytrailerinitialinspectionresult;
	}
	public void setCurrentflytrailerinitialinspectionresult(
			String currentflytrailerinitialinspectionresult) {
		this.currentflytrailerinitialinspectionresult = currentflytrailerinitialinspectionresult;
	}
	public String getCurrentflytrailerdisqualification() {
		return currentflytrailerdisqualification;
	}
	public void setCurrentflytrailerdisqualification(
			String currentflytrailerdisqualification) {
		this.currentflytrailerdisqualification = currentflytrailerdisqualification;
	}
	public String getCurrentflytrailerexaminationresult() {
		return currentflytrailerexaminationresult;
	}
	public void setCurrentflytrailerexaminationresult(
			String currentflytrailerexaminationresult) {
		this.currentflytrailerexaminationresult = currentflytrailerexaminationresult;
	}
	public String getCurrentbrakhostinitialinspectionresult() {
		return currentbrakhostinitialinspectionresult;
	}
	public void setCurrentbrakhostinitialinspectionresult(
			String currentbrakhostinitialinspectionresult) {
		this.currentbrakhostinitialinspectionresult = currentbrakhostinitialinspectionresult;
	}
	public String getCurrentbrakhostdisqualification() {
		return currentbrakhostdisqualification;
	}
	public void setCurrentbrakhostdisqualification(
			String currentbrakhostdisqualification) {
		this.currentbrakhostdisqualification = currentbrakhostdisqualification;
	}
	public String getCurrentbrakhostexaminationresult() {
		return currentbrakhostexaminationresult;
	}
	public void setCurrentbrakhostexaminationresult(
			String currentbrakhostexaminationresult) {
		this.currentbrakhostexaminationresult = currentbrakhostexaminationresult;
	}
	public String getCurrentbraktrailerinitialinspectionresult() {
		return currentbraktrailerinitialinspectionresult;
	}
	public void setCurrentbraktrailerinitialinspectionresult(
			String currentbraktrailerinitialinspectionresult) {
		this.currentbraktrailerinitialinspectionresult = currentbraktrailerinitialinspectionresult;
	}
	public String getCurrentbraktrailerdisqualification() {
		return currentbraktrailerdisqualification;
	}
	public void setCurrentbraktrailerdisqualification(
			String currentbraktrailerdisqualification) {
		this.currentbraktrailerdisqualification = currentbraktrailerdisqualification;
	}
	public String getCurrentbraktrailerexaminationresult() {
		return currentbraktrailerexaminationresult;
	}
	public void setCurrentbraktrailerexaminationresult(
			String currentbraktrailerexaminationresult) {
		this.currentbraktrailerexaminationresult = currentbraktrailerexaminationresult;
	}
	public String getCurrentlighthostinitialinspectionresult() {
		return currentlighthostinitialinspectionresult;
	}
	public void setCurrentlighthostinitialinspectionresult(
			String currentlighthostinitialinspectionresult) {
		this.currentlighthostinitialinspectionresult = currentlighthostinitialinspectionresult;
	}
	public String getCurrentlighthostdisqualification() {
		return currentlighthostdisqualification;
	}
	public void setCurrentlighthostdisqualification(
			String currentlighthostdisqualification) {
		this.currentlighthostdisqualification = currentlighthostdisqualification;
	}
	public String getCurrentlighthostexaminationresult() {
		return currentlighthostexaminationresult;
	}
	public void setCurrentlighthostexaminationresult(
			String currentlighthostexaminationresult) {
		this.currentlighthostexaminationresult = currentlighthostexaminationresult;
	}
	public String getCurrentlighttrailerinitialinspectionresult() {
		return currentlighttrailerinitialinspectionresult;
	}
	public void setCurrentlighttrailerinitialinspectionresult(
			String currentlighttrailerinitialinspectionresult) {
		this.currentlighttrailerinitialinspectionresult = currentlighttrailerinitialinspectionresult;
	}
	public String getCurrentlighttrailerdisqualification() {
		return currentlighttrailerdisqualification;
	}
	public void setCurrentlighttrailerdisqualification(
			String currentlighttrailerdisqualification) {
		this.currentlighttrailerdisqualification = currentlighttrailerdisqualification;
	}
	public String getCurrentlighttrailerexaminationresult() {
		return currentlighttrailerexaminationresult;
	}
	public void setCurrentlighttrailerexaminationresult(
			String currentlighttrailerexaminationresult) {
		this.currentlighttrailerexaminationresult = currentlighttrailerexaminationresult;
	}
	public String getCurrenttractioninitialinspectionresult() {
		return currenttractioninitialinspectionresult;
	}
	public void setCurrenttractioninitialinspectionresult(
			String currenttractioninitialinspectionresult) {
		this.currenttractioninitialinspectionresult = currenttractioninitialinspectionresult;
	}
	public String getCurrenttractiondisqualification() {
		return currenttractiondisqualification;
	}
	public void setCurrenttractiondisqualification(
			String currenttractiondisqualification) {
		this.currenttractiondisqualification = currenttractiondisqualification;
	}
	public String getCurrenttractionexaminationresult() {
		return currenttractionexaminationresult;
	}
	public void setCurrenttractionexaminationresult(
			String currenttractionexaminationresult) {
		this.currenttractionexaminationresult = currenttractionexaminationresult;
	}
	public Date getOrginexpirydate() {
		return orginexpirydate;
	}
	public void setOrginexpirydate(Date orginexpirydate) {
		this.orginexpirydate = orginexpirydate;
	}
	public Date getOrgincheckexpirydate() {
		return orgincheckexpirydate;
	}
	public void setOrgincheckexpirydate(Date orgincheckexpirydate) {
		this.orgincheckexpirydate = orgincheckexpirydate;
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
