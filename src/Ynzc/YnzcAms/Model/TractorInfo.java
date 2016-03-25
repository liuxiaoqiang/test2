package Ynzc.YnzcAms.Model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ynzc_tractorinfo")
public class TractorInfo {
	 public int id ;
     public int unitid;
     public String license;
	 public Date checkeddate;
     public String recorder;
     public int status;
     public String regcerno;
     public Date registerdate;
     public String changeType;
     public String regionid;
     public int filing;
     public Date filingDate;
     @Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Date getCheckeddate() {
		return checkeddate;
	}
	public void setCheckeddate(Date checkeddate) {
		this.checkeddate = checkeddate;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRegcerno() {
		return regcerno;
	}
	public void setRegcerno(String regcerno) {
		this.regcerno = regcerno;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getRegionid() {
		return regionid;
	}
	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}
	public int getFiling() {
		return filing;
	}
	public void setFiling(int filing) {
		this.filing = filing;
	}
	public Date getFilingDate() {
		return filingDate;
	}
	public void setFilingDate(Date filingDate) {
		this.filingDate = filingDate;
	}

}
