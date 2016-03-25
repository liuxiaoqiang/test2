package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//所有人信息
@Entity
@Table(name = "ynzc_ownerinfo")
public class OwnerInfo {
public int id;
public String owner;
public String realcertificatetype;
public String realcertificateno;
public String address;
public String tempaddress;
public int istemplived;
public int templivefiletype;
public String timplivefileno;
public String telephone;
public int isUnion;
public String zipCode;
public int tractorinfoId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public String getRealcertificatetype() {
	return realcertificatetype;
}
public void setRealcertificatetype(String realcertificatetype) {
	this.realcertificatetype = realcertificatetype;
}
public String getRealcertificateno() {
	return realcertificateno;
}
public void setRealcertificateno(String realcertificateno) {
	this.realcertificateno = realcertificateno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTempaddress() {
	return tempaddress;
}
public void setTempaddress(String tempaddress) {
	this.tempaddress = tempaddress;
}
public int getIstemplived() {
	return istemplived;
}
public void setIstemplived(int istemplived) {
	this.istemplived = istemplived;
}
public int getTemplivefiletype() {
	return templivefiletype;
}
public void setTemplivefiletype(int templivefiletype) {
	this.templivefiletype = templivefiletype;
}
public String getTimplivefileno() {
	return timplivefileno;
}
public void setTimplivefileno(String timplivefileno) {
	this.timplivefileno = timplivefileno;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public int getIsUnion() {
	return isUnion;
}
public void setIsUnion(int isUnion) {
	this.isUnion = isUnion;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
public int getTractorinfoId() {
	return tractorinfoId;
}
public void setTractorinfoId(int tractorinfoId) {
	this.tractorinfoId = tractorinfoId;
}
}
