package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.CertificateDao;
import Ynzc.YnzcAms.Model.Certificate;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.CertificateService;

public class CertificateServiceImpl implements CertificateService {

	private CertificateDao certificateDao;
	
	public CertificateDao getCertificateDao() {
		return certificateDao;
	}

	public void setCertificateDao(CertificateDao certificateDao) {
		this.certificateDao = certificateDao;
	}

	public List<Certificate> getAllModelList(Page page, String conditions) {
		return this.certificateDao.getAllModelList(page, conditions);
	}

	public List<Certificate> getAllCertificateList() {
		return this.certificateDao.getAllModelList();
	}

	public Certificate findModelById(int id) {
		return this.certificateDao.findModelById(id);
	}

	public boolean addModel(Certificate model) {
		return this.certificateDao.addModel(model);
	}

	public boolean delModel(Certificate model) {
		return this.certificateDao.delModel(model);
	}

	public boolean updateModel(Certificate model) {
		return this.certificateDao.updateModel(model);
	}

}
