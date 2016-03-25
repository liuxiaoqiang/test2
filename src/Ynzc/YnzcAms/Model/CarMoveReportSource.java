package Ynzc.YnzcAms.Model;

import java.sql.Date;

public class CarMoveReportSource {
	private String plateCode;
	private String license;
	private String machinetype;
	private String owner;
	private String machinebodyno;
	private String shelfno;
	private String engineno;
	private String engineBrand;
	private int driverinno;
	private int totalquality;
	private int ratifiedload;
	private Date registerdate;
	private Date sendLicenseTime;
	private String address1;
	private String address2;
	private Date checkexpirydate;
	
	public int getDriverinno() {
		return driverinno;
	}
	public void setDriverinno(int driverinno) {
		this.driverinno = driverinno;
	}
	public int getTotalquality() {
		return totalquality;
	}
	public void setTotalquality(int totalquality) {
		this.totalquality = totalquality;
	}
	public int getRatifiedload() {
		return ratifiedload;
	}
	public void setRatifiedload(int ratifiedload) {
		this.ratifiedload = ratifiedload;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public Date getSendLicenseTime() {
		return sendLicenseTime;
	}
	public void setSendLicenseTime(Date sendLicenseTime) {
		this.sendLicenseTime = sendLicenseTime;
	}
	public Date getCheckexpirydate() {
		return checkexpirydate;
	}
	public void setCheckexpirydate(Date checkexpirydate) {
		this.checkexpirydate = checkexpirydate;
	}
	public String getPlateCode() {
		return plateCode;
	}
	public void setPlateCode(String plateCode) {
		this.plateCode = plateCode;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getMachinetype() {
		return machinetype;
	}
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	public String getEngineno() {
		return engineno;
	}
	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
	public String getEngineBrand() {
		return engineBrand;
	}
	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
}
