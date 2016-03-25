package Ynzc.YnzcAms.Model;

public class TractorTransferApplicationSource {
//拖拉机转移登记申请表
	//ynzc_ownerinfo
	private String telephone;//联系电话
	private String owner;//所有者
	private String zipCode;//邮政编码
	private String address;//家庭联系地址
	private String realcertificatetype;//有效证件类型
	private String realcertificateno;//有效证件编号
    private String templivefiletype;//暂住证类别
    private String timplivefileno;//暂住证号码
	private String tempAddress;//现居住地址
    //ynzc_tractorbasicinfo
    private String machinebodyno;//机身底盘号码
    private String engineno;//发动机号码
    //拖拉机信息表
    private String regcerno;//登记证书编号
    //ynzc_drivingLicenceDefile
    private String license;//号牌号码
    
	private String plantType;//拖拉机型号
	private String tempCode;//暂住邮政编码
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRealcertificatetype() {
		return realcertificatetype;
	}
	public void setRealcertificatetype(String realcertificatetype) {
		this.realcertificatetype = realcertificatetype;
	}
	public String getRealcertificateno() {
		return realcertificateno;
	}
	public void setRealcertificateno(String realcertificateno) {
		this.realcertificateno = realcertificateno;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
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
	public String getRegcerno() {
		return regcerno;
	}
	public void setRegcerno(String regcerno) {
		this.regcerno = regcerno;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getTemplivefiletype() {
		return templivefiletype;
	}
	public void setTemplivefiletype(String templivefiletype) {
		this.templivefiletype = templivefiletype;
	}
	public String getTimplivefileno() {
		return timplivefileno;
	}
	public void setTimplivefileno(String timplivefileno) {
		this.timplivefileno = timplivefileno;
	}
	public String getTempAddress() {
		return tempAddress;
	}
	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}
	public String getTempCode() {
		return tempCode;
	}
	public void setTempCode(String tempCode) {
		this.tempCode = tempCode;
	}
    
}
