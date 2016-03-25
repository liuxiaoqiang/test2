package Ynzc.YnzcAms.Dao;

import Ynzc.YnzcAms.Model.PlateOperateRecord;

public interface PlateOperateRecordDao {
	public boolean addPlateOperateRecord(PlateOperateRecord plateOperateRecord);
	public boolean DelPlateOperateRecordByReplaceRequestId(int  replaceRequestId);
}
