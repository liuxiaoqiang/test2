package Ynzc.YnzcAms.Model;

public class TechnicalDataSource {
	//拖拉机信息表
	private String license;//号牌号码
	private String regcerno;//登记证书编号
	private String unitid;//新管辖地
	//拖拉机技术参数表
	//ynzc_ownerinfo
	private String owner;//所有者
	private String telephone;//联系电话
	
	//机械类型表
	private String machinetype;//机械类型
	private String plantType;//厂牌型号

	//ynzc_tractorbasicinfo
	private String engineno;//发动机号码
	private String machinebodyno;//机身底盘号码
	private String shelfno;//挂机架号码
	//ynzc_technicalparameters
	private String machinebodycolor;//机身颜色
	private String outsize;//外轮廓尺寸
	private String directcontrol;//转向形式
	private String containersize;//货箱内尺寸
	private String engineBrand;//发动机品牌
	private String power;//功率
	private int cylinderno;//缸数
	private int wheelno;//轴数
	private String fuelname;//燃料名称
	private String wheelbase;//轴距
	private int tiresno;//轮胎数
	private String tiresSize;//轮胎规格
	private String wheeldis;//轮距
	private int totalquality;//总质量
	private int allquality;//整备质量
	private int ratifiedload;//核定载质量
	private int allowdragtotalquality;//准牵引总质量
	private int driverinno;//驾驶室人数
	private int steelspring;//钢板弹簧片数
	private int vicecartiresno;//挂车轮胎数
	private String outcarwheeldis;//挂车轮距
	private String outcartiressize;//挂车轮胎规格
	
	
	
	//ynzc_cartransfer
	
	//ynzc_ engineBrand
	
	//ynzc_fueltype
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getMachinebodycolor() {
		return machinebodycolor;
	}
	public void setMachinebodycolor(String machinebodycolor) {
		this.machinebodycolor = machinebodycolor;
	}
	public String getEngineno() {
		return engineno;
	}
	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
	public String getMachinebodyno() {
		return machinebodyno;
	}
	public void setMachinebodyno(String machinebodyno) {
		this.machinebodyno = machinebodyno;
	}
	public String getShelfno() {
		return shelfno;
	}
	public void setShelfno(String shelfno) {
		this.shelfno = shelfno;
	}
	public String getOutsize() {
		return outsize;
	}
	public void setOutsize(String outsize) {
		this.outsize = outsize;
	}
	public String getContainersize() {
		return containersize;
	}
	public void setContainersize(String containersize) {
		this.containersize = containersize;
	}
	public int getWheelno() {
		return wheelno;
	}
	public void setWheelno(int wheelno) {
		this.wheelno = wheelno;
	}
	public String getWheelbase() {
		return wheelbase;
	}
	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}
	public int getVicecartiresno() {
		return vicecartiresno;
	}
	public void setVicecartiresno(int vicecartiresno) {
		this.vicecartiresno = vicecartiresno;
	}
	public String getOutcarwheeldis() {
		return outcarwheeldis;
	}
	public void setOutcarwheeldis(String outcarwheeldis) {
		this.outcarwheeldis = outcarwheeldis;
	}
	public int getSteelspring() {
		return steelspring;
	}
	public void setSteelspring(int steelspring) {
		this.steelspring = steelspring;
	}
	public String getOutcartiressize() {
		return outcartiressize;
	}
	public void setOutcartiressize(String outcartiressize) {
		this.outcartiressize = outcartiressize;
	}
	public String getRegcerno() {
		return regcerno;
	}
	public void Regcerno(String regcerno) {
		this.regcerno = regcerno;
	}
	public String getUnitid() {
		return unitid;
	}
	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}
	public String getEngineBrand() {
		return engineBrand;
	}
	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getCylinderno() {
		return cylinderno;
	}
	public void setCylinderno(int cylinderno) {
		this.cylinderno = cylinderno;
	}
	public String getTiresSize() {
		return tiresSize;
	}
	public void setTiresSize(String tiresSize) {
		this.tiresSize = tiresSize;
	}
	public int getAllquality() {
		return allquality;
	}
	public void setAllquality(int allquality) {
		this.allquality = allquality;
	}
	public int getAllowdragtotalquality() {
		return allowdragtotalquality;
	}
	public void setAllowdragtotalquality(int allowdragtotalquality) {
		this.allowdragtotalquality = allowdragtotalquality;
	}
	public int getDriverinno() {
		return driverinno;
	}
	public void setDriverinno(int driverinno) {
		this.driverinno = driverinno;
	}
	public String getDirectcontrol() {
		return directcontrol;
	}
	public void setDirectcontrol(String directcontrol) {
		this.directcontrol = directcontrol;
	}
	public int getTiresno() {
		return tiresno;
	}
	public void setTiresno(int tiresno) {
		this.tiresno = tiresno;
	}
	public String getWheeldis() {
		return wheeldis;
	}
	public void setWheeldis(String wheeldis) {
		this.wheeldis = wheeldis;
	}
	public int getTotalquality() {
		return totalquality;
	}
	public void setTotalquality(int totalquality) {
		this.totalquality = totalquality;
	}
	public String getFuelname() {
		return fuelname;
	}
	public void setFuelname(String fuelname) {
		this.fuelname = fuelname;
	}
	public int getRatifiedload() {
		return ratifiedload;
	}
	public void setRatifiedload(int ratifiedload) {
		this.ratifiedload = ratifiedload;
	}
	
	
}
