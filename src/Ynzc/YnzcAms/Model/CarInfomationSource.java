package Ynzc.YnzcAms.Model;


public class CarInfomationSource {
	//tractor
	private String unitID;//管辖地
	private String license;//号牌号码
	private String regcerno;//登记证书编号
	//ownerinfo
	private String owner;//所有者
	private String realcertificatetype;//有效证件类型
	private String realcertificateno;//有效证件编号
	private String address;//家庭联系地址
	private String istemplived;//是否暂住
	private String templivefiletype;//暂住证类型
	private String timplivefileno;//暂住证号码
	private String telephone;//联系电话
	private String isUnion;//单位或个人
	private String zipCode;//邮件编码
    
	//tractorbasicinfo
	private String getway;//获取方式
	private String machinetype;//机械类型
	private String machinebrandtypeid;//机械牌子型号
	private String machinebodyno;//机身地盘型号
	private String engineno;//发动机号码
	private String shelfno;//挂机架号码
	private String usedfor;//使用性质
	private String manufacturer;//制作厂名称
	private String seller;//销售单位
	private String manufacturedate;//生产日期
	private String price;//交易价格
	private String photoUrl;//图片地址
	
	//(ynzc_relationinfo
	private String getwayfiletypeid;//来历凭证类型
	private String getwayfileno;//来历凭证编号
	private String importsfiletypeid;//进口凭证类型
	private String importsfileno;//进口凭证编号
	private String insurancelistno;//保单号码
	private String insurancecompanyname;//保险公司名称
	private String insurancedate;//保险日期
	private String expirydate;//保险有效期
	private String issuedate;//发牌证日期
	//ynzc_registerinfo
	private String registerdate;//登记日期
	private String turnindate;//转入日期
	private String beforeregion;//转入前管辖地
	private String flapperDirectorDate;//换发牌证日期
	//ynzc_technicalinspect
	private String checkexpirydate;//检验有效期
	//ynzc_carchange
	private String applicationtime;//申请变更时间
	private String changeNumber;//变更次数
	
	private String approvaltime;//变更备案登记时间
	private String recordNumber;//变更备案登记次数
	//ynzc_cartransfer
	private String applydate;//转移登记时间
	private String transferNum;//转移登记次数
	private String registerTransactorDate;//补换行驶证时间
	private String registerTransactorNum;//补换行驶证次数
	private String flapperFace;//补换号牌证时间
	private String changePlateNum;//补换号牌证次数
	private String registrationCertificateDate;//补换登记证书时间
	private String registrationCertificateNum;//补换登记证书次数
	private String whetherMortgage;//是否抵押
	private String mortgageDate;//抵押时间
	private String whetherStop;//是否停驶
	private String stopDate;//停驶时间
	private String engineBrand;//品牌型号
	private String operatorDate;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIstemplived() {
		return istemplived;
	}
	public void setIstemplived(String istemplived) {
		this.istemplived = istemplived;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIsUnion() {
		return isUnion;
	}
	public void setIsUnion(String isUnion) {
		this.isUnion = isUnion;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getGetway() {
		return getway;
	}
	public void setGetway(String getway) {
		this.getway = getway;
	}
	public String getMachinetype() {
		return machinetype;
	}
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	public String getMachinebrandtypeid() {
		return machinebrandtypeid;
	}
	public void setMachinebrandtypeid(String machinebrandtypeid) {
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
	public String getManufacturedate() {
		return manufacturedate;
	}
	public void setManufacturedate(String manufacturedate) {
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
	public String getGetwayfiletypeid() {
		return getwayfiletypeid;
	}
	public void setGetwayfiletypeid(String getwayfiletypeid) {
		this.getwayfiletypeid = getwayfiletypeid;
	}
	public String getGetwayfileno() {
		return getwayfileno;
	}
	public void setGetwayfileno(String getwayfileno) {
		this.getwayfileno = getwayfileno;
	}
	public String getImportsfiletypeid() {
		return importsfiletypeid;
	}
	public void setImportsfiletypeid(String importsfiletypeid) {
		this.importsfiletypeid = importsfiletypeid;
	}
	public String getImportsfileno() {
		return importsfileno;
	}
	public void setImportsfileno(String importsfileno) {
		this.importsfileno = importsfileno;
	}
	public String getInsurancelistno() {
		return insurancelistno;
	}
	public void setInsurancelistno(String insurancelistno) {
		this.insurancelistno = insurancelistno;
	}
	public String getInsurancecompanyname() {
		return insurancecompanyname;
	}
	public void setInsurancecompanyname(String insurancecompanyname) {
		this.insurancecompanyname = insurancecompanyname;
	}
	public String getInsurancedate() {
		return insurancedate;
	}
	public void setInsurancedate(String insurancedate) {
		this.insurancedate = insurancedate;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
	public String getTurnindate() {
		return turnindate;
	}
	public void setTurnindate(String turnindate) {
		this.turnindate = turnindate;
	}
	public String getBeforeregion() {
		return beforeregion;
	}
	public void setBeforeregion(String beforeregion) {
		this.beforeregion = beforeregion;
	}
	public String getFlapperDirectorDate() {
		return flapperDirectorDate;
	}
	public void setFlapperDirectorDate(String flapperDirectorDate) {
		this.flapperDirectorDate = flapperDirectorDate;
	}
	public String getCheckexpirydate() {
		return checkexpirydate;
	}
	public void setCheckexpirydate(String checkexpirydate) {
		this.checkexpirydate = checkexpirydate;
	}
	public String getApplicationtime() {
		return applicationtime;
	}
	public void setApplicationtime(String applicationtime) {
		this.applicationtime = applicationtime;
	}
	public String getChangeNumber() {
		return changeNumber;
	}
	public void setChangeNumber(String changeNumber) {
		this.changeNumber = changeNumber;
	}
	public String getApprovaltime() {
		return approvaltime;
	}
	public void setApprovaltime(String approvaltime) {
		this.approvaltime = approvaltime;
	}
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	public String getTransferNum() {
		return transferNum;
	}
	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}
	public String getRegisterTransactorDate() {
		return registerTransactorDate;
	}
	public void setRegisterTransactorDate(String registerTransactorDate) {
		this.registerTransactorDate = registerTransactorDate;
	}
	public String getRegisterTransactorNum() {
		return registerTransactorNum;
	}
	public void setRegisterTransactorNum(String registerTransactorNum) {
		this.registerTransactorNum = registerTransactorNum;
	}
	public String getChangePlateNum() {
		return changePlateNum;
	}
	public void setChangePlateNum(String changePlateNum) {
		this.changePlateNum = changePlateNum;
	}
	public String getRegistrationCertificateDate() {
		return registrationCertificateDate;
	}
	public void setRegistrationCertificateDate(String registrationCertificateDate) {
		this.registrationCertificateDate = registrationCertificateDate;
	}
	public String getRegistrationCertificateNum() {
		return registrationCertificateNum;
	}
	public void setRegistrationCertificateNum(String registrationCertificateNum) {
		this.registrationCertificateNum = registrationCertificateNum;
	}
	public String getWhetherMortgage() {
		return whetherMortgage;
	}
	public void setWhetherMortgage(String whetherMortgage) {
		this.whetherMortgage = whetherMortgage;
	}
	public String getMortgageDate() {
		return mortgageDate;
	}
	public void setMortgageDate(String mortgageDate) {
		this.mortgageDate = mortgageDate;
	}
	public String getWhetherStop() {
		return whetherStop;
	}
	public void setWhetherStop(String whetherStop) {
		this.whetherStop = whetherStop;
	}
	public String getStopDate() {
		return stopDate;
	}
	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}
	public String getEngineBrand() {
		return engineBrand;
	}
	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}
	public void setOperatorDate(String operatorDate) {
		this.operatorDate = operatorDate;
	}
	public String getOperatorDate() {
		return operatorDate;
	}
	public void setFlapperFace(String flapperFace) {
		this.flapperFace = flapperFace;
	}
	public String getFlapperFace() {
		return flapperFace;
	}
	
}
