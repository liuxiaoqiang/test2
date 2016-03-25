package Ynzc.YnzcAms.Model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_cartransfer")
public class CarTransfer {
	private int id;//自动增长ID主键
	private int tractorinfoId;//转移拖拉机ID
	private String transfertype;//转移业务类型
	private String orginregionid;//转出原地区编号
	private String orginregionname;//转出原地区名称
	private int orginunitid;//转出原机构编号
	private String orginunitname;//转出原机构名称
	private String regionid;//转入现地区编号
	private String regionname;//转入现地区名称
	private int unitid;//转入现机构编号
	private String unitname;//转入现机构名称
	private Date applydate;//申请日期
	private String applymen;//申请人名字
	private String applyip;//申请地址
	private String checkmen;//审核人名字
	private Date checkdate;//审核日期
	private String checkip;//审核地址
	private int checkresult;//审核结果 0.待上报 1、已上报、等到审核 2、审核通过 3、审核未通过
	private String checkcontext;//审核内容
	private String oldlicense;//原号牌号码 
	private int applytype;//申请类型 0、申请转出 1、申请转入
//	private int filing;
//	private Date filingDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTractorinfoId() {
		return tractorinfoId;
	}

	public void setTractorinfoId(int tractorinfoId) {
		this.tractorinfoId = tractorinfoId;
	}

	public String getTransfertype() {
		return transfertype;
	}

	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getApplymen() {
		return applymen;
	}

	public void setApplymen(String applymen) {
		this.applymen = applymen;
	}

	public String getApplyip() {
		return applyip;
	}

	public void setApplyip(String applyip) {
		this.applyip = applyip;
	}

	public String getCheckmen() {
		return checkmen;
	}

	public void setCheckmen(String checkmen) {
		this.checkmen = checkmen;
	}

	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	public String getCheckip() {
		return checkip;
	}

	public void setCheckip(String checkip) {
		this.checkip = checkip;
	}

	public int getOrginunitid() {
		return orginunitid;
	}

	public void setOrginunitid(int orginunitid) {
		this.orginunitid = orginunitid;
	}

	public String getOrginunitname() {
		return orginunitname;
	}

	public void setOrginunitname(String orginunitname) {
		this.orginunitname = orginunitname;
	}

	public int getUnitid() {
		return unitid;
	}

	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getOrginregionname() {
		return orginregionname;
	}

	public void setOrginregionname(String orginregionname) {
		this.orginregionname = orginregionname;
	}

	public String getRegionname() {
		return regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public String getOrginregionid() {
		return orginregionid;
	}

	public void setOrginregionid(String orginregionid) {
		this.orginregionid = orginregionid;
	}

	public String getRegionid() {
		return regionid;
	}

	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}

	public String getCheckcontext() {
		return checkcontext;
	}

	public void setCheckcontext(String checkcontext) {
		this.checkcontext = checkcontext;
	}

	public int getCheckresult() {
		return checkresult;
	}

	public void setCheckresult(int checkresult) {
		this.checkresult = checkresult;
	}

	public String getOldlicense() {
		return oldlicense;
	}

	public void setOldlicense(String oldlicense) {
		this.oldlicense = oldlicense;
	}

	public int getApplytype() {
		return applytype;
	}

	public void setApplytype(int applytype) {
		this.applytype = applytype;
	}
    
//	public int getFiling() {
//		return filing;
//	}
//
//	public void setFiling(int filing) {
//		this.filing = filing;
//	}
//
//	public Date getFilingDate() {
//		return filingDate;
//	}
//
//	public void setFilingDate(Date filingDate) {
//		this.filingDate = filingDate;
//	}

}
