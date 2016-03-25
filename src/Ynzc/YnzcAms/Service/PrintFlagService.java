package Ynzc.YnzcAms.Service;

import Ynzc.YnzcAms.Model.PrintFlag;

public interface PrintFlagService {
	public boolean addPrintFlag(PrintFlag printFlag);
	public boolean DelPrintFlag(int tractroinfoId,int pintType);
	public PrintFlag GetPrintFlag(int tractorinfoId,int printType);
}
