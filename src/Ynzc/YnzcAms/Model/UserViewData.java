package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class UserViewData {
	
	private int id;
	private String username;
	private String realname;
	private String password;
	private String telephone;
	private String roleid;
	private String region;
	private String regionid;
	private String useunit;
	private String platecode;
	private int unitid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionid() {
		return regionid;
	}
	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}
	public String getUseunit() {
		return useunit;
	}
	public void setUseunit(String useunit) {
		this.useunit = useunit;
	}
	public String getPlatecode() {
		return platecode;
	}
	public void setPlatecode(String platecode) {
		this.platecode = platecode;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
}
