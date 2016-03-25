package Ynzc.YnzcAms.Model;

import java.sql.Date;

public class CarcheckReportSource {
	
	//ownerinfo
	private String owner;//所有者
	private int realcertificatetype;//有效证件类型
	private String realcertificateno;//有效证件编号
	private String address;//家庭联系地址
	private String tempaddress;//现居住地
	private int istemplived;//是否暂住
	private int templivefiletype;//暂住证类型
	private String timplivefileno;//暂住证号码
	private String telephone;//联系电话
	private int isUnion;//单位或个人
	private String zipCode;//邮件编码
    
	//tractorbasicinfo
	private int getwayid;//获取方式
	private int machinetypeid;//机械类型
	private int machinebrandtypeid;//机械牌子型号
	private String machinebodyno;//机身地盘型号
	private String engineno;//发动机号码
	private String shelfno;//挂机架号码
	private String usedfor;//使用性质
	private String manufacturer;//制作厂名称
	private String seller;//销售单位
	private Date manufacturedate;//生产日期
	private String price;//交易价格
	private String photoUrl;//图片地址
	
	//carcheck
	private String inspectorresult;//
	private Date checkexpirydate;//
	private String inspector;//
	private String checkcompanyname;//
	private String insurancelistno;//
	private Date insurancedate;//
	private String insurancecompanyname;//
	private Date expirydate;//
	private String reviewer;//
	private Date reviewerconductdate;//
	private String issueadmin;//
	private Date issueadmindate;//
	private String leaderreview;//
	private Date leaderreviewdate;//
	private String operateuser;//
	private Date operatedate;//
	private String checkuser;//
	private Date checkdate;//
	private String checkip;//
	private String checkresult;//
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getRealcertificatetype() {
		return realcertificatetype;
	}
	public void setRealcertificatetype(int realcertificatetype) {
		this.realcertificatetype = realcertificatetype;
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
	public int getTemplivefiletype() {
		return templivefiletype;
	}
	public void setTemplivefiletype(int templivefiletype) {
		this.templivefiletype = templivefiletype;
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
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
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
	public String getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}
	
	

}
