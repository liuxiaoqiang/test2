package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_tractorreplacementinfo")
public class TractorReplacementInfo {
	public int id;
	public String flapperNumber;
	public String certregistrationNumber;
	public String venue;
	public String sortsofinsurance;
	public String selevanceVoucher;
	public String reason;
	public String flapperFace;
	public String registrantAuditor;
	public Date registrantAuditorDate;
	public String flapperDirector;
	public Date flapperDirectorDate;
	public String businessLeadAuditor;
	public Date businessLeadAuditorDate;
	public int examineStatus;
	public String examineAuditor;
	public String examineStatusIdea;
	public Date examineDate;
	public String operator;
	public Date operatorDate;
	public int tractorinfoId;
//	public int filing;
//	public Date filingDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlapperNumber() {
		return flapperNumber;
	}
	public void setFlapperNumber(String flapperNumber) {
		this.flapperNumber = flapperNumber;
	}
	public String getCertregistrationNumber() {
		return certregistrationNumber;
	}
	public void setCertregistrationNumber(String certregistrationNumber) {
		this.certregistrationNumber = certregistrationNumber;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getSortsofinsurance() {
		return sortsofinsurance;
	}
	public void setSortsofinsurance(String sortsofinsurance) {
		this.sortsofinsurance = sortsofinsurance;
	}
	public String getSelevanceVoucher() {
		return selevanceVoucher;
	}
	public void setSelevanceVoucher(String relevanceVoucher) {
		this.selevanceVoucher = relevanceVoucher;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getFlapperFace() {
		return flapperFace;
	}
	public void setFlapperFace(String flapperFace) {
		this.flapperFace = flapperFace;
	}
	public String getRegistrantAuditor() {
		return registrantAuditor;
	}
	public void setRegistrantAuditor(String registrantAuditor) {
		this.registrantAuditor = registrantAuditor;
	}
	public Date getRegistrantAuditorDate() {
		return registrantAuditorDate;
	}
	public void setRegistrantAuditorDate(Date registrantAuditorDate) {
		this.registrantAuditorDate = registrantAuditorDate;
	}
	public String getFlapperDirector() {
		return flapperDirector;
	}
	public void setFlapperDirector(String flapperDirector) {
		this.flapperDirector = flapperDirector;
	}
	public Date getFlapperDirectorDate() {
		return flapperDirectorDate;
	}
	public void setFlapperDirectorDate(Date flapperDirectorDate) {
		this.flapperDirectorDate = flapperDirectorDate;
	}
	public String getBusinessLeadAuditor() {
		return businessLeadAuditor;
	}
	public void setBusinessLeadAuditor(String businessLeadAuditor) {
		this.businessLeadAuditor = businessLeadAuditor;
	}
	public Date getBusinessLeadAuditorDate() {
		return businessLeadAuditorDate;
	}
	public int getExamineStatus() {
		return examineStatus;
	}
	public void setExamineStatus(int examineStatus) {
		this.examineStatus = examineStatus;
	}
	public void setBusinessLeadAuditorDate(Date businessLeadAuditorDate) {
		this.businessLeadAuditorDate = businessLeadAuditorDate;
	}
	public String getExamineAuditor() {
		return examineAuditor;
	}
	public void setExamineAuditor(String examineAuditor) {
		this.examineAuditor = examineAuditor;
	}
	public String getExamineStatusIdea() {
		return examineStatusIdea;
	}
	public void setExamineStatusIdea(String examineStatusIdea) {
		this.examineStatusIdea = examineStatusIdea;
	}
	public Date getExamineDate() {
		return examineDate;
	}
	public void setExamineDate(Date examineDate) {
		this.examineDate = examineDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOperatorDate() {
		return operatorDate;
	}
	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}	
	public int getTractorinfoId() {
		return tractorinfoId;
	}
	public void setTractorinfoId(int tractorinfoId) {
		this.tractorinfoId = tractorinfoId;
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
