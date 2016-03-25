package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_changeengine")
public class ChangeEngine {
	// Fields

	private int id;
	private int carchangeid;
	private String enginecode;
	private String fueltype;
	private String enginebrand;
	private String cylindernumber;
	private String power;
	private String newenginecode;
	private int newfueltype;
	private int newenginebrand;
	private String newcylindernumber;
	private String newpower;
	private String engineproof;
	private String engineproofnumber;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarchangeid() {
		return this.carchangeid;
	}

	public void setCarchangeid(int carchangeid) {
		this.carchangeid = carchangeid;
	}

	public String getEnginecode() {
		return this.enginecode;
	}

	public void setEnginecode(String enginecode) {
		this.enginecode = enginecode;
	}

	public String getFueltype() {
		return this.fueltype;
	}

	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}



	public String getCylindernumber() {
		return this.cylindernumber;
	}

	public void setCylindernumber(String cylindernumber) {
		this.cylindernumber = cylindernumber;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getNewenginecode() {
		return this.newenginecode;
	}

	public void setNewenginecode(String newenginecode) {
		this.newenginecode = newenginecode;
	}



	public int getNewenginebrand() {
		return this.newenginebrand;
	}

	public void setNewenginebrand(int newenginebrand) {
		this.newenginebrand = newenginebrand;
	}

	public String getNewcylindernumber() {
		return this.newcylindernumber;
	}

	public void setNewcylindernumber(String newcylindernumber) {
		this.newcylindernumber = newcylindernumber;
	}

	public String getNewpower() {
		return this.newpower;
	}

	public void setNewpower(String newpower) {
		this.newpower = newpower;
	}

	public String getEngineproof() {
		return this.engineproof;
	}

	public void setEngineproof(String engineproof) {
		this.engineproof = engineproof;
	}

	public String getEngineproofnumber() {
		return this.engineproofnumber;
	}

	public void setEngineproofnumber(String engineproofnumber) {
		this.engineproofnumber = engineproofnumber;
	}

	public String getEnginebrand() {
		return enginebrand;
	}

	public void setEnginebrand(String enginebrand) {
		this.enginebrand = enginebrand;
	}

	public int getNewfueltype() {
		return newfueltype;
	}

	public void setNewfueltype(int newfueltype) {
		this.newfueltype = newfueltype;
	}

}
