package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterMove;
import Ynzc.YnzcAms.Model.UniteharvesterMoveView;

public interface UniteharvesterMoveService {
	public boolean addUniteharvesterMove(UniteharvesterMove uniteharvesterMove);
	public boolean delUniteharvesterMove(UniteharvesterMove uniteharvesterMove);
	public boolean updateUniteharvesterMove(UniteharvesterMove uniteharvesterMove);
	public List<UniteharvesterMoveView> getUniteharvesterMoveAll(Page page,String conditions,int userid);
}
