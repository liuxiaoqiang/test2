package Ynzc.YnzcAms.Model;
/**
 * 驾照类型
 * @author zy
 * @date 2011-04-25
 * class DrivingLicenceType.java
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_drivinglicencetype")
public class DrivingLicenceType {
	private int id;//编号
	private int unitId;//单位Id
	private String drivingLicenceName;//驾照类型
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public String getDrivingLicenceName() {
		return drivingLicenceName;
	}
	public void setDrivingLicenceName(String drivingLicenceName) {
		this.drivingLicenceName = drivingLicenceName;
	}
}
