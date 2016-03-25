package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_unitmanage")
public class UnitManage {
	private int id;
	private String region;
	private String regionid;
	private String useunit;
	private String responsiblemen;
	private String linktel;
	private String address;
	private String zipcode;
	private String chaptercode;
	private String platecode;
	private String registman;
	private String 	paizhengman;
	private String leaderman;
	private int userid;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getResponsiblemen() {
		return responsiblemen;
	}

	public void setResponsiblemen(String responsiblemen) {
		this.responsiblemen = responsiblemen;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getChaptercode() {
		return chaptercode;
	}

	public void setChaptercode(String chaptercode) {
		this.chaptercode = chaptercode;
	}

	public String getPlatecode() {
		return platecode;
	}

	public void setPlatecode(String platecode) {
		this.platecode = platecode;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegistman() {
		return registman;
	}

	public void setRegistman(String registman) {
		this.registman = registman;
	}

	public String getPaizhengman() {
		return paizhengman;
	}

	public void setPaizhengman(String paizhengman) {
		this.paizhengman = paizhengman;
	}

	public String getLeaderman() {
		return leaderman;
	}

	public void setLeaderman(String leaderman) {
		this.leaderman = leaderman;
	}
	
}
