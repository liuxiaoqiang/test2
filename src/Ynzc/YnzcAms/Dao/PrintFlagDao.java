package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Certificate;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PrintFlag;

public interface PrintFlagDao {
	public boolean addPrintFlag(PrintFlag printFlag);
	public boolean DelPrintFlag(int tractroinfoId,int pintType);
	public PrintFlag GetPrintFlag(int tractorinfoId,int printType);
}
