package Ynzc.YnzcAms.Model;
/**
 * 验证目录
 * @author zy
 * @date 2011-04-18
 * class ValidateList.java
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_validatelist")
public class ValidateList {
	private int id;//ID
	private String dirNo;//目录编号
	private Date registerDate;//注册日期
	private String machineType;//厂牌型号
	private String machineNo;//厂牌识别号
	private String productor;//生产企业
	private String carColor;//车色
	private String license;//许可证号
	private String productorAddress;//企业地址
	private String productorPost;//企业邮编
	private String productorSeller;//销售商
	private String productorTel;//企业电话
	private String sellerTelephone;//销售商电话
	private String photoDir;//图片路径
	private String setRow;//排数
	private String isAuto;//装卸
	private String shapeSize;//外形尺寸
	private String containerSize;//货箱尺寸
	private String axisSize;//轴距
	private String power;//功率
	private String wheelSize;//轮距
	private String drivers;//驱动类型
	private String directControl;//转向类型
	private String topSpeed;//最高时速
	private int fuelTypeId;//燃油类型Id
	private String fuelCost;//燃油消耗
	private String wheelNo;//轮数
	private int allQuality;//整备质量
	private String tiresSize;//轮胎规格
	private int totalQuality;//总质量
	private int loadQuality;//载质量
	private int driverInNo;//驾驶室人数
	private String tilt;//倾斜角
	private int engineBrandId;//发动机品牌Id
	private int steelSpring;//钢板弹簧片数
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDirNo() {
		return dirNo;
	}
	public void setDirNo(String dirNo) {
		this.dirNo = dirNo;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getMachineNo() {
		return machineNo;
	}
	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getProductorAddress() {
		return productorAddress;
	}
	public void setProductorAddress(String productorAddress) {
		this.productorAddress = productorAddress;
	}
	public String getProductorPost() {
		return productorPost;
	}
	public void setProductorPost(String productorPost) {
		this.productorPost = productorPost;
	}
	public String getProductorSeller() {
		return productorSeller;
	}
	public void setProductorSeller(String productorSeller) {
		this.productorSeller = productorSeller;
	}
	public String getProductorTel() {
		return productorTel;
	}
	public void setProductorTel(String productorTel) {
		this.productorTel = productorTel;
	}
	public String getSellerTelephone() {
		return sellerTelephone;
	}
	public void setSellerTelephone(String sellerTelephone) {
		this.sellerTelephone = sellerTelephone;
	}
	public String getPhotoDir() {
		return photoDir;
	}
	public void setPhotoDir(String photoDir) {
		this.photoDir = photoDir;
	}
	public String getSetRow() {
		return setRow;
	}
	public void setSetRow(String setRow) {
		this.setRow = setRow;
	}
	public String getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(String isAuto) {
		this.isAuto = isAuto;
	}
	public String getShapeSize() {
		return shapeSize;
	}
	public void setShapeSize(String shapeSize) {
		this.shapeSize = shapeSize;
	}
	public String getContainerSize() {
		return containerSize;
	}
	public void setContainerSize(String containerSize) {
		this.containerSize = containerSize;
	}
	public String getAxisSize() {
		return axisSize;
	}
	public void setAxisSize(String axisSize) {
		this.axisSize = axisSize;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getWheelSize() {
		return wheelSize;
	}
	public void setWheelSize(String wheelSize) {
		this.wheelSize = wheelSize;
	}
	public String getDrivers() {
		return drivers;
	}
	public void setDrivers(String drivers) {
		this.drivers = drivers;
	}
	public String getDirectControl() {
		return directControl;
	}
	public void setDirectControl(String directControl) {
		this.directControl = directControl;
	}
	public String getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(String topSpeed) {
		this.topSpeed = topSpeed;
	}
	public int getFuelTypeId() {
		return fuelTypeId;
	}
	public void setFuelTypeId(int fuelTypeId) {
		this.fuelTypeId = fuelTypeId;
	}
	public String getFuelCost() {
		return fuelCost;
	}
	public void setFuelCost(String fuelCost) {
		this.fuelCost = fuelCost;
	}
	public String getWheelNo() {
		return wheelNo;
	}
	public void setWheelNo(String wheelNo) {
		this.wheelNo = wheelNo;
	}
	public int getAllQuality() {
		return allQuality;
	}
	public void setAllQuality(int allQuality) {
		this.allQuality = allQuality;
	}
	public String getTiresSize() {
		return tiresSize;
	}
	public void setTiresSize(String tiresSize) {
		this.tiresSize = tiresSize;
	}
	public int getTotalQuality() {
		return totalQuality;
	}
	public void setTotalQuality(int totalQuality) {
		this.totalQuality = totalQuality;
	}
	public int getLoadQuality() {
		return loadQuality;
	}
	public void setLoadQuality(int loadQuality) {
		this.loadQuality = loadQuality;
	}
	public int getDriverInNo() {
		return driverInNo;
	}
	public void setDriverInNo(int driverInNo) {
		this.driverInNo = driverInNo;
	}
	public String getTilt() {
		return tilt;
	}
	public void setTilt(String tilt) {
		this.tilt = tilt;
	}
	public int getEngineBrandId() {
		return engineBrandId;
	}
	public void setEngineBrandId(int engineBrandId) {
		this.engineBrandId = engineBrandId;
	}
	public int getSteelSpring() {
		return steelSpring;
	}
	public void setSteelSpring(int steelSpring) {
		this.steelSpring = steelSpring;
	}
}
