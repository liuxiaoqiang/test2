package Ynzc.YnzcAms.Model;
/**
 * 班级组
 * @author zy
 * @date 2011-04-25
 * class DriverClassTeam.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_driverclassteam")
public class DriverClassTeam {
	private int id;//编号
	private int driverClassId;//班级Id
	private int driverStrInfoId;//学员Id
	private int theoryPermitFlag;//理论准考证
	private int practicePermitFlag;//实践准考证
	private int unitId;//单位Id
	private String regionId;//行政区划Id
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
	public int getDriverClassId() {
		return driverClassId;
	}
	public void setDriverClassId(int driverClassId) {
		this.driverClassId = driverClassId;
	}
	public int getDriverStrInfoId() {
		return driverStrInfoId;
	}
	public void setDriverStrInfoId(int driverStrInfoId) {
		this.driverStrInfoId = driverStrInfoId;
	}
	public int getTheoryPermitFlag() {
		return theoryPermitFlag;
	}
	public void setTheoryPermitFlag(int theoryPermitFlag) {
		this.theoryPermitFlag = theoryPermitFlag;
	}
	public int getPracticePermitFlag() {
		return practicePermitFlag;
	}
	public void setPracticePermitFlag(int practicePermitFlag) {
		this.practicePermitFlag = practicePermitFlag;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
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
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
}
