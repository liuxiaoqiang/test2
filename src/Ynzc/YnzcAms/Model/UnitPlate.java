package Ynzc.YnzcAms.Model;

public class UnitPlate {
	private int id;
	private String region;
	private String regionid;
	private String platecode;
	private int notuseplate;
	private int usedplate;
	private int bfplate;
	private int bpplate;
	private int zjplate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPlatecode() {
		return platecode;
	}
	public void setPlatecode(String platecode) {
		this.platecode = platecode;
	}
	public int getNotuseplate() {
		return notuseplate;
	}
	public void setNotuseplate(int notuseplate) {
		this.notuseplate = notuseplate;
	}
	public int getUsedplate() {
		return usedplate;
	}
	public void setUsedplate(int usedplate) {
		this.usedplate = usedplate;
	}
	public int getBfplate() {
		return bfplate;
	}
	public void setBfplate(int bfplate) {
		this.bfplate = bfplate;
	}
	public int getBpplate() {
		return bpplate;
	}
	public void setBpplate(int bpplate) {
		this.bpplate = bpplate;
	}
	public int getZjplate() {
		return zjplate;
	}
	public void setZjplate(int zjplate) {
		this.zjplate = zjplate;
	}
}
