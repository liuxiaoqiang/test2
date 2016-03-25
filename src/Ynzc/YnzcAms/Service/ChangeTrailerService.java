package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeTrailer;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeTrailerService {
	public List<ChangeTrailer> getChangeTrailerList(Page page,String conditions);
	public List<ChangeTrailer> getChangeTrailerList();
	public ChangeTrailer findChangeTrailerById(int id);
	public boolean addChangeTrailer(ChangeTrailer model);
	public boolean delChangeTrailer(ChangeTrailer model);
	public boolean updateChangeTrailer(ChangeTrailer model);
	public boolean delChangeTrailerByIds(String ids);
}
