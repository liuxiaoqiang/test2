package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
@Entity
@Table(name = "ynzc_carchange")
public class CarChange {
	// Fields

	private int id;
	private int tractorinfoId;
	private String changeType;
	private String applicationmen;
	private Date applicationtime;
	private String applicationip;
	private String approvalmen;
	private Date approvaltime;
	private int approvalstate;
	private String approvalip;
	private String approvacontext;
	private int filing;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTractorinfoId() {
		return this.tractorinfoId;
	}

	public void setTractorinfoId(int tractorinfoId) {
		this.tractorinfoId = tractorinfoId;
	}

	public String getChangeType() {
		return this.changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public Date getApplicationtime() {
		return this.applicationtime;
	}

	public void setApplicationtime(Date applicationtime) {
		this.applicationtime = applicationtime;
	}

	public String getApplicationip() {
		return this.applicationip;
	}

	public void setApplicationip(String applicationip) {
		this.applicationip = applicationip;
	}



	public Date getApprovaltime() {
		return this.approvaltime;
	}

	public void setApprovaltime(Date approvaltime) {
		this.approvaltime = approvaltime;
	}


	public String getApprovalip() {
		return this.approvalip;
	}

	public void setApprovalip(String approvalip) {
		this.approvalip = approvalip;
	}

	public String getApplicationmen() {
		return applicationmen;
	}

	public void setApplicationmen(String applicationmen) {
		this.applicationmen = applicationmen;
	}

	public String getApprovalmen() {
		return approvalmen;
	}

	public void setApprovalmen(String approvalmen) {
		this.approvalmen = approvalmen;
	}

	public String getApprovacontext() {
		return approvacontext;
	}

	public void setApprovacontext(String approvacontext) {
		this.approvacontext = approvacontext;
	}

	public int getApprovalstate() {
		return approvalstate;
	}

	public void setApprovalstate(int approvalstate) {
		this.approvalstate = approvalstate;
	}

	public int getFiling() {
		return filing;
	}

	public void setFiling(int filing) {
		this.filing = filing;
	}

}
