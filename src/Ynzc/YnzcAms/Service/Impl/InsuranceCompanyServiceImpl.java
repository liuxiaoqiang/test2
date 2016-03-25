package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.InsuranceCompanyDao;
import Ynzc.YnzcAms.Model.InsuranceCompany;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.InsuranceCompanyService;

public class InsuranceCompanyServiceImpl implements InsuranceCompanyService {

	private InsuranceCompanyDao insuranceCompanyDao;

	public InsuranceCompanyDao getInsuranceCompanyDao() {
		return insuranceCompanyDao;
	}

	public void setInsuranceCompanyDao(InsuranceCompanyDao insuranceCompanyDao) {
		this.insuranceCompanyDao = insuranceCompanyDao;
	}

	public List<InsuranceCompany> getAllInsuranceCompanyList(Page page,
			String conditions) {
		return this.insuranceCompanyDao.getAllInsuranceCompanyList(page,
				conditions);
	}

	public List<InsuranceCompany> getAllInsuranceCompanyList() {
		return this.insuranceCompanyDao.getAllModelList();
	}

	public InsuranceCompany findInsuranceCompanyById(int id) {
		return this.insuranceCompanyDao.findInsuranceCompanyById(id);
	}

	public boolean addInsuranceCompany(InsuranceCompany model) {
		return this.insuranceCompanyDao.addInsuranceCompany(model);
	}

	public boolean delInsuranceCompany(InsuranceCompany model) {
		return this.insuranceCompanyDao.delInsuranceCompany(model);
	}

	public boolean updateInsuranceCompany(InsuranceCompany model) {
		return this.insuranceCompanyDao.updateInsuranceCompany(model);
	}

}
