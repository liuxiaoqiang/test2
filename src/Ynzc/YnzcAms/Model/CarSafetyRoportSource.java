package Ynzc.YnzcAms.Model;

import java.util.Date;

public class CarSafetyRoportSource {
	private String owner;//拖拉机所有人
	private String license;//号码号牌
	private String address;//住所地址
	private String telephone;//电话
	private String machineType;//拖拉机类型
	private String plantType;//厂牌型号
	private String machinebodycolor;//机身颜色
	private String engineno;//发动机号码
	private String machinebodyno;//机身（底盘）号码
	private String shelfno;//挂车架号码
	private String showinitialinspectionresult;//外观检验结果
	private String showdisqualification;//外观不合格原因
	private String showexaminationresult;//外观复检结果
	private String engineinitialinspectionresult;//发动机检验结果
	private String enginedisqualification;//发动机不合格原因
	private String engineexaminationresult;//发动机复检结果
	private String conveyorinitialinspectionresult;//传动系检验结果
	private String conveyordisqualification;//传动系不合格原因
	private String conveyorexaminationresult;//传动系复检结果
	private String steeringinitialinspectionresult;//转向系检验结果
	private String steeringdisqualification;//转向系不合格原因
	private String steeringexaminationresult;//转向系复检结果
	private String flyhostinitialinspectionresult;//机架及行走系主机 检验结果
	private String flyhostdisqualification;//机架及行走系主机不合格原因
	private String flyhostexaminationresult;//机架及行走系主机复检结果
	private String flytrailerinitialinspectionresult;//机架及行走系挂机 检验结果
	private String flytrailerdisqualification;//机架及行走系挂机不合格原因
	private String flytrailerexaminationresult;//机架及行走系挂机复检结果
	private String brakhostinitialinspectionresult;//制动系主机 检验结果
	private String brakhostdisqualification;//制动系主机不合格原因
	private String brakhostexaminationresult;//制动系主机复检结果
	private String braktrailerinitialinspectionresult;//制动系挂机 检验结果
	private String braktrailerdisqualification;//制动系挂机不合格原因
	private String braktrailerexaminationresult;//制动系挂机复检结果
	private String lighthostinitialinspectionresult;//灯光及信号装置主机检验结果
	private String lighthostdisqualification;//灯光及信号装置主机不合格原因
	private String lighthostexaminationresult;//灯光及信号装置主机复检结果
	private String lighttrailerinitialinspectionresult;//灯光及信号装置挂车检验结果
	private String lighttrailerdisqualification;//灯光及信号装置挂车不合格原因
	private String lighttrailerexaminationresult;//灯光及信号装置挂车复检结果
	private String tractioninitialinspectionresult;//液压悬挂及牵引装置检验结果
	private String tractiondisqualification;//液压悬挂及牵引装置不合格原因
	private String tractionexaminationresult;//液压悬挂及牵引装置复检结果
	private String outsize;//外廓尺寸
	private String containersize;//货箱内部尺寸
	private int  wheelno;//轴数
	private String wheelbase;//轴距
	private int vicecartiresno;//挂车轮胎数
	private String outcarwheeldis;//挂车轮距
	private int steelspring;//后轴单侧钢板弹簧片数
	private String outcartiressize;//挂车轮胎规格
	private String checkresult;//总检结果：结论
	private String inspector;//检验人员
	private Date checkdate;//日期
	private String disqualification;//不合格原因
	private String reviewPerson;//检验人员
	private String reviewDate;//日期
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}
	public String getMachinebodycolor() {
		return machinebodycolor;
	}
	public void setMachinebodycolor(String machinebodycolor) {
		this.machinebodycolor = machinebodycolor;
	}
	public String getEngineno() {
		return engineno;
	}
	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
	public String getMachinebodyno() {
		return machinebodyno;
	}
	public void setMachinebodyno(String machinebodyno) {
		this.machinebodyno = machinebodyno;
	}
	public String getShelfno() {
		return shelfno;
	}
	public void setShelfno(String shelfno) {
		this.shelfno = shelfno;
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
	public int getWheelno() {
		return wheelno;
	}
	public void setWheelno(int wheelno) {
		this.wheelno = wheelno;
	}
	public String getWheelbase() {
		return wheelbase;
	}
	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}
	public int getVicecartiresno() {
		return vicecartiresno;
	}
	public void setVicecartiresno(int vicecartiresno) {
		this.vicecartiresno = vicecartiresno;
	}
	public String getOutcarwheeldis() {
		return outcarwheeldis;
	}
	public void setOutcarwheeldis(String outcarwheeldis) {
		this.outcarwheeldis = outcarwheeldis;
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
	public String getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
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
	public String getDisqualification() {
		return disqualification;
	}
	public void setDisqualification(String disqualification) {
		this.disqualification = disqualification;
	}
	public String getReviewPerson() {
		return reviewPerson;
	}
	public void setReviewPerson(String reviewPerson) {
		this.reviewPerson = reviewPerson;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public void setEnginedisqualification(String enginedisqualification) {
		this.enginedisqualification = enginedisqualification;
	}
	public String getEnginedisqualification() {
		return enginedisqualification;
	}
	
	
}
