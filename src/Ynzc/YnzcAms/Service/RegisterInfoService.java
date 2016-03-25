package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RegisterInfo;

public interface RegisterInfoService {
	public List<RegisterInfo> getAllRegisterInfoList(Page page,String conditions);
	public RegisterInfo findRegisterInfoById(int id);
	public boolean addRegisterInfo(RegisterInfo model);
	public boolean delRegisterInfo(RegisterInfo model);
	public boolean updateRegisterInfo(RegisterInfo model);
	public boolean delRegisterInfoByIds(String ids);
}
