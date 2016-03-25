package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//技术参数
@Entity
@Table(name = "ynzc_technicalparameters")
public class TechnicalParameters {
public int id;
public String machinebodycolor;
public String directcontrol;
public int enginebrandid;
public int fueltypeid;
public int tiresno;
public int totalquality;
public int allowdragtotalquality;
public int vicecartiresno;
public String outsize;
public String containersize;
public String power;
public int cylinderno;
public int wheelno;
public String tiressize;
public int allquality;
public int driverinno;
public String outcarwheeldis;
public String wheelbase;
public String wheeldis;
public int ratifiedload;
public int steelspring;
public String outcartiressize;
public int tractorinfoId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMachinebodycolor() {
	return machinebodycolor;
}
public void setMachinebodycolor(String machinebodycolor) {
	this.machinebodycolor = machinebodycolor;
}
public String getDirectcontrol() {
	return directcontrol;
}
public void setDirectcontrol(String directcontrol) {
	this.directcontrol = directcontrol;
}
public int getEnginebrandid() {
	return enginebrandid;
}
public void setEnginebrandid(int enginebrandid) {
	this.enginebrandid = enginebrandid;
}
public int getFueltypeid() {
	return fueltypeid;
}
public void setFueltypeid(int fueltypeid) {
	this.fueltypeid = fueltypeid;
}
public int getTiresno() {
	return tiresno;
}
public void setTiresno(int tiresno) {
	this.tiresno = tiresno;
}
public int getTotalquality() {
	return totalquality;
}
public void setTotalquality(int totalquality) {
	this.totalquality = totalquality;
}
public int getAllowdragtotalquality() {
	return allowdragtotalquality;
}
public void setAllowdragtotalquality(int allowdragtotalquality) {
	this.allowdragtotalquality = allowdragtotalquality;
}
public int getVicecartiresno() {
	return vicecartiresno;
}
public void setVicecartiresno(int vicecartiresno) {
	this.vicecartiresno = vicecartiresno;
}
public String getOutsize() {
	return outsize;
}
public void setOutsize(String outsize) {
	this.outsize = outsize;
}
public String getContainersize() {
	return containersize;
}
public void setContainersize(String containersize) {
	this.containersize = containersize;
}

public int getCylinderno() {
	return cylinderno;
}
public void setCylinderno(int cylinderno) {
	this.cylinderno = cylinderno;
}
public int getWheelno() {
	return wheelno;
}
public void setWheelno(int wheelno) {
	this.wheelno = wheelno;
}
public String getTiressize() {
	return tiressize;
}
public void setTiressize(String tiressize) {
	this.tiressize = tiressize;
}
public int getAllquality() {
	return allquality;
}
public void setAllquality(int allquality) {
	this.allquality = allquality;
}
public int getDriverinno() {
	return driverinno;
}
public void setDriverinno(int driverinno) {
	this.driverinno = driverinno;
}
public String getOutcarwheeldis() {
	return outcarwheeldis;
}
public void setOutcarwheeldis(String outcarwheeldis) {
	this.outcarwheeldis = outcarwheeldis;
}
public String getWheelbase() {
	return wheelbase;
}
public void setWheelbase(String wheelbase) {
	this.wheelbase = wheelbase;
}
public String getWheeldis() {
	return wheeldis;
}
public void setWheeldis(String wheeldis) {
	this.wheeldis = wheeldis;
}
public int getRatifiedload() {
	return ratifiedload;
}
public void setRatifiedload(int ratifiedload) {
	this.ratifiedload = ratifiedload;
}
public int getSteelspring() {
	return steelspring;
}
public void setSteelspring(int steelspring) {
	this.steelspring = steelspring;
}
public String getOutcartiressize() {
	return outcartiressize;
}
public void setOutcartiressize(String outcartiressize) {
	this.outcartiressize = outcartiressize;
}
public int getTractorinfoId() {
	return tractorinfoId;
}
public void setTractorinfoId(int tractorinfoId) {
	this.tractorinfoId = tractorinfoId;
}
public String getPower() {
	return power;
}
public void setPower(String power) {
	this.power = power;
}
}
