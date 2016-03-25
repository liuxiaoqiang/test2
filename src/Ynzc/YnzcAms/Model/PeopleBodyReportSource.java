package Ynzc.YnzcAms.Model;
/**
 * 人员视图
 * @author zy
 * @date 2011-05-05
 * class PeopleBodyView.java
 */

public class PeopleBodyReportSource {
	private String peopleName;//名字
	private String sex;//性别
	private String birthday;//出生日期
	private String idCard;//身份证
	private String archivesNo;//暂住证
	private String drivingLicenceName;
	private String realcertificatetype;
	private String picture;//照片
	private String hight;//身高
	private String resolvingPowerFlag;//辨色力
	private String rightEyePwoer;//右眼视力
	private String rightEyeRectificationFlag;//右眼矫正
	private String leftEyePwoer;//左眼视力
	private String leftEyeRectificationFlag;//左眼矫正
	private String rightEarPwoer;//右耳听力
	private String leftEarPwoer;//左耳听力
	private String rightHandFlag;//右手
	private String leftHandFlag;//左手
	private String rightLagFlag;//右脚
	private String leftLagFlag;//左脚
	private String bodyNeck;//身体和颈椎
	private String bodyCheckDate;//身体检查时间
	public String getBodyCheckDate() {
		return bodyCheckDate;
	}
	public void setBodyCheckDate(String bodyCheckDate) {
		this.bodyCheckDate = bodyCheckDate;
	}
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
	public String getHight() {
		return hight;
	}
	public void setHight(String hight) {
		this.hight = hight;
	}
	public String getResolvingPowerFlag() {
		if("1".equals(resolvingPowerFlag)){
			return "合格";
		}else{
			return "不合格";
		}
	}
	public void setResolvingPowerFlag(String resolvingPowerFlag) {
		this.resolvingPowerFlag = resolvingPowerFlag;
	}
	public String getRightEyePwoer() {
		return rightEyePwoer;
	}
	public void setRightEyePwoer(String rightEyePwoer) {
		this.rightEyePwoer = rightEyePwoer;
	}
	public String getRightEyeRectificationFlag() {
		return rightEyeRectificationFlag;
	}
	public void setRightEyeRectificationFlag(String rightEyeRectificationFlag) {
		this.rightEyeRectificationFlag = rightEyeRectificationFlag;
	}
	public String getLeftEyePwoer() {
		return leftEyePwoer;
	}
	public void setLeftEyePwoer(String leftEyePwoer) {
		this.leftEyePwoer = leftEyePwoer;
	}
	public String getLeftEyeRectificationFlag() {
		return leftEyeRectificationFlag;
	}
	public void setLeftEyeRectificationFlag(String leftEyeRectificationFlag) {
		this.leftEyeRectificationFlag = leftEyeRectificationFlag;
	}
	public String getRightEarPwoer() {
		return rightEarPwoer;
	}
	public void setRightEarPwoer(String rightEarPwoer) {
		this.rightEarPwoer = rightEarPwoer;
	}
	public String getLeftEarPwoer() {
		return leftEarPwoer;
	}
	public void setLeftEarPwoer(String leftEarPwoer) {
		this.leftEarPwoer = leftEarPwoer;
	}
	public String getRightHandFlag() {
		if("1".equals(rightHandFlag)){
			return "合格";
		}else{
			return "不合格";
		}
	}
	public void setRightHandFlag(String rightHandFlag) {
		this.rightHandFlag = rightHandFlag;
	}
	public String getLeftHandFlag() {
		if("1".equals(leftHandFlag)){
			return "合格";
		}else{
			return "不合格";
		}
	}
	public void setLeftHandFlag(String leftHandFlag) {
		this.leftHandFlag = leftHandFlag;
	}
	public String getRightLagFlag() {
		if("1".equals(rightLagFlag)){
			return "合格";
		}else{
			return "不合格";
		}
	}
	public void setRightLagFlag(String rightLagFlag) {
		this.rightLagFlag = rightLagFlag;
	}
	public String getLeftLagFlag() {
		if("1".equals(leftLagFlag)){
			return "合格";
		}else{
			return "不合格";
		}
	}
	public void setLeftLagFlag(String leftLagFlag) {
		this.leftLagFlag = leftLagFlag;
	}
	public String getBodyNeck() {
		if("1".equals(bodyNeck)){
			return "合格";
		}else{
			return "不合格";
		}
	}
	public void setBodyNeck(String bodyNeck) {
		this.bodyNeck = bodyNeck;
	}
}
