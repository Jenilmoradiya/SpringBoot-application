package com.CloudJourney.firstjobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getallcompany();
    Boolean updateCompany(Long id, Company Updatedcompany);
    void CreateCompany(Company company);
    Boolean DeleteCompanyById(Long id);
    Company GetCompanyById(Long id);
}
