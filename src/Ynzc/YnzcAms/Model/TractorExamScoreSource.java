package Ynzc.YnzcAms.Model;

public class TractorExamScoreSource {
	//拖 拉 机 驾 驶 人 考 试 成 绩 表
	//ynzc_peopleInfo
	private String peopleName;//名字
	private String sex;//性别
	private String linkTel;//联系电话
	//ynzc_driverStrInfo
	private String archivesNo;//档案号
	private String drivingLicenceTypeId;//申请型号
	private String examinationCode;//报考号
	//ynzc_theoryExam
	private String theoryResult;//考试成绩
	private String examinerOne;//主考人
	private String theoryDate;//正考时间
	private String makeupResult;//补考成绩
	private String makeupExaminerOne;//补考主考人
	private String makeupDate;//补考时间
	//ynzc_practiceExam
	private String fieldResult;//场地考试成绩
	private String examinerFieldOne;//场地主考人
	private String examinerFieldDate;//场地考试日期
	private String examinerMakeupFieldOne;//场地主考人（补）
	private String makeupFieldDate;//场地补考日期
	private String machineResult;//作业考试成绩
	private String examinerMachineOne;//作业主考人
	private String machineDate;//作业考试日期
	private String makeupMachineResult;//作业补考成绩
	private String examinerMakeupMachineOne;//作业主考人（补）
	private String makeupMachineDate;//作业补考日期
	private String roadResult;//公路考试成绩
	private String examinerRoadOne;//公路主考人
	private String roadDate;//公路考试日期
	private String makeupRoadResult;//公路补考成绩
	private String examinerMakeupRoadOne;//公路主考人（补）
	private String makeupRoadDate;//公路补考日期
	
	private String makeupfieldResult;//场地考试补考成绩
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getExaminationCode() {
		return examinationCode;
	}
	public void setExaminationCode(String examinationCode) {
		this.examinationCode = examinationCode;
	}
	public String getDrivingLicenceTypeId() {
		return drivingLicenceTypeId;
	}
	public void setDrivingLicenceTypeId(String drivingLicenceTypeId) {
		this.drivingLicenceTypeId = drivingLicenceTypeId;
	}
	public String getTheoryResult() {
		return theoryResult;
	}
	public void setTheoryResult(String theoryResult) {
		this.theoryResult = theoryResult;
	}
	public String getExaminerOne() {
		return examinerOne;
	}
	public void setExaminerOne(String examinerOne) {
		this.examinerOne = examinerOne;
	}
	public String getTheoryDate() {
		return theoryDate;
	}
	public void setTheoryDate(String theoryDate) {
		this.theoryDate = theoryDate;
	}
	public String getMakeupResult() {
		return makeupResult;
	}
	public void setMakeupResult(String makeupResult) {
		this.makeupResult = makeupResult;
	}
	public String getMakeupExaminerOne() {
		return makeupExaminerOne;
	}
	public void setMakeupExaminerOne(String makeupExaminerOne) {
		this.makeupExaminerOne = makeupExaminerOne;
	}
	public String getMakeupDate() {
		return makeupDate;
	}
	public void setMakeupDate(String makeupDate) {
		this.makeupDate = makeupDate;
	}
	public String getFieldResult() {
		return fieldResult;
	}
	public void setFieldResult(String fieldResult) {
		this.fieldResult = fieldResult;
	}
	public String getExaminerFieldOne() {
		return examinerFieldOne;
	}
	public void setExaminerFieldOne(String examinerFieldOne) {
		this.examinerFieldOne = examinerFieldOne;
	}
	public String getExaminerFieldDate() {
		return examinerFieldDate;
	}
	public void setExaminerFieldDate(String examinerFieldDate) {
		this.examinerFieldDate = examinerFieldDate;
	}
	public String getMakeupfieldResult() {
		return makeupfieldResult;
	}
	public void setMakeupfieldResult(String makeupfieldResult) {
		this.makeupfieldResult = makeupfieldResult;
	}
	public String getExaminerMakeupFieldOne() {
		return examinerMakeupFieldOne;
	}
	public void setExaminerMakeupFieldOne(String examinerMakeupFieldOne) {
		this.examinerMakeupFieldOne = examinerMakeupFieldOne;
	}
	public String getMakeupFieldDate() {
		return makeupFieldDate;
	}
	public void setMakeupFieldDate(String makeupFieldDate) {
		this.makeupFieldDate = makeupFieldDate;
	}
	public String getMachineResult() {
		return machineResult;
	}
	public void setMachineResult(String machineResult) {
		this.machineResult = machineResult;
	}
	public String getExaminerMachineOne() {
		return examinerMachineOne;
	}
	public void setExaminerMachineOne(String examinerMachineOne) {
		this.examinerMachineOne = examinerMachineOne;
	}
	public String getMachineDate() {
		return machineDate;
	}
	public void setMachineDate(String machineDate) {
		this.machineDate = machineDate;
	}
	public String getMakeupMachineResult() {
		return makeupMachineResult;
	}
	public void setMakeupMachineResult(String makeupMachineResult) {
		this.makeupMachineResult = makeupMachineResult;
	}
	public String getExaminerMakeupMachineOne() {
		return examinerMakeupMachineOne;
	}
	public void setExaminerMakeupMachineOne(String examinerMakeupMachineOne) {
		this.examinerMakeupMachineOne = examinerMakeupMachineOne;
	}
	public String getMakeupMachineDate() {
		return makeupMachineDate;
	}
	public void setMakeupMachineDate(String makeupMachineDate) {
		this.makeupMachineDate = makeupMachineDate;
	}
	public String getRoadResult() {
		return roadResult;
	}
	public void setRoadResult(String roadResult) {
		this.roadResult = roadResult;
	}
	public String getExaminerRoadOne() {
		return examinerRoadOne;
	}
	public void setExaminerRoadOne(String examinerRoadOne) {
		this.examinerRoadOne = examinerRoadOne;
	}
	public String getRoadDate() {
		return roadDate;
	}
	public void setRoadDate(String roadDate) {
		this.roadDate = roadDate;
	}
	public String getMakeupRoadResult() {
		return makeupRoadResult;
	}
	public void setMakeupRoadResult(String makeupRoadResult) {
		this.makeupRoadResult = makeupRoadResult;
	}
	public String getExaminerMakeupRoadOne() {
		return examinerMakeupRoadOne;
	}
	public void setExaminerMakeupRoadOne(String examinerMakeupRoadOne) {
		this.examinerMakeupRoadOne = examinerMakeupRoadOne;
	}
	public String getMakeupRoadDate() {
		return makeupRoadDate;
	}
	public void setMakeupRoadDate(String makeupRoadDate) {
		this.makeupRoadDate = makeupRoadDate;
	}

}
