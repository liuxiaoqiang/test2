package Ynzc.YnzcAms.Model;
/**
 * 发动机品牌
 * @author zy
 * @date 2011-04-18
 * class EngineBrand.java
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_enginebrand")
public class EngineBrand {
	private int id;//Id
	private String engineBrand;//发动机品牌

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEngineBrand() {
		return engineBrand;
	}

	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}
}
