package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_changetrailer")
public class ChangeTrailer {
	// Fields

	private int id;
	private int carchangeid;
	private int orgintires;
	private String orgintrack;
	private String orginnorm;
	private int currenttires;
	private String currenttrack;
	private String currentnorm;
	
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



	public String getOrgintrack() {
		return this.orgintrack;
	}

	public void setOrgintrack(String orgintrack) {
		this.orgintrack = orgintrack;
	}

	public String getOrginnorm() {
		return this.orginnorm;
	}

	public void setOrginnorm(String orginnorm) {
		this.orginnorm = orginnorm;
	}



	public String getCurrenttrack() {
		return this.currenttrack;
	}

	public void setCurrenttrack(String currenttrack) {
		this.currenttrack = currenttrack;
	}

	public String getCurrentnorm() {
		return this.currentnorm;
	}

	public void setCurrentnorm(String currentnorm) {
		this.currentnorm = currentnorm;
	}

	public int getOrgintires() {
		return orgintires;
	}

	public void setOrgintires(int orgintires) {
		this.orgintires = orgintires;
	}

	public int getCurrenttires() {
		return currenttires;
	}

	public void setCurrenttires(int currenttires) {
		this.currenttires = currenttires;
	}



}
