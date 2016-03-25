package Ynzc.YnzcAms.Model;

import java.util.Date;

public class CompleteHarvesterRegistrationAndTurnInSource {
//联合收割机注册登记/转入申请表
	//ynzc_uniteHarvester
	private String harvesterOwner;//所有人姓名
	private String livePostCode;//居住地邮编
	private String certitype;//证件类型
	private String telephoneNum;//电话号码
	private String tempAddress;//临时居住地址
	private String liveType;//居住类型（常住/暂住）
	private String tempPostCode;//临时居住地址邮编
	private String liveAddress;//居住地址
	private String certiCode;//证件号码
	private String liveCode;//居住证件号码
	private String harvesterEngineCode;//发动机号
	private String harvesterGuanXiaDi;//管辖地
	private String harvesterBodyCode;//机身号码
	private String harvesterChangPaiType;//厂牌型号
	private String harvesterCode;//收割机号牌号码
	//ynzc_uniteHarvesterCheck
	private String insurancedate;//保险日期
	private String insurancecompanyname;//保险公司名称
	private Date checkRegisterdate;//登记日期
	//拖拉机信息表
	private String regcerno;//登记证书编号
	public String getHarvesterOwner() {
		return harvesterOwner;
	}
	public void setHarvesterOwner(String harvesterOwner) {
		this.harvesterOwner = harvesterOwner;
	}
	public String getInsurancecompanyname() {
		return insurancecompanyname;
	}
	public void setInsurancecompanyname(String insurancecompanyname) {
		this.insurancecompanyname = insurancecompanyname;
	}
	public String getLivePostCode() {
		return livePostCode;
	}
	public void setLivePostCode(String livePostCode) {
		this.livePostCode = livePostCode;
	}
	public String getCertitype() {
		return certitype;
	}
	public void setCertitype(String certitype) {
		this.certitype = certitype;
	}
	public String getInsurancedate() {
		return insurancedate;
	}
	public void setInsurancedate(String insurancedate) {
		this.insurancedate = insurancedate;
	}
	public String getHarvesterEngineCode() {
		return harvesterEngineCode;
	}
	public void setHarvesterEngineCode(String harvesterEngineCode) {
		this.harvesterEngineCode = harvesterEngineCode;
	}
	public String getCertiCode() {
		return certiCode;
	}
	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}
	public String getHarvesterGuanXiaDi() {
		return harvesterGuanXiaDi;
	}
	public void setHarvesterGuanXiaDi(String harvesterGuanXiaDi) {
		this.harvesterGuanXiaDi = harvesterGuanXiaDi;
	}
	public String getTempPostCode() {
		return tempPostCode;
	}
	public void setTempPostCode(String tempPostCode) {
		this.tempPostCode = tempPostCode;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getRegcerno() {
		return regcerno;
	}
	public void setRegcerno(String regcerno) {
		this.regcerno = regcerno;
	}
	public String getHarvesterBodyCode() {
		return harvesterBodyCode;
	}
	public void setHarvesterBodyCode(String harvesterBodyCode) {
		this.harvesterBodyCode = harvesterBodyCode;
	}
	public String getLiveCode() {
		return liveCode;
	}
	public void setLiveCode(String liveCode) {
		this.liveCode = liveCode;
	}
	public String getHarvesterChangPaiType() {
		return harvesterChangPaiType;
	}
	public void setHarvesterChangPaiType(String harvesterChangPaiType) {
		this.harvesterChangPaiType = harvesterChangPaiType;
	}
	public String getTelephoneNum() {
		return telephoneNum;
	}
	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}
	public String getTempAddress() {
		return tempAddress;
	}
	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}
	public String getLiveType() {
		return liveType;
	}
	public void setLiveType(String liveType) {
		this.liveType = liveType;
	}
	public Date getCheckRegisterdate() {
		return checkRegisterdate;
	}
	public void setCheckRegisterdate(Date checkRegisterdate) {
		this.checkRegisterdate = checkRegisterdate;
	}
	public String getHarvesterCode() {
		return harvesterCode;
	}
	public void setHarvesterCode(String harvesterCode) {
		this.harvesterCode = harvesterCode;
	}
	
	
	
	
}
