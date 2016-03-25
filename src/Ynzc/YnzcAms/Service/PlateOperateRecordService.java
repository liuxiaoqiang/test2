package Ynzc.YnzcAms.Service;

import Ynzc.YnzcAms.Model.PlateOperateRecord;

public interface PlateOperateRecordService {
	public boolean addPlateOperateRecord(PlateOperateRecord plateOperateRecord);
	public boolean DelPlateOperateRecordByReplaceRequestId(int  replaceRequestId);
}
