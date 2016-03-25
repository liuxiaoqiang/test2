package Ynzc.YnzcAms.Model;

import java.util.Date;

public class TrainingRecordSource {
//拖拉机驾驶培训记录
	//ynzc_peopleInfo
	private Date writeDate ;//录入时间
	private String peopleName;//名字
	private String sex;//性别
	private String idCard;//身份证
	private String address;//家庭地址
	private String linkTel;//联系电话
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
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
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	
	
}
