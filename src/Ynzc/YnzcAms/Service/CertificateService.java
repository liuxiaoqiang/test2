package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Certificate;
import Ynzc.YnzcAms.Model.Page;

public interface CertificateService {
	public List<Certificate> getAllModelList(Page page,String conditions);
	public List<Certificate> getAllCertificateList();
	public Certificate findModelById(int id);
	public boolean addModel(Certificate model);
	public boolean delModel(Certificate model);
	public boolean updateModel(Certificate model);	
}
