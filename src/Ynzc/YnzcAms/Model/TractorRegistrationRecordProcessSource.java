package Ynzc.YnzcAms.Model;

import java.sql.Date;

public class TractorRegistrationRecordProcessSource {
//拖拉机登记业务流程记录单
	private String serialNumber;//流水号
	//ynzc_ownerinfo
	private String owner;//所有者
	private String name;//业务名称
	
	//机械类型表
	private String machinetype;//机械类型
	//ynzc_ engineBrand
	private String engineBrand;//发动机品牌
	//拖拉机信息表
	private String regcerno;//登记证书编号
	private String license;//号牌号码
	
	private String reviewer;//登记审核岗经办人
	private String plateCodeReviewer;//牌证管理岗经办人
	private String businessReviewer;//业务领导刚经办人
	private String fileReviewer;//档案管理岗经办人
	private String reviewerDate;//登记审核人经办时间
	private String plateCodeReviewerDate;//牌证管理员经办时间
	private String businessReviewerDate;//业务领导经办时间
	private String fileReviewerDate;//档案管理岗经办时间
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getMachinetype() {
		return machinetype;
	}
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	public String getEngineBrand() {
		return engineBrand;
	}
	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getPlateCodeReviewer() {
		return plateCodeReviewer;
	}
	public void setPlateCodeReviewer(String plateCodeReviewer) {
		this.plateCodeReviewer = plateCodeReviewer;
	}
	public String getBusinessReviewer() {
		return businessReviewer;
	}
	public void setBusinessReviewer(String businessReviewer) {
		this.businessReviewer = businessReviewer;
	}
	public String getFileReviewer() {
		return fileReviewer;
	}
	public void setFileReviewer(String fileReviewer) {
		this.fileReviewer = fileReviewer;
	}
	public String getReviewerDate() {
		return reviewerDate;
	}
	public void setReviewerDate(String reviewerDate) {
		this.reviewerDate = reviewerDate;
	}
	public String getPlateCodeReviewerDate() {
		return plateCodeReviewerDate;
	}
	public void setPlateCodeReviewerDate(String plateCodeReviewerDate) {
		this.plateCodeReviewerDate = plateCodeReviewerDate;
	}
	public String getBusinessReviewerDate() {
		return businessReviewerDate;
	}
	public void setBusinessReviewerDate(String businessReviewerDate) {
		this.businessReviewerDate = businessReviewerDate;
	}
	public String getFileReviewerDate() {
		return fileReviewerDate;
	}
	public void setFileReviewerDate(String fileReviewerDate) {
		this.fileReviewerDate = fileReviewerDate;
	}
	

}
