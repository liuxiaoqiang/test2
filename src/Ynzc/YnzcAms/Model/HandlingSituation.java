package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
//经办情况
@Entity
@Table(name = "ynzc_handlingsituation")
public class HandlingSituation {
public int id;
public String reviewer;
public Date reviewerconductdate;
public String issueadmin;
public String leaderreview;
public Date leaderreviewconductdate;
public Date issueadmindate;
public  int tractorinfoId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getLeaderreview() {
	return leaderreview;
}
public void setLeaderreview(String leaderreview) {
	this.leaderreview = leaderreview;
}
public Date getLeaderreviewconductdate() {
	return leaderreviewconductdate;
}
public void setLeaderreviewconductdate(Date leaderreviewconductdate) {
	this.leaderreviewconductdate = leaderreviewconductdate;
}
public Date getIssueadmindate() {
	return issueadmindate;
}
public void setIssueadmindate(Date issueadmindate) {
	this.issueadmindate = issueadmindate;
}
public int getTractorinfoId() {
	return tractorinfoId;
}
public void setTractorinfoId(int tractorinfoId) {
	this.tractorinfoId = tractorinfoId;
}
}
