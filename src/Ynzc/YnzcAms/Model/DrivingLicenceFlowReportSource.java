package Ynzc.YnzcAms.Model;
/**
 * 人员视图
 * @author zy
 * @date 2011-05-05
 * class PeopleBodyView.java
 */

public class DrivingLicenceFlowReportSource {
	private String archivesNo;//档案号
	private String examinationCode;//报考号
	private String peopleName;//名字
	private String sex;//性别
	private String birthday;//出生日期
	private String fosterType;//培养类型
	private String linkTel;//联系电话
	private String idCard;//身份证
	private String drivingLicenceTypeId;
	public String getFosterType() {
		return fosterType;
	}
	public String getDrivingLicenceTypeId() {
		return drivingLicenceTypeId;
	}
	public void setDrivingLicenceTypeId(String drivingLicenceTypeId) {
		this.drivingLicenceTypeId = drivingLicenceTypeId;
	}
	public void setFosterType(String fosterType) {
		this.fosterType = fosterType;
	}
	public String getExaminationCode() {
		return examinationCode;
	}
	public void setExaminationCode(String examinationCode) {
		this.examinationCode = examinationCode;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
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
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
}
