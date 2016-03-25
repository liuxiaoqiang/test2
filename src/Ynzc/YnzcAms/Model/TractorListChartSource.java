package Ynzc.YnzcAms.Model;

import java.util.Date;

public class TractorListChartSource {
	// 拖拉机在册情况统计表
	private String mediumTractorCheck;// 已检数大中型拖拉机
	private String smallWheelTractorCheck;// 已检数小型方向盘式拖拉机
	private String walkingtractorCheck;// 已检数手扶式拖拉机
	private String mediumTractorList;// 在册数大中型拖拉机
	private String smallWheelTractorList;// 在册数小型方向盘式拖拉机
	private String walkingtractorList;// 在册数手扶式拖拉机
	private String otherList;// 在册数其他
	private String totalList;// 在册数合计（单位）
	private String subtotal; // （单位）注册登记小记
	private String turnIn;// 已检数转入
	private String mediumTractorCheckTotal;// 已检数大中型拖拉机合计
	private String totalCheck;// （单位）已检数合计
	private String turnBy; // 减少数转籍
	private String scrap;// 减少数报废
	private String reduceTotal;
	private String smallWheelTractorCheckTotal;// 已检数小型方向盘式拖拉机合计
	private String walkingtractorCheckTotal;// 已检数手扶式拖拉机合计
	private String otherListTotal;// 在册数其他合计
	private String totalListAll;// 在册数合计
	private String unit;// 单位
	private String mediumTractorListTotal;// 在册数大中型拖拉机合计
	private String smallWheelTractorListTotal;// 在册数小型方向盘式拖拉机合计
	private String walkingtractorListTotal;// 在册数手扶式拖拉机合计
	private String totalCheckAll;// 已检数其他合计
	private String subtotalAll;// 小记合计
	private String turnInTotal;// 转入合计
	private String total;// 减少数合计（单位）
	private String totalAll;// 减少数合计
	private String scrapTotal;// 报废合计
	private String turnByTotal; // 转籍合计
	private Date startTime; // 统计开始时间
	private Date endTime;// 统计结束时间

	public String getMediumTractorCheck() {
		return mediumTractorCheck;
	}

	public void setMediumTractorCheck(String mediumTractorCheck) {
		this.mediumTractorCheck = mediumTractorCheck;
	}

	public String getSmallWheelTractorCheck() {
		return smallWheelTractorCheck;
	}

	public void setSmallWheelTractorCheck(String smallWheelTractorCheck) {
		this.smallWheelTractorCheck = smallWheelTractorCheck;
	}

	public String getWalkingtractorCheck() {
		return walkingtractorCheck;
	}

	public void setWalkingtractorCheck(String walkingtractorCheck) {
		this.walkingtractorCheck = walkingtractorCheck;
	}

	public String getMediumTractorList() {
		return mediumTractorList;
	}

	public void setMediumTractorList(String mediumTractorList) {
		this.mediumTractorList = mediumTractorList;
	}

	public String getSmallWheelTractorList() {
		return smallWheelTractorList;
	}

	public void setSmallWheelTractorList(String smallWheelTractorList) {
		this.smallWheelTractorList = smallWheelTractorList;
	}

	public String getWalkingtractorList() {
		return walkingtractorList;
	}

	public void setWalkingtractorList(String walkingtractorList) {
		this.walkingtractorList = walkingtractorList;
	}

	public String getOtherList() {
		return otherList;
	}

	public void setOtherList(String otherList) {
		this.otherList = otherList;
	}

	public String getTotalList() {
		return totalList;
	}

	public void setTotalList(String totalList) {
		this.totalList = totalList;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getTurnIn() {
		return turnIn;
	}

	public void setTurnIn(String turnIn) {
		this.turnIn = turnIn;
	}

	public String getMediumTractorCheckTotal() {
		return mediumTractorCheckTotal;
	}

	public void setMediumTractorCheckTotal(String mediumTractorCheckTotal) {
		this.mediumTractorCheckTotal = mediumTractorCheckTotal;
	}

	public String getTotalCheck() {
		return totalCheck;
	}

	public void setTotalCheck(String totalCheck) {
		this.totalCheck = totalCheck;
	}

	public String getTurnBy() {
		return turnBy;
	}

	public void setTurnBy(String turnBy) {
		this.turnBy = turnBy;
	}

	public String getScrap() {
		return scrap;
	}

	public void setScrap(String scrap) {
		this.scrap = scrap;
	}

	public String getReduceTotal() {
		return reduceTotal;
	}

	public void setReduceTotal(String reduceTotal) {
		this.reduceTotal = reduceTotal;
	}

	public String getSmallWheelTractorCheckTotal() {
		return smallWheelTractorCheckTotal;
	}

	public void setSmallWheelTractorCheckTotal(
			String smallWheelTractorCheckTotal) {
		this.smallWheelTractorCheckTotal = smallWheelTractorCheckTotal;
	}

	public String getWalkingtractorCheckTotal() {
		return walkingtractorCheckTotal;
	}

	public void setWalkingtractorCheckTotal(String walkingtractorCheckTotal) {
		this.walkingtractorCheckTotal = walkingtractorCheckTotal;
	}

	public String getOtherListTotal() {
		return otherListTotal;
	}

	public void setOtherListTotal(String otherListTotal) {
		this.otherListTotal = otherListTotal;
	}

	public String getTotalListAll() {
		return totalListAll;
	}

	public void setTotalListAll(String totalListAll) {
		this.totalListAll = totalListAll;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMediumTractorListTotal() {
		return mediumTractorListTotal;
	}

	public void setMediumTractorListTotal(String mediumTractorListTotal) {
		this.mediumTractorListTotal = mediumTractorListTotal;
	}

	public String getSmallWheelTractorListTotal() {
		return smallWheelTractorListTotal;
	}

	public void setSmallWheelTractorListTotal(String smallWheelTractorListTotal) {
		this.smallWheelTractorListTotal = smallWheelTractorListTotal;
	}

	public String getWalkingtractorListTotal() {
		return walkingtractorListTotal;
	}

	public void setWalkingtractorListTotal(String walkingtractorListTotal) {
		this.walkingtractorListTotal = walkingtractorListTotal;
	}

	public String getTotalCheckAll() {
		return totalCheckAll;
	}

	public void setTotalCheckAll(String totalCheckAll) {
		this.totalCheckAll = totalCheckAll;
	}

	public String getSubtotalAll() {
		return subtotalAll;
	}

	public void setSubtotalAll(String subtotalAll) {
		this.subtotalAll = subtotalAll;
	}

	public String getTurnInTotal() {
		return turnInTotal;
	}

	public void setTurnInTotal(String turnInTotal) {
		this.turnInTotal = turnInTotal;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getTotalAll() {
		return totalAll;
	}

	public void setTotalAll(String totalAll) {
		this.totalAll = totalAll;
	}

	public String getScrapTotal() {
		return scrapTotal;
	}

	public void setScrapTotal(String scrapTotal) {
		this.scrapTotal = scrapTotal;
	}

	public String getTurnByTotal() {
		return turnByTotal;
	}

	public void setTurnByTotal(String turnByTotal) {
		this.turnByTotal = turnByTotal;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
