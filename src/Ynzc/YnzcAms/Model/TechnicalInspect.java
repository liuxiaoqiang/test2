package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
//技术检验
@Entity
@Table(name = "ynzc_technicalinspect")
public class TechnicalInspect {
public int id;
public String checkresult;
private String disqualification;
public Date checkexpirydate;
public String inspector;
public Date checkdate;
private String showinitialinspectionresult;
private String showdisqualification;
private String showexaminationresult;
private String engineinitialinspectionresult;
private String enginedisqualification;
private String engineexaminationresult;
private String conveyorinitialinspectionresult;
private String conveyordisqualification;
private String conveyorexaminationresult;
private String steeringinitialinspectionresult;
private String steeringdisqualification;
private String steeringexaminationresult;
private String flyhostinitialinspectionresult;
private String flyhostdisqualification;
private String flyhostexaminationresult;
private String flytrailerinitialinspectionresult;
private String flytrailerdisqualification;
private String flytrailerexaminationresult;
private String brakhostinitialinspectionresult;
private String brakhostdisqualification;
private String brakhostexaminationresult;
private String braktrailerinitialinspectionresult;
private String braktrailerdisqualification;
private String braktrailerexaminationresult;
private String lighthostinitialinspectionresult;
private String lighthostdisqualification;
private String lighthostexaminationresult;
private String lighttrailerinitialinspectionresult;
private String lighttrailerdisqualification;
private String lighttrailerexaminationresult;
private String tractioninitialinspectionresult;
private String tractiondisqualification;
private String tractionexaminationresult;
public int tractorinfoId;
 
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCheckresult() {
	return checkresult;
}
public void setCheckresult(String checkresult) {
	this.checkresult = checkresult;
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
public Date getCheckdate() {
	return checkdate;
}
public void setCheckdate(Date checkdate) {
	this.checkdate = checkdate;
}
public int getTractorinfoId() {
	return tractorinfoId;
}
public void setTractorinfoId(int tractorinfoId) {
	this.tractorinfoId = tractorinfoId;
}
public String getDisqualification() {
	return disqualification;
}
public void setDisqualification(String disqualification) {
	this.disqualification = disqualification;
}
public String getShowinitialinspectionresult() {
	return showinitialinspectionresult;
}
public void setShowinitialinspectionresult(String showinitialinspectionresult) {
	this.showinitialinspectionresult = showinitialinspectionresult;
}
public String getShowdisqualification() {
	return showdisqualification;
}
public void setShowdisqualification(String showdisqualification) {
	this.showdisqualification = showdisqualification;
}
public String getShowexaminationresult() {
	return showexaminationresult;
}
public void setShowexaminationresult(String showexaminationresult) {
	this.showexaminationresult = showexaminationresult;
}
public String getEngineinitialinspectionresult() {
	return engineinitialinspectionresult;
}
public void setEngineinitialinspectionresult(
		String engineinitialinspectionresult) {
	this.engineinitialinspectionresult = engineinitialinspectionresult;
}
public String getEnginedisqualification() {
	return enginedisqualification;
}
public void setEnginedisqualification(String enginedisqualification) {
	this.enginedisqualification = enginedisqualification;
}
public String getEngineexaminationresult() {
	return engineexaminationresult;
}
public void setEngineexaminationresult(String engineexaminationresult) {
	this.engineexaminationresult = engineexaminationresult;
}
public String getConveyorinitialinspectionresult() {
	return conveyorinitialinspectionresult;
}
public void setConveyorinitialinspectionresult(
		String conveyorinitialinspectionresult) {
	this.conveyorinitialinspectionresult = conveyorinitialinspectionresult;
}
public String getConveyordisqualification() {
	return conveyordisqualification;
}
public void setConveyordisqualification(String conveyordisqualification) {
	this.conveyordisqualification = conveyordisqualification;
}
public String getConveyorexaminationresult() {
	return conveyorexaminationresult;
}
public void setConveyorexaminationresult(String conveyorexaminationresult) {
	this.conveyorexaminationresult = conveyorexaminationresult;
}
public String getSteeringinitialinspectionresult() {
	return steeringinitialinspectionresult;
}
public void setSteeringinitialinspectionresult(
		String steeringinitialinspectionresult) {
	this.steeringinitialinspectionresult = steeringinitialinspectionresult;
}
public String getSteeringdisqualification() {
	return steeringdisqualification;
}
public void setSteeringdisqualification(String steeringdisqualification) {
	this.steeringdisqualification = steeringdisqualification;
}
public String getSteeringexaminationresult() {
	return steeringexaminationresult;
}
public void setSteeringexaminationresult(String steeringexaminationresult) {
	this.steeringexaminationresult = steeringexaminationresult;
}
public String getFlyhostinitialinspectionresult() {
	return flyhostinitialinspectionresult;
}
public void setFlyhostinitialinspectionresult(
		String flyhostinitialinspectionresult) {
	this.flyhostinitialinspectionresult = flyhostinitialinspectionresult;
}
public String getFlyhostdisqualification() {
	return flyhostdisqualification;
}
public void setFlyhostdisqualification(String flyhostdisqualification) {
	this.flyhostdisqualification = flyhostdisqualification;
}
public String getFlyhostexaminationresult() {
	return flyhostexaminationresult;
}
public void setFlyhostexaminationresult(String flyhostexaminationresult) {
	this.flyhostexaminationresult = flyhostexaminationresult;
}
public String getFlytrailerinitialinspectionresult() {
	return flytrailerinitialinspectionresult;
}
public void setFlytrailerinitialinspectionresult(
		String flytrailerinitialinspectionresult) {
	this.flytrailerinitialinspectionresult = flytrailerinitialinspectionresult;
}
public String getFlytrailerdisqualification() {
	return flytrailerdisqualification;
}
public void setFlytrailerdisqualification(String flytrailerdisqualification) {
	this.flytrailerdisqualification = flytrailerdisqualification;
}
public String getFlytrailerexaminationresult() {
	return flytrailerexaminationresult;
}
public void setFlytrailerexaminationresult(String flytrailerexaminationresult) {
	this.flytrailerexaminationresult = flytrailerexaminationresult;
}
public String getBrakhostinitialinspectionresult() {
	return brakhostinitialinspectionresult;
}
public void setBrakhostinitialinspectionresult(
		String brakhostinitialinspectionresult) {
	this.brakhostinitialinspectionresult = brakhostinitialinspectionresult;
}
public String getBrakhostdisqualification() {
	return brakhostdisqualification;
}
public void setBrakhostdisqualification(String brakhostdisqualification) {
	this.brakhostdisqualification = brakhostdisqualification;
}
public String getBrakhostexaminationresult() {
	return brakhostexaminationresult;
}
public void setBrakhostexaminationresult(String brakhostexaminationresult) {
	this.brakhostexaminationresult = brakhostexaminationresult;
}
public String getBraktrailerinitialinspectionresult() {
	return braktrailerinitialinspectionresult;
}
public void setBraktrailerinitialinspectionresult(
		String braktrailerinitialinspectionresult) {
	this.braktrailerinitialinspectionresult = braktrailerinitialinspectionresult;
}
public String getBraktrailerdisqualification() {
	return braktrailerdisqualification;
}
public void setBraktrailerdisqualification(String braktrailerdisqualification) {
	this.braktrailerdisqualification = braktrailerdisqualification;
}
public String getBraktrailerexaminationresult() {
	return braktrailerexaminationresult;
}
public void setBraktrailerexaminationresult(String braktrailerexaminationresult) {
	this.braktrailerexaminationresult = braktrailerexaminationresult;
}
public String getLighthostinitialinspectionresult() {
	return lighthostinitialinspectionresult;
}
public void setLighthostinitialinspectionresult(
		String lighthostinitialinspectionresult) {
	this.lighthostinitialinspectionresult = lighthostinitialinspectionresult;
}
public String getLighthostdisqualification() {
	return lighthostdisqualification;
}
public void setLighthostdisqualification(String lighthostdisqualification) {
	this.lighthostdisqualification = lighthostdisqualification;
}
public String getLighthostexaminationresult() {
	return lighthostexaminationresult;
}
public void setLighthostexaminationresult(String lighthostexaminationresult) {
	this.lighthostexaminationresult = lighthostexaminationresult;
}
public String getLighttrailerinitialinspectionresult() {
	return lighttrailerinitialinspectionresult;
}
public void setLighttrailerinitialinspectionresult(
		String lighttrailerinitialinspectionresult) {
	this.lighttrailerinitialinspectionresult = lighttrailerinitialinspectionresult;
}
public String getLighttrailerdisqualification() {
	return lighttrailerdisqualification;
}
public void setLighttrailerdisqualification(String lighttrailerdisqualification) {
	this.lighttrailerdisqualification = lighttrailerdisqualification;
}
public String getLighttrailerexaminationresult() {
	return lighttrailerexaminationresult;
}
public void setLighttrailerexaminationresult(
		String lighttrailerexaminationresult) {
	this.lighttrailerexaminationresult = lighttrailerexaminationresult;
}
public String getTractioninitialinspectionresult() {
	return tractioninitialinspectionresult;
}
public void setTractioninitialinspectionresult(
		String tractioninitialinspectionresult) {
	this.tractioninitialinspectionresult = tractioninitialinspectionresult;
}
public String getTractiondisqualification() {
	return tractiondisqualification;
}
public void setTractiondisqualification(String tractiondisqualification) {
	this.tractiondisqualification = tractiondisqualification;
}
public String getTractionexaminationresult() {
	return tractionexaminationresult;
}
public void setTractionexaminationresult(String tractionexaminationresult) {
	this.tractionexaminationresult = tractionexaminationresult;
}

}
