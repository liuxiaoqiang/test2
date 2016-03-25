package Ynzc.YnzcAms.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
@Entity
@Table(name = "ynzc_plateoperaterecord")
public class PlateOperateRecord {
	private int id;//主键
	private int plateId;//号牌ID
	private String plateCode;//号牌号码
	private Date operateDate;//号牌操作日期
	private String operateContent;//号牌操作说明
	private String operateUserName;//操作人
	private int replaceRequestId;//号牌操作对应的补领补换申请ID
	private int flag;//操作信息状态 0、不可用 1、可用
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlateId() {
		return plateId;
	}
	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	public String getPlateCode() {
		return plateCode;
	}
	public void setPlateCode(String plateCode) {
		this.plateCode = plateCode;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateContent() {
		return operateContent;
	}
	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
	}
	public String getOperateUserName() {
		return operateUserName;
	}
	public void setOperateUserName(String operateUserName) {
		this.operateUserName = operateUserName;
	}
	public int getReplaceRequestId() {
		return replaceRequestId;
	}
	public void setReplaceRequestId(int replaceRequestId) {
		this.replaceRequestId = replaceRequestId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
