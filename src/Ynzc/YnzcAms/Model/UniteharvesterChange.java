package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ynzc_uniteharvesterchange")
public class UniteharvesterChange {
	private int id;
	private int harvesterId;
	private String changeType;
	private String changeUnit;
	private int changeApplicationtype;
	private String changeRegisterman;
	private Date changeRegistdate;
	private String changeNote;
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
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getChangeUnit() {
		return changeUnit;
	}
	public void setChangeUnit(String changeUnit) {
		this.changeUnit = changeUnit;
	}
	public int getChangeApplicationtype() {
		return changeApplicationtype;
	}
	public void setChangeApplicationtype(int changeApplicationtype) {
		this.changeApplicationtype = changeApplicationtype;
	}
	public String getChangeRegisterman() {
		return changeRegisterman;
	}
	public void setChangeRegisterman(String changeRegisterman) {
		this.changeRegisterman = changeRegisterman;
	}
	public Date getChangeRegistdate() {
		return changeRegistdate;
	}
	public void setChangeRegistdate(Date changeRegistdate) {
		this.changeRegistdate = changeRegistdate;
	}
	public String getChangeNote() {
		return changeNote;
	}
	public void setChangeNote(String changeNote) {
		this.changeNote = changeNote;
	}
}
