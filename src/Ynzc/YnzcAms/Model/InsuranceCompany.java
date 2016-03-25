package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_insurancecompany")
public class InsuranceCompany {
	private int id;
	private String insurancecompanyName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsurancecompanyName() {
		return insurancecompanyName;
	}

	public void setInsurancecompanyName(String insurancecompanyName) {
		this.insurancecompanyName = insurancecompanyName;
	}
}
