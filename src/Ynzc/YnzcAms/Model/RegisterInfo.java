package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
//注册信息
@Entity
@Table(name = "ynzc_registerinfo")
public class RegisterInfo {
public int id;
public Date registerdate;
private Date turnindate;
public Date issuedate;
public String beforeregion;
public int tractorinfoId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getRegisterdate() {
	return registerdate;
}
public void setRegisterdate(Date registerdate) {
	this.registerdate = registerdate;
}
public Date getIssuedate() {
	return issuedate;
}
public void setIssuedate(Date issuedate) {
	this.issuedate = issuedate;
}
public String getBeforeregion() {
	return beforeregion;
}
public void setBeforeregion(String beforeregion) {
	this.beforeregion = beforeregion;
}
public int getTractorinfoId() {
	return tractorinfoId;
}
public void setTractorinfoId(int tractorinfoId) {
	this.tractorinfoId = tractorinfoId;
}
public Date getTurnindate() {
	return turnindate;
}
public void setTurnindate(Date turnindate) {
	this.turnindate = turnindate;
}
}
