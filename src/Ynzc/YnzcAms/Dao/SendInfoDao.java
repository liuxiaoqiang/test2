package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.SendInformation;

public interface SendInfoDao {
	public List<SendInformation> getSendInfoAll(Page page,String conditions,int userid);
	public boolean delSendInfo(SendInformation sendInfomation);
	public boolean updateSendInformation(SendInformation sendInfomation);
	public boolean addSendInfomation(SendInformation sendInfomation);
	public List<SendInformation> getSendInfoNewsAll(Page page,String conditions);
	public List<SendInformation> getSendInfoMessageAll(Page page,String conditions);
	public List<SendInformation> getSendInfoMessageIdList(int id);
	public boolean delReply(int themeid);
}
