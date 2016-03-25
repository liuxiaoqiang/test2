package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "ynzc_logout")
public class Loyout {
	private int id;
	private int tractorinfoid;
	private int logtouttype;
	private int logoutnum;
	private String relationinfo;
	private int logoutreasons;
	private Date stopdate;
	private String checkinmen;
	private Date checkindate;
	private String licensemen;
	private Date licensedate;
	private String businessmen;
	private Date businessdate;	
	private String checkmen;
	private int checkstate;
	private String checkcontent;
	private Date checkdate;
	private String checkip;
	private String opertator;
	private Date operatedate;
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
	public int getTractorinfoid() {
		return tractorinfoid;
	}
	public void setTractorinfoid(int tractorinfoid) {
		this.tractorinfoid = tractorinfoid;
	}
	public int getLogtouttype() {
		return logtouttype;
	}
	public void setLogtouttype(int logtouttype) {
		this.logtouttype = logtouttype;
	}
	public int getLogoutnum() {
		return logoutnum;
	}
	public void setLogoutnum(int logoutnum) {
		this.logoutnum = logoutnum;
	}
	public String getRelationinfo() {
		return relationinfo;
	}
	public void setRelationinfo(String relationinfo) {
		this.relationinfo = relationinfo;
	}
	public int getLogoutreasons() {
		return logoutreasons;
	}
	public void setLogoutreasons(int logoutreasons) {
		this.logoutreasons = logoutreasons;
	}
	public Date getStopdate() {
		return stopdate;
	}
	public void setStopdate(Date stopdate) {
		this.stopdate = stopdate;
	}
	public String getCheckinmen() {
		return checkinmen;
	}
	public void setCheckinmen(String checkinmen) {
		this.checkinmen = checkinmen;
	}
	public Date getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(Date checkindate) {
		this.checkindate = checkindate;
	}
	public String getLicensemen() {
		return licensemen;
	}
	public void setLicensemen(String licensemen) {
		this.licensemen = licensemen;
	}
	public Date getLicensedate() {
		return licensedate;
	}
	public void setLicensedate(Date licensedate) {
		this.licensedate = licensedate;
	}
	public String getBusinessmen() {
		return businessmen;
	}
	public void setBusinessmen(String businessmen) {
		this.businessmen = businessmen;
	}
	public Date getBusinessdate() {
		return businessdate;
	}
	public void setBusinessdate(Date businessdate) {
		this.businessdate = businessdate;
	}
	public String getCheckmen() {
		return checkmen;
	}
	public void setCheckmen(String checkmen) {
		this.checkmen = checkmen;
	}
	public int getCheckstate() {
		return checkstate;
	}
	public void setCheckstate(int checkstate) {
		this.checkstate = checkstate;
	}
	public String getCheckcontent() {
		return checkcontent;
	}
	public void setCheckcontent(String checkcontent) {
		this.checkcontent = checkcontent;
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
	public String getOpertator() {
		return opertator;
	}
	public void setOpertator(String opertator) {
		this.opertator = opertator;
	}
	public Date getOperatedate() {
		return operatedate;
	}
	public void setOperatedate(Date operatedate) {
		this.operatedate = operatedate;
	}
//	public int getFiling() {
//		return filing;
//	}
//	public void setFiling(int filing) {
//		this.filing = filing;
//	}
//	public Date getFilingDate() {
//		return filingDate;
//	}
//	public void setFilingDate(Date filingDate) {
//		this.filingDate = filingDate;
//	}

}
