package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_platehandle")
public class PlateHandle {
	private int id;
	private String platenum;
	private int unitid;
	private int platehandle;
	private Date handledate;
	private int userid;
	private int types;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlatenum() {
		return platenum;
	}
	public void setPlatenum(String platenum) {
		this.platenum = platenum;
	}
	
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public int getPlatehandle() {
		return platehandle;
	}
	public void setPlatehandle(int platehandle) {
		this.platehandle = platehandle;
	}
	public Date getHandledate() {
		return handledate;
	}
	public void setHandledate(Date handledate) {
		this.handledate = handledate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTypes() {
		return types;
	}
	public void setTypes(int types) {
		this.types = types;
	}	
}
