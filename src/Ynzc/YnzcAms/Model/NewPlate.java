package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ynzc_newplate")
public class NewPlate {

	private int id;
	private String platenum;
	private String platenumhead;
	private int psid;
	private int madestatus;
	private int isaddnew;
	
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
	public String getPlatenumhead() {
		return platenumhead;
	}
	public void setPlatenumhead(String platenumhead) {
		this.platenumhead = platenumhead;
	}
	public int getPsid() {
		return psid;
	}
	public void setPsid(int psid) {
		this.psid = psid;
	}
	public int getMadestatus() {
		return madestatus;
	}
	public void setMadestatus(int madestatus) {
		this.madestatus = madestatus;
	}
	public int getIsaddnew() {
		return isaddnew;
	}
	public void setIsaddnew(int isaddnew) {
		this.isaddnew = isaddnew;
	}
}
