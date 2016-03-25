package Ynzc.YnzcAms.Model;

import java.util.Date;

public class YearInspectionChartSource {
	// 教练车年度检验统计表
	private Date statstime;// 统计时间
	private String unit;// 单位
	private String noInspection;// 未检数
	private String noInspectiontotal;// 未检数合计
	private String inspectionrate;// 检验率
	private String inspectionratetotal;// 检验率(%)合计

	// 应检数
	private String mediumTractorN;// 大中型拖拉机
	private String mediumTractorNT;// 大中型拖拉机合计
	private String smallWheelTractorN;// 小型方向盘式拖拉机
	private String smallWheelTractorNT;// 小型方向盘式拖拉机合计
	private String walkingtractorN;// 手扶式拖拉机
	private String walkingtractorNT;// 手扶式拖拉机合计
	private String smallWalkingtractorN;// 小手扶式拖拉机
	private String smallWalkingtractorNT;// 小手扶式拖拉机合计
	private String fourWheelTractorN;// 小四轮拖拉机
	private String fourWheelTractorNT;// 小四轮拖拉机合计
	private String crawlerTractorN;// 履带式拖拉机
	private String crawlerTractorNT;// 履带式拖拉机合计
	private String noChecktotal;// 应检数合计（单位）
	private String noCheckalltotal;// 应检数合计

	// 已检数
	private String mediumTractorY;// 大中型拖拉机
	private String mediumTractorYT;// 大中型拖拉机合计
	private String smallWheelTractorY;// 小型方向盘式拖拉机
	private String smallWheelTractorYT;// 小型方向盘式拖拉机合计
	private String walkingtractorY;// 手扶式拖拉机
	private String walkingtractorYT;// 手扶式拖拉机合计
	private String smallWalkingtractorY;// 小手扶式拖拉机
	private String smallWalkingtractorYT;// 小手扶式拖拉机合计
	private String fourWheelTractorY;// 小四轮拖拉机
	private String fourWheelTractorYT;// 小四轮拖拉机合计
	private String crawlerTractorY;// 履带式拖拉机
	private String crawlerTractorYT;// 履带式拖拉机合计
	private String yesChecktotal;// 应检数合计（单位）
	private String yesCheckalltotal;// 应检数合计

	public Date getStarttime() {
		return statstime;
	}

	public void setStarttime(Date starttime) {
		this.statstime = starttime;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNoInspection() {
		return noInspection;
	}

	public void setNoInspection(String noInspection) {
		this.noInspection = noInspection;
	}

	public String getNoInspectiontotal() {
		return noInspectiontotal;
	}

	public void setNoInspectiontotal(String noInspectiontotal) {
		this.noInspectiontotal = noInspectiontotal;
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

	public String getMediumTractorN() {
		return mediumTractorN;
	}

	public void setMediumTractorN(String mediumTractorN) {
		this.mediumTractorN = mediumTractorN;
	}

	public String getMediumTractorNT() {
		return mediumTractorNT;
	}

	public void setMediumTractorNT(String mediumTractorNT) {
		this.mediumTractorNT = mediumTractorNT;
	}

	public String getSmallWheelTractorN() {
		return smallWheelTractorN;
	}

	public void setSmallWheelTractorN(String smallWheelTractorN) {
		this.smallWheelTractorN = smallWheelTractorN;
	}

	public String getSmallWheelTractorNT() {
		return smallWheelTractorNT;
	}

	public void setSmallWheelTractorNT(String smallWheelTractorNT) {
		this.smallWheelTractorNT = smallWheelTractorNT;
	}

	public String getWalkingtractorN() {
		return walkingtractorN;
	}

	public void setWalkingtractorN(String walkingtractorN) {
		this.walkingtractorN = walkingtractorN;
	}

	public String getWalkingtractorNT() {
		return walkingtractorNT;
	}

	public void setWalkingtractorNT(String walkingtractorNT) {
		this.walkingtractorNT = walkingtractorNT;
	}

	public String getSmallWalkingtractorN() {
		return smallWalkingtractorN;
	}

	public void setSmallWalkingtractorN(String smallWalkingtractorN) {
		this.smallWalkingtractorN = smallWalkingtractorN;
	}

	public String getSmallWalkingtractorNT() {
		return smallWalkingtractorNT;
	}

	public void setSmallWalkingtractorNT(String smallWalkingtractorNT) {
		this.smallWalkingtractorNT = smallWalkingtractorNT;
	}

	public String getFourWheelTractorN() {
		return fourWheelTractorN;
	}

	public void setFourWheelTractorN(String fourWheelTractorN) {
		this.fourWheelTractorN = fourWheelTractorN;
	}

	public String getFourWheelTractorNT() {
		return fourWheelTractorNT;
	}

	public void setFourWheelTractorNT(String fourWheelTractorNT) {
		this.fourWheelTractorNT = fourWheelTractorNT;
	}

	public String getCrawlerTractorN() {
		return crawlerTractorN;
	}

	public void setCrawlerTractorN(String crawlerTractorN) {
		this.crawlerTractorN = crawlerTractorN;
	}

	public String getCrawlerTractorNT() {
		return crawlerTractorNT;
	}

	public void setCrawlerTractorNT(String crawlerTractorNT) {
		this.crawlerTractorNT = crawlerTractorNT;
	}

	public String getNoChecktotal() {
		return noChecktotal;
	}

	public void setNoChecktotal(String noChecktotal) {
		this.noChecktotal = noChecktotal;
	}

	public String getNoCheckalltotal() {
		return noCheckalltotal;
	}

	public void setNoCheckalltotal(String noCheckalltotal) {
		this.noCheckalltotal = noCheckalltotal;
	}

	public String getMediumTractorY() {
		return mediumTractorY;
	}

	public void setMediumTractorY(String mediumTractorY) {
		this.mediumTractorY = mediumTractorY;
	}

	public String getMediumTractorYT() {
		return mediumTractorYT;
	}

	public void setMediumTractorYT(String mediumTractorYT) {
		this.mediumTractorYT = mediumTractorYT;
	}

	public String getSmallWheelTractorY() {
		return smallWheelTractorY;
	}

	public void setSmallWheelTractorY(String smallWheelTractorY) {
		this.smallWheelTractorY = smallWheelTractorY;
	}

	public String getSmallWheelTractorYT() {
		return smallWheelTractorYT;
	}

	public void setSmallWheelTractorYT(String smallWheelTractorYT) {
		this.smallWheelTractorYT = smallWheelTractorYT;
	}

	public String getWalkingtractorY() {
		return walkingtractorY;
	}

	public void setWalkingtractorY(String walkingtractorY) {
		this.walkingtractorY = walkingtractorY;
	}

	public String getWalkingtractorYT() {
		return walkingtractorYT;
	}

	public void setWalkingtractorYT(String walkingtractorYT) {
		this.walkingtractorYT = walkingtractorYT;
	}

	public String getSmallWalkingtractorY() {
		return smallWalkingtractorY;
	}

	public void setSmallWalkingtractorY(String smallWalkingtractorY) {
		this.smallWalkingtractorY = smallWalkingtractorY;
	}

	public String getSmallWalkingtractorYT() {
		return smallWalkingtractorYT;
	}

	public void setSmallWalkingtractorYT(String smallWalkingtractorYT) {
		this.smallWalkingtractorYT = smallWalkingtractorYT;
	}

	public String getFourWheelTractorY() {
		return fourWheelTractorY;
	}

	public void setFourWheelTractorY(String fourWheelTractorY) {
		this.fourWheelTractorY = fourWheelTractorY;
	}

	public String getFourWheelTractorYT() {
		return fourWheelTractorYT;
	}

	public void setFourWheelTractorYT(String fourWheelTractorYT) {
		this.fourWheelTractorYT = fourWheelTractorYT;
	}

	public String getCrawlerTractorY() {
		return crawlerTractorY;
	}

	public void setCrawlerTractorY(String crawlerTractorY) {
		this.crawlerTractorY = crawlerTractorY;
	}

	public String getCrawlerTractorYT() {
		return crawlerTractorYT;
	}

	public void setCrawlerTractorYT(String crawlerTractorYT) {
		this.crawlerTractorYT = crawlerTractorYT;
	}

	public String getYesChecktotal() {
		return yesChecktotal;
	}

	public void setYesChecktotal(String yesChecktotal) {
		this.yesChecktotal = yesChecktotal;
	}

	public String getYesCheckalltotal() {
		return yesCheckalltotal;
	}

	public void setYesCheckalltotal(String yesCheckalltotal) {
		this.yesCheckalltotal = yesCheckalltotal;
	}

}
