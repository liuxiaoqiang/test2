package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_uiteharvestercancle")
public class UniteharvesterCancle {
	private int id;
	private int harvesterId;
	private String cancledateContent;
	private int cancleWhytype;
	private int cancleApplicationtype;
	private String cancleRegisterman;
	private Date cancleRegistdate;
	private String cancleNote;
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
	public String getCancledateContent() {
		return cancledateContent;
	}
	public void setCancledateContent(String cancledateContent) {
		this.cancledateContent = cancledateContent;
	}
	public int getCancleWhytype() {
		return cancleWhytype;
	}
	public void setCancleWhytype(int cancleWhytype) {
		this.cancleWhytype = cancleWhytype;
	}
	public int getCancleApplicationtype() {
		return cancleApplicationtype;
	}
	public void setCancleApplicationtype(int cancleApplicationtype) {
		this.cancleApplicationtype = cancleApplicationtype;
	}
	public String getCancleRegisterman() {
		return cancleRegisterman;
	}
	public void setCancleRegisterman(String cancleRegisterman) {
		this.cancleRegisterman = cancleRegisterman;
	}
	public Date getCancleRegistdate() {
		return cancleRegistdate;
	}
	public void setCancleRegistdate(Date cancleRegistdate) {
		this.cancleRegistdate = cancleRegistdate;
	}
	public String getCancleNote() {
		return cancleNote;
	}
	public void setCancleNote(String cancleNote) {
		this.cancleNote = cancleNote;
	}
	
}
