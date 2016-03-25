package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_changecolor")
public class ChangeColor {
	// Fields

	private int id;
	private int carchangeid;
	private String orgincolor;
	private String cuurentcolor;
	private String photourl;
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

	public String getOrgincolor() {
		return this.orgincolor;
	}

	public void setOrgincolor(String orgincolor) {
		this.orgincolor = orgincolor;
	}

	public String getCuurentcolor() {
		return this.cuurentcolor;
	}

	public void setCuurentcolor(String cuurentcolor) {
		this.cuurentcolor = cuurentcolor;
	}

	public String getPhotourl() {
		return this.photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
}
