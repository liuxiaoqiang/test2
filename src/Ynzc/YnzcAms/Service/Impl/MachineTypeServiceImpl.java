package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.MachineTypeDao;
import Ynzc.YnzcAms.Model.MachineType;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.MachineTypeService;

public class MachineTypeServiceImpl implements MachineTypeService {
	private MachineTypeDao machineTypeDao;

	public MachineTypeDao getMachineTypeDao() {
		return machineTypeDao;
	}

	public void setMachineTypeDao(MachineTypeDao machineTypeDao) {
		this.machineTypeDao = machineTypeDao;
	}

	public List<MachineType> getMachineTypeList(Page page, String conditions) {
		return this.machineTypeDao.getMachineTypeList(page, conditions);
	}

	public List<MachineType> getMachineTypeList() {
		return this.machineTypeDao.getAllModelList();
	}

	public MachineType findMachineTypeById(int id) {
		return this.machineTypeDao.findMachineTypeById(id);
	}

	public boolean addMachineType(MachineType model) {
		return this.machineTypeDao.addMachineType(model);
	}

	public boolean delMachineType(MachineType model) {
		return this.machineTypeDao.delMachineType(model);
	}

	public boolean updateMachineType(MachineType model) {
		return this.machineTypeDao.updateMachineType(model);
	}
}
