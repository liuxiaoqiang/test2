package Ynzc.YnzcAms.Model;

public class TractorInspectionApplicationSource {
	//拖拉机存根
	//拖拉机信息表
	private String license;//号牌号码
	//ynzc_ownerinfo
	private String owner;//所有者
	private String realcertificatetype;//有效证件类型
	private String realcertificateno;//有效证件编号
	//ynzc_tractorbasicinfo
	private String manufacturer;//制造厂名称
	private String machinebodyno;//机身底盘号码
	private String engineno;//发动机号码
	//机械类型表
	private String machinetype;//机械类型
	//unit
	private String useunit;//使用单位
	//ynzc_ engineBrand
	private String engineBrand;//发动机品牌
	
	private String plantType;//拖拉机型号
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
	public String getMachinetype() {
		return machinetype;
	}
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	public String getUseunit() {
		return useunit;
	}
	public void setUseunit(String useunit) {
		this.useunit = useunit;
	}
	public String getEngineBrand() {
		return engineBrand;
	}
	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}
	
	

}
