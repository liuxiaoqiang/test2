package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_uiteharvesterrepair")
public class UniteharvesterRepair {
	private int id;
	private int harvesterId;
	private int repairPapes;
	private String repairWhy;
	private String repairType;
	private int repairApplicationtype;
	private String repairRegisterman;
	private Date repairRegistdate;
	private String repairNote;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHarvesterId() {
		return harvesterId;
	}
	public void setHarvesterId(int harvesterId) {
		this.harvesterId = harvesterId;
	}
	public int getRepairPapes() {
		return repairPapes;
	}
	public void setRepairPapes(int repairPapes) {
		this.repairPapes = repairPapes;
	}
	public String getRepairWhy() {
		return repairWhy;
	}
	public void setRepairWhy(String repairWhy) {
		this.repairWhy = repairWhy;
	}
	public String getRepairType() {
		return repairType;
	}
	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}
	public int getRepairApplicationtype() {
		return repairApplicationtype;
	}
	public void setRepairApplicationtype(int repairApplicationtype) {
		this.repairApplicationtype = repairApplicationtype;
	}
	public String getRepairRegisterman() {
		return repairRegisterman;
	}
	public void setRepairRegisterman(String repairRegisterman) {
		this.repairRegisterman = repairRegisterman;
	}
	public Date getRepairRegistdate() {
		return repairRegistdate;
	}
	public void setRepairRegistdate(Date repairRegistdate) {
		this.repairRegistdate = repairRegistdate;
	}
	public String getRepairNote() {
		return repairNote;
	}
	public void setRepairNote(String repairNote) {
		this.repairNote = repairNote;
	}
}
