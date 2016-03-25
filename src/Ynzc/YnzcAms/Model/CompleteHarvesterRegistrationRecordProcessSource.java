package Ynzc.YnzcAms.Model;

public class CompleteHarvesterRegistrationRecordProcessSource {
//联合收割机登记业务流程记录单
	//ynzc_uniteHarvester
	private String harvesterOwner;//所有人姓名
	private String harvesterChangPaiType;//厂牌型号
	private String serialNumber;//流水号
	private String harvesterType;//收割机类型
	private String harvesterCode;//收割机号牌号码
	//ynzc_drivingLicenceRepair
	private String name;//业务名称

	public String getHarvesterOwner() {
		return harvesterOwner;
	}
	public void setHarvesterOwner(String harvesterOwner) {
		this.harvesterOwner = harvesterOwner;
	}
	public String getHarvesterChangPaiType() {
		return harvesterChangPaiType;
	}
	public void setHarvesterChangPaiType(String harvesterChangPaiType) {
		this.harvesterChangPaiType = harvesterChangPaiType;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHarvesterType() {
		return harvesterType;
	}
	public void setHarvesterType(String harvesterType) {
		this.harvesterType = harvesterType;
	}
	public String getHarvesterCode() {
		return harvesterCode;
	}
	public void setHarvesterCode(String harvesterCode) {
		this.harvesterCode = harvesterCode;
	}
	
	
}
