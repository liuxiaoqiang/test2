package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_templivefile")
public class TempliveFile {
	private int id;
	private String templivefileType;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTemplivefileType() {
		return templivefileType;
	}
	public void setTemplivefileType(String templivefileType) {
		this.templivefileType = templivefileType;
	}
}
