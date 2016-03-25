package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ynzc_uiteharvestermove")
public class UniteharvesterMove {
	private int id;
	private int harvesterId;
	private int moveType;
	private String moveAcceptunitName;
	private int moveApplicationtype;
	private String moveRegisterman;
	private Date moveRegistdate;
	private String oldUnitname;
	private int moveMark;
	private String moveNote;
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
	public int getMoveType() {
		return moveType;
	}
	public void setMoveType(int moveType) {
		this.moveType = moveType;
	}
	public String getMoveAcceptunitName() {
		return moveAcceptunitName;
	}
	public void setMoveAcceptunitName(String moveAcceptunitName) {
		this.moveAcceptunitName = moveAcceptunitName;
	}
	public int getMoveApplicationtype() {
		return moveApplicationtype;
	}
	public void setMoveApplicationtype(int moveApplicationtype) {
		this.moveApplicationtype = moveApplicationtype;
	}
	public String getMoveRegisterman() {
		return moveRegisterman;
	}
	public void setMoveRegisterman(String moveRegisterman) {
		this.moveRegisterman = moveRegisterman;
	}
	public Date getMoveRegistdate() {
		return moveRegistdate;
	}
	public void setMoveRegistdate(Date moveRegistdate) {
		this.moveRegistdate = moveRegistdate;
	}
	public String getOldUnitname() {
		return oldUnitname;
	}
	public void setOldUnitname(String oldUnitname) {
		this.oldUnitname = oldUnitname;
	}
	public int getMoveMark() {
		return moveMark;
	}
	public void setMoveMark(int moveMark) {
		this.moveMark = moveMark;
	}
	public String getMoveNote() {
		return moveNote;
	}
	public void setMoveNote(String moveNote) {
		this.moveNote = moveNote;
	}
}
