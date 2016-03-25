package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_region")
public class Region {

	private int id;
	private String citycode;
	private String cityname;
	private int fatherid;
	private String cityno;
	private String citypost;
	private int treelevel;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getFatherid() {
		return fatherid;
	}
	public void setFatherid(int fatherid) {
		this.fatherid = fatherid;
	}
	public String getCityno() {
		return cityno;
	}
	public void setCityno(String cityno) {
		this.cityno = cityno;
	}
	public String getCitypost() {
		return citypost;
	}
	public void setCitypost(String citypost) {
		this.citypost = citypost;
	}
	public int getTreelevel() {
		return treelevel;
	}
	public void setTreelevel(int treelevel) {
		this.treelevel = treelevel;
	}
	
}
