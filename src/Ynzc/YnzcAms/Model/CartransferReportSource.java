package Ynzc.YnzcAms.Model;

import java.sql.Date;

public class CartransferReportSource {
	private String owner;//所有者
	private String realcertificateno;//有效证件编号
	private String address;//家庭联系地址
	private String telephone;//联系电话
	private String sex;//性别;
	
	private int machinetypeid;//机械类型
	private String machinebodyno;//机身地盘型号
	private String engineno;//发动机号码
	private String shelfno;//挂机架号码
	private String photoUrl;//图片地址
	
	private Date expirydate;//保险有效期
	
	private String transfertype;//转移类型
	private int orginunitid;//原来管辖地
	private String orginunitname;//原来农机监理机构名称
	private int unitid;//新管辖地
	private String unitname;//新农机监理机构名称
	private Date applydate;//申请日期
	private String applymen;//申请人
	private String applyip;//申请ip
	private String checkmen;//审核人
	private Date checkdate;//审核日期
	//private String checkip;
	private String checkresult;//审核结果
	
	private Date registerdate;//登记日期;
	private String reviewer;//登记审核人;
	
	private String license;//号牌号码;
	private String regcerno;//等级证书编号;
	
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getMachinetypeid() {
		return machinetypeid;
	}
	public void setMachinetypeid(int machinetypeid) {
		this.machinetypeid = machinetypeid;
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
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public String getTransfertype() {
		return transfertype;
	}
	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
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
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
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
	public String getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getRegcerno() {
		return regcerno;
	}
	public void setRegcerno(String regcerno) {
		this.regcerno = regcerno;
	}
	
	
	
	
}
