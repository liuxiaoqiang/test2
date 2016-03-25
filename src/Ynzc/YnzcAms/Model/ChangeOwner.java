package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_changeowner")
public class ChangeOwner {
	// Fields

	private int id;
	private int carchangeid;
	private String orginusername;
	private String orginlintel;
	private String orgincertificateid;
	private String orgincertificatecode;
	private String orginunittype;
	private String orginaddress;
	private String orginzipcode;
	private String orginistemporary;
	private String orgintemporaycertificate;
	private String orgintemporaycertificatecode;
	private String username;
	private String lintel;
	private int certificateid;
	private String certificatecode;
	private int unittype;
	private String address;
	private String zipcode;
	private int istemporary;
	private int temporaycertificate;
	private String temporaycertificatecode;

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

	public String getOrginusername() {
		return this.orginusername;
	}

	public void setOrginusername(String orginusername) {
		this.orginusername = orginusername;
	}

	public String getOrginlintel() {
		return this.orginlintel;
	}

	public void setOrginlintel(String orginlintel) {
		this.orginlintel = orginlintel;
	}
	public String getOrgincertificatecode() {
		return this.orgincertificatecode;
	}

	public void setOrgincertificatecode(String orgincertificatecode) {
		this.orgincertificatecode = orgincertificatecode;
	}

	public String getOrginunittype() {
		return this.orginunittype;
	}

	public void setOrginunittype(String orginunittype) {
		this.orginunittype = orginunittype;
	}

	public String getOrginaddress() {
		return this.orginaddress;
	}

	public void setOrginaddress(String orginaddress) {
		this.orginaddress = orginaddress;
	}

	public String getOrginzipcode() {
		return this.orginzipcode;
	}

	public void setOrginzipcode(String orginzipcode) {
		this.orginzipcode = orginzipcode;
	}

	public String getOrginistemporary() {
		return this.orginistemporary;
	}

	public void setOrginistemporary(String orginistemporary) {
		this.orginistemporary = orginistemporary;
	}

	public String getOrgintemporaycertificate() {
		return this.orgintemporaycertificate;
	}

	public void setOrgintemporaycertificate(String orgintemporaycertificate) {
		this.orgintemporaycertificate = orgintemporaycertificate;
	}

	public String getOrgintemporaycertificatecode() {
		return this.orgintemporaycertificatecode;
	}

	public void setOrgintemporaycertificatecode(
			String orgintemporaycertificatecode) {
		this.orgintemporaycertificatecode = orgintemporaycertificatecode;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLintel() {
		return this.lintel;
	}

	public void setLintel(String lintel) {
		this.lintel = lintel;
	}

	public int getCertificateid() {
		return this.certificateid;
	}

	public void setCertificateid(int certificateid) {
		this.certificateid = certificateid;
	}

	public String getCertificatecode() {
		return this.certificatecode;
	}

	public void setCertificatecode(String certificatecode) {
		this.certificatecode = certificatecode;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getTemporaycertificatecode() {
		return this.temporaycertificatecode;
	}

	public void setTemporaycertificatecode(String temporaycertificatecode) {
		this.temporaycertificatecode = temporaycertificatecode;
	}

	public String getOrgincertificateid() {
		return orgincertificateid;
	}

	public void setOrgincertificateid(String orgincertificateid) {
		this.orgincertificateid = orgincertificateid;
	}

	public int getUnittype() {
		return unittype;
	}

	public void setUnittype(int unittype) {
		this.unittype = unittype;
	}

	public int getIstemporary() {
		return istemporary;
	}

	public void setIstemporary(int istemporary) {
		this.istemporary = istemporary;
	}

	public int getTemporaycertificate() {
		return temporaycertificate;
	}

	public void setTemporaycertificate(int temporaycertificate) {
		this.temporaycertificate = temporaycertificate;
	}
}
