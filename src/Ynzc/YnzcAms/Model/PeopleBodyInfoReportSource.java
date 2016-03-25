package Ynzc.YnzcAms.Model;
/**
 * 人员视图
 * @author zy
 * @date 2011-05-05
 * class PeopleBodyView.java
 */

public class PeopleBodyInfoReportSource {
	private String peopleName;//名字
	private String sex;//性别
	private String birthday;//出生日期
	private String idCard;//身份证
	private String archivesNo;//暂住证
	private String drivingLicenceName;
	private String realcertificatetype;
	private String picture;//照片
	public String getDrivingLicenceName() {
		return drivingLicenceName;
	}
	public void setDrivingLicenceName(String drivingLicenceName) {
		this.drivingLicenceName = drivingLicenceName;
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
	public String getRealcertificatetype() {
		return realcertificatetype;
	}
	public void setRealcertificatetype(String realcertificatetype) {
		this.realcertificatetype = realcertificatetype;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
