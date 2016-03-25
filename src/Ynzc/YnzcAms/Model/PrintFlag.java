package Ynzc.YnzcAms.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
@Entity
@Table(name = "ynzc_printflag")
public class PrintFlag {
	private int id;//主键
	private int tractroinfoId;//打印的拖拉机ID
	private Date printBegianDate;//打印开始有效期
	private Date printEndDate;//打印结束有效期
	private int flag;//表示是否可用0不可用 1可用
	private int printType;//打印类型 0、行驶证 1、登记证书
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTractroinfoId() {
		return tractroinfoId;
	}
	public void setTractroinfoId(int tractroinfoId) {
		this.tractroinfoId = tractroinfoId;
	}
	public Date getPrintBegianDate() {
		return printBegianDate;
	}
	public void setPrintBegianDate(Date printBegianDate) {
		this.printBegianDate = printBegianDate;
	}
	public Date getPrintEndDate() {
		return printEndDate;
	}
	public void setPrintEndDate(Date printEndDate) {
		this.printEndDate = printEndDate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getPrintType() {
		return printType;
	}
	public void setPrintType(int printType) {
		this.printType = printType;
	}

	
}
