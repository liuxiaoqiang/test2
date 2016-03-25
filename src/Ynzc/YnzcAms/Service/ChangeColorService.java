package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeColor;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeColorService {
	public List<ChangeColor> getChangeColorList(Page page,String conditions);
	public List<ChangeColor> getChangeColorList();
	public ChangeColor findChangeColorById(int id);
	public boolean addChangeColor(ChangeColor model);
	public boolean delChangeColor(ChangeColor model);
	public boolean updateChangeColor(ChangeColor model);
	public boolean delChangeColorByIds(String ids);
}
