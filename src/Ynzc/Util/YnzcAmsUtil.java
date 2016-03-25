package Ynzc.Util;

public class YnzcAmsUtil {
	public static String findDrivingLicenceType(int type){
		String[] typeName = new String[]{"G","H","GK","HK","K","R","S","T","RS","RT","RK","KS","RG","ST","GS","GKR","KGS"};
		return typeName[type-1];
	}
}
