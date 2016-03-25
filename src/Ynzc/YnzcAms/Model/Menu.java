package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_menu")
public class Menu {

	private int id;
	private String menu;
	private int fatherid;
	private String jsname;
	private String menucode;
	private int isleaf;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getFatherid() {
		return fatherid;
	}
	public void setFatherid(int fatherid) {
		this.fatherid = fatherid;
	}
	public String getJsname() {
		return jsname;
	}
	public void setJsname(String jsname) {
		this.jsname = jsname;
	}
	public String getMenucode() {
		return menucode;
	}
	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}
	public int getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
}
