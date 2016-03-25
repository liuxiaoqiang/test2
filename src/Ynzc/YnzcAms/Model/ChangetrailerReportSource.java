package Ynzc.YnzcAms.Model;

import java.sql.Date;

public class ChangetrailerReportSource {
	//tractor
	private String unitID;//管辖地
	private String license;//号牌号码
	private String regcerno;//登记证书编号
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
	//changetrailer
	private int carchangeid;
	private int orgintires;
	private String orgintrack;
	private String orginnorm;
	private int currenttires;
	private String currenttrack;
	private String currentnorm;
	
	
	public String getUnitID() {
		return unitID;
	}
	public void setUnitID(String unitID) {
		this.unitID = unitID;
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
	public int getCarchangeid() {
		return carchangeid;
	}
	public void setCarchangeid(int carchangeid) {
		this.carchangeid = carchangeid;
	}
	public int getOrgintires() {
		return orgintires;
	}
	public void setOrgintires(int orgintires) {
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
	public int getCurrenttires() {
		return currenttires;
	}
	public void setCurrenttires(int currenttires) {
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

	
	
	

}
