package Ynzc.YnzcAms.Model;
/**
 * 学员信息
 * @author zy
 * @date 2011-04-25
 * class DriverStrInfo.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_driverstrinfo")
public class DriverStrInfo {
	private int id;//编号
	private String archivesNo;//档案号
	private int fosterType;//培养类型
	private int peopleInfoId;//人员信息Id
	private int applicationFlag;//审查
	private int applicationUserId;
	private Date applicationDate;
	private Date drivingLicenceFirst;//初领驾证
	private String drivingLicenceTypeId;//申请型号
	private String applicationAddress;//申请地址
	private String examinationCode;//报考号
	private String strState;//学员状态
	private int pigeonholeFlag;//是否归档
	private int pigeonholeUserId;
	private Date pigeonholeDate;//归档时间
	private int theoryId;//理论考试Id
	private int theoryFlag;//理论通过
	private int theoryMakeUpNum;//理论补考次数
	private int practiceId;//技术考试Id
	private int practiceFlag;//技术通过
	private int practiceMakeUpNum;//技术补考次数
	private int unitId;//单位Id
	private String regionId;//行政区划Id
	private String year;//年度
	private int writeUserId;//录入人
	private Date writeDate;//录入时间
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApplicationUserId() {
		return applicationUserId;
	}
	public void setApplicationUserId(int applicationUserId) {
		this.applicationUserId = applicationUserId;
	}
	public int getPigeonholeUserId() {
		return pigeonholeUserId;
	}
	public void setPigeonholeUserId(int pigeonholeUserId) {
		this.pigeonholeUserId = pigeonholeUserId;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public int getFosterType() {
		return fosterType;
	}
	public void setFosterType(int fosterType) {
		this.fosterType = fosterType;
	}
	public int getPeopleInfoId() {
		return peopleInfoId;
	}
	public void setPeopleInfoId(int peopleInfoId) {
		this.peopleInfoId = peopleInfoId;
	}
	public int getApplicationFlag() {
		return applicationFlag;
	}
	public void setApplicationFlag(int applicationFlag) {
		this.applicationFlag = applicationFlag;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getDrivingLicenceTypeId() {
		return drivingLicenceTypeId;
	}
	public void setDrivingLicenceTypeId(String drivingLicenceTypeId) {
		this.drivingLicenceTypeId = drivingLicenceTypeId;
	}
	public String getApplicationAddress() {
		return applicationAddress;
	}
	public void setApplicationAddress(String applicationAddress) {
		this.applicationAddress = applicationAddress;
	}
	public String getExaminationCode() {
		return examinationCode;
	}
	public void setExaminationCode(String examinationCode) {
		this.examinationCode = examinationCode;
	}
	public String getStrState() {
		return strState;
	}
	public void setStrState(String strState) {
		this.strState = strState;
	}
	public int getPigeonholeFlag() {
		return pigeonholeFlag;
	}
	public void setPigeonholeFlag(int pigeonholeFlag) {
		this.pigeonholeFlag = pigeonholeFlag;
	}
	public Date getPigeonholeDate() {
		return pigeonholeDate;
	}
	public void setPigeonholeDate(Date pigeonholeDate) {
		this.pigeonholeDate = pigeonholeDate;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getWriteUserId() {
		return writeUserId;
	}
	public void setWriteUserId(int writeUserId) {
		this.writeUserId = writeUserId;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getTheoryId() {
		return theoryId;
	}
	public void setTheoryId(int theoryId) {
		this.theoryId = theoryId;
	}
	public int getTheoryFlag() {
		return theoryFlag;
	}
	public void setTheoryFlag(int theoryFlag) {
		this.theoryFlag = theoryFlag;
	}
	public int getPracticeId() {
		return practiceId;
	}
	public void setPracticeId(int practiceId) {
		this.practiceId = practiceId;
	}
	public int getPracticeFlag() {
		return practiceFlag;
	}
	public void setPracticeFlag(int practiceFlag) {
		this.practiceFlag = practiceFlag;
	}
	public int getTheoryMakeUpNum() {
		return theoryMakeUpNum;
	}
	public void setTheoryMakeUpNum(int theoryMakeUpNum) {
		this.theoryMakeUpNum = theoryMakeUpNum;
	}
	public int getPracticeMakeUpNum() {
		return practiceMakeUpNum;
	}
	public void setPracticeMakeUpNum(int practiceMakeUpNum) {
		this.practiceMakeUpNum = practiceMakeUpNum;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public Date getDrivingLicenceFirst() {
		return drivingLicenceFirst;
	}
	public void setDrivingLicenceFirst(Date drivingLicenceFirst) {
		this.drivingLicenceFirst = drivingLicenceFirst;
	}
}
