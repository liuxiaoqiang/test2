package Ynzc.YnzcAms.Model;

import java.util.Date;

public class HarvesterTransferChartSource {
	// 收割机转移登记业务进展情况统计表
	private Date starttime;// 开始时间
	private Date endtime;// 结束时间
	private String unit;// 单位
	private String total;// 合计（单位）
	private String alltotal;// 合计

	// 联合收割机在农机监理机构管辖区内的转移登记
	private String wheelharvesterIn;// 方向盘自走式联合收割机
	private String wheelharvesterIntotal;// 方向盘自走式联合收割机合计
	private String manipulationharvesterIn;// 操纵杆自走式联合收割机
	private String manipulationharvesterIntotal;// 操纵杆自走式联合收割机合计
	private String suspensionharvesterIn;// 悬挂式联合收割机
	private String suspensionharvesterIntotal;// 悬挂式联合收割机合计
	private String intotal;// 联合收割机在农机监理机构管辖区内的转移登记小计（单位）
	private String inalltotal;// 联合收割机在农机监理机构管辖区内的转移登记小计

	// 联合收割机转出农机监理机构管辖区内的转移登记
	private String wheelharvesterOut;// 方向盘自走式联合收割机
	private String wheelharvesterOuttotal;// 方向盘自走式联合收割机合计
	private String manipulationharvesterOut;// 操纵杆自走式联合收割机
	private String manipulationharvesterOuttotal;// 操纵杆自走式联合收割机合计
	private String suspensionharvesterOut;// 悬挂式联合收割机
	private String suspensionharvesterOuttotal;// 悬挂式联合收割机合计
	private String outtotal;// 联合收割机在农机监理机构管辖区内的转移登记小计（单位）
	private String outalltotal;// 联合收割机在农机监理机构管辖区内的转移登记小计

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getAlltotal() {
		return alltotal;
	}

	public void setAlltotal(String alltotal) {
		this.alltotal = alltotal;
	}

	public String getWheelharvesterIn() {
		return wheelharvesterIn;
	}

	public void setWheelharvesterIn(String wheelharvesterIn) {
		this.wheelharvesterIn = wheelharvesterIn;
	}

	public String getWheelharvesterIntotal() {
		return wheelharvesterIntotal;
	}

	public void setWheelharvesterIntotal(String wheelharvesterIntotal) {
		this.wheelharvesterIntotal = wheelharvesterIntotal;
	}

	public String getManipulationharvesterIn() {
		return manipulationharvesterIn;
	}

	public void setManipulationharvesterIn(String manipulationharvesterIn) {
		this.manipulationharvesterIn = manipulationharvesterIn;
	}

	public String getManipulationharvesterIntotal() {
		return manipulationharvesterIntotal;
	}

	public void setManipulationharvesterIntotal(
			String manipulationharvesterIntotal) {
		this.manipulationharvesterIntotal = manipulationharvesterIntotal;
	}

	public String getSuspensionharvesterIn() {
		return suspensionharvesterIn;
	}

	public void setSuspensionharvesterIn(String suspensionharvesterIn) {
		this.suspensionharvesterIn = suspensionharvesterIn;
	}

	public String getSuspensionharvesterIntotal() {
		return suspensionharvesterIntotal;
	}

	public void setSuspensionharvesterIntotal(String suspensionharvesterIntotal) {
		this.suspensionharvesterIntotal = suspensionharvesterIntotal;
	}

	public String getIntotal() {
		return intotal;
	}

	public void setIntotal(String intotal) {
		this.intotal = intotal;
	}

	public String getInalltotal() {
		return inalltotal;
	}

	public void setInalltotal(String inalltotal) {
		this.inalltotal = inalltotal;
	}

	public String getWheelharvesterOut() {
		return wheelharvesterOut;
	}

	public void setWheelharvesterOut(String wheelharvesterOut) {
		this.wheelharvesterOut = wheelharvesterOut;
	}

	public String getWheelharvesterOuttotal() {
		return wheelharvesterOuttotal;
	}

	public void setWheelharvesterOuttotal(String wheelharvesterOuttotal) {
		this.wheelharvesterOuttotal = wheelharvesterOuttotal;
	}

	public String getManipulationharvesterOut() {
		return manipulationharvesterOut;
	}

	public void setManipulationharvesterOut(String manipulationharvesterOut) {
		this.manipulationharvesterOut = manipulationharvesterOut;
	}

	public String getManipulationharvesterOuttotal() {
		return manipulationharvesterOuttotal;
	}

	public void setManipulationharvesterOuttotal(
			String manipulationharvesterOuttotal) {
		this.manipulationharvesterOuttotal = manipulationharvesterOuttotal;
	}

	public String getSuspensionharvesterOut() {
		return suspensionharvesterOut;
	}

	public void setSuspensionharvesterOut(String suspensionharvesterOut) {
		this.suspensionharvesterOut = suspensionharvesterOut;
	}

	public String getSuspensionharvesterOuttotal() {
		return suspensionharvesterOuttotal;
	}

	public void setSuspensionharvesterOuttotal(
			String suspensionharvesterOuttotal) {
		this.suspensionharvesterOuttotal = suspensionharvesterOuttotal;
	}

	public String getOuttotal() {
		return outtotal;
	}

	public void setOuttotal(String outtotal) {
		this.outtotal = outtotal;
	}

	public String getOutalltotal() {
		return outalltotal;
	}

	public void setOutalltotal(String outalltotal) {
		this.outalltotal = outalltotal;
	}

}
