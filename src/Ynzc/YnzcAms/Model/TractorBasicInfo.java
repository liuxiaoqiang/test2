package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "ynzc_tractorbasicinfo")
public class TractorBasicInfo {
public int id;
public int getwayid;
public int machinetypeid;
public int machinebrandtypeid;
public String machinebodyno;
public String engineno;
public String shelfno;
public String usedfor;
public String manufacturer;
public String seller;
public Date manufacturedate;
public String price;
public String photourl;
public int tractorinfoId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getGetwayid() {
	return getwayid;
}
public void setGetwayid(int getwayid) {
	this.getwayid = getwayid;
}
public int getMachinetypeid() {
	return machinetypeid;
}
public void setMachinetypeid(int machinetypeid) {
	this.machinetypeid = machinetypeid;
}
public int getMachinebrandtypeid() {
	return machinebrandtypeid;
}
public void setMachinebrandtypeid(int machinebrandtypeid) {
	this.machinebrandtypeid = machinebrandtypeid;
}
public String getMachinebodyno() {
	return machinebodyno;
}
public void setMachinebodyno(String machinebodyno) {
	this.machinebodyno = machinebodyno;
}
public String getEngineno() {
	return engineno;
}
public void setEngineno(String engineno) {
	this.engineno = engineno;
}
public String getShelfno() {
	return shelfno;
}
public void setShelfno(String shelfno) {
	this.shelfno = shelfno;
}
public String getUsedfor() {
	return usedfor;
}
public void setUsedfor(String usedfor) {
	this.usedfor = usedfor;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
public String getSeller() {
	return seller;
}
public void setSeller(String seller) {
	this.seller = seller;
}
public Date getManufacturedate() {
	return manufacturedate;
}
public void setManufacturedate(Date manufacturedate) {
	this.manufacturedate = manufacturedate;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getPhotourl() {
	return photourl;
}
public void setPhotourl(String photourl) {
	this.photourl = photourl;
}
public int getTractorinfoId() {
	return tractorinfoId;
}
public void setTractorinfoId(int tractorinfoId) {
	this.tractorinfoId = tractorinfoId;
}

}
