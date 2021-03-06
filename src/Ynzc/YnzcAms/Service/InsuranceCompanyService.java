package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.InsuranceCompany;
import Ynzc.YnzcAms.Model.Page;

public interface InsuranceCompanyService {
	public List<InsuranceCompany> getAllInsuranceCompanyList(Page page,String conditions);
	public List<InsuranceCompany> getAllInsuranceCompanyList();
	public InsuranceCompany findInsuranceCompanyById(int id);
	public boolean addInsuranceCompany(InsuranceCompany model);
	public boolean delInsuranceCompany(InsuranceCompany model);
	public boolean updateInsuranceCompany(InsuranceCompany model);
}
