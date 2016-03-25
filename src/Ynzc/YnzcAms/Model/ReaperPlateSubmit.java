package Ynzc.YnzcAms.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ynzc_reaperplatesubmit")
public class ReaperPlateSubmit {

	private int id;
	private String submitman;
	private String cityinputman;
	private Date cityinputtime;
	private String provinceinputman;
	private Date provinputtime;
	private Date submitdate;
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
	public String getCityinputman() {
		return cityinputman;
	}
	public void setCityinputman(String cityinputman) {
		this.cityinputman = cityinputman;
	}
	public Date getCityinputtime() {
		return cityinputtime;
	}
	public void setCityinputtime(Date cityinputtime) {
		this.cityinputtime = cityinputtime;
	}
	public String getProvinceinputman() {
		return provinceinputman;
	}
	public void setProvinceinputman(String provinceinputman) {
		this.provinceinputman = provinceinputman;
	}
	public Date getProvinputtime() {
		return provinputtime;
	}
	public void setProvinputtime(Date provinputtime) {
		this.provinputtime = provinputtime;
	}
	
}
