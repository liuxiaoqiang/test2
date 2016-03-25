package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Uniteharvester;
import Ynzc.YnzcAms.Model.UniteharvesterView;

public interface UniteharvesterService {
	public boolean addUniteharvester(Uniteharvester uniteharvester);
	public boolean saveUniteharvester(Uniteharvester uniteharvester);
	public boolean delUniteharvester(Uniteharvester uniteharvester);
	public boolean updateUniteharvester(Uniteharvester uniteharvester);
	public List<UniteharvesterView> getUniteharvesterViewAll(Page page,String conditions,int userid);
	public Uniteharvester findUniteharvesterById(int id);
	public UniteharvesterView findUniteharvesterByCarNum(String carnum,int userid);
	public UniteharvesterView findUniteharvesterViewById(int id);
}
