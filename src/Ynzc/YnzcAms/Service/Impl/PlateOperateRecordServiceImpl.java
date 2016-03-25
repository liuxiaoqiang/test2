package Ynzc.YnzcAms.Service.Impl;

import Ynzc.YnzcAms.Model.PlateOperateRecord;
import Ynzc.YnzcAms.Service.PlateOperateRecordService;
import Ynzc.YnzcAms.Dao.PlateOperateRecordDao;

public class PlateOperateRecordServiceImpl implements PlateOperateRecordService {

	private PlateOperateRecordDao plateOperateRecordDao;
	public PlateOperateRecordDao getPlateOperateRecordDao() {
		return plateOperateRecordDao;
	}

	public void setPlateOperateRecordDao(PlateOperateRecordDao plateOperateRecordDao) {
		this.plateOperateRecordDao = plateOperateRecordDao;
	}
	public boolean addPlateOperateRecord(PlateOperateRecord plateOperateRecord) {
		// TODO Auto-generated method stub
		return plateOperateRecordDao.addPlateOperateRecord(plateOperateRecord);
	}


	public boolean DelPlateOperateRecordByReplaceRequestId(int  replaceRequestId){
		return plateOperateRecordDao.DelPlateOperateRecordByReplaceRequestId(replaceRequestId);
	}
}
