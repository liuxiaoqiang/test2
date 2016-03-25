package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.SendInfoDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.SendInformation;
import Ynzc.YnzcAms.Service.SendInfoService;

public class SendInfoServiceImpl implements SendInfoService {
	private SendInfoDao sendInfoDao;

	public SendInfoDao getSendInfoDao() {
		return sendInfoDao;
	}

	public void setSendInfoDao(SendInfoDao sendInfoDao) {
		this.sendInfoDao = sendInfoDao;
	}

	public List<SendInformation> getSendInfoAll(Page page, String conditions,
			int userid) {
		// TODO Auto-generated method stub
		return sendInfoDao.getSendInfoAll(page, conditions, userid);
	}

	public boolean delSendInfo(SendInformation sendInfomation) {
		// TODO Auto-generated method stub
		return sendInfoDao.delSendInfo(sendInfomation);
	}

	public boolean updateSendInformation(SendInformation sendInfomation) {
		// TODO Auto-generated method stub
		return sendInfoDao.updateSendInformation(sendInfomation);
	}

	public boolean addSendInfomation(SendInformation sendInfomation) {
		// TODO Auto-generated method stub
		return sendInfoDao.addSendInfomation(sendInfomation);
	}

	public List<SendInformation> getSendInfoNewsAll(Page page, String conditions) {
		// TODO Auto-generated method stub
		return sendInfoDao.getSendInfoNewsAll(page, conditions);
	}

	public List<SendInformation> getSendInfoMessageAll(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		return sendInfoDao.getSendInfoMessageAll(page, conditions);
	}

	public List<SendInformation> getSendInfoMessageIdList(int id) {
		// TODO Auto-generated method stub
		return sendInfoDao.getSendInfoMessageIdList(id);
	}

	public boolean delReply(int themeid) {
		// TODO Auto-generated method stub
		return sendInfoDao.delReply(themeid);
	}
}
