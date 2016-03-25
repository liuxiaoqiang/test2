package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivertraing_tractor_view")
public class DrivertraingTractorinfoView {
	private int id;//拖拉机id
	private String license;//拖拉机号牌号码
	private String Regcerno;//登记证书编号
	
	private String Owner;//所有者
	private String telephone;//电话号码
	private String realcertificateno;//证件号码
	private String address;//地址
	private String zipCode;//邮编
	private int isUnion;//是否单位
	private int istemplived;//是否暂住
	private int realcertificatetypeid;//证件类型id
	
	private int machinetypeid;//机械类型id
	private int machinebrandtypeid;//厂牌型号id
	private String machinebodyno;//机身底盘号码
	private String engineno;//发动机号码
	private String shelfno;//挂机架号码
	private Date manufacturedate;//生产日期
	
	private Date registerdate;//注册日期
	private Date Turnindate;//转入日期
	private Date issuedate;//发牌证日期
	
	private String reviewer;//登记审核人
	private Date reviewerconductdate;//办理时间
	private String issueadmin;//牌证人
	private Date issueadmindate;//经办时间
	private String leaderreview;//业务领导
	private Date leaderreviewconductdate;//办理时间
	
	private String platecode;//号牌代码
	private int unitid;//单位id
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegcerno() {
		return Regcerno;
	}
	public void setRegcerno(String regcerno) {
		Regcerno = regcerno;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getIsUnion() {
		return isUnion;
	}
	public void setIsUnion(int isUnion) {
		this.isUnion = isUnion;
	}
	public int getIstemplived() {
		return istemplived;
	}
	public void setIstemplived(int istemplived) {
		this.istemplived = istemplived;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public Date getTurnindate() {
		return Turnindate;
	}
	public void setTurnindate(Date turnindate) {
		Turnindate = turnindate;
	}
	public Date getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
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
	public Date getLeaderreviewconductdate() {
		return leaderreviewconductdate;
	}
	public void setLeaderreviewconductdate(Date leaderreviewconductdate) {
		this.leaderreviewconductdate = leaderreviewconductdate;
	}
	public String getPlatecode() {
		return platecode;
	}
	public void setPlatecode(String platecode) {
		this.platecode = platecode;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public String getLeaderreview() {
		return leaderreview;
	}
	public void setLeaderreview(String leaderreview) {
		this.leaderreview = leaderreview;
	}
	public int getRealcertificatetypeid() {
		return realcertificatetypeid;
	}
	public void setRealcertificatetypeid(int realcertificatetypeid) {
		this.realcertificatetypeid = realcertificatetypeid;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Date getManufacturedate() {
		return manufacturedate;
	}
	public void setManufacturedate(Date manufacturedate) {
		this.manufacturedate = manufacturedate;
	}	
}
