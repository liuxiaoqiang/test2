package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.MachineType;
import Ynzc.YnzcAms.Model.Page;

public interface MachineTypeService {
	
	public List<MachineType> getMachineTypeList(Page page,String conditions);
	public List<MachineType> getMachineTypeList();
	public MachineType findMachineTypeById(int id);
	public boolean addMachineType(MachineType model);
	public boolean delMachineType(MachineType model);
	public boolean updateMachineType(MachineType model);
	
}
