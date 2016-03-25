package Ynzc.YnzcAms.Model;

public class CompleteHarvesterSkillExamProveSource {
//联合收割机驾驶技能准考证明
	//ynzc_peopleInfo
	private String peopleName;//名字
	private String idCard;//身份证
	private String sex;//性别
	private String birthday;//出生日期
	//ynzc_driverStrInfo
	private String archivesNo;//档案号
	//ynzc_drivingLicenceType
	private String drivingLicenceName;//驾照类型
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public String getDrivingLicenceName() {
		return drivingLicenceName;
	}
	public void setDrivingLicenceName(String drivingLicenceName) {
		this.drivingLicenceName = drivingLicenceName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
