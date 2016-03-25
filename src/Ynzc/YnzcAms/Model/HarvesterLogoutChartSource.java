package Ynzc.YnzcAms.Model;

import java.util.Date;

public class HarvesterLogoutChartSource {
	private String unit;// 单位
	private String starttime;// 开始时间
	private Date endtime;// 截止时间
	private String total;
	private String alltotal;// 合计
	private String wheelharvester;// 方向盘自走式联合收割机
	private String wheelharvestertotal;// 方向盘自走式联合收割机合计
	private String manipulationharvester;// 操纵自走式联合收割机
	private String manipulationharvestertotal;// 操纵自走式联合收割机合计
	private String suspensionharvester;// 悬挂式联合收割机
	private String suspensionharvestertotal;// 悬挂式联合收割机合计

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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

	public String getWheelharvester() {
		return wheelharvester;
	}

	public void setWheelharvester(String wheelharvester) {
		this.wheelharvester = wheelharvester;
	}

	public String getWheelharvestertotal() {
		return wheelharvestertotal;
	}

	public void setWheelharvestertotal(String wheelharvestertotal) {
		this.wheelharvestertotal = wheelharvestertotal;
	}

	public String getManipulationharvester() {
		return manipulationharvester;
	}

	public void setManipulationharvester(String manipulationharvester) {
		this.manipulationharvester = manipulationharvester;
	}

	public String getManipulationharvestertotal() {
		return manipulationharvestertotal;
	}

	public void setManipulationharvestertotal(String manipulationharvestertotal) {
		this.manipulationharvestertotal = manipulationharvestertotal;
	}

	public String getSuspensionharvester() {
		return suspensionharvester;
	}

	public void setSuspensionharvester(String suspensionharvester) {
		this.suspensionharvester = suspensionharvester;
	}

	public String getSuspensionharvestertotal() {
		return suspensionharvestertotal;
	}

	public void setSuspensionharvestertotal(String suspensionharvestertotal) {
		this.suspensionharvestertotal = suspensionharvestertotal;
	}

}
