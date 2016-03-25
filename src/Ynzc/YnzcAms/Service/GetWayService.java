package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.GetWay;
import Ynzc.YnzcAms.Model.Page;

public interface GetWayService {
	public List<GetWay> getAllGetWayList(Page page,String conditions);
	public List<GetWay> getAllGetWayList();
	public GetWay findGetWayById(int id);
	public boolean addGetWay(GetWay model);
	public boolean delGetWay(GetWay model);
	public boolean updateGetWay(GetWay model);	
}
