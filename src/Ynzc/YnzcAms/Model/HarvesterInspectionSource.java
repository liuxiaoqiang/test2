package Ynzc.YnzcAms.Model;

import java.util.Date;

public class HarvesterInspectionSource {
	//收割机检验情况统计表
	private Date starttime;//统计开始时间
	private Date endtime;//统计结束时间
	private String unit;//单位
	private String noinspection;//未检数
	private String noinspectiontotal;//未检数合计
	private String inspectionrate;//检验率
	private String inspectionratetotal;//检验率合计
	
	//应检数
	private String wheelharvesterN;//方向盘自走式联合收割机
	private String wheelharvesterNT;//方向盘自走式联合收割机合计
	private String manipulationharvesterN;//操纵杆自走式联合收割机
	private String manipulationharvesterNT;//操纵杆自走式联合收割机合计
	private String suspensionharvesterN;//悬挂式联合收割机
	private String suspensionharvesterNT;//悬挂式联合收割机合计
	private String totalN;//合计（单位）
	private String totalNT;//合计
	
	//已检数
	private String wheelharvesterY;//方向盘自走式联合收割机
	private String wheelharvesterYT;//方向盘自走式联合收割机合计
	private String manipulationharvesterY;//操纵杆自走式联合收割机
	private String manipulationharvesterYT;//操纵杆自走式联合收割机合计
	private String suspensionharvesterY;//悬挂式联合收割机
	private String suspensionharvesterYT;//悬挂式联合收割机合计
	private String totalY;//合计（单位）
	private String totalYT;//合计
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
	public String getNoinspection() {
		return noinspection;
	}
	public void setNoinspection(String noinspection) {
		this.noinspection = noinspection;
	}
	public String getNoinspectiontotal() {
		return noinspectiontotal;
	}
	public void setNoinspectiontotal(String noinspectiontotal) {
		this.noinspectiontotal = noinspectiontotal;
	}
	public String getInspectionrate() {
		return inspectionrate;
	}
	public void setInspectionrate(String inspectionrate) {
		this.inspectionrate = inspectionrate;
	}
	public String getInspectionratetotal() {
		return inspectionratetotal;
	}
	public void setInspectionratetotal(String inspectionratetotal) {
		this.inspectionratetotal = inspectionratetotal;
	}
	public String getWheelharvesterN() {
		return wheelharvesterN;
	}
	public void setWheelharvesterN(String wheelharvesterN) {
		this.wheelharvesterN = wheelharvesterN;
	}
	public String getWheelharvesterNT() {
		return wheelharvesterNT;
	}
	public void setWheelharvesterNT(String wheelharvesterNT) {
		this.wheelharvesterNT = wheelharvesterNT;
	}
	public String getManipulationharvesterN() {
		return manipulationharvesterN;
	}
	public void setManipulationharvesterN(String manipulationharvesterN) {
		this.manipulationharvesterN = manipulationharvesterN;
	}
	public String getManipulationharvesterNT() {
		return manipulationharvesterNT;
	}
	public void setManipulationharvesterNT(String manipulationharvesterNT) {
		this.manipulationharvesterNT = manipulationharvesterNT;
	}
	public String getSuspensionharvesterN() {
		return suspensionharvesterN;
	}
	public void setSuspensionharvesterN(String suspensionharvesterN) {
		this.suspensionharvesterN = suspensionharvesterN;
	}
	public String getSuspensionharvesterNT() {
		return suspensionharvesterNT;
	}
	public void setSuspensionharvesterNT(String suspensionharvesterNT) {
		this.suspensionharvesterNT = suspensionharvesterNT;
	}
	public String getTotalN() {
		return totalN;
	}
	public void setTotalN(String totalN) {
		this.totalN = totalN;
	}
	public String getTotalNT() {
		return totalNT;
	}
	public void setTotalNT(String totalNT) {
		this.totalNT = totalNT;
	}
	public String getWheelharvesterY() {
		return wheelharvesterY;
	}
	public void setWheelharvesterY(String wheelharvesterY) {
		this.wheelharvesterY = wheelharvesterY;
	}
	public String getWheelharvesterYT() {
		return wheelharvesterYT;
	}
	public void setWheelharvesterYT(String wheelharvesterYT) {
		this.wheelharvesterYT = wheelharvesterYT;
	}
	public String getManipulationharvesterY() {
		return manipulationharvesterY;
	}
	public void setManipulationharvesterY(String manipulationharvesterY) {
		this.manipulationharvesterY = manipulationharvesterY;
	}
	public String getManipulationharvesterYT() {
		return manipulationharvesterYT;
	}
	public void setManipulationharvesterYT(String manipulationharvesterYT) {
		this.manipulationharvesterYT = manipulationharvesterYT;
	}
	public String getSuspensionharvesterY() {
		return suspensionharvesterY;
	}
	public void setSuspensionharvesterY(String suspensionharvesterY) {
		this.suspensionharvesterY = suspensionharvesterY;
	}
	public String getSuspensionharvesterYT() {
		return suspensionharvesterYT;
	}
	public void setSuspensionharvesterYT(String suspensionharvesterYT) {
		this.suspensionharvesterYT = suspensionharvesterYT;
	}
	public String getTotalY() {
		return totalY;
	}
	public void setTotalY(String totalY) {
		this.totalY = totalY;
	}
	public String getTotalYT() {
		return totalYT;
	}
	public void setTotalYT(String totalYT) {
		this.totalYT = totalYT;
	}
	
	

}
