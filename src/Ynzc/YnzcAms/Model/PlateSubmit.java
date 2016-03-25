package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_platesubmit")
public class PlateSubmit {

	private int id;
	private String submitman;
	private String trueman;
	private Date truetime;
	private Date submitdate;
	private int status;
	private int unitid;
	private int istrue;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubmitman() {
		return submitman;
	}

	public void setSubmitman(String submitman) {
		this.submitman = submitman;
	}

	public Date getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(Date submitdate) {
		this.submitdate = submitdate;
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

	public String getTrueman() {
		return trueman;
	}

	public void setTrueman(String trueman) {
		this.trueman = trueman;
	}

	public Date getTruetime() {
		return truetime;
	}

	public void setTruetime(Date truetime) {
		this.truetime = truetime;
	}

	public int getIstrue() {
		return istrue;
	}

	public void setIstrue(int istrue) {
		this.istrue = istrue;
	}

}
