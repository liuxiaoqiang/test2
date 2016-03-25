package Ynzc.YnzcAms.Service.Manager;

import Ynzc.YnzcAms.Service.*;

public class ServiceManager {

	private BodyInfoService bodyInfoService;
	private CarChangeService carChangeService;
	private CarCheckService carCheckService;
	private CarTransferService carTransferService;
	private CertificateService certificateService;
	private ChangeBodyService changeBodyService;
	private ChangeColorService changeColorService;
	private ChangeEngineService changeEngineService;
	private ChangeOwnerService changeOwnerService;
	private ChangeRecordService changeRecordService;
	private ChangeTrailerService changeTrailerService;
	private DriverMarkService driverMarkService;
	private DriverClassInfoService driverClassInfoService;
	private DriverClassTeamService driverClassTeamService;
	private DriverStrInfoService driverStrInfoService;
	private DrivingLicenceChangeService drivingLicenceChangeService;
	private DrivingLicenceDefileService drivingLicenceDefileService;
	private DrivingLicenceGotoService drivingLicenceGotoService;
	private DrivingLicenceLogoutService drivingLicenceLogoutService;
	private DrivingLicenceRepairService drivingLicenceRepairService;
	private DrivingLicenceService drivingLicenceService;
	private DrivingLicenceShiftToService drivingLicenceShiftToService;
	private DrivingLicenceTermService drivingLicenceTermService;
	private DrivingLicenceTypeService drivingLicenceTypeService;
	private EngineBrandService engineBrandService;
	private FuelTypeService fuelTypeService;
	private GetWayService getWayService;
	private HandlingSituationService handlingSituationService;
	private ImportsFileService importsFileService;
	private InsuranceCompanyService insuranceCompanyService;
	private LoyoutService loyoutService;
	private MachineTypeService machineTypeService;
	private MenuService menuService;
	private MortgageService mortgageService;
	private NewPlateService newPlateService;
	private OwnerInfoService ownerInfoService;
	private PeopleInfoService peopleInfoService;
	private PlateService plateService;
	private PlateSubmitService plateSubmitService;
	private PracticeExamService practiceExamService;
	private RegionService regionService;
	private RegisterInfoService registerInfoService;
	private RelationInfoService relationInfoService;
	private RoleService roleService;
	private SendInfoService sendInfoService;
	private TechnicalInspectService technicalInspectService;
	private TechnicalParametersService technicalParametersService;
	private TempliveFileService templiveFileService;
	private TheoryExamService theoryExamService;
	private TractorBasicInfoService tractorBasicInfoService;
	private TractorInfoService tractorInfoService;
	private TractorInfoViewService tractorInfoViewService;
	private TractorReplacementInfoService tractorReplacementInfoService;
	private UnitManageService unitManageService;
	private UserService userService;
	private ValidateListService validateListService;
	private WayFileService wayFileService;
	private DrivertrainingService drivertrainingService;
	private DrivertrainingCheckService drivertrainingCheckService;
	private UniteharvesterChangeService uniteharvesterChangeService;
	private UniteharvesterCancleService uniteharvesterCancleService;
	private UniteharvesterMoveService uniteharvesterMoveService;
	private UniteharvesterRepairService uniteharvesterRepairService;
	private UniteharvesterService uniteharvesterService;
	private UniteharvesterCheckService uniteharvesterCheckService;
	private SetTimeService setTimeService;
	private ReaperPlateSubmitService reaperPlateSubmitService;
	private ReaperPlateService reaperPlateService;
	private NewReaperPlateService newReaperPlateService;
	private PlateHandleService plateHandleService;
    private WordSetService wordSetService;
    private PlateOperateRecordService plateOperateRecordService;
	private PrintFlagService printFlagService;
	public ReaperPlateSubmitService getReaperPlateSubmitService() {
		return reaperPlateSubmitService;
	}

	public void setReaperPlateSubmitService(
			ReaperPlateSubmitService reaperPlateSubmitService) {
		this.reaperPlateSubmitService = reaperPlateSubmitService;
	}

	public ReaperPlateService getReaperPlateService() {
		return reaperPlateService;
	}

	public void setReaperPlateService(ReaperPlateService reaperPlateService) {
		this.reaperPlateService = reaperPlateService;
	}

	public NewReaperPlateService getNewReaperPlateService() {
		return newReaperPlateService;
	}

	public void setNewReaperPlateService(NewReaperPlateService newReaperPlateService) {
		this.newReaperPlateService = newReaperPlateService;
	}

	public SetTimeService getSetTimeService() {
		return setTimeService;
	}

	public void setSetTimeService(SetTimeService setTimeService) {
		this.setTimeService = setTimeService;
	}

	public BodyInfoService getBodyInfoService() {
		return bodyInfoService;
	}

	public void setBodyInfoService(BodyInfoService bodyInfoService) {
		this.bodyInfoService = bodyInfoService;
	}

	public CarChangeService getCarChangeService() {
		return carChangeService;
	}

	public void setCarChangeService(CarChangeService carChangeService) {
		this.carChangeService = carChangeService;
	}

	public CarCheckService getCarCheckService() {
		return carCheckService;
	}

	public void setCarCheckService(CarCheckService carCheckService) {
		this.carCheckService = carCheckService;
	}

	public CarTransferService getCarTransferService() {
		return carTransferService;
	}

	public void setCarTransferService(CarTransferService carTransferService) {
		this.carTransferService = carTransferService;
	}

	public CertificateService getCertificateService() {
		return certificateService;
	}

	public void setCertificateService(CertificateService certificateService) {
		this.certificateService = certificateService;
	}

	public ChangeBodyService getChangeBodyService() {
		return changeBodyService;
	}

	public void setChangeBodyService(ChangeBodyService changeBodyService) {
		this.changeBodyService = changeBodyService;
	}

	public ChangeColorService getChangeColorService() {
		return changeColorService;
	}

	public void setChangeColorService(ChangeColorService changeColorService) {
		this.changeColorService = changeColorService;
	}

	public ChangeEngineService getChangeEngineService() {
		return changeEngineService;
	}

	public void setChangeEngineService(ChangeEngineService changeEngineService) {
		this.changeEngineService = changeEngineService;
	}

	public ChangeOwnerService getChangeOwnerService() {
		return changeOwnerService;
	}

	public void setChangeOwnerService(ChangeOwnerService changeOwnerService) {
		this.changeOwnerService = changeOwnerService;
	}

	public ChangeRecordService getChangeRecordService() {
		return changeRecordService;
	}

	public void setChangeRecordService(ChangeRecordService changeRecordService) {
		this.changeRecordService = changeRecordService;
	}

	public ChangeTrailerService getChangeTrailerService() {
		return changeTrailerService;
	}

	public void setChangeTrailerService(
			ChangeTrailerService changeTrailerService) {
		this.changeTrailerService = changeTrailerService;
	}

	public DriverMarkService getDriverMarkService() {
		return driverMarkService;
	}

	public void setDriverMarkService(DriverMarkService driverMarkService) {
		this.driverMarkService = driverMarkService;
	}

	public DriverClassInfoService getDriverClassInfoService() {
		return driverClassInfoService;
	}

	public void setDriverClassInfoService(
			DriverClassInfoService driverClassInfoService) {
		this.driverClassInfoService = driverClassInfoService;
	}

	public DriverClassTeamService getDriverClassTeamService() {
		return driverClassTeamService;
	}

	public void setDriverClassTeamService(
			DriverClassTeamService driverClassTeamService) {
		this.driverClassTeamService = driverClassTeamService;
	}

	public DriverStrInfoService getDriverStrInfoService() {
		return driverStrInfoService;
	}

	public void setDriverStrInfoService(
			DriverStrInfoService driverStrInfoService) {
		this.driverStrInfoService = driverStrInfoService;
	}

	public DrivingLicenceChangeService getDrivingLicenceChangeService() {
		return drivingLicenceChangeService;
	}

	public void setDrivingLicenceChangeService(
			DrivingLicenceChangeService drivingLicenceChangeService) {
		this.drivingLicenceChangeService = drivingLicenceChangeService;
	}

	public DrivingLicenceDefileService getDrivingLicenceDefileService() {
		return drivingLicenceDefileService;
	}

	public void setDrivingLicenceDefileService(
			DrivingLicenceDefileService drivingLicenceDefileService) {
		this.drivingLicenceDefileService = drivingLicenceDefileService;
	}

	public DrivingLicenceGotoService getDrivingLicenceGotoService() {
		return drivingLicenceGotoService;
	}

	public void setDrivingLicenceGotoService(
			DrivingLicenceGotoService drivingLicenceGotoService) {
		this.drivingLicenceGotoService = drivingLicenceGotoService;
	}

	public DrivingLicenceLogoutService getDrivingLicenceLogoutService() {
		return drivingLicenceLogoutService;
	}

	public void setDrivingLicenceLogoutService(
			DrivingLicenceLogoutService drivingLicenceLogoutService) {
		this.drivingLicenceLogoutService = drivingLicenceLogoutService;
	}

	public DrivingLicenceRepairService getDrivingLicenceRepairService() {
		return drivingLicenceRepairService;
	}

	public void setDrivingLicenceRepairService(
			DrivingLicenceRepairService drivingLicenceRepairService) {
		this.drivingLicenceRepairService = drivingLicenceRepairService;
	}

	public DrivingLicenceService getDrivingLicenceService() {
		return drivingLicenceService;
	}

	public void setDrivingLicenceService(
			DrivingLicenceService drivingLicenceService) {
		this.drivingLicenceService = drivingLicenceService;
	}

	public DrivingLicenceShiftToService getDrivingLicenceShiftToService() {
		return drivingLicenceShiftToService;
	}

	public void setDrivingLicenceShiftToService(
			DrivingLicenceShiftToService drivingLicenceShiftToService) {
		this.drivingLicenceShiftToService = drivingLicenceShiftToService;
	}

	public DrivingLicenceTermService getDrivingLicenceTermService() {
		return drivingLicenceTermService;
	}

	public void setDrivingLicenceTermService(
			DrivingLicenceTermService drivingLicenceTermService) {
		this.drivingLicenceTermService = drivingLicenceTermService;
	}

	public DrivingLicenceTypeService getDrivingLicenceTypeService() {
		return drivingLicenceTypeService;
	}

	public void setDrivingLicenceTypeService(
			DrivingLicenceTypeService drivingLicenceTypeService) {
		this.drivingLicenceTypeService = drivingLicenceTypeService;
	}

	public EngineBrandService getEngineBrandService() {
		return engineBrandService;
	}

	public void setEngineBrandService(EngineBrandService engineBrandService) {
		this.engineBrandService = engineBrandService;
	}

	public FuelTypeService getFuelTypeService() {
		return fuelTypeService;
	}

	public void setFuelTypeService(FuelTypeService fuelTypeService) {
		this.fuelTypeService = fuelTypeService;
	}

	public GetWayService getGetWayService() {
		return getWayService;
	}

	public void setGetWayService(GetWayService getWayService) {
		this.getWayService = getWayService;
	}

	public HandlingSituationService getHandlingSituationService() {
		return handlingSituationService;
	}

	public void setHandlingSituationService(
			HandlingSituationService handlingSituationService) {
		this.handlingSituationService = handlingSituationService;
	}

	public ImportsFileService getImportsFileService() {
		return importsFileService;
	}

	public void setImportsFileService(ImportsFileService importsFileService) {
		this.importsFileService = importsFileService;
	}

	public InsuranceCompanyService getInsuranceCompanyService() {
		return insuranceCompanyService;
	}

	public void setInsuranceCompanyService(
			InsuranceCompanyService insuranceCompanyService) {
		this.insuranceCompanyService = insuranceCompanyService;
	}

	public LoyoutService getLoyoutService() {
		return loyoutService;
	}

	public void setLoyoutService(LoyoutService loyoutService) {
		this.loyoutService = loyoutService;
	}

	public MachineTypeService getMachineTypeService() {
		return machineTypeService;
	}

	public void setMachineTypeService(MachineTypeService machineTypeService) {
		this.machineTypeService = machineTypeService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public MortgageService getMortgageService() {
		return mortgageService;
	}

	public void setMortgageService(MortgageService mortgageService) {
		this.mortgageService = mortgageService;
	}

	public NewPlateService getNewPlateService() {
		return newPlateService;
	}

	public void setNewPlateService(NewPlateService newPlateService) {
		this.newPlateService = newPlateService;
	}

	public OwnerInfoService getOwnerInfoService() {
		return ownerInfoService;
	}

	public void setOwnerInfoService(OwnerInfoService ownerInfoService) {
		this.ownerInfoService = ownerInfoService;
	}

	public PeopleInfoService getPeopleInfoService() {
		return peopleInfoService;
	}

	public void setPeopleInfoService(PeopleInfoService peopleInfoService) {
		this.peopleInfoService = peopleInfoService;
	}

	public PlateService getPlateService() {
		return plateService;
	}

	public void setPlateService(PlateService plateService) {
		this.plateService = plateService;
	}

	public PlateSubmitService getPlateSubmitService() {
		return plateSubmitService;
	}

	public void setPlateSubmitService(PlateSubmitService plateSubmitService) {
		this.plateSubmitService = plateSubmitService;
	}

	public PracticeExamService getPracticeExamService() {
		return practiceExamService;
	}

	public void setPracticeExamService(PracticeExamService practiceExamService) {
		this.practiceExamService = practiceExamService;
	}

	public RegionService getRegionService() {
		return regionService;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	public RegisterInfoService getRegisterInfoService() {
		return registerInfoService;
	}

	public void setRegisterInfoService(RegisterInfoService registerInfoService) {
		this.registerInfoService = registerInfoService;
	}

	public RelationInfoService getRelationInfoService() {
		return relationInfoService;
	}

	public void setRelationInfoService(RelationInfoService relationInfoService) {
		this.relationInfoService = relationInfoService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public SendInfoService getSendInfoService() {
		return sendInfoService;
	}

	public void setSendInfoService(SendInfoService sendInfoService) {
		this.sendInfoService = sendInfoService;
	}

	public TechnicalInspectService getTechnicalInspectService() {
		return technicalInspectService;
	}

	public void setTechnicalInspectService(
			TechnicalInspectService technicalInspectService) {
		this.technicalInspectService = technicalInspectService;
	}

	public TechnicalParametersService getTechnicalParametersService() {
		return technicalParametersService;
	}

	public void setTechnicalParametersService(
			TechnicalParametersService technicalParametersService) {
		this.technicalParametersService = technicalParametersService;
	}

	public TempliveFileService getTempliveFileService() {
		return templiveFileService;
	}

	public void setTempliveFileService(TempliveFileService templiveFileService) {
		this.templiveFileService = templiveFileService;
	}

	public TheoryExamService getTheoryExamService() {
		return theoryExamService;
	}

	public void setTheoryExamService(TheoryExamService theoryExamService) {
		this.theoryExamService = theoryExamService;
	}

	public TractorBasicInfoService getTractorBasicInfoService() {
		return tractorBasicInfoService;
	}

	public void setTractorBasicInfoService(
			TractorBasicInfoService tractorBasicInfoService) {
		this.tractorBasicInfoService = tractorBasicInfoService;
	}

	public TractorInfoService getTractorInfoService() {
		return tractorInfoService;
	}

	public void setTractorInfoService(TractorInfoService tractorInfoService) {
		this.tractorInfoService = tractorInfoService;
	}

	public TractorInfoViewService getTractorInfoViewService() {
		return tractorInfoViewService;
	}

	public void setTractorInfoViewService(
			TractorInfoViewService tractorInfoViewService) {
		this.tractorInfoViewService = tractorInfoViewService;
	}

	public TractorReplacementInfoService getTractorReplacementInfoService() {
		return tractorReplacementInfoService;
	}

	public void setTractorReplacementInfoService(
			TractorReplacementInfoService tractorReplacementInfoService) {
		this.tractorReplacementInfoService = tractorReplacementInfoService;
	}

	public UnitManageService getUnitManageService() {
		return unitManageService;
	}

	public void setUnitManageService(UnitManageService unitManageService) {
		this.unitManageService = unitManageService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ValidateListService getValidateListService() {
		return validateListService;
	}

	public void setValidateListService(ValidateListService validateListService) {
		this.validateListService = validateListService;
	}

	public WayFileService getWayFileService() {
		return wayFileService;
	}

	public void setWayFileService(WayFileService wayFileService) {
		this.wayFileService = wayFileService;
	}

	public DrivertrainingService getDrivertrainingService() {
		return drivertrainingService;
	}

	public void setDrivertrainingService(
			DrivertrainingService drivertrainingService) {
		this.drivertrainingService = drivertrainingService;
	}

	public DrivertrainingCheckService getDrivertrainingCheckService() {
		return drivertrainingCheckService;
	}

	public void setDrivertrainingCheckService(
			DrivertrainingCheckService drivertrainingCheckService) {
		this.drivertrainingCheckService = drivertrainingCheckService;
	}

	public UniteharvesterChangeService getUniteharvesterChangeService() {
		return uniteharvesterChangeService;
	}

	public void setUniteharvesterChangeService(
			UniteharvesterChangeService uniteharvesterChangeService) {
		this.uniteharvesterChangeService = uniteharvesterChangeService;
	}

	public UniteharvesterCancleService getUniteharvesterCancleService() {
		return uniteharvesterCancleService;
	}

	public void setUniteharvesterCancleService(
			UniteharvesterCancleService uniteharvesterCancleService) {
		this.uniteharvesterCancleService = uniteharvesterCancleService;
	}

	public UniteharvesterMoveService getUniteharvesterMoveService() {
		return uniteharvesterMoveService;
	}

	public void setUniteharvesterMoveService(
			UniteharvesterMoveService uniteharvesterMoveService) {
		this.uniteharvesterMoveService = uniteharvesterMoveService;
	}

	public UniteharvesterRepairService getUniteharvesterRepairService() {
		return uniteharvesterRepairService;
	}

	public void setUniteharvesterRepairService(
			UniteharvesterRepairService uniteharvesterRepairService) {
		this.uniteharvesterRepairService = uniteharvesterRepairService;
	}

	public UniteharvesterService getUniteharvesterService() {
		return uniteharvesterService;
	}

	public void setUniteharvesterService(
			UniteharvesterService uniteharvesterService) {
		this.uniteharvesterService = uniteharvesterService;
	}

	public UniteharvesterCheckService getUniteharvesterCheckService() {
		return uniteharvesterCheckService;
	}

	public void setUniteharvesterCheckService(
			UniteharvesterCheckService uniteharvesterCheckService) {
		this.uniteharvesterCheckService = uniteharvesterCheckService;
	}

	public PlateHandleService getPlateHandleService() {
		return plateHandleService;
	}

	public void setPlateHandleService(PlateHandleService plateHandleService) {
		this.plateHandleService = plateHandleService;
	}

	public WordSetService getWordSetService() {
		return wordSetService;
	}

	public void setWordSetService(WordSetService wordSetService) {
		this.wordSetService = wordSetService;
	}

	public PlateOperateRecordService getPlateOperateRecordService() {
		return plateOperateRecordService;
	}

	public void setPlateOperateRecordService(
			PlateOperateRecordService plateOperateRecordService) {
		this.plateOperateRecordService = plateOperateRecordService;
	}

	public PrintFlagService getPrintFlagService() {
		return printFlagService;
	}

	public void setPrintFlagService(PrintFlagService printFlagService) {
		this.printFlagService = printFlagService;
	}
	
}