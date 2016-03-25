package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_reaperplate")
public class ReaperPlate {

	private int id;
	private String platenum;
	private String platehead;
	private int status;
	private int unitid;
	
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
	public String getPlatehead() {
		return platehead;
	}
	public void setPlatehead(String platehead) {
		this.platehead = platehead;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	
}
