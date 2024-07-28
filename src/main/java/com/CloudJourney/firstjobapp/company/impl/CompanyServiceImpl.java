package com.CloudJourney.firstjobapp.company.impl;

import com.CloudJourney.firstjobapp.company.Company;
import com.CloudJourney.firstjobapp.company.CompanyController;
import com.CloudJourney.firstjobapp.company.CompanyRepository;
import com.CloudJourney.firstjobapp.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {


    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getallcompany() {
        return companyRepository.findAll();
    }

    @Override
    public Boolean updateCompany(Long id,Company Updatedcompany) {
        Optional<Company> optionalCompany=companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company=optionalCompany.get();
            company.setName(Updatedcompany.getName());
            company.setDescription(Updatedcompany.getDescription());
            company.setJobs(Updatedcompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void CreateCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Boolean DeleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Company GetCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }


}
