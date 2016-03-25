package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ynzc_mortgage_view")
public class MortgageView {
	private int id;
	private int tractorinfoId;
	private String tractorcode;
	private String tractorno;
	private String tractoraddress;
	private String mortgagetype;
	private String mortgagementype;
	private String mortgageownermentype;
	private String mortgageusername;
	private String mortgageaddress;
	private String mortgageistemplive;
	private int mortgagecaridtype;
	private String mortgagecarid;
	private String mortgagelinktel;
	private String mortgagezipcode;
	private Date mortgagehandledate;
	private String mortgageownerusername;
	private String mortgageowneraddress;
	private String mortgageisownertemplive;
	private int mortgageownercaridtype;
	private String mortgageownercarid;
	private String mortgageownerlinktel;
	private String mortgageownerzipcode;
	private Date mortgageownerhandledate;
	private String mortgageinformation;

	private String mortgageproxyusername;
	private String mortgageproxylinktel;
	private String mortgageproxyaddress;
	private int mortgageproxyidtype;
	private String mortgageproxyid;
	private String mortgageproxyhandlename;
	private int mortgageproxyhandleidtype;
	private String mortgageproxyhandleid;
	private String mortgageproxyhandleaddress;
	private Date mortgageproxyhandledate;

	private String mortgageownerproxyusername;
	private String mortgageownerproxylinktel;
	private String mortgageownerproxyaddress;
	private int mortgageownerproxyidtype;
	private String mortgageownerproxyid;
	private String mortgageownerproxyhandlename;
	private int mortgageownerproxyhandleidtype;
	private String mortgageownerproxyhandleid;
	private String mortgageownerproxyhandleaddress;
	private Date mortgageownerproxyhandledate;

	private String checkmen;
	private int checkstate;
	private String checkcontent;
	private Date checkdate;
	private String checkip;
	private String opertator;
	private Date operatedate;
	
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
	public String getTractorcode() {
		return tractorcode;
	}
	public void setTractorcode(String tractorcode) {
		this.tractorcode = tractorcode;
	}
	public String getTractorno() {
		return tractorno;
	}
	public void setTractorno(String tractorno) {
		this.tractorno = tractorno;
	}
	public String getTractoraddress() {
		return tractoraddress;
	}
	public void setTractoraddress(String tractoraddress) {
		this.tractoraddress = tractoraddress;
	}
	public String getMortgagetype() {
		return mortgagetype;
	}
	public void setMortgagetype(String mortgagetype) {
		this.mortgagetype = mortgagetype;
	}
	public String getMortgagementype() {
		return mortgagementype;
	}
	public void setMortgagementype(String mortgagementype) {
		this.mortgagementype = mortgagementype;
	}
	public String getMortgageownermentype() {
		return mortgageownermentype;
	}
	public void setMortgageownermentype(String mortgageownermentype) {
		this.mortgageownermentype = mortgageownermentype;
	}
	public String getMortgageusername() {
		return mortgageusername;
	}
	public void setMortgageusername(String mortgageusername) {
		this.mortgageusername = mortgageusername;
	}
	public String getMortgageaddress() {
		return mortgageaddress;
	}
	public void setMortgageaddress(String mortgageaddress) {
		this.mortgageaddress = mortgageaddress;
	}
	public String getMortgageistemplive() {
		return mortgageistemplive;
	}
	public void setMortgageistemplive(String mortgageistemplive) {
		this.mortgageistemplive = mortgageistemplive;
	}
	public int getMortgagecaridtype() {
		return mortgagecaridtype;
	}
	public void setMortgagecaridtype(int mortgagecaridtype) {
		this.mortgagecaridtype = mortgagecaridtype;
	}
	public String getMortgagecarid() {
		return mortgagecarid;
	}
	public void setMortgagecarid(String mortgagecarid) {
		this.mortgagecarid = mortgagecarid;
	}
	public String getMortgagelinktel() {
		return mortgagelinktel;
	}
	public void setMortgagelinktel(String mortgagelinktel) {
		this.mortgagelinktel = mortgagelinktel;
	}
	public String getMortgagezipcode() {
		return mortgagezipcode;
	}
	public void setMortgagezipcode(String mortgagezipcode) {
		this.mortgagezipcode = mortgagezipcode;
	}
	public Date getMortgagehandledate() {
		return mortgagehandledate;
	}
	public void setMortgagehandledate(Date mortgagehandledate) {
		this.mortgagehandledate = mortgagehandledate;
	}
	public String getMortgageownerusername() {
		return mortgageownerusername;
	}
	public void setMortgageownerusername(String mortgageownerusername) {
		this.mortgageownerusername = mortgageownerusername;
	}
	public String getMortgageowneraddress() {
		return mortgageowneraddress;
	}
	public void setMortgageowneraddress(String mortgageowneraddress) {
		this.mortgageowneraddress = mortgageowneraddress;
	}
	public String getMortgageisownertemplive() {
		return mortgageisownertemplive;
	}
	public void setMortgageisownertemplive(String mortgageisownertemplive) {
		this.mortgageisownertemplive = mortgageisownertemplive;
	}
	public int getMortgageownercaridtype() {
		return mortgageownercaridtype;
	}
	public void setMortgageownercaridtype(int mortgageownercaridtype) {
		this.mortgageownercaridtype = mortgageownercaridtype;
	}
	public String getMortgageownercarid() {
		return mortgageownercarid;
	}
	public void setMortgageownercarid(String mortgageownercarid) {
		this.mortgageownercarid = mortgageownercarid;
	}
	public String getMortgageownerlinktel() {
		return mortgageownerlinktel;
	}
	public void setMortgageownerlinktel(String mortgageownerlinktel) {
		this.mortgageownerlinktel = mortgageownerlinktel;
	}
	public String getMortgageownerzipcode() {
		return mortgageownerzipcode;
	}
	public void setMortgageownerzipcode(String mortgageownerzipcode) {
		this.mortgageownerzipcode = mortgageownerzipcode;
	}
	public Date getMortgageownerhandledate() {
		return mortgageownerhandledate;
	}
	public void setMortgageownerhandledate(Date mortgageownerhandledate) {
		this.mortgageownerhandledate = mortgageownerhandledate;
	}
	public String getMortgageinformation() {
		return mortgageinformation;
	}
	public void setMortgageinformation(String mortgageinformation) {
		this.mortgageinformation = mortgageinformation;
	}
	public String getMortgageproxyusername() {
		return mortgageproxyusername;
	}
	public void setMortgageproxyusername(String mortgageproxyusername) {
		this.mortgageproxyusername = mortgageproxyusername;
	}
	public String getMortgageproxylinktel() {
		return mortgageproxylinktel;
	}
	public void setMortgageproxylinktel(String mortgageproxylinktel) {
		this.mortgageproxylinktel = mortgageproxylinktel;
	}
	public String getMortgageproxyaddress() {
		return mortgageproxyaddress;
	}
	public void setMortgageproxyaddress(String mortgageproxyaddress) {
		this.mortgageproxyaddress = mortgageproxyaddress;
	}
	public int getMortgageproxyidtype() {
		return mortgageproxyidtype;
	}
	public void setMortgageproxyidtype(int mortgageproxyidtype) {
		this.mortgageproxyidtype = mortgageproxyidtype;
	}
	public String getMortgageproxyid() {
		return mortgageproxyid;
	}
	public void setMortgageproxyid(String mortgageproxyid) {
		this.mortgageproxyid = mortgageproxyid;
	}
	public String getMortgageproxyhandlename() {
		return mortgageproxyhandlename;
	}
	public void setMortgageproxyhandlename(String mortgageproxyhandlename) {
		this.mortgageproxyhandlename = mortgageproxyhandlename;
	}
	public int getMortgageproxyhandleidtype() {
		return mortgageproxyhandleidtype;
	}
	public void setMortgageproxyhandleidtype(int mortgageproxyhandleidtype) {
		this.mortgageproxyhandleidtype = mortgageproxyhandleidtype;
	}
	public String getMortgageproxyhandleid() {
		return mortgageproxyhandleid;
	}
	public void setMortgageproxyhandleid(String mortgageproxyhandleid) {
		this.mortgageproxyhandleid = mortgageproxyhandleid;
	}
	public String getMortgageproxyhandleaddress() {
		return mortgageproxyhandleaddress;
	}
	public void setMortgageproxyhandleaddress(String mortgageproxyhandleaddress) {
		this.mortgageproxyhandleaddress = mortgageproxyhandleaddress;
	}
	public Date getMortgageproxyhandledate() {
		return mortgageproxyhandledate;
	}
	public void setMortgageproxyhandledate(Date mortgageproxyhandledate) {
		this.mortgageproxyhandledate = mortgageproxyhandledate;
	}
	public String getMortgageownerproxyusername() {
		return mortgageownerproxyusername;
	}
	public void setMortgageownerproxyusername(String mortgageownerproxyusername) {
		this.mortgageownerproxyusername = mortgageownerproxyusername;
	}
	public String getMortgageownerproxylinktel() {
		return mortgageownerproxylinktel;
	}
	public void setMortgageownerproxylinktel(String mortgageownerproxylinktel) {
		this.mortgageownerproxylinktel = mortgageownerproxylinktel;
	}
	public String getMortgageownerproxyaddress() {
		return mortgageownerproxyaddress;
	}
	public void setMortgageownerproxyaddress(String mortgageownerproxyaddress) {
		this.mortgageownerproxyaddress = mortgageownerproxyaddress;
	}
	public int getMortgageownerproxyidtype() {
		return mortgageownerproxyidtype;
	}
	public void setMortgageownerproxyidtype(int mortgageownerproxyidtype) {
		this.mortgageownerproxyidtype = mortgageownerproxyidtype;
	}
	public String getMortgageownerproxyid() {
		return mortgageownerproxyid;
	}
	public void setMortgageownerproxyid(String mortgageownerproxyid) {
		this.mortgageownerproxyid = mortgageownerproxyid;
	}
	public String getMortgageownerproxyhandlename() {
		return mortgageownerproxyhandlename;
	}
	public void setMortgageownerproxyhandlename(String mortgageownerproxyhandlename) {
		this.mortgageownerproxyhandlename = mortgageownerproxyhandlename;
	}
	public int getMortgageownerproxyhandleidtype() {
		return mortgageownerproxyhandleidtype;
	}
	public void setMortgageownerproxyhandleidtype(int mortgageownerproxyhandleidtype) {
		this.mortgageownerproxyhandleidtype = mortgageownerproxyhandleidtype;
	}
	public String getMortgageownerproxyhandleid() {
		return mortgageownerproxyhandleid;
	}
	public void setMortgageownerproxyhandleid(String mortgageownerproxyhandleid) {
		this.mortgageownerproxyhandleid = mortgageownerproxyhandleid;
	}
	public String getMortgageownerproxyhandleaddress() {
		return mortgageownerproxyhandleaddress;
	}
	public void setMortgageownerproxyhandleaddress(
			String mortgageownerproxyhandleaddress) {
		this.mortgageownerproxyhandleaddress = mortgageownerproxyhandleaddress;
	}
	public Date getMortgageownerproxyhandledate() {
		return mortgageownerproxyhandledate;
	}
	public void setMortgageownerproxyhandledate(Date mortgageownerproxyhandledate) {
		this.mortgageownerproxyhandledate = mortgageownerproxyhandledate;
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
	public String getCheckcontent() {
		return checkcontent;
	}
	public void setCheckcontent(String checkcontent) {
		this.checkcontent = checkcontent;
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
	public String getOpertator() {
		return opertator;
	}
	public void setOpertator(String opertator) {
		this.opertator = opertator;
	}
	public Date getOperatedate() {
		return operatedate;
	}
	public void setOperatedate(Date operatedate) {
		this.operatedate = operatedate;
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
