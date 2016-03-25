package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "ynzc_changerecord")
public class ChangeRecord {
	private int id;
	private int tractorinfoid;
	private String changerecordtype;
	private String changerecordname;
	private String linktel;
	private int certificateid;
	private String certificatecode;
	private int unittype;
	private String address;
	private String zipcode;
	private int istemporary;
	private int temporaycertificate;
	private String temporaycertificatecode;
	private String checkinmen;
	private Date checkindate;
	private String licensemen;
	private Date licensedate;
	private String businessmen;
	private Date businessdate;
	private String checkmen;
	private int checkstate;
	private Date checkdate;
	private String checkcontent;
	private String checkip;
	private String opertator;
	private Date opertatedate;
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

	public String getChangerecordtype() {
		return changerecordtype;
	}

	public void setChangerecordtype(String changerecordtype) {
		this.changerecordtype = changerecordtype;
	}

	public String getChangerecordname() {
		return changerecordname;
	}

	public void setChangerecordname(String changerecordname) {
		this.changerecordname = changerecordname;
	}

	public int getCertificateid() {
		return certificateid;
	}

	public void setCertificateid(int certificateid) {
		this.certificateid = certificateid;
	}

	public String getCertificatecode() {
		return certificatecode;
	}

	public void setCertificatecode(String certificatecode) {
		this.certificatecode = certificatecode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getTemporaycertificate() {
		return temporaycertificate;
	}

	public void setTemporaycertificate(int temporaycertificate) {
		this.temporaycertificate = temporaycertificate;
	}

	public String getTemporaycertificatecode() {
		return temporaycertificatecode;
	}

	public void setTemporaycertificatecode(String temporaycertificatecode) {
		this.temporaycertificatecode = temporaycertificatecode;
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

	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	public String getCheckcontent() {
		return checkcontent;
	}

	public void setCheckcontent(String checkcontent) {
		this.checkcontent = checkcontent;
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

	public Date getOpertatedate() {
		return opertatedate;
	}

	public void setOpertatedate(Date opertatedate) {
		this.opertatedate = opertatedate;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public int getUnittype() {
		return unittype;
	}

	public void setUnittype(int unittype) {
		this.unittype = unittype;
	}

	public int getIstemporary() {
		return istemporary;
	}

	public void setIstemporary(int istemporary) {
		this.istemporary = istemporary;
	}

	public int getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(int checkstate) {
		this.checkstate = checkstate;
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
