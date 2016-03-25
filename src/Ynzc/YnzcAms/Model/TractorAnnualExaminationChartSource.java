package Ynzc.YnzcAms.Model;

public class TractorAnnualExaminationChartSource {
//拖拉机年度检验统计表
	private String statisticalTime;//统计时间
	private String unit;//单位
	private String noCheckTotal;//未检数
	private String yesCheckTotal;//已检数
	private String yearCheckTotal;//年度应检数
	private String monthCheckConut;////月应检数
	private String annualInspectionRate;////年度检验率
	private String inspectionRate;////检验率
	private String mediumTractorN;//大中型拖拉机（未检数）
	private String mediumTractorY;//大中型拖拉机（已检数）
	private String mediumTractorD;//大中型拖拉机（年度应检数）
	private String smallWheelTractorN;//小型方向盘式拖拉机（未检数）
	private String smallWheelTractorY;//小型方向盘式拖拉机（已检数）
	private String smallWheelTractorD;//小型方向盘式拖拉机（年度应检数）
	private String walkingtractorN;//手扶式拖拉机（未检数）
	private String walkingtractorY;//手扶式拖拉机（已检数）
	private String walkingtractorD;//手扶式拖拉机（年度应检数）
	private String smallWalkingtractorN;//小手扶式拖拉机（未检数）
	private String smallWalkingtractorY;//小手扶式拖拉机（已检数）
	private String smallWalkingtractorD;//小手扶式拖拉机（年度应检数）
	private String fourWheelTractorN;//小四轮拖拉机（未检数）
	private String fourWheelTractorY;//小四轮拖拉机（已检数）
	private String fourWheelTractorD;//小四轮拖拉机（年度应检数）
	private String crawlerTractorN;//履带式拖拉机（未检数）
	private String crawlerTractorY;//履带式拖拉机（已检数）
	private String crawlerTractorD;//履带式拖拉机（年度应检数）
	private String mediumTractorNT;//大中型拖拉机（未检数合计）
	private String mediumTractorYT;//大中型拖拉机（已检数合计）
	private String mediumTractorDT;//大中型拖拉机（年度应检数合计）
	private String smallWheelTractorNT;//小型方向盘式拖拉机（未检数合计）
	private String smallWheelTractorYT;//小型方向盘式拖拉机（已检数合计）
	private String smallWheelTractorDT;//小型方向盘式拖拉机（年度应检数合计）
	private String walkingtractorNT;//手扶式拖拉机（未检数合计）
	private String walkingtractorYT;//手扶式拖拉机（已检数合计）
	private String walkingtractorDT;//手扶式拖拉机（年度应检数合计）
	private String smallWalkingtractorNT;//小手扶式拖拉机（未检数合计）
	private String smallWalkingtractorYT;//小手扶式拖拉机（已检数合计）
	private String smallWalkingtractorDT;//小手扶式拖拉机（年度应检数合计）
	private String fourWheelTractorNT;//小四轮拖拉机（未检数合计）
	private String fourWheelTractorYT;//小四轮拖拉机（已检数合计）
	private String fourWheelTractorDT;//小四轮拖拉机（年度应检数合计）
	private String crawlerTractorNT;//履带式拖拉机（未检数合计）
	private String crawlerTractorYT;//履带式拖拉机（已检数合计）
	private String crawlerTractorDT;//履带式拖拉机（年度应检数合计）
	private String noCheckAllTotal;//未检数合计
	private String yesCheckAllTotal;  //已检数合计
	private String yearCheckAllTotal;//年度应检数合计
	private String annualInspectionTotalRate; //年度检验率合计
	private String monthCheckTotalConut;//月应检数合计
	private String inspectionTotalRate;//检验率合计
	private String statisticalMonth;
	public String getStatisticalTime() {
		return statisticalTime;
	}
	public void setStatisticalTime(String statisticalTime) {
		this.statisticalTime = statisticalTime;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getNoCheckTotal() {
		return noCheckTotal;
	}
	public void setNoCheckTotal(String noCheckTotal) {
		this.noCheckTotal = noCheckTotal;
	}
	public String getYesCheckTotal() {
		return yesCheckTotal;
	}
	public void setYesCheckTotal(String yesCheckTotal) {
		this.yesCheckTotal = yesCheckTotal;
	}
	public String getYearCheckTotal() {
		return yearCheckTotal;
	}
	public void setYearCheckTotal(String yearCheckTotal) {
		this.yearCheckTotal = yearCheckTotal;
	}
	public String getMonthCheckConut() {
		return monthCheckConut;
	}
	public void setMonthCheckConut(String monthCheckConut) {
		this.monthCheckConut = monthCheckConut;
	}
	public String getAnnualInspectionRate() {
		return annualInspectionRate;
	}
	public void setAnnualInspectionRate(String annualInspectionRate) {
		this.annualInspectionRate = annualInspectionRate;
	}
	public String getInspectionRate() {
		return inspectionRate;
	}
	public void setInspectionRate(String inspectionRate) {
		this.inspectionRate = inspectionRate;
	}
	public String getFourWheelTractorN() {
		return fourWheelTractorN;
	}
	public void setFourWheelTractorN(String fourWheelTractorN) {
		this.fourWheelTractorN = fourWheelTractorN;
	}
	public String getCrawlerTractorN() {
		return crawlerTractorN;
	}
	public void setCrawlerTractorN(String crawlerTractorN) {
		this.crawlerTractorN = crawlerTractorN;
	}
	public String getMediumTractorN() {
		return mediumTractorN;
	}
	public void setMediumTractorN(String mediumTractorN) {
		this.mediumTractorN = mediumTractorN;
	}
	public String getMediumTractorY() {
		return mediumTractorY;
	}
	public void setMediumTractorY(String mediumTractorY) {
		this.mediumTractorY = mediumTractorY;
	}
	public String getMediumTractorD() {
		return mediumTractorD;
	}
	public void setMediumTractorD(String mediumTractorD) {
		this.mediumTractorD = mediumTractorD;
	}
	public String getSmallWheelTractorN() {
		return smallWheelTractorN;
	}
	public void setSmallWheelTractorN(String smallWheelTractorN) {
		this.smallWheelTractorN = smallWheelTractorN;
	}
	public String getSmallWheelTractorY() {
		return smallWheelTractorY;
	}
	public void setSmallWheelTractorY(String smallWheelTractorY) {
		this.smallWheelTractorY = smallWheelTractorY;
	}
	public String getSmallWheelTractorD() {
		return smallWheelTractorD;
	}
	public void setSmallWheelTractorD(String smallWheelTractorD) {
		this.smallWheelTractorD = smallWheelTractorD;
	}
	public String getWalkingtractorN() {
		return walkingtractorN;
	}
	public void setWalkingtractorN(String walkingtractorN) {
		this.walkingtractorN = walkingtractorN;
	}
	public String getWalkingtractorY() {
		return walkingtractorY;
	}
	public void setWalkingtractorY(String walkingtractorY) {
		this.walkingtractorY = walkingtractorY;
	}
	public String getWalkingtractorD() {
		return walkingtractorD;
	}
	public void setWalkingtractorD(String walkingtractorD) {
		this.walkingtractorD = walkingtractorD;
	}
	public String getSmallWalkingtractorN() {
		return smallWalkingtractorN;
	}
	public void setSmallWalkingtractorN(String smallWalkingtractorN) {
		this.smallWalkingtractorN = smallWalkingtractorN;
	}
	public String getSmallWalkingtractorY() {
		return smallWalkingtractorY;
	}
	public void setSmallWalkingtractorY(String smallWalkingtractorY) {
		this.smallWalkingtractorY = smallWalkingtractorY;
	}
	public String getSmallWalkingtractorD() {
		return smallWalkingtractorD;
	}
	public void setSmallWalkingtractorD(String smallWalkingtractorD) {
		this.smallWalkingtractorD = smallWalkingtractorD;
	}
	public String getFourWheelTractorY() {
		return fourWheelTractorY;
	}
	public void setFourWheelTractorY(String fourWheelTractorY) {
		this.fourWheelTractorY = fourWheelTractorY;
	}
	public String getFourWheelTractorD() {
		return fourWheelTractorD;
	}
	public void setFourWheelTractorD(String fourWheelTractorD) {
		this.fourWheelTractorD = fourWheelTractorD;
	}
	public String getCrawlerTractorY() {
		return crawlerTractorY;
	}
	public void setCrawlerTractorY(String crawlerTractorY) {
		this.crawlerTractorY = crawlerTractorY;
	}
	public String getCrawlerTractorD() {
		return crawlerTractorD;
	}
	public void setCrawlerTractorD(String crawlerTractorD) {
		this.crawlerTractorD = crawlerTractorD;
	}
	public String getMediumTractorNT() {
		return mediumTractorNT;
	}
	public void setMediumTractorNT(String mediumTractorNT) {
		this.mediumTractorNT = mediumTractorNT;
	}
	public String getMediumTractorYT() {
		return mediumTractorYT;
	}
	public void setMediumTractorYT(String mediumTractorYT) {
		this.mediumTractorYT = mediumTractorYT;
	}
	public String getMediumTractorDT() {
		return mediumTractorDT;
	}
	public void setMediumTractorDT(String mediumTractorDT) {
		this.mediumTractorDT = mediumTractorDT;
	}
	public String getSmallWheelTractorNT() {
		return smallWheelTractorNT;
	}
	public void setSmallWheelTractorNT(String smallWheelTractorNT) {
		this.smallWheelTractorNT = smallWheelTractorNT;
	}
	public String getSmallWheelTractorYT() {
		return smallWheelTractorYT;
	}
	public void setSmallWheelTractorYT(String smallWheelTractorYT) {
		this.smallWheelTractorYT = smallWheelTractorYT;
	}
	public String getSmallWheelTractorDT() {
		return smallWheelTractorDT;
	}
	public void setSmallWheelTractorDT(String smallWheelTractorDT) {
		this.smallWheelTractorDT = smallWheelTractorDT;
	}
	public String getWalkingtractorNT() {
		return walkingtractorNT;
	}
	public void setWalkingtractorNT(String walkingtractorNT) {
		this.walkingtractorNT = walkingtractorNT;
	}
	public String getWalkingtractorYT() {
		return walkingtractorYT;
	}
	public void setWalkingtractorYT(String walkingtractorYT) {
		this.walkingtractorYT = walkingtractorYT;
	}
	public String getWalkingtractorDT() {
		return walkingtractorDT;
	}
	public void setWalkingtractorDT(String walkingtractorDT) {
		this.walkingtractorDT = walkingtractorDT;
	}
	public String getSmallWalkingtractorNT() {
		return smallWalkingtractorNT;
	}
	public void setSmallWalkingtractorNT(String smallWalkingtractorNT) {
		this.smallWalkingtractorNT = smallWalkingtractorNT;
	}
	public String getSmallWalkingtractorYT() {
		return smallWalkingtractorYT;
	}
	public void setSmallWalkingtractorYT(String smallWalkingtractorYT) {
		this.smallWalkingtractorYT = smallWalkingtractorYT;
	}
	public String getSmallWalkingtractorDT() {
		return smallWalkingtractorDT;
	}
	public void setSmallWalkingtractorDT(String smallWalkingtractorDT) {
		this.smallWalkingtractorDT = smallWalkingtractorDT;
	}
	public String getFourWheelTractorNT() {
		return fourWheelTractorNT;
	}
	public void setFourWheelTractorNT(String fourWheelTractorNT) {
		this.fourWheelTractorNT = fourWheelTractorNT;
	}
	public String getFourWheelTractorYT() {
		return fourWheelTractorYT;
	}
	public void setFourWheelTractorYT(String fourWheelTractorYT) {
		this.fourWheelTractorYT = fourWheelTractorYT;
	}
	public String getFourWheelTractorDT() {
		return fourWheelTractorDT;
	}
	public void setFourWheelTractorDT(String fourWheelTractorDT) {
		this.fourWheelTractorDT = fourWheelTractorDT;
	}
	public String getCrawlerTractorNT() {
		return crawlerTractorNT;
	}
	public void setCrawlerTractorNT(String crawlerTractorNT) {
		this.crawlerTractorNT = crawlerTractorNT;
	}
	public String getCrawlerTractorYT() {
		return crawlerTractorYT;
	}
	public void setCrawlerTractorYT(String crawlerTractorYT) {
		this.crawlerTractorYT = crawlerTractorYT;
	}
	public String getCrawlerTractorDT() {
		return crawlerTractorDT;
	}
	public void setCrawlerTractorDT(String crawlerTractorDT) {
		this.crawlerTractorDT = crawlerTractorDT;
	}
	public String getNoCheckAllTotal() {
		return noCheckAllTotal;
	}
	public void setNoCheckAllTotal(String noCheckAllTotal) {
		this.noCheckAllTotal = noCheckAllTotal;
	}
	public String getYesCheckAllTotal() {
		return yesCheckAllTotal;
	}
	public void setYesCheckAllTotal(String yesCheckAllTotal) {
		this.yesCheckAllTotal = yesCheckAllTotal;
	}
	public String getYearCheckAllTotal() {
		return yearCheckAllTotal;
	}
	public void setYearCheckAllTotal(String yearCheckAllTotal) {
		this.yearCheckAllTotal = yearCheckAllTotal;
	}
	public String getAnnualInspectionTotalRate() {
		return annualInspectionTotalRate;
	}
	public void setAnnualInspectionTotalRate(String annualInspectionTotalRate) {
		this.annualInspectionTotalRate = annualInspectionTotalRate;
	}
	public String getMonthCheckTotalConut() {
		return monthCheckTotalConut;
	}
	public void setMonthCheckTotalConut(String monthCheckTotalConut) {
		this.monthCheckTotalConut = monthCheckTotalConut;
	}
	public String getInspectionTotalRate() {
		return inspectionTotalRate;
	}
	public void setInspectionTotalRate(String inspectionTotalRate) {
		this.inspectionTotalRate = inspectionTotalRate;
	}
	public String getStatisticalMonth() {
		return statisticalMonth;
	}
	public void setStatisticalMonth(String statisticalMonth) {
		this.statisticalMonth = statisticalMonth;
	}
	
	
}
