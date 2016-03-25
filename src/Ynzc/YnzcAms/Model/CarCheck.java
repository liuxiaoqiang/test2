package Ynzc.YnzcAms.Model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_carcheck")
public class CarCheck {
	private int id;
	private int tractorinfoId;
	private int orgintractorstate;
	private String orgincheckresult;
	private String orgindisqualification;
	private Date orgincheckexpirydate;
	private String orgininspector;
	private Date orgincheckdate;
	private String orginshowinitialinspectionresult;
	private String orginshowdisqualification;
	private String orginshowexaminationresult;
	private String orginengineinitialinspectionresult;
	private String orginenginedisqualification;
	private String orginengineexaminationresult;
	private String orginconveyorinitialinspectionresult;
	private String orginconveyordisqualification;
	private String orginconveyorexaminationresult;
	private String orginsteeringinitialinspectionresult;
	private String orginsteeringdisqualification;
	private String orginsteeringexaminationresult;
	private String orginflyhostinitialinspectionresult;
	private String orginflyhostdisqualification;
	private String orginflyhostexaminationresult;
	private String orginflytrailerinitialinspectionresult;
	private String orginflytrailerdisqualification;
	private String orginflytrailerexaminationresult;
	private String orginbrakhostinitialinspectionresult;
	private String orginbrakhostdisqualification;
	private String orginbrakhostexaminationresult;
	private String orginbraktrailerinitialinspectionresult;
	private String orginbraktrailerdisqualification;
	private String orginbraktrailerexaminationresult;
	private String orginlighthostinitialinspectionresult;
	private String orginlighthostdisqualification;
	private String orginlighthostexaminationresult;
	private String orginlighttrailerinitialinspectionresult;
	private String orginlighttrailerdisqualification;
	private String orginlighttrailerexaminationresult;
	private String orgintractioninitialinspectionresult;
	private String orgintractiondisqualification;
	private String orgintractionexaminationresult;
	private String orgininsurancelistno;
	private Date orgininsurancedate;
	private String orgininsurancecompanyname;
	private String orginexpirydate;

	private String inspectorresult;
	private Date checkexpirydate;
	private String inspector;
	private Date inspectordate;
	private String checkcompanyname;
	private String currentdisqualification;
	private String currentshowinitialinspectionresult;
	private String currentshowdisqualification;
	private String currentshowexaminationresult;
	private String currentengineinitialinspectionresult;
	private String currentenginedisqualification;
	private String currentengineexaminationresult;
	private String currentconveyorinitialinspectionresult;
	private String currentconveyordisqualification;
	private String currentconveyorexaminationresult;
	private String currentsteeringinitialinspectionresult;
	private String currentsteeringdisqualification;
	private String currentsteeringexaminationresult;
	private String currentflyhostinitialinspectionresult;
	private String currentflyhostdisqualification;
	private String currentflyhostexaminationresult;
	private String currentflytrailerinitialinspectionresult;
	private String currentflytrailerdisqualification;
	private String currentflytrailerexaminationresult;
	private String currentbrakhostinitialinspectionresult;
	private String currentbrakhostdisqualification;
	private String currentbrakhostexaminationresult;
	private String currentbraktrailerinitialinspectionresult;
	private String currentbraktrailerdisqualification;
	private String currentbraktrailerexaminationresult;
	private String currentlighthostinitialinspectionresult;
	private String currentlighthostdisqualification;
	private String currentlighthostexaminationresult;
	private String currentlighttrailerinitialinspectionresult;
	private String currentlighttrailerdisqualification;
	private String currentlighttrailerexaminationresult;
	private String currenttractioninitialinspectionresult;
	private String currenttractiondisqualification;
	private String currenttractionexaminationresult;

	private String insurancelistno;
	private Date insurancedate;
	private String insurancecompanyname;
	private Date expirydate;
	private String reviewer;
	private Date reviewerconductdate;
	private String issueadmin;
	private Date issueadmindate;
	private String leaderreview;
	private Date leaderreviewdate;
	private String operateuser;
	private Date operatedate;
	private String checkuser;
	private Date checkdate;
	private String checkip;
	private int checkresult;
	private String checkcontext;
	private int checktype;
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

	public String getInspectorresult() {
		return inspectorresult;
	}

	public int getOrgintractorstate() {
		return orgintractorstate;
	}

	public void setOrgintractorstate(int orgintractorstate) {
		this.orgintractorstate = orgintractorstate;
	}

	public void setInspectorresult(String inspectorresult) {
		this.inspectorresult = inspectorresult;
	}

	public Date getCheckexpirydate() {
		return checkexpirydate;
	}

	public void setCheckexpirydate(Date checkexpirydate) {
		this.checkexpirydate = checkexpirydate;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public Date getInspectordate() {
		return inspectordate;
	}

	public void setInspectordate(Date inspectordate) {
		this.inspectordate = inspectordate;
	}

	public String getCheckcompanyname() {
		return checkcompanyname;
	}

	public void setCheckcompanyname(String checkcompanyname) {
		this.checkcompanyname = checkcompanyname;
	}

	public String getInsurancelistno() {
		return insurancelistno;
	}

	public void setInsurancelistno(String insurancelistno) {
		this.insurancelistno = insurancelistno;
	}

	public Date getInsurancedate() {
		return insurancedate;
	}

	public void setInsurancedate(Date insurancedate) {
		this.insurancedate = insurancedate;
	}

	public String getInsurancecompanyname() {
		return insurancecompanyname;
	}

	public void setInsurancecompanyname(String insurancecompanyname) {
		this.insurancecompanyname = insurancecompanyname;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
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

	public String getLeaderreview() {
		return leaderreview;
	}

	public void setLeaderreview(String leaderreview) {
		this.leaderreview = leaderreview;
	}

	public Date getLeaderreviewdate() {
		return leaderreviewdate;
	}

	public void setLeaderreviewdate(Date leaderreviewdate) {
		this.leaderreviewdate = leaderreviewdate;
	}

	public String getOperateuser() {
		return operateuser;
	}

	public void setOperateuser(String operateuser) {
		this.operateuser = operateuser;
	}

	public int getCheckresult() {
		return checkresult;
	}

	public void setCheckresult(int checkresult) {
		this.checkresult = checkresult;
	}

	public String getCheckcontext() {
		return checkcontext;
	}

	public void setCheckcontext(String checkcontext) {
		this.checkcontext = checkcontext;
	}

	public Date getOperatedate() {
		return operatedate;
	}

	public void setOperatedate(Date operatedate) {
		this.operatedate = operatedate;
	}

	public String getCheckuser() {
		return checkuser;
	}

	public void setCheckuser(String checkuser) {
		this.checkuser = checkuser;
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

	public int getChecktype() {
		return checktype;
	}

	public void setChecktype(int checktype) {
		this.checktype = checktype;
	}

	public String getOrgincheckresult() {
		return orgincheckresult;
	}

	public void setOrgincheckresult(String orgincheckresult) {
		this.orgincheckresult = orgincheckresult;
	}

	public String getOrgindisqualification() {
		return orgindisqualification;
	}

	public void setOrgindisqualification(String orgindisqualification) {
		this.orgindisqualification = orgindisqualification;
	}

	public Date getOrgincheckexpirydate() {
		return orgincheckexpirydate;
	}

	public void setOrgincheckexpirydate(Date orgincheckexpirydate) {
		this.orgincheckexpirydate = orgincheckexpirydate;
	}

	public String getOrgininspector() {
		return orgininspector;
	}

	public void setOrgininspector(String orgininspector) {
		this.orgininspector = orgininspector;
	}

	public Date getOrgincheckdate() {
		return orgincheckdate;
	}

	public void setOrgincheckdate(Date orgincheckdate) {
		this.orgincheckdate = orgincheckdate;
	}

	public String getOrginshowinitialinspectionresult() {
		return orginshowinitialinspectionresult;
	}

	public void setOrginshowinitialinspectionresult(
			String orginshowinitialinspectionresult) {
		this.orginshowinitialinspectionresult = orginshowinitialinspectionresult;
	}

	public String getOrginshowdisqualification() {
		return orginshowdisqualification;
	}

	public void setOrginshowdisqualification(String orginshowdisqualification) {
		this.orginshowdisqualification = orginshowdisqualification;
	}

	public String getOrginshowexaminationresult() {
		return orginshowexaminationresult;
	}

	public void setOrginshowexaminationresult(String orginshowexaminationresult) {
		this.orginshowexaminationresult = orginshowexaminationresult;
	}

	public String getOrginengineinitialinspectionresult() {
		return orginengineinitialinspectionresult;
	}

	public void setOrginengineinitialinspectionresult(
			String orginengineinitialinspectionresult) {
		this.orginengineinitialinspectionresult = orginengineinitialinspectionresult;
	}

	public String getOrginenginedisqualification() {
		return orginenginedisqualification;
	}

	public void setOrginenginedisqualification(
			String orginenginedisqualification) {
		this.orginenginedisqualification = orginenginedisqualification;
	}

	public String getOrginengineexaminationresult() {
		return orginengineexaminationresult;
	}

	public void setOrginengineexaminationresult(
			String orginengineexaminationresult) {
		this.orginengineexaminationresult = orginengineexaminationresult;
	}

	public String getOrginconveyorinitialinspectionresult() {
		return orginconveyorinitialinspectionresult;
	}

	public void setOrginconveyorinitialinspectionresult(
			String orginconveyorinitialinspectionresult) {
		this.orginconveyorinitialinspectionresult = orginconveyorinitialinspectionresult;
	}

	public String getOrginconveyordisqualification() {
		return orginconveyordisqualification;
	}

	public void setOrginconveyordisqualification(
			String orginconveyordisqualification) {
		this.orginconveyordisqualification = orginconveyordisqualification;
	}

	public String getOrginconveyorexaminationresult() {
		return orginconveyorexaminationresult;
	}

	public void setOrginconveyorexaminationresult(
			String orginconveyorexaminationresult) {
		this.orginconveyorexaminationresult = orginconveyorexaminationresult;
	}

	public String getOrginsteeringinitialinspectionresult() {
		return orginsteeringinitialinspectionresult;
	}

	public void setOrginsteeringinitialinspectionresult(
			String orginsteeringinitialinspectionresult) {
		this.orginsteeringinitialinspectionresult = orginsteeringinitialinspectionresult;
	}

	public String getOrginsteeringdisqualification() {
		return orginsteeringdisqualification;
	}

	public void setOrginsteeringdisqualification(
			String orginsteeringdisqualification) {
		this.orginsteeringdisqualification = orginsteeringdisqualification;
	}

	public String getOrginsteeringexaminationresult() {
		return orginsteeringexaminationresult;
	}

	public void setOrginsteeringexaminationresult(
			String orginsteeringexaminationresult) {
		this.orginsteeringexaminationresult = orginsteeringexaminationresult;
	}

	public String getOrginflyhostinitialinspectionresult() {
		return orginflyhostinitialinspectionresult;
	}

	public void setOrginflyhostinitialinspectionresult(
			String orginflyhostinitialinspectionresult) {
		this.orginflyhostinitialinspectionresult = orginflyhostinitialinspectionresult;
	}

	public String getOrginflyhostdisqualification() {
		return orginflyhostdisqualification;
	}

	public void setOrginflyhostdisqualification(
			String orginflyhostdisqualification) {
		this.orginflyhostdisqualification = orginflyhostdisqualification;
	}

	public String getOrginflyhostexaminationresult() {
		return orginflyhostexaminationresult;
	}

	public void setOrginflyhostexaminationresult(
			String orginflyhostexaminationresult) {
		this.orginflyhostexaminationresult = orginflyhostexaminationresult;
	}

	public String getOrginflytrailerinitialinspectionresult() {
		return orginflytrailerinitialinspectionresult;
	}

	public void setOrginflytrailerinitialinspectionresult(
			String orginflytrailerinitialinspectionresult) {
		this.orginflytrailerinitialinspectionresult = orginflytrailerinitialinspectionresult;
	}

	public String getOrginflytrailerdisqualification() {
		return orginflytrailerdisqualification;
	}

	public void setOrginflytrailerdisqualification(
			String orginflytrailerdisqualification) {
		this.orginflytrailerdisqualification = orginflytrailerdisqualification;
	}

	public String getOrginflytrailerexaminationresult() {
		return orginflytrailerexaminationresult;
	}

	public void setOrginflytrailerexaminationresult(
			String orginflytrailerexaminationresult) {
		this.orginflytrailerexaminationresult = orginflytrailerexaminationresult;
	}

	public String getOrginbrakhostinitialinspectionresult() {
		return orginbrakhostinitialinspectionresult;
	}

	public void setOrginbrakhostinitialinspectionresult(
			String orginbrakhostinitialinspectionresult) {
		this.orginbrakhostinitialinspectionresult = orginbrakhostinitialinspectionresult;
	}

	public String getOrginbrakhostdisqualification() {
		return orginbrakhostdisqualification;
	}

	public void setOrginbrakhostdisqualification(
			String orginbrakhostdisqualification) {
		this.orginbrakhostdisqualification = orginbrakhostdisqualification;
	}

	public String getOrginbrakhostexaminationresult() {
		return orginbrakhostexaminationresult;
	}

	public void setOrginbrakhostexaminationresult(
			String orginbrakhostexaminationresult) {
		this.orginbrakhostexaminationresult = orginbrakhostexaminationresult;
	}

	public String getOrginbraktrailerinitialinspectionresult() {
		return orginbraktrailerinitialinspectionresult;
	}

	public void setOrginbraktrailerinitialinspectionresult(
			String orginbraktrailerinitialinspectionresult) {
		this.orginbraktrailerinitialinspectionresult = orginbraktrailerinitialinspectionresult;
	}

	public String getOrginbraktrailerdisqualification() {
		return orginbraktrailerdisqualification;
	}

	public void setOrginbraktrailerdisqualification(
			String orginbraktrailerdisqualification) {
		this.orginbraktrailerdisqualification = orginbraktrailerdisqualification;
	}

	public String getOrginbraktrailerexaminationresult() {
		return orginbraktrailerexaminationresult;
	}

	public void setOrginbraktrailerexaminationresult(
			String orginbraktrailerexaminationresult) {
		this.orginbraktrailerexaminationresult = orginbraktrailerexaminationresult;
	}

	public String getOrginlighthostinitialinspectionresult() {
		return orginlighthostinitialinspectionresult;
	}

	public void setOrginlighthostinitialinspectionresult(
			String orginlighthostinitialinspectionresult) {
		this.orginlighthostinitialinspectionresult = orginlighthostinitialinspectionresult;
	}

	public String getOrginlighthostdisqualification() {
		return orginlighthostdisqualification;
	}

	public void setOrginlighthostdisqualification(
			String orginlighthostdisqualification) {
		this.orginlighthostdisqualification = orginlighthostdisqualification;
	}

	public String getOrginlighthostexaminationresult() {
		return orginlighthostexaminationresult;
	}

	public void setOrginlighthostexaminationresult(
			String orginlighthostexaminationresult) {
		this.orginlighthostexaminationresult = orginlighthostexaminationresult;
	}

	public String getOrginlighttrailerinitialinspectionresult() {
		return orginlighttrailerinitialinspectionresult;
	}

	public void setOrginlighttrailerinitialinspectionresult(
			String orginlighttrailerinitialinspectionresult) {
		this.orginlighttrailerinitialinspectionresult = orginlighttrailerinitialinspectionresult;
	}

	public String getOrginlighttrailerdisqualification() {
		return orginlighttrailerdisqualification;
	}

	public void setOrginlighttrailerdisqualification(
			String orginlighttrailerdisqualification) {
		this.orginlighttrailerdisqualification = orginlighttrailerdisqualification;
	}

	public String getOrginlighttrailerexaminationresult() {
		return orginlighttrailerexaminationresult;
	}

	public void setOrginlighttrailerexaminationresult(
			String orginlighttrailerexaminationresult) {
		this.orginlighttrailerexaminationresult = orginlighttrailerexaminationresult;
	}

	public String getOrgintractioninitialinspectionresult() {
		return orgintractioninitialinspectionresult;
	}

	public void setOrgintractioninitialinspectionresult(
			String orgintractioninitialinspectionresult) {
		this.orgintractioninitialinspectionresult = orgintractioninitialinspectionresult;
	}

	public String getOrgintractiondisqualification() {
		return orgintractiondisqualification;
	}

	public void setOrgintractiondisqualification(
			String orgintractiondisqualification) {
		this.orgintractiondisqualification = orgintractiondisqualification;
	}

	public String getOrgintractionexaminationresult() {
		return orgintractionexaminationresult;
	}

	public void setOrgintractionexaminationresult(
			String orgintractionexaminationresult) {
		this.orgintractionexaminationresult = orgintractionexaminationresult;
	}

	public String getOrgininsurancelistno() {
		return orgininsurancelistno;
	}

	public void setOrgininsurancelistno(String orgininsurancelistno) {
		this.orgininsurancelistno = orgininsurancelistno;
	}

	public Date getOrgininsurancedate() {
		return orgininsurancedate;
	}

	public void setOrgininsurancedate(Date orgininsurancedate) {
		this.orgininsurancedate = orgininsurancedate;
	}

	public String getOrgininsurancecompanyname() {
		return orgininsurancecompanyname;
	}

	public void setOrgininsurancecompanyname(String orgininsurancecompanyname) {
		this.orgininsurancecompanyname = orgininsurancecompanyname;
	}

	public String getOrginexpirydate() {
		return orginexpirydate;
	}

	public void setOrginexpirydate(String orginexpirydate) {
		this.orginexpirydate = orginexpirydate;
	}

	public String getCurrentdisqualification() {
		return currentdisqualification;
	}

	public void setCurrentdisqualification(String currentdisqualification) {
		this.currentdisqualification = currentdisqualification;
	}

	public String getCurrentshowinitialinspectionresult() {
		return currentshowinitialinspectionresult;
	}

	public void setCurrentshowinitialinspectionresult(
			String currentshowinitialinspectionresult) {
		this.currentshowinitialinspectionresult = currentshowinitialinspectionresult;
	}

	public String getCurrentshowdisqualification() {
		return currentshowdisqualification;
	}

	public void setCurrentshowdisqualification(
			String currentshowdisqualification) {
		this.currentshowdisqualification = currentshowdisqualification;
	}

	public String getCurrentshowexaminationresult() {
		return currentshowexaminationresult;
	}

	public void setCurrentshowexaminationresult(
			String currentshowexaminationresult) {
		this.currentshowexaminationresult = currentshowexaminationresult;
	}

	public String getCurrentengineinitialinspectionresult() {
		return currentengineinitialinspectionresult;
	}

	public void setCurrentengineinitialinspectionresult(
			String currentengineinitialinspectionresult) {
		this.currentengineinitialinspectionresult = currentengineinitialinspectionresult;
	}

	public String getCurrentenginedisqualification() {
		return currentenginedisqualification;
	}

	public void setCurrentenginedisqualification(
			String currentenginedisqualification) {
		this.currentenginedisqualification = currentenginedisqualification;
	}

	public String getCurrentengineexaminationresult() {
		return currentengineexaminationresult;
	}

	public void setCurrentengineexaminationresult(
			String currentengineexaminationresult) {
		this.currentengineexaminationresult = currentengineexaminationresult;
	}

	public String getCurrentconveyorinitialinspectionresult() {
		return currentconveyorinitialinspectionresult;
	}

	public void setCurrentconveyorinitialinspectionresult(
			String currentconveyorinitialinspectionresult) {
		this.currentconveyorinitialinspectionresult = currentconveyorinitialinspectionresult;
	}

	public String getCurrentconveyordisqualification() {
		return currentconveyordisqualification;
	}

	public void setCurrentconveyordisqualification(
			String currentconveyordisqualification) {
		this.currentconveyordisqualification = currentconveyordisqualification;
	}

	public String getCurrentconveyorexaminationresult() {
		return currentconveyorexaminationresult;
	}

	public void setCurrentconveyorexaminationresult(
			String currentconveyorexaminationresult) {
		this.currentconveyorexaminationresult = currentconveyorexaminationresult;
	}

	public String getCurrentsteeringinitialinspectionresult() {
		return currentsteeringinitialinspectionresult;
	}

	public void setCurrentsteeringinitialinspectionresult(
			String currentsteeringinitialinspectionresult) {
		this.currentsteeringinitialinspectionresult = currentsteeringinitialinspectionresult;
	}

	public String getCurrentsteeringdisqualification() {
		return currentsteeringdisqualification;
	}

	public void setCurrentsteeringdisqualification(
			String currentsteeringdisqualification) {
		this.currentsteeringdisqualification = currentsteeringdisqualification;
	}

	public String getCurrentsteeringexaminationresult() {
		return currentsteeringexaminationresult;
	}

	public void setCurrentsteeringexaminationresult(
			String currentsteeringexaminationresult) {
		this.currentsteeringexaminationresult = currentsteeringexaminationresult;
	}

	public String getCurrentflyhostinitialinspectionresult() {
		return currentflyhostinitialinspectionresult;
	}

	public void setCurrentflyhostinitialinspectionresult(
			String currentflyhostinitialinspectionresult) {
		this.currentflyhostinitialinspectionresult = currentflyhostinitialinspectionresult;
	}

	public String getCurrentflyhostdisqualification() {
		return currentflyhostdisqualification;
	}

	public void setCurrentflyhostdisqualification(
			String currentflyhostdisqualification) {
		this.currentflyhostdisqualification = currentflyhostdisqualification;
	}

	public String getCurrentflyhostexaminationresult() {
		return currentflyhostexaminationresult;
	}

	public void setCurrentflyhostexaminationresult(
			String currentflyhostexaminationresult) {
		this.currentflyhostexaminationresult = currentflyhostexaminationresult;
	}

	public String getCurrentflytrailerinitialinspectionresult() {
		return currentflytrailerinitialinspectionresult;
	}

	public void setCurrentflytrailerinitialinspectionresult(
			String currentflytrailerinitialinspectionresult) {
		this.currentflytrailerinitialinspectionresult = currentflytrailerinitialinspectionresult;
	}

	public String getCurrentflytrailerdisqualification() {
		return currentflytrailerdisqualification;
	}

	public void setCurrentflytrailerdisqualification(
			String currentflytrailerdisqualification) {
		this.currentflytrailerdisqualification = currentflytrailerdisqualification;
	}

	public String getCurrentflytrailerexaminationresult() {
		return currentflytrailerexaminationresult;
	}

	public void setCurrentflytrailerexaminationresult(
			String currentflytrailerexaminationresult) {
		this.currentflytrailerexaminationresult = currentflytrailerexaminationresult;
	}

	public String getCurrentbrakhostinitialinspectionresult() {
		return currentbrakhostinitialinspectionresult;
	}

	public void setCurrentbrakhostinitialinspectionresult(
			String currentbrakhostinitialinspectionresult) {
		this.currentbrakhostinitialinspectionresult = currentbrakhostinitialinspectionresult;
	}

	public String getCurrentbrakhostdisqualification() {
		return currentbrakhostdisqualification;
	}

	public void setCurrentbrakhostdisqualification(
			String currentbrakhostdisqualification) {
		this.currentbrakhostdisqualification = currentbrakhostdisqualification;
	}

	public String getCurrentbrakhostexaminationresult() {
		return currentbrakhostexaminationresult;
	}

	public void setCurrentbrakhostexaminationresult(
			String currentbrakhostexaminationresult) {
		this.currentbrakhostexaminationresult = currentbrakhostexaminationresult;
	}

	public String getCurrentbraktrailerinitialinspectionresult() {
		return currentbraktrailerinitialinspectionresult;
	}

	public void setCurrentbraktrailerinitialinspectionresult(
			String currentbraktrailerinitialinspectionresult) {
		this.currentbraktrailerinitialinspectionresult = currentbraktrailerinitialinspectionresult;
	}

	public String getCurrentbraktrailerdisqualification() {
		return currentbraktrailerdisqualification;
	}

	public void setCurrentbraktrailerdisqualification(
			String currentbraktrailerdisqualification) {
		this.currentbraktrailerdisqualification = currentbraktrailerdisqualification;
	}

	public String getCurrentbraktrailerexaminationresult() {
		return currentbraktrailerexaminationresult;
	}

	public void setCurrentbraktrailerexaminationresult(
			String currentbraktrailerexaminationresult) {
		this.currentbraktrailerexaminationresult = currentbraktrailerexaminationresult;
	}

	public String getCurrentlighthostinitialinspectionresult() {
		return currentlighthostinitialinspectionresult;
	}

	public void setCurrentlighthostinitialinspectionresult(
			String currentlighthostinitialinspectionresult) {
		this.currentlighthostinitialinspectionresult = currentlighthostinitialinspectionresult;
	}

	public String getCurrentlighthostdisqualification() {
		return currentlighthostdisqualification;
	}

	public void setCurrentlighthostdisqualification(
			String currentlighthostdisqualification) {
		this.currentlighthostdisqualification = currentlighthostdisqualification;
	}

	public String getCurrentlighthostexaminationresult() {
		return currentlighthostexaminationresult;
	}

	public void setCurrentlighthostexaminationresult(
			String currentlighthostexaminationresult) {
		this.currentlighthostexaminationresult = currentlighthostexaminationresult;
	}

	public String getCurrentlighttrailerinitialinspectionresult() {
		return currentlighttrailerinitialinspectionresult;
	}

	public void setCurrentlighttrailerinitialinspectionresult(
			String currentlighttrailerinitialinspectionresult) {
		this.currentlighttrailerinitialinspectionresult = currentlighttrailerinitialinspectionresult;
	}

	public String getCurrentlighttrailerdisqualification() {
		return currentlighttrailerdisqualification;
	}

	public void setCurrentlighttrailerdisqualification(
			String currentlighttrailerdisqualification) {
		this.currentlighttrailerdisqualification = currentlighttrailerdisqualification;
	}

	public String getCurrentlighttrailerexaminationresult() {
		return currentlighttrailerexaminationresult;
	}

	public void setCurrentlighttrailerexaminationresult(
			String currentlighttrailerexaminationresult) {
		this.currentlighttrailerexaminationresult = currentlighttrailerexaminationresult;
	}

	public String getCurrenttractioninitialinspectionresult() {
		return currenttractioninitialinspectionresult;
	}

	public void setCurrenttractioninitialinspectionresult(
			String currenttractioninitialinspectionresult) {
		this.currenttractioninitialinspectionresult = currenttractioninitialinspectionresult;
	}

	public String getCurrenttractiondisqualification() {
		return currenttractiondisqualification;
	}

	public void setCurrenttractiondisqualification(
			String currenttractiondisqualification) {
		this.currenttractiondisqualification = currenttractiondisqualification;
	}

	public String getCurrenttractionexaminationresult() {
		return currenttractionexaminationresult;
	}

	public void setCurrenttractionexaminationresult(
			String currenttractionexaminationresult) {
		this.currenttractionexaminationresult = currenttractionexaminationresult;
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
