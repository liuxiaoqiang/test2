package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "ynzc_mortgage")
public class Mortgage {
	private int id;
	private int tractorinfoid;
	private String tractorcode;
	private String tractorno;
	private String tractoraddress;
	private String mortgagetype;
	private String mortgagementype;
	private String mortgageownermentype;
	private String mortgageusername;
	private String mortgageaddress;
	private String mortgageistemplive;
	private int mortgagecaridtype;
	private String mortgagecarid;
	private String mortgagelinktel;
	private String mortgagezipcode;
	private Date mortgagehandledate;
	private String mortgageownerusername;
	private String mortgageowneraddress;
	private String mortgageisownertemplive;
	private int mortgageownercaridtype;
	private String mortgageownercarid;
	private String mortgageownerlinktel;
	private String mortgageownerzipcode;
	private Date mortgageownerhandledate;
	private String mortgageinformation;

	private String mortgageproxyusername;
	private String mortgageproxylinktel;
	private String mortgageproxyaddress;
	private int mortgageproxyidtype;
	private String mortgageproxyid;
	private String mortgageproxyhandlename;
	private int mortgageproxyhandleidtype;
	private String mortgageproxyhandleid;
	private String mortgageproxyhandleaddress;
	private Date mortgageproxyhandledate;

	private String mortgageownerproxyusername;
	private String mortgageownerproxylinktel;
	private String mortgageownerproxyaddress;
	private int mortgageownerproxyidtype;
	private String mortgageownerproxyid;
	private String mortgageownerproxyhandlename;
	private int mortgageownerproxyhandleidtype;
	private String mortgageownerproxyhandleid;
	private String mortgageownerproxyhandleaddress;
	private Date mortgageownerproxyhandledate;

	private String checkmen;
	private int checkstate;
	private String checkcontent;
	private Date checkdate;
	private String checkip;
	private String opertator;
	private Date operatedate;
//	private int filing;
//	private Date filingDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTractorinfoid() {
		return tractorinfoid;
	}

	public void setTractorinfoid(int tractorinfoid) {
		this.tractorinfoid = tractorinfoid;
	}

	public String getMortgagetype() {
		return mortgagetype;
	}

	public void setMortgagetype(String mortgagetype) {
		this.mortgagetype = mortgagetype;
	}

	public String getMortgagementype() {
		return mortgagementype;
	}

	public void setMortgagementype(String mortgagementype) {
		this.mortgagementype = mortgagementype;
	}

	public String getMortgageusername() {
		return mortgageusername;
	}

	public void setMortgageusername(String mortgageusername) {
		this.mortgageusername = mortgageusername;
	}

	public String getMortgageaddress() {
		return mortgageaddress;
	}

	public void setMortgageaddress(String mortgageaddress) {
		this.mortgageaddress = mortgageaddress;
	}

	public String getMortgageistemplive() {
		return mortgageistemplive;
	}

	public void setMortgageistemplive(String mortgageistemplive) {
		this.mortgageistemplive = mortgageistemplive;
	}

	public int getMortgagecaridtype() {
		return mortgagecaridtype;
	}

	public void setMortgagecaridtype(int mortgagecaridtype) {
		this.mortgagecaridtype = mortgagecaridtype;
	}

	public String getMortgagecarid() {
		return mortgagecarid;
	}

	public void setMortgagecarid(String mortgagecarid) {
		this.mortgagecarid = mortgagecarid;
	}

	public String getMortgagelinktel() {
		return mortgagelinktel;
	}

	public void setMortgagelinktel(String mortgagelinktel) {
		this.mortgagelinktel = mortgagelinktel;
	}

	public String getMortgagezipcode() {
		return mortgagezipcode;
	}

	public void setMortgagezipcode(String mortgagezipcode) {
		this.mortgagezipcode = mortgagezipcode;
	}

	public Date getMortgagehandledate() {
		return mortgagehandledate;
	}

	public void setMortgagehandledate(Date mortgagehandledate) {
		this.mortgagehandledate = mortgagehandledate;
	}

	public String getMortgageinformation() {
		return mortgageinformation;
	}

	public void setMortgageinformation(String mortgageinformation) {
		this.mortgageinformation = mortgageinformation;
	}

	public String getMortgageproxyusername() {
		return mortgageproxyusername;
	}

	public void setMortgageproxyusername(String mortgageproxyusername) {
		this.mortgageproxyusername = mortgageproxyusername;
	}

	public String getMortgageproxylinktel() {
		return mortgageproxylinktel;
	}

	public void setMortgageproxylinktel(String mortgageproxylinktel) {
		this.mortgageproxylinktel = mortgageproxylinktel;
	}

	public String getMortgageproxyaddress() {
		return mortgageproxyaddress;
	}

	public void setMortgageproxyaddress(String mortgageproxyaddress) {
		this.mortgageproxyaddress = mortgageproxyaddress;
	}

	public int getMortgageproxyidtype() {
		return mortgageproxyidtype;
	}

	public void setMortgageproxyidtype(int mortgageproxyidtype) {
		this.mortgageproxyidtype = mortgageproxyidtype;
	}

	public String getMortgageproxyid() {
		return mortgageproxyid;
	}

	public void setMortgageproxyid(String mortgageproxyid) {
		this.mortgageproxyid = mortgageproxyid;
	}

	public String getMortgageproxyhandlename() {
		return mortgageproxyhandlename;
	}

	public void setMortgageproxyhandlename(String mortgageproxyhandlename) {
		this.mortgageproxyhandlename = mortgageproxyhandlename;
	}

	public int getMortgageproxyhandleidtype() {
		return mortgageproxyhandleidtype;
	}

	public void setMortgageproxyhandleidtype(int mortgageproxyhandleidtype) {
		this.mortgageproxyhandleidtype = mortgageproxyhandleidtype;
	}

	public String getMortgageproxyhandleid() {
		return mortgageproxyhandleid;
	}

	public void setMortgageproxyhandleid(String mortgageproxyhandleid) {
		this.mortgageproxyhandleid = mortgageproxyhandleid;
	}

	public String getMortgageproxyhandleaddress() {
		return mortgageproxyhandleaddress;
	}

	public void setMortgageproxyhandleaddress(String mortgageproxyhandleaddress) {
		this.mortgageproxyhandleaddress = mortgageproxyhandleaddress;
	}

	public Date getMortgageproxyhandledate() {
		return mortgageproxyhandledate;
	}

	public void setMortgageproxyhandledate(Date mortgageproxyhandledate) {
		this.mortgageproxyhandledate = mortgageproxyhandledate;
	}

	public String getCheckmen() {
		return checkmen;
	}

	public void setCheckmen(String checkmen) {
		this.checkmen = checkmen;
	}

	public String getCheckcontent() {
		return checkcontent;
	}

	public void setCheckcontent(String checkcontent) {
		this.checkcontent = checkcontent;
	}

	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	public String getCheckip() {
		return checkip;
	}

	public void setCheckip(String checkip) {
		this.checkip = checkip;
	}

	public String getOpertator() {
		return opertator;
	}

	public void setOpertator(String opertator) {
		this.opertator = opertator;
	}

	public Date getOperatedate() {
		return operatedate;
	}

	public void setOperatedate(Date operatedate) {
		this.operatedate = operatedate;
	}

	public String getTractorcode() {
		return tractorcode;
	}

	public void setTractorcode(String tractorcode) {
		this.tractorcode = tractorcode;
	}

	public String getTractorno() {
		return tractorno;
	}

	public void setTractorno(String tractorno) {
		this.tractorno = tractorno;
	}

	public String getTractoraddress() {
		return tractoraddress;
	}

	public void setTractoraddress(String tractoraddress) {
		this.tractoraddress = tractoraddress;
	}

	public String getMortgageownermentype() {
		return mortgageownermentype;
	}

	public void setMortgageownermentype(String mortgageownermentype) {
		this.mortgageownermentype = mortgageownermentype;
	}

	public String getMortgageownerusername() {
		return mortgageownerusername;
	}

	public void setMortgageownerusername(String mortgageownerusername) {
		this.mortgageownerusername = mortgageownerusername;
	}

	public String getMortgageowneraddress() {
		return mortgageowneraddress;
	}

	public void setMortgageowneraddress(String mortgageowneraddress) {
		this.mortgageowneraddress = mortgageowneraddress;
	}

	public String getMortgageisownertemplive() {
		return mortgageisownertemplive;
	}

	public void setMortgageisownertemplive(String mortgageisownertemplive) {
		this.mortgageisownertemplive = mortgageisownertemplive;
	}

	public int getMortgageownercaridtype() {
		return mortgageownercaridtype;
	}

	public void setMortgageownercaridtype(int mortgageownercaridtype) {
		this.mortgageownercaridtype = mortgageownercaridtype;
	}

	public String getMortgageownercarid() {
		return mortgageownercarid;
	}

	public void setMortgageownercarid(String mortgageownercarid) {
		this.mortgageownercarid = mortgageownercarid;
	}

	public String getMortgageownerlinktel() {
		return mortgageownerlinktel;
	}

	public void setMortgageownerlinktel(String mortgageownerlinktel) {
		this.mortgageownerlinktel = mortgageownerlinktel;
	}

	public String getMortgageownerzipcode() {
		return mortgageownerzipcode;
	}

	public void setMortgageownerzipcode(String mortgageownerzipcode) {
		this.mortgageownerzipcode = mortgageownerzipcode;
	}

	public Date getMortgageownerhandledate() {
		return mortgageownerhandledate;
	}

	public void setMortgageownerhandledate(Date mortgageownerhandledate) {
		this.mortgageownerhandledate = mortgageownerhandledate;
	}

	public String getMortgageownerproxyusername() {
		return mortgageownerproxyusername;
	}

	public void setMortgageownerproxyusername(String mortgageownerproxyusername) {
		this.mortgageownerproxyusername = mortgageownerproxyusername;
	}

	public String getMortgageownerproxylinktel() {
		return mortgageownerproxylinktel;
	}

	public void setMortgageownerproxylinktel(String mortgageownerproxylinktel) {
		this.mortgageownerproxylinktel = mortgageownerproxylinktel;
	}

	public String getMortgageownerproxyaddress() {
		return mortgageownerproxyaddress;
	}

	public void setMortgageownerproxyaddress(String mortgageownerproxyaddress) {
		this.mortgageownerproxyaddress = mortgageownerproxyaddress;
	}

	public int getMortgageownerproxyidtype() {
		return mortgageownerproxyidtype;
	}

	public void setMortgageownerproxyidtype(int mortgageownerproxyidtype) {
		this.mortgageownerproxyidtype = mortgageownerproxyidtype;
	}

	public String getMortgageownerproxyid() {
		return mortgageownerproxyid;
	}

	public void setMortgageownerproxyid(String mortgageownerproxyid) {
		this.mortgageownerproxyid = mortgageownerproxyid;
	}

	public String getMortgageownerproxyhandlename() {
		return mortgageownerproxyhandlename;
	}

	public void setMortgageownerproxyhandlename(
			String mortgageownerproxyhandlename) {
		this.mortgageownerproxyhandlename = mortgageownerproxyhandlename;
	}

	public int getMortgageownerproxyhandleidtype() {
		return mortgageownerproxyhandleidtype;
	}

	public void setMortgageownerproxyhandleidtype(
			int mortgageownerproxyhandleidtype) {
		this.mortgageownerproxyhandleidtype = mortgageownerproxyhandleidtype;
	}

	public String getMortgageownerproxyhandleid() {
		return mortgageownerproxyhandleid;
	}

	public void setMortgageownerproxyhandleid(String mortgageownerproxyhandleid) {
		this.mortgageownerproxyhandleid = mortgageownerproxyhandleid;
	}

	public String getMortgageownerproxyhandleaddress() {
		return mortgageownerproxyhandleaddress;
	}

	public void setMortgageownerproxyhandleaddress(
			String mortgageownerproxyhandleaddress) {
		this.mortgageownerproxyhandleaddress = mortgageownerproxyhandleaddress;
	}

	public Date getMortgageownerproxyhandledate() {
		return mortgageownerproxyhandledate;
	}

	public void setMortgageownerproxyhandledate(
			Date mortgageownerproxyhandledate) {
		this.mortgageownerproxyhandledate = mortgageownerproxyhandledate;
	}

	public int getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(int checkstate) {
		this.checkstate = checkstate;
	}

//	public int getFiling() {
//		return filing;
//	}
//
//	public void setFiling(int filing) {
//		this.filing = filing;
//	}
//
//	public Date getFilingDate() {
//		return filingDate;
//	}
//
//	public void setFilingDate(Date filingDate) {
//		this.filingDate = filingDate;
//	}
	
}
