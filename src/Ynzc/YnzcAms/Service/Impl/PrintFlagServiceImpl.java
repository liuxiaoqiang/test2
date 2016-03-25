package Ynzc.YnzcAms.Service.Impl;

import Ynzc.YnzcAms.Model.PrintFlag;
import Ynzc.YnzcAms.Service.PrintFlagService;
import Ynzc.YnzcAms.Dao.PrintFlagDao;
public class PrintFlagServiceImpl implements PrintFlagService {

	private PrintFlagDao printFlagDao;
	public PrintFlagDao getPrintFlagDao() {
		return printFlagDao;
	}

	public void setPrintFlagDao(PrintFlagDao printFlagDao) {
		this.printFlagDao = printFlagDao;
	}
	public boolean addPrintFlag(PrintFlag printFlag) {
		// TODO Auto-generated method stub
		return printFlagDao.addPrintFlag(printFlag);
	}
	public boolean DelPrintFlag(int tractroinfoId,int pintType){
		return printFlagDao.DelPrintFlag(tractroinfoId, pintType);
	}
	public PrintFlag GetPrintFlag(int tractorinfoId,int printType){
		return printFlagDao.GetPrintFlag(tractorinfoId, printType);
	}

}
