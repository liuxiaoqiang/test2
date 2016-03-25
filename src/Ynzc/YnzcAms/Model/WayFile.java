package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_wayfile")
public class WayFile {
	private int id;
	private String getWayFileType;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGetWayFileType() {
		return getWayFileType;
	}
	public void setGetWayFileType(String getWayFileType) {
		this.getWayFileType = getWayFileType;
	}
}
