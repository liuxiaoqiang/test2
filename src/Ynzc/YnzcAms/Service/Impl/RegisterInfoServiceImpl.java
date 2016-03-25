package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.RegisterInfoDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RegisterInfo;
import Ynzc.YnzcAms.Service.RegisterInfoService;

public class RegisterInfoServiceImpl implements RegisterInfoService {
	private RegisterInfoDao registerInfoDao;

	public RegisterInfoDao getRegisterInfoDao() {
		return registerInfoDao;
	}

	public void setRegisterInfoDao(RegisterInfoDao registerInfoDao) {
		this.registerInfoDao = registerInfoDao;
	}

	public List<RegisterInfo> getAllRegisterInfoList(Page page,
			String conditions) {
		return this.registerInfoDao.getAllRegisterInfoList(page, conditions);
	}

	public RegisterInfo findRegisterInfoById(int id) {
		return this.registerInfoDao.findRegisterInfoById(id);
	}

	public boolean addRegisterInfo(RegisterInfo model) {
		return this.registerInfoDao.addRegisterInfo(model);
	}

	public boolean delRegisterInfo(RegisterInfo model) {
		return this.registerInfoDao.delRegisterInfo(model);
	}

	public boolean updateRegisterInfo(RegisterInfo model) {
		return this.registerInfoDao.updateRegisterInfo(model);
	}

	public boolean delRegisterInfoByIds(String ids) {
		return this.registerInfoDao.delRegisterInfoByIds(ids);
	}
}
