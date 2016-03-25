package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

//相关资料
@Entity
@Table(name = "ynzc_relationinfo")
public class RelationInfo {

public int id;
public int getwayfiletypeid;
public String getwayfileno;
public int importsfiletypeid;
public String importsfileno;
public String other;
public String insurancelistno;
public String insurancecompanyname;
public Date insurancedate;
public Date expirydate;
public int tractorinfoId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getGetwayfiletypeid() {
	return getwayfiletypeid;
}
public void setGetwayfiletypeid(int getwayfiletypeid) {
	this.getwayfiletypeid = getwayfiletypeid;
}
public String getGetwayfileno() {
	return getwayfileno;
}
public void setGetwayfileno(String getwayfileno) {
	this.getwayfileno = getwayfileno;
}
public int getImportsfiletypeid() {
	return importsfiletypeid;
}
public void setImportsfiletypeid(int importsfiletypeid) {
	this.importsfiletypeid = importsfiletypeid;
}
public String getImportsfileno() {
	return importsfileno;
}
public void setImportsfileno(String importsfileno) {
	this.importsfileno = importsfileno;
}
public String getOther() {
	return other;
}
public void setOther(String other) {
	this.other = other;
}
public String getInsurancelistno() {
	return insurancelistno;
}
public void setInsurancelistno(String insurancelistno) {
	this.insurancelistno = insurancelistno;
}
public String getInsurancecompanyname() {
	return insurancecompanyname;
}
public void setInsurancecompanyname(String insurancecompanyname) {
	this.insurancecompanyname = insurancecompanyname;
}
public Date getInsurancedate() {
	return insurancedate;
}
public void setInsurancedate(Date insurancedate) {
	this.insurancedate = insurancedate;
}
public Date getExpirydate() {
	return expirydate;
}
public void setExpirydate(Date expirydate) {
	this.expirydate = expirydate;
}
public int getTractorinfoId() {
	return tractorinfoId;
}
public void setTractorinfoId(int tractorinfoId) {
	this.tractorinfoId = tractorinfoId;
}

}
