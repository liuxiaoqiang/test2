package Ynzc.YnzcAms.Model;

import java.util.Date;

public class TractorTransferProgressChartSource {
	// 拖拉机转移登记业务进展情况统计表
	private Date startTime;// 开始时间
	private Date endTime;// 结束时间
	private String unit;// 单位
	private String allTotal;// 合计
	private String total;// 合计（单位）

	// 拖拉机在农机监理机构管辖区内的转移登记
	private String mediumTractorWithinTotal;// 大中型拖拉机合计
	private String smallWheelTractorWithinTotal;// 小型方向盘式拖拉机合计
	private String walkingtractorWithinTotal;// 手扶式拖拉机合计
	private String fourWheelTractorWithinTotal;// 小四轮拖拉机合计
	private String smallWalkingtractorWithinTotal;// 小手扶式拖拉机合计
	private String crawlerTractorWithinTotal;// 履带式拖拉机合计
	private String crawlerTractorWithin;// 履带式拖拉机
	private String fourWheelTractorWithin;// 小四轮拖拉机
	private String smallWalkingtractorWithin;// 小手扶式拖拉机
	private String walkingtractorWithin;// 手扶式拖拉机
	private String smallWheelTractorWithin;// 小型方向盘式拖拉机
	private String mediumTractorWithin;// 大中型拖拉机
	private String minorAllWithinTotal;// 小记合计
	private String minorWithinTotal;// 小记

	// 拖拉机转出农机监理机构管辖区的转移登记
	private String mediumTractorWithoutTotal;// 大中型拖拉机合计
	private String mediumTractorWithout;// 大中型拖拉机
	private String smallWheelTractorWithoutTotal;// 小型方向盘式拖拉机合计
	private String smallWheelTractorWithout;// 小型方向盘式拖拉机
	private String walkingtractorWithoutTotal;// 手扶式拖拉机合计
	private String walkingtractorWithout;// 手扶式拖拉机
	private String fourWheelTractorWithoutTotal;// 小四轮拖拉机合计
	private String fourWheelTractorWithout;// 小四轮拖拉机
	private String smallWalkingtractorWithoutTotal;// 小手扶式拖拉机合计
	private String smallWalkingtractorWithout;// 小手扶式拖拉机
	private String crawlerTractorWithoutTotal;// 履带式拖拉机合计
	private String crawlerTractorWithout;// 履带式拖拉机
	private String minorAllWithoutTotal;// 小记合计
	private String minorWithoutTotal;// 小记

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

	public String getAllTotal() {
		return allTotal;
	}

	public void setAllTotal(String allTotal) {
		this.allTotal = allTotal;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getMediumTractorWithinTotal() {
		return mediumTractorWithinTotal;
	}

	public void setMediumTractorWithinTotal(String mediumTractorWithinTotal) {
		this.mediumTractorWithinTotal = mediumTractorWithinTotal;
	}

	public String getSmallWheelTractorWithinTotal() {
		return smallWheelTractorWithinTotal;
	}

	public void setSmallWheelTractorWithinTotal(
			String smallWheelTractorWithinTotal) {
		this.smallWheelTractorWithinTotal = smallWheelTractorWithinTotal;
	}

	public String getWalkingtractorWithinTotal() {
		return walkingtractorWithinTotal;
	}

	public void setWalkingtractorWithinTotal(String walkingtractorWithinTotal) {
		this.walkingtractorWithinTotal = walkingtractorWithinTotal;
	}

	public String getFourWheelTractorWithinTotal() {
		return fourWheelTractorWithinTotal;
	}

	public void setFourWheelTractorWithinTotal(
			String fourWheelTractorWithinTotal) {
		this.fourWheelTractorWithinTotal = fourWheelTractorWithinTotal;
	}

	public String getSmallWalkingtractorWithinTotal() {
		return smallWalkingtractorWithinTotal;
	}

	public void setSmallWalkingtractorWithinTotal(
			String smallWalkingtractorWithinTotal) {
		this.smallWalkingtractorWithinTotal = smallWalkingtractorWithinTotal;
	}

	public String getCrawlerTractorWithinTotal() {
		return crawlerTractorWithinTotal;
	}

	public void setCrawlerTractorWithinTotal(String crawlerTractorWithinTotal) {
		this.crawlerTractorWithinTotal = crawlerTractorWithinTotal;
	}

	public String getCrawlerTractorWithin() {
		return crawlerTractorWithin;
	}

	public void setCrawlerTractorWithin(String crawlerTractorWithin) {
		this.crawlerTractorWithin = crawlerTractorWithin;
	}

	public String getFourWheelTractorWithin() {
		return fourWheelTractorWithin;
	}

	public void setFourWheelTractorWithin(String fourWheelTractorWithin) {
		this.fourWheelTractorWithin = fourWheelTractorWithin;
	}

	public String getSmallWalkingtractorWithin() {
		return smallWalkingtractorWithin;
	}

	public void setSmallWalkingtractorWithin(String smallWalkingtractorWithin) {
		this.smallWalkingtractorWithin = smallWalkingtractorWithin;
	}

	public String getWalkingtractorWithin() {
		return walkingtractorWithin;
	}

	public void setWalkingtractorWithin(String walkingtractorWithin) {
		this.walkingtractorWithin = walkingtractorWithin;
	}

	public String getSmallWheelTractorWithin() {
		return smallWheelTractorWithin;
	}

	public void setSmallWheelTractorWithin(String smallWheelTractorWithin) {
		this.smallWheelTractorWithin = smallWheelTractorWithin;
	}

	public String getMediumTractorWithin() {
		return mediumTractorWithin;
	}

	public void setMediumTractorWithin(String mediumTractorWithin) {
		this.mediumTractorWithin = mediumTractorWithin;
	}

	public String getMinorAllWithinTotal() {
		return minorAllWithinTotal;
	}

	public void setMinorAllWithinTotal(String minorAllWithinTotal) {
		this.minorAllWithinTotal = minorAllWithinTotal;
	}

	public String getMinorWithinTotal() {
		return minorWithinTotal;
	}

	public void setMinorWithinTotal(String minorWithinTotal) {
		this.minorWithinTotal = minorWithinTotal;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMediumTractorWithoutTotal() {
		return mediumTractorWithoutTotal;
	}

	public void setMediumTractorWithoutTotal(String mediumTractorWithoutTotal) {
		this.mediumTractorWithoutTotal = mediumTractorWithoutTotal;
	}

	public String getMediumTractorWithout() {
		return mediumTractorWithout;
	}

	public void setMediumTractorWithout(String mediumTractorWithout) {
		this.mediumTractorWithout = mediumTractorWithout;
	}

	public String getSmallWheelTractorWithoutTotal() {
		return smallWheelTractorWithoutTotal;
	}

	public void setSmallWheelTractorWithoutTotal(
			String smallWheelTractorWithoutTotal) {
		this.smallWheelTractorWithoutTotal = smallWheelTractorWithoutTotal;
	}

	public String getSmallWheelTractorWithout() {
		return smallWheelTractorWithout;
	}

	public void setSmallWheelTractorWithout(String smallWheelTractorWithout) {
		this.smallWheelTractorWithout = smallWheelTractorWithout;
	}

	public String getWalkingtractorWithoutTotal() {
		return walkingtractorWithoutTotal;
	}

	public void setWalkingtractorWithoutTotal(String walkingtractorWithoutTotal) {
		this.walkingtractorWithoutTotal = walkingtractorWithoutTotal;
	}

	public String getWalkingtractorWithout() {
		return walkingtractorWithout;
	}

	public void setWalkingtractorWithout(String walkingtractorWithout) {
		this.walkingtractorWithout = walkingtractorWithout;
	}

	public String getFourWheelTractorWithoutTotal() {
		return fourWheelTractorWithoutTotal;
	}

	public void setFourWheelTractorWithoutTotal(
			String fourWheelTractorWithoutTotal) {
		this.fourWheelTractorWithoutTotal = fourWheelTractorWithoutTotal;
	}

	public String getFourWheelTractorWithout() {
		return fourWheelTractorWithout;
	}

	public void setFourWheelTractorWithout(String fourWheelTractorWithout) {
		this.fourWheelTractorWithout = fourWheelTractorWithout;
	}

	public String getSmallWalkingtractorWithoutTotal() {
		return smallWalkingtractorWithoutTotal;
	}

	public void setSmallWalkingtractorWithoutTotal(
			String smallWalkingtractorWithoutTotal) {
		this.smallWalkingtractorWithoutTotal = smallWalkingtractorWithoutTotal;
	}

	public String getSmallWalkingtractorWithout() {
		return smallWalkingtractorWithout;
	}

	public void setSmallWalkingtractorWithout(String smallWalkingtractorWithout) {
		this.smallWalkingtractorWithout = smallWalkingtractorWithout;
	}

	public String getCrawlerTractorWithoutTotal() {
		return crawlerTractorWithoutTotal;
	}

	public void setCrawlerTractorWithoutTotal(String crawlerTractorWithoutTotal) {
		this.crawlerTractorWithoutTotal = crawlerTractorWithoutTotal;
	}

	public String getCrawlerTractorWithout() {
		return crawlerTractorWithout;
	}

	public void setCrawlerTractorWithout(String crawlerTractorWithout) {
		this.crawlerTractorWithout = crawlerTractorWithout;
	}

	public String getMinorAllWithoutTotal() {
		return minorAllWithoutTotal;
	}

	public void setMinorAllWithoutTotal(String minorAllWithoutTotal) {
		this.minorAllWithoutTotal = minorAllWithoutTotal;
	}

	public String getMinorWithoutTotal() {
		return minorWithoutTotal;
	}

	public void setMinorWithoutTotal(String minorWithoutTotal) {
		this.minorWithoutTotal = minorWithoutTotal;
	}

}
