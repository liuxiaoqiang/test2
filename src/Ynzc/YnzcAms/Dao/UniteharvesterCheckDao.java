package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterCheck;
import Ynzc.YnzcAms.Model.UniteharvesterCheckView;

public interface UniteharvesterCheckDao {
	public boolean addUniteharvesterCheck(UniteharvesterCheck uniteharvesterCheck);
	public boolean delUniteharvesterCheck(UniteharvesterCheck uniteharvesterCheck);
	public boolean updateUniteharvesterCheck(UniteharvesterCheck uniteharvesterCheck);
	public List<UniteharvesterCheckView> getUniteharvesterCheckAll(Page page,String conditions,int userid);
}
