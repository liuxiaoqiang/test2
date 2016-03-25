package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_carchange_view")
public class CarChangeView {
    private int id;
 	private int tractorinfoId;
 	private String changeType;
 	private String applicationmen;
 	private Date applicationtime;
 	private String applicationip;
 	private String approvalmen;
 	private Date approvaltime;
 	private int approvalstate;
 	private String approvalip;
 	private String approvacontext;
      
	//private int changecolorid;
    private String changecolorid;
	private String orgincolor;
	private String cuurentcolor;
	private String changecolorphotourl;
	
	//private int changeengineid;
	private String changeengineid;
	private String changeenginecode;
	private String changeenginefueltype;
	private String enginebrand;
	private String cylindernumber;
	private String changeenginepower;
	private String newenginecode;
	//private int newfueltype;
	private String newfueltype;
	//private int newenginebrand;
	private String newenginebrand;
	private String newcylindernumber;
	private String newpower;
	private String engineproof;//发动机来历证明
	private String engineproofnumber;//发动机合格证明编号
 	
	//private int changetrailerid;
	private String changetrailerid;
	//private int orgintires;
	private String orgintires;
	private String orgintrack;
	private String orginnorm;
	//private int currenttires;
	private String currenttires;
	private String currenttrack;
	private String currentnorm;
	
	//private int changeownerid;
	private String changeownerid;
	private String orginusername;
	private String orginlintel;
	private String orgincertificateid;
	private String orgincertificatecode;
	private String orginunittype;
	private String orginaddress;
	private String orginzipcode;
	private String orginistemporary;
	private String orgintemporaycertificate;
	private String orgintemporaycertificatecode;
	private String username;
	private String lintel;
	//private int certificateid;
	private String certificateid;
	private String certificatecode;
	//private int unittype;
	private String unittype;
	private String currentaddress;
	private String zipcode;
	//private int istemporary;
	private String istemporary;
	//private int temporaycertificate;
	private String temporaycertificate;
	private String temporaycertificatecode;
	
	//private int changebodyid;
	private String changebodyid;
	private String orgingettypeid;
	private String orginmachinetypeid;
	private String orginengineid;
	private String orginbodycode;
	private String orginenginecode;
	private String orginrackcode;
	private String orginusernature;
	private String orginfactoryname;
	private String orginsaleunit;
	private Date orginreleasedate;
	private String orginprice;
	private String orginphotourl;
	private String orgingetwayfiletypeid;
	private String orgingetwayfiletypecode;
	private String orginimportsfiletypeid;
	private String orginimportsfiletypecode;
	private String orginother;
	private String orgininsurancelistno;
	private String orgininsurancecompany;
	private Date orgininsurancedate;
	private Date orgininsurancevalidate;
	private String orginbodycolor;
	private String orginsize;
	private String orgindirectcontrol;
	private String orgincontainersize;
	private String orginenginebrandid;
	private String orginpower;
	private String orgincylinderno;
	private String orginfueltype;
	private String orginwheelno;
	private String orginwheelbase;
	//private int orgintiresno;
	private String orgintiresno;
	private String orgintiressize;
	private String orginwheeldis;
	private String orgintotalquality;
	private String orginallquality;
	private String orginratifiedload;
	private String orginallowdragtotalquality;
	//private int orgindriverinno;
	private String orgindriverinno;
	private String orginsteelspring;
	//private int orginvicecartiresno;
	private String orginvicecartiresno;
	private String orginoutcarwheeldis;
	private String orginoutcartiressize;
	//private int gettypeid;
	private String gettypeid;
	//private int machinetypeid;
	private String machinetypeid;
	//private int engineid;
	private String engineid;
	private String bodycode;
	private String enginecode;
	private String rackcode;
	private String usernature;
	private String factoryname;
	private String saleunit;
	private Date releasedate;
	private String price;
	private String photourl;
	//private int getwayfiletypeid;
	private String getwayfiletypeid;
	private String getwayfiletypecode;
	//private int importsfiletypeid;
	private String importsfiletypeid;
	private String importsfiletypecode;
	private String other;
	private String insurancelistno;
	private String insurancecompany;
	private Date insurancedate;
	private Date insurancevalidate;
	private String bodycolor;
	private String size;
	private String directcontrol;
	private String containersize;
	//private int enginebrandid;
	private String enginebrandid;
	private String power;
	private String cylinderno;
	//private int fueltypeid;
	private String fueltypeid;
	private String wheelno;
	private String wheelbase;
	//private int tiresno;
	private String tiresno;
	private String tiressize;
	private String wheeldis;
	private String totalquality;
	private String allquality;
	private String ratifiedload;
	private String allowdragtotalquality;
	private String driverinno;//输入值为int
	private String steelspring;
	private String vicecartiresno;//输入值为int
	private String outcarwheeldis;
	private String outcartiressize;
	
	private String templivefileType;
	private String getway;
	private String machinetype;
	private String plantType;
	
	
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
	private String tractorinfoplantType;
	
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
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getApplicationmen() {
		return applicationmen;
	}
	public void setApplicationmen(String applicationmen) {
		this.applicationmen = applicationmen;
	}
	public Date getApplicationtime() {
		return applicationtime;
	}
	public void setApplicationtime(Date applicationtime) {
		this.applicationtime = applicationtime;
	}
	public String getApplicationip() {
		return applicationip;
	}
	public void setApplicationip(String applicationip) {
		this.applicationip = applicationip;
	}
	public String getApprovalmen() {
		return approvalmen;
	}
	public void setApprovalmen(String approvalmen) {
		this.approvalmen = approvalmen;
	}
	public Date getApprovaltime() {
		return approvaltime;
	}
	public void setApprovaltime(Date approvaltime) {
		this.approvaltime = approvaltime;
	}
	public int getApprovalstate() {
		return approvalstate;
	}
	public void setApprovalstate(int approvalstate) {
		this.approvalstate = approvalstate;
	}
	public String getApprovalip() {
		return approvalip;
	}
	public void setApprovalip(String approvalip) {
		this.approvalip = approvalip;
	}
	public String getApprovacontext() {
		return approvacontext;
	}
	public void setApprovacontext(String approvacontext) {
		this.approvacontext = approvacontext;
	}
	public String getChangecolorid() {
		return changecolorid;
	}
	public void setChangecolorid(String changecolorid) {
		this.changecolorid = changecolorid;
	}
	public String getOrgincolor() {
		return orgincolor;
	}
	public void setOrgincolor(String orgincolor) {
		this.orgincolor = orgincolor;
	}
	public String getCuurentcolor() {
		return cuurentcolor;
	}
	public void setCuurentcolor(String cuurentcolor) {
		this.cuurentcolor = cuurentcolor;
	}
	public String getChangecolorphotourl() {
		return changecolorphotourl;
	}
	public void setChangecolorphotourl(String changecolorphotourl) {
		this.changecolorphotourl = changecolorphotourl;
	}
	public String getChangeengineid() {
		return changeengineid;
	}
	public void setChangeengineid(String changeengineid) {
		this.changeengineid = changeengineid;
	}
	public String getChangeenginecode() {
		return changeenginecode;
	}
	public void setChangeenginecode(String changeenginecode) {
		this.changeenginecode = changeenginecode;
	}
	public String getChangeenginefueltype() {
		return changeenginefueltype;
	}
	public void setChangeenginefueltype(String changeenginefueltype) {
		this.changeenginefueltype = changeenginefueltype;
	}
	public String getEnginebrand() {
		return enginebrand;
	}
	public void setEnginebrand(String enginebrand) {
		this.enginebrand = enginebrand;
	}
	public String getCylindernumber() {
		return cylindernumber;
	}
	public void setCylindernumber(String cylindernumber) {
		this.cylindernumber = cylindernumber;
	}
	public String getChangeenginepower() {
		return changeenginepower;
	}
	public void setChangeenginepower(String changeenginepower) {
		this.changeenginepower = changeenginepower;
	}
	public String getNewenginecode() {
		return newenginecode;
	}
	public void setNewenginecode(String newenginecode) {
		this.newenginecode = newenginecode;
	}
	public String getNewfueltype() {
		return newfueltype;
	}
	public void setNewfueltype(String newfueltype) {
		this.newfueltype = newfueltype;
	}
	public String getNewenginebrand() {
		return newenginebrand;
	}
	public void setNewenginebrand(String newenginebrand) {
		this.newenginebrand = newenginebrand;
	}
	public String getNewcylindernumber() {
		return newcylindernumber;
	}
	public void setNewcylindernumber(String newcylindernumber) {
		this.newcylindernumber = newcylindernumber;
	}
	public String getNewpower() {
		return newpower;
	}
	public void setNewpower(String newpower) {
		this.newpower = newpower;
	}
	public String getEngineproof() {
		return engineproof;
	}
	public void setEngineproof(String engineproof) {
		this.engineproof = engineproof;
	}
	public String getEngineproofnumber() {
		return engineproofnumber;
	}
	public void setEngineproofnumber(String engineproofnumber) {
		this.engineproofnumber = engineproofnumber;
	}
	public String getChangetrailerid() {
		return changetrailerid;
	}
	public void setChangetrailerid(String changetrailerid) {
		this.changetrailerid = changetrailerid;
	}
	public String getOrgintires() {
		return orgintires;
	}
	public void setOrgintires(String orgintires) {
		this.orgintires = orgintires;
	}
	public String getOrgintrack() {
		return orgintrack;
	}
	public void setOrgintrack(String orgintrack) {
		this.orgintrack = orgintrack;
	}
	public String getOrginnorm() {
		return orginnorm;
	}
	public void setOrginnorm(String orginnorm) {
		this.orginnorm = orginnorm;
	}
	public String getCurrenttires() {
		return currenttires;
	}
	public void setCurrenttires(String currenttires) {
		this.currenttires = currenttires;
	}
	public String getCurrenttrack() {
		return currenttrack;
	}
	public void setCurrenttrack(String currenttrack) {
		this.currenttrack = currenttrack;
	}
	public String getCurrentnorm() {
		return currentnorm;
	}
	public void setCurrentnorm(String currentnorm) {
		this.currentnorm = currentnorm;
	}
	public String getChangeownerid() {
		return changeownerid;
	}
	public void setChangeownerid(String changeownerid) {
		this.changeownerid = changeownerid;
	}
	public String getOrginusername() {
		return orginusername;
	}
	public void setOrginusername(String orginusername) {
		this.orginusername = orginusername;
	}
	public String getOrginlintel() {
		return orginlintel;
	}
	public void setOrginlintel(String orginlintel) {
		this.orginlintel = orginlintel;
	}
	public String getOrgincertificateid() {
		return orgincertificateid;
	}
	public void setOrgincertificateid(String orgincertificateid) {
		this.orgincertificateid = orgincertificateid;
	}
	public String getOrgincertificatecode() {
		return orgincertificatecode;
	}
	public void setOrgincertificatecode(String orgincertificatecode) {
		this.orgincertificatecode = orgincertificatecode;
	}
	public String getOrginunittype() {
		return orginunittype;
	}
	public void setOrginunittype(String orginunittype) {
		this.orginunittype = orginunittype;
	}
	public String getOrginaddress() {
		return orginaddress;
	}
	public void setOrginaddress(String orginaddress) {
		this.orginaddress = orginaddress;
	}
	public String getOrginzipcode() {
		return orginzipcode;
	}
	public void setOrginzipcode(String orginzipcode) {
		this.orginzipcode = orginzipcode;
	}
	public String getOrginistemporary() {
		return orginistemporary;
	}
	public void setOrginistemporary(String orginistemporary) {
		this.orginistemporary = orginistemporary;
	}
	public String getOrgintemporaycertificate() {
		return orgintemporaycertificate;
	}
	public void setOrgintemporaycertificate(String orgintemporaycertificate) {
		this.orgintemporaycertificate = orgintemporaycertificate;
	}
	public String getOrgintemporaycertificatecode() {
		return orgintemporaycertificatecode;
	}
	public void setOrgintemporaycertificatecode(String orgintemporaycertificatecode) {
		this.orgintemporaycertificatecode = orgintemporaycertificatecode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLintel() {
		return lintel;
	}
	public void setLintel(String lintel) {
		this.lintel = lintel;
	}
	public String getCertificateid() {
		return certificateid;
	}
	public void setCertificateid(String certificateid) {
		this.certificateid = certificateid;
	}
	public String getCertificatecode() {
		return certificatecode;
	}
	public void setCertificatecode(String certificatecode) {
		this.certificatecode = certificatecode;
	}
	public String getUnittype() {
		return unittype;
	}
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}
	public String getCurrentaddress() {
		return currentaddress;
	}
	public void setCurrentaddress(String currentaddress) {
		this.currentaddress = currentaddress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getIstemporary() {
		return istemporary;
	}
	public void setIstemporary(String istemporary) {
		this.istemporary = istemporary;
	}
	public String getTemporaycertificate() {
		return temporaycertificate;
	}
	public void setTemporaycertificate(String temporaycertificate) {
		this.temporaycertificate = temporaycertificate;
	}
	public String getTemporaycertificatecode() {
		return temporaycertificatecode;
	}
	public void setTemporaycertificatecode(String temporaycertificatecode) {
		this.temporaycertificatecode = temporaycertificatecode;
	}
	public String getChangebodyid() {
		return changebodyid;
	}
	public void setChangebodyid(String changebodyid) {
		this.changebodyid = changebodyid;
	}
	public String getOrgingettypeid() {
		return orgingettypeid;
	}
	public void setOrgingettypeid(String orgingettypeid) {
		this.orgingettypeid = orgingettypeid;
	}
	public String getOrginmachinetypeid() {
		return orginmachinetypeid;
	}
	public void setOrginmachinetypeid(String orginmachinetypeid) {
		this.orginmachinetypeid = orginmachinetypeid;
	}
	public String getOrginengineid() {
		return orginengineid;
	}
	public void setOrginengineid(String orginengineid) {
		this.orginengineid = orginengineid;
	}
	public String getOrginbodycode() {
		return orginbodycode;
	}
	public void setOrginbodycode(String orginbodycode) {
		this.orginbodycode = orginbodycode;
	}
	public String getOrginenginecode() {
		return orginenginecode;
	}
	public void setOrginenginecode(String orginenginecode) {
		this.orginenginecode = orginenginecode;
	}
	public String getOrginrackcode() {
		return orginrackcode;
	}
	public void setOrginrackcode(String orginrackcode) {
		this.orginrackcode = orginrackcode;
	}
	public String getOrginusernature() {
		return orginusernature;
	}
	public void setOrginusernature(String orginusernature) {
		this.orginusernature = orginusernature;
	}
	public String getOrginfactoryname() {
		return orginfactoryname;
	}
	public void setOrginfactoryname(String orginfactoryname) {
		this.orginfactoryname = orginfactoryname;
	}
	public String getOrginsaleunit() {
		return orginsaleunit;
	}
	public void setOrginsaleunit(String orginsaleunit) {
		this.orginsaleunit = orginsaleunit;
	}
	public Date getOrginreleasedate() {
		return orginreleasedate;
	}
	public void setOrginreleasedate(Date orginreleasedate) {
		this.orginreleasedate = orginreleasedate;
	}
	public String getOrginprice() {
		return orginprice;
	}
	public void setOrginprice(String orginprice) {
		this.orginprice = orginprice;
	}
	public String getOrginphotourl() {
		return orginphotourl;
	}
	public void setOrginphotourl(String orginphotourl) {
		this.orginphotourl = orginphotourl;
	}
	public String getOrgingetwayfiletypeid() {
		return orgingetwayfiletypeid;
	}
	public void setOrgingetwayfiletypeid(String orgingetwayfiletypeid) {
		this.orgingetwayfiletypeid = orgingetwayfiletypeid;
	}
	public String getOrgingetwayfiletypecode() {
		return orgingetwayfiletypecode;
	}
	public void setOrgingetwayfiletypecode(String orgingetwayfiletypecode) {
		this.orgingetwayfiletypecode = orgingetwayfiletypecode;
	}
	public String getOrginimportsfiletypeid() {
		return orginimportsfiletypeid;
	}
	public void setOrginimportsfiletypeid(String orginimportsfiletypeid) {
		this.orginimportsfiletypeid = orginimportsfiletypeid;
	}
	public String getOrginimportsfiletypecode() {
		return orginimportsfiletypecode;
	}
	public void setOrginimportsfiletypecode(String orginimportsfiletypecode) {
		this.orginimportsfiletypecode = orginimportsfiletypecode;
	}
	public String getOrginother() {
		return orginother;
	}
	public void setOrginother(String orginother) {
		this.orginother = orginother;
	}
	public String getOrgininsurancelistno() {
		return orgininsurancelistno;
	}
	public void setOrgininsurancelistno(String orgininsurancelistno) {
		this.orgininsurancelistno = orgininsurancelistno;
	}
	public String getOrgininsurancecompany() {
		return orgininsurancecompany;
	}
	public void setOrgininsurancecompany(String orgininsurancecompany) {
		this.orgininsurancecompany = orgininsurancecompany;
	}
	public Date getOrgininsurancedate() {
		return orgininsurancedate;
	}
	public void setOrgininsurancedate(Date orgininsurancedate) {
		this.orgininsurancedate = orgininsurancedate;
	}
	public Date getOrgininsurancevalidate() {
		return orgininsurancevalidate;
	}
	public void setOrgininsurancevalidate(Date orgininsurancevalidate) {
		this.orgininsurancevalidate = orgininsurancevalidate;
	}
	public String getOrginbodycolor() {
		return orginbodycolor;
	}
	public void setOrginbodycolor(String orginbodycolor) {
		this.orginbodycolor = orginbodycolor;
	}
	public String getOrginsize() {
		return orginsize;
	}
	public void setOrginsize(String orginsize) {
		this.orginsize = orginsize;
	}
	public String getOrgindirectcontrol() {
		return orgindirectcontrol;
	}
	public void setOrgindirectcontrol(String orgindirectcontrol) {
		this.orgindirectcontrol = orgindirectcontrol;
	}
	public String getOrgincontainersize() {
		return orgincontainersize;
	}
	public void setOrgincontainersize(String orgincontainersize) {
		this.orgincontainersize = orgincontainersize;
	}
	public String getOrginenginebrandid() {
		return orginenginebrandid;
	}
	public void setOrginenginebrandid(String orginenginebrandid) {
		this.orginenginebrandid = orginenginebrandid;
	}
	public String getOrginpower() {
		return orginpower;
	}
	public void setOrginpower(String orginpower) {
		this.orginpower = orginpower;
	}
	public String getOrgincylinderno() {
		return orgincylinderno;
	}
	public void setOrgincylinderno(String orgincylinderno) {
		this.orgincylinderno = orgincylinderno;
	}
	public String getOrginfueltype() {
		return orginfueltype;
	}
	public void setOrginfueltype(String orginfueltype) {
		this.orginfueltype = orginfueltype;
	}
	public String getOrginwheelno() {
		return orginwheelno;
	}
	public void setOrginwheelno(String orginwheelno) {
		this.orginwheelno = orginwheelno;
	}
	public String getOrginwheelbase() {
		return orginwheelbase;
	}
	public void setOrginwheelbase(String orginwheelbase) {
		this.orginwheelbase = orginwheelbase;
	}
	public String getOrgintiresno() {
		return orgintiresno;
	}
	public void setOrgintiresno(String orgintiresno) {
		this.orgintiresno = orgintiresno;
	}
	public String getOrgintiressize() {
		return orgintiressize;
	}
	public void setOrgintiressize(String orgintiressize) {
		this.orgintiressize = orgintiressize;
	}
	public String getOrginwheeldis() {
		return orginwheeldis;
	}
	public void setOrginwheeldis(String orginwheeldis) {
		this.orginwheeldis = orginwheeldis;
	}
	public String getOrgintotalquality() {
		return orgintotalquality;
	}
	public void setOrgintotalquality(String orgintotalquality) {
		this.orgintotalquality = orgintotalquality;
	}
	public String getOrginallquality() {
		return orginallquality;
	}
	public void setOrginallquality(String orginallquality) {
		this.orginallquality = orginallquality;
	}
	public String getOrginratifiedload() {
		return orginratifiedload;
	}
	public void setOrginratifiedload(String orginratifiedload) {
		this.orginratifiedload = orginratifiedload;
	}
	public String getOrginallowdragtotalquality() {
		return orginallowdragtotalquality;
	}
	public void setOrginallowdragtotalquality(String orginallowdragtotalquality) {
		this.orginallowdragtotalquality = orginallowdragtotalquality;
	}
	public String getOrgindriverinno() {
		return orgindriverinno;
	}
	public void setOrgindriverinno(String orgindriverinno) {
		this.orgindriverinno = orgindriverinno;
	}
	public String getOrginsteelspring() {
		return orginsteelspring;
	}
	public void setOrginsteelspring(String orginsteelspring) {
		this.orginsteelspring = orginsteelspring;
	}
	public String getOrginvicecartiresno() {
		return orginvicecartiresno;
	}
	public void setOrginvicecartiresno(String orginvicecartiresno) {
		this.orginvicecartiresno = orginvicecartiresno;
	}
	public String getOrginoutcarwheeldis() {
		return orginoutcarwheeldis;
	}
	public void setOrginoutcarwheeldis(String orginoutcarwheeldis) {
		this.orginoutcarwheeldis = orginoutcarwheeldis;
	}
	public String getOrginoutcartiressize() {
		return orginoutcartiressize;
	}
	public void setOrginoutcartiressize(String orginoutcartiressize) {
		this.orginoutcartiressize = orginoutcartiressize;
	}
	public String getGettypeid() {
		return gettypeid;
	}
	public void setGettypeid(String gettypeid) {
		this.gettypeid = gettypeid;
	}
	public String getMachinetypeid() {
		return machinetypeid;
	}
	public void setMachinetypeid(String machinetypeid) {
		this.machinetypeid = machinetypeid;
	}
	public String getEngineid() {
		return engineid;
	}
	public void setEngineid(String engineid) {
		this.engineid = engineid;
	}
	public String getBodycode() {
		return bodycode;
	}
	public void setBodycode(String bodycode) {
		this.bodycode = bodycode;
	}
	public String getEnginecode() {
		return enginecode;
	}
	public void setEnginecode(String enginecode) {
		this.enginecode = enginecode;
	}
	public String getRackcode() {
		return rackcode;
	}
	public void setRackcode(String rackcode) {
		this.rackcode = rackcode;
	}
	public String getUsernature() {
		return usernature;
	}
	public void setUsernature(String usernature) {
		this.usernature = usernature;
	}
	public String getFactoryname() {
		return factoryname;
	}
	public void setFactoryname(String factoryname) {
		this.factoryname = factoryname;
	}
	public String getSaleunit() {
		return saleunit;
	}
	public void setSaleunit(String saleunit) {
		this.saleunit = saleunit;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
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
	public String getGetwayfiletypeid() {
		return getwayfiletypeid;
	}
	public void setGetwayfiletypeid(String getwayfiletypeid) {
		this.getwayfiletypeid = getwayfiletypeid;
	}
	public String getGetwayfiletypecode() {
		return getwayfiletypecode;
	}
	public void setGetwayfiletypecode(String getwayfiletypecode) {
		this.getwayfiletypecode = getwayfiletypecode;
	}
	public String getImportsfiletypeid() {
		return importsfiletypeid;
	}
	public void setImportsfiletypeid(String importsfiletypeid) {
		this.importsfiletypeid = importsfiletypeid;
	}
	public String getImportsfiletypecode() {
		return importsfiletypecode;
	}
	public void setImportsfiletypecode(String importsfiletypecode) {
		this.importsfiletypecode = importsfiletypecode;
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
	public String getInsurancecompany() {
		return insurancecompany;
	}
	public void setInsurancecompany(String insurancecompany) {
		this.insurancecompany = insurancecompany;
	}
	public Date getInsurancedate() {
		return insurancedate;
	}
	public void setInsurancedate(Date insurancedate) {
		this.insurancedate = insurancedate;
	}
	public Date getInsurancevalidate() {
		return insurancevalidate;
	}
	public void setInsurancevalidate(Date insurancevalidate) {
		this.insurancevalidate = insurancevalidate;
	}
	public String getBodycolor() {
		return bodycolor;
	}
	public void setBodycolor(String bodycolor) {
		this.bodycolor = bodycolor;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDirectcontrol() {
		return directcontrol;
	}
	public void setDirectcontrol(String directcontrol) {
		this.directcontrol = directcontrol;
	}
	public String getContainersize() {
		return containersize;
	}
	public void setContainersize(String containersize) {
		this.containersize = containersize;
	}
	public String getEnginebrandid() {
		return enginebrandid;
	}
	public void setEnginebrandid(String enginebrandid) {
		this.enginebrandid = enginebrandid;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getCylinderno() {
		return cylinderno;
	}
	public void setCylinderno(String cylinderno) {
		this.cylinderno = cylinderno;
	}
	public String getFueltypeid() {
		return fueltypeid;
	}
	public void setFueltypeid(String fueltypeid) {
		this.fueltypeid = fueltypeid;
	}
	public String getWheelno() {
		return wheelno;
	}
	public void setWheelno(String wheelno) {
		this.wheelno = wheelno;
	}
	public String getWheelbase() {
		return wheelbase;
	}
	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}
	public String getTiresno() {
		return tiresno;
	}
	public void setTiresno(String tiresno) {
		this.tiresno = tiresno;
	}
	public String getTiressize() {
		return tiressize;
	}
	public void setTiressize(String tiressize) {
		this.tiressize = tiressize;
	}
	public String getWheeldis() {
		return wheeldis;
	}
	public void setWheeldis(String wheeldis) {
		this.wheeldis = wheeldis;
	}
	public String getTotalquality() {
		return totalquality;
	}
	public void setTotalquality(String totalquality) {
		this.totalquality = totalquality;
	}
	public String getAllquality() {
		return allquality;
	}
	public void setAllquality(String allquality) {
		this.allquality = allquality;
	}
	public String getRatifiedload() {
		return ratifiedload;
	}
	public void setRatifiedload(String ratifiedload) {
		this.ratifiedload = ratifiedload;
	}
	public String getAllowdragtotalquality() {
		return allowdragtotalquality;
	}
	public void setAllowdragtotalquality(String allowdragtotalquality) {
		this.allowdragtotalquality = allowdragtotalquality;
	}
	public String getDriverinno() {
		return driverinno;
	}
	public void setDriverinno(String driverinno) {
		this.driverinno = driverinno;
	}
	public String getSteelspring() {
		return steelspring;
	}
	public void setSteelspring(String steelspring) {
		this.steelspring = steelspring;
	}
	public String getVicecartiresno() {
		return vicecartiresno;
	}
	public void setVicecartiresno(String vicecartiresno) {
		this.vicecartiresno = vicecartiresno;
	}
	public String getOutcarwheeldis() {
		return outcarwheeldis;
	}
	public void setOutcarwheeldis(String outcarwheeldis) {
		this.outcarwheeldis = outcarwheeldis;
	}
	public String getOutcartiressize() {
		return outcartiressize;
	}
	public void setOutcartiressize(String outcartiressize) {
		this.outcartiressize = outcartiressize;
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
	public String getMachinetype() {
		return machinetype;
	}
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
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
	public String getTractorinfoplantType() {
		return tractorinfoplantType;
	}
	public void setTractorinfoplantType(String tractorinfoplantType) {
		this.tractorinfoplantType = tractorinfoplantType;
	}

}
