package Ynzc.YnzcAms.Model;

public class TractorStopRecoverSource {
//拖拉机停驶、复驶/注销登记申请表
    //拖拉机信息表
    private String regcerno;//登记证书编号
	//拖拉机信息表
	private String license;//号牌号码
	//ynzc_ownerinfo
	private String owner;//所有者
	private String realcertificatetype;//有效证件类型
	private String realcertificateno;//有效证件编号
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
	
	

}
