package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
@Entity
@Table(name = "ynzc_changebody")
public class ChangeBody {
	// Fields

	private int id;
	private int carchangeid;
	private String orgingettypeid;
	private String orginmachinetypeid;
	private String orginengineid;
	private String orginbodycode;
	private String orginenginecode;
	private String orginrackcode;
	private String orginusernature;
	private String orginfactoryname;
	private String orginsaleunit;
	private Date orginreleasedate;
	private String orginprice;
	private String orginphotourl;
	private String orgingetwayfiletypeid;
	private String orgingetwayfiletypecode;
	private String orginimportsfiletypeid;
	private String orginimportsfiletypecode;
	private String orginother;
	private String orgininsurancelistno;
	private String orgininsurancecompany;
	private Date orgininsurancedate;
	private Date orgininsurancevalidate;
	private String orginbodycolor;
	private String orginsize;
	private String orgindirectcontrol;
	private String orgincontainersize;
	private String orginenginebrandid;
	private String orginpower;
	private String orgincylinderno;
	private String orginfueltype;
	private String orginwheelno;
	private String orginwheelbase;
	private int orgintiresno;
	private String orgintiressize;
	private String orginwheeldis;
	private String orgintotalquality;
	private String orginallquality;
	private String orginratifiedload;
	private String orginallowdragtotalquality;
	private int orgindriverinno;
	private String orginsteelspring;
	private int orginvicecartiresno;
	private String orginoutcarwheeldis;
	private String orginoutcartiressize;
	private int gettypeid;
	private int machinetypeid;
	private int engineid;
	private String bodycode;
	private String enginecode;
	private String rackcode;
	private String usernature;
	private String factoryname;
	private String saleunit;
	private Date releasedate;
	private String price;
	private String photourl;
	private int getwayfiletypeid;
	private String getwayfiletypecode;
	private int importsfiletypeid;
	private String importsfiletypecode;
	private String other;
	private String insurancelistno;
	private String insurancecompany;
	private Date insurancedate;
	private Date insurancevalidate;
	private String bodycolor;
	private String size;
	private String directcontrol;
	private String containersize;
	private int enginebrandid;
	private String power;
	private String cylinderno;
	private int fueltypeid;
	private String wheelno;
	private String wheelbase;
	private int tiresno;
	private String tiressize;
	private String wheeldis;
	private String totalquality;
	private String allquality;
	private String ratifiedload;
	private String allowdragtotalquality;
	private int driverinno;
	private String steelspring;
	private int vicecartiresno;
	private String outcarwheeldis;
	private String outcartiressize;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarchangeid() {
		return this.carchangeid;
	}

	public void setCarchangeid(int carchangeid) {
		this.carchangeid = carchangeid;
	}

	public String getOrginbodycode() {
		return this.orginbodycode;
	}

	public void setOrginbodycode(String orginbodycode) {
		this.orginbodycode = orginbodycode;
	}

	public String getOrginenginecode() {
		return this.orginenginecode;
	}

	public void setOrginenginecode(String orginenginecode) {
		this.orginenginecode = orginenginecode;
	}

	public String getOrginrackcode() {
		return this.orginrackcode;
	}

	public void setOrginrackcode(String orginrackcode) {
		this.orginrackcode = orginrackcode;
	}

	public String getOrginusernature() {
		return this.orginusernature;
	}

	public void setOrginusernature(String orginusernature) {
		this.orginusernature = orginusernature;
	}

	public String getOrginfactoryname() {
		return this.orginfactoryname;
	}

	public void setOrginfactoryname(String orginfactoryname) {
		this.orginfactoryname = orginfactoryname;
	}

	public String getOrginsaleunit() {
		return this.orginsaleunit;
	}

	public void setOrginsaleunit(String orginsaleunit) {
		this.orginsaleunit = orginsaleunit;
	}

	public Date getOrginreleasedate() {
		return this.orginreleasedate;
	}

	public void setOrginreleasedate(Date orginreleasedate) {
		this.orginreleasedate = orginreleasedate;
	}

	public String getOrginprice() {
		return this.orginprice;
	}

	public void setOrginprice(String orginprice) {
		this.orginprice = orginprice;
	}

	public String getOrginphotourl() {
		return this.orginphotourl;
	}

	public void setOrginphotourl(String orginphotourl) {
		this.orginphotourl = orginphotourl;
	}

	public String getOrgingetwayfiletypecode() {
		return this.orgingetwayfiletypecode;
	}

	public void setOrgingetwayfiletypecode(String orgingetwayfiletypecode) {
		this.orgingetwayfiletypecode = orgingetwayfiletypecode;
	}



	public String getOrginimportsfiletypecode() {
		return this.orginimportsfiletypecode;
	}

	public void setOrginimportsfiletypecode(String orginimportsfiletypecode) {
		this.orginimportsfiletypecode = orginimportsfiletypecode;
	}

	public String getOrginother() {
		return this.orginother;
	}

	public void setOrginother(String orginother) {
		this.orginother = orginother;
	}

	public String getOrgininsurancelistno() {
		return this.orgininsurancelistno;
	}

	public void setOrgininsurancelistno(String orgininsurancelistno) {
		this.orgininsurancelistno = orgininsurancelistno;
	}



	public Date getOrgininsurancedate() {
		return this.orgininsurancedate;
	}

	public void setOrgininsurancedate(Date orgininsurancedate) {
		this.orgininsurancedate = orgininsurancedate;
	}

	public Date getOrgininsurancevalidate() {
		return this.orgininsurancevalidate;
	}

	public void setOrgininsurancevalidate(Date orgininsurancevalidate) {
		this.orgininsurancevalidate = orgininsurancevalidate;
	}

	public String getOrginbodycolor() {
		return this.orginbodycolor;
	}

	public void setOrginbodycolor(String orginbodycolor) {
		this.orginbodycolor = orginbodycolor;
	}

	public String getOrginsize() {
		return this.orginsize;
	}

	public void setOrginsize(String orginsize) {
		this.orginsize = orginsize;
	}

	public String getOrgindirectcontrol() {
		return this.orgindirectcontrol;
	}

	public void setOrgindirectcontrol(String orgindirectcontrol) {
		this.orgindirectcontrol = orgindirectcontrol;
	}

	public String getOrgincontainersize() {
		return this.orgincontainersize;
	}

	public void setOrgincontainersize(String orgincontainersize) {
		this.orgincontainersize = orgincontainersize;
	}



	public String getOrginpower() {
		return this.orginpower;
	}

	public void setOrginpower(String orginpower) {
		this.orginpower = orginpower;
	}

	public String getOrgincylinderno() {
		return this.orgincylinderno;
	}

	public void setOrgincylinderno(String orgincylinderno) {
		this.orgincylinderno = orgincylinderno;
	}

	public String getOrginfueltype() {
		return this.orginfueltype;
	}

	public void setOrginfueltype(String orginfueltype) {
		this.orginfueltype = orginfueltype;
	}

	public String getOrginwheelno() {
		return this.orginwheelno;
	}

	public void setOrginwheelno(String orginwheelno) {
		this.orginwheelno = orginwheelno;
	}

	public String getOrginwheelbase() {
		return this.orginwheelbase;
	}

	public void setOrginwheelbase(String orginwheelbase) {
		this.orginwheelbase = orginwheelbase;
	}

	public int getOrgintiresno() {
		return this.orgintiresno;
	}

	public void setOrgintiresno(int orgintiresno) {
		this.orgintiresno = orgintiresno;
	}

	public String getOrgintiressize() {
		return this.orgintiressize;
	}

	public void setOrgintiressize(String orgintiressize) {
		this.orgintiressize = orgintiressize;
	}

	public String getOrginwheeldis() {
		return this.orginwheeldis;
	}

	public void setOrginwheeldis(String orginwheeldis) {
		this.orginwheeldis = orginwheeldis;
	}

	public String getOrgintotalquality() {
		return this.orgintotalquality;
	}

	public void setOrgintotalquality(String orgintotalquality) {
		this.orgintotalquality = orgintotalquality;
	}

	public String getOrginallquality() {
		return this.orginallquality;
	}

	public void setOrginallquality(String orginallquality) {
		this.orginallquality = orginallquality;
	}

	public String getOrginratifiedload() {
		return this.orginratifiedload;
	}

	public void setOrginratifiedload(String orginratifiedload) {
		this.orginratifiedload = orginratifiedload;
	}

	public String getOrginallowdragtotalquality() {
		return this.orginallowdragtotalquality;
	}

	public void setOrginallowdragtotalquality(String orginallowdragtotalquality) {
		this.orginallowdragtotalquality = orginallowdragtotalquality;
	}

	public int getOrgindriverinno() {
		return this.orgindriverinno;
	}

	public void setOrgindriverinno(int orgindriverinno) {
		this.orgindriverinno = orgindriverinno;
	}

	public String getOrginsteelspring() {
		return this.orginsteelspring;
	}

	public void setOrginsteelspring(String orginsteelspring) {
		this.orginsteelspring = orginsteelspring;
	}

	public int getOrginvicecartiresno() {
		return this.orginvicecartiresno;
	}

	public void setOrginvicecartiresno(int orginvicecartiresno) {
		this.orginvicecartiresno = orginvicecartiresno;
	}

	public String getOrginoutcarwheeldis() {
		return this.orginoutcarwheeldis;
	}

	public void setOrginoutcarwheeldis(String orginoutcarwheeldis) {
		this.orginoutcarwheeldis = orginoutcarwheeldis;
	}

	public String getOrginoutcartiressize() {
		return this.orginoutcartiressize;
	}

	public void setOrginoutcartiressize(String orginoutcartiressize) {
		this.orginoutcartiressize = orginoutcartiressize;
	}

	public int getGettypeid() {
		return this.gettypeid;
	}

	public void setGettypeid(int gettypeid) {
		this.gettypeid = gettypeid;
	}

	public int getMachinetypeid() {
		return this.machinetypeid;
	}

	public void setMachinetypeid(int machinetypeid) {
		this.machinetypeid = machinetypeid;
	}

	public int getEngineid() {
		return this.engineid;
	}

	public void setEngineid(int engineid) {
		this.engineid = engineid;
	}

	public String getBodycode() {
		return this.bodycode;
	}

	public void setBodycode(String bodycode) {
		this.bodycode = bodycode;
	}

	public String getEnginecode() {
		return this.enginecode;
	}

	public void setEnginecode(String enginecode) {
		this.enginecode = enginecode;
	}

	public String getRackcode() {
		return this.rackcode;
	}

	public void setRackcode(String rackcode) {
		this.rackcode = rackcode;
	}

	public String getUsernature() {
		return this.usernature;
	}

	public void setUsernature(String usernature) {
		this.usernature = usernature;
	}

	public String getFactoryname() {
		return this.factoryname;
	}

	public void setFactoryname(String factoryname) {
		this.factoryname = factoryname;
	}

	public String getSaleunit() {
		return this.saleunit;
	}

	public void setSaleunit(String saleunit) {
		this.saleunit = saleunit;
	}

	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPhotourl() {
		return this.photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	public int getGetwayfiletypeid() {
		return this.getwayfiletypeid;
	}

	public void setGetwayfiletypeid(int getwayfiletypeid) {
		this.getwayfiletypeid = getwayfiletypeid;
	}

	public String getGetwayfiletypecode() {
		return this.getwayfiletypecode;
	}

	public void setGetwayfiletypecode(String getwayfiletypecode) {
		this.getwayfiletypecode = getwayfiletypecode;
	}

	public int getImportsfiletypeid() {
		return this.importsfiletypeid;
	}

	public void setImportsfiletypeid(int importsfiletypeid) {
		this.importsfiletypeid = importsfiletypeid;
	}

	public String getImportsfiletypecode() {
		return this.importsfiletypecode;
	}

	public void setImportsfiletypecode(String importsfiletypecode) {
		this.importsfiletypecode = importsfiletypecode;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getInsurancelistno() {
		return this.insurancelistno;
	}

	public void setInsurancelistno(String insurancelistno) {
		this.insurancelistno = insurancelistno;
	}



	public Date getInsurancedate() {
		return this.insurancedate;
	}

	public void setInsurancedate(Date insurancedate) {
		this.insurancedate = insurancedate;
	}

	public Date getInsurancevalidate() {
		return this.insurancevalidate;
	}

	public void setInsurancevalidate(Date insurancevalidate) {
		this.insurancevalidate = insurancevalidate;
	}

	public String getBodycolor() {
		return this.bodycolor;
	}

	public void setBodycolor(String bodycolor) {
		this.bodycolor = bodycolor;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDirectcontrol() {
		return this.directcontrol;
	}

	public void setDirectcontrol(String directcontrol) {
		this.directcontrol = directcontrol;
	}

	public String getContainersize() {
		return this.containersize;
	}

	public void setContainersize(String containersize) {
		this.containersize = containersize;
	}

	public int getEnginebrandid() {
		return this.enginebrandid;
	}

	public void setEnginebrandid(int enginebrandid) {
		this.enginebrandid = enginebrandid;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getCylinderno() {
		return this.cylinderno;
	}

	public void setCylinderno(String cylinderno) {
		this.cylinderno = cylinderno;
	}


	public String getWheelno() {
		return this.wheelno;
	}

	public void setWheelno(String wheelno) {
		this.wheelno = wheelno;
	}

	public String getWheelbase() {
		return this.wheelbase;
	}

	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}

	public int getTiresno() {
		return this.tiresno;
	}

	public void setTiresno(int tiresno) {
		this.tiresno = tiresno;
	}

	public String getTiressize() {
		return this.tiressize;
	}

	public void setTiressize(String tiressize) {
		this.tiressize = tiressize;
	}

	public String getWheeldis() {
		return this.wheeldis;
	}

	public void setWheeldis(String wheeldis) {
		this.wheeldis = wheeldis;
	}

	public String getTotalquality() {
		return this.totalquality;
	}

	public void setTotalquality(String totalquality) {
		this.totalquality = totalquality;
	}

	public String getAllquality() {
		return this.allquality;
	}

	public void setAllquality(String allquality) {
		this.allquality = allquality;
	}

	public String getRatifiedload() {
		return this.ratifiedload;
	}

	public void setRatifiedload(String ratifiedload) {
		this.ratifiedload = ratifiedload;
	}

	public String getAllowdragtotalquality() {
		return this.allowdragtotalquality;
	}

	public void setAllowdragtotalquality(String allowdragtotalquality) {
		this.allowdragtotalquality = allowdragtotalquality;
	}

	public int getDriverinno() {
		return this.driverinno;
	}

	public void setDriverinno(int driverinno) {
		this.driverinno = driverinno;
	}

	public String getSteelspring() {
		return this.steelspring;
	}

	public void setSteelspring(String steelspring) {
		this.steelspring = steelspring;
	}

	public int getVicecartiresno() {
		return this.vicecartiresno;
	}

	public void setVicecartiresno(int vicecartiresno) {
		this.vicecartiresno = vicecartiresno;
	}

	public String getOutcarwheeldis() {
		return this.outcarwheeldis;
	}

	public void setOutcarwheeldis(String outcarwheeldis) {
		this.outcarwheeldis = outcarwheeldis;
	}

	public String getOutcartiressize() {
		return this.outcartiressize;
	}

	public void setOutcartiressize(String outcartiressize) {
		this.outcartiressize = outcartiressize;
	}

	public String getOrgingettypeid() {
		return orgingettypeid;
	}

	public void setOrgingettypeid(String orgingettypeid) {
		this.orgingettypeid = orgingettypeid;
	}

	public String getOrginmachinetypeid() {
		return orginmachinetypeid;
	}

	public void setOrginmachinetypeid(String orginmachinetypeid) {
		this.orginmachinetypeid = orginmachinetypeid;
	}

	public String getOrginengineid() {
		return orginengineid;
	}

	public void setOrginengineid(String orginengineid) {
		this.orginengineid = orginengineid;
	}

	public String getOrgingetwayfiletypeid() {
		return orgingetwayfiletypeid;
	}

	public void setOrgingetwayfiletypeid(String orgingetwayfiletypeid) {
		this.orgingetwayfiletypeid = orgingetwayfiletypeid;
	}

	public String getOrginimportsfiletypeid() {
		return orginimportsfiletypeid;
	}

	public void setOrginimportsfiletypeid(String orginimportsfiletypeid) {
		this.orginimportsfiletypeid = orginimportsfiletypeid;
	}

	public String getOrgininsurancecompany() {
		return orgininsurancecompany;
	}

	public void setOrgininsurancecompany(String orgininsurancecompany) {
		this.orgininsurancecompany = orgininsurancecompany;
	}

	public String getOrginenginebrandid() {
		return orginenginebrandid;
	}

	public void setOrginenginebrandid(String orginenginebrandid) {
		this.orginenginebrandid = orginenginebrandid;
	}

	public String getInsurancecompany() {
		return insurancecompany;
	}

	public void setInsurancecompany(String insurancecompany) {
		this.insurancecompany = insurancecompany;
	}

	public int getFueltypeid() {
		return fueltypeid;
	}

	public void setFueltypeid(int fueltypeid) {
		this.fueltypeid = fueltypeid;
	}

}
