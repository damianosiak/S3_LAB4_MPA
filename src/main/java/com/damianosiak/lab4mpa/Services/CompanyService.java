package com.damianosiak.lab4mpa.Services;

import com.damianosiak.lab4mpa.model.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CompanyService {
    private List<Company> companies = new ArrayList<>();

    public List<Company> getCompanies() {
        return companies;
    }

    public void createCompany(Long companyEin, String companyName){
        Company company = new Company(companyEin, companyName);
        companies.add(company);
    }

    public void addCompanyToList(Company company){
        companies.add(company);
    }

    public void deleteCompanyFromListByCompanyEin(Long ein){
        companies.removeIf(company -> (company.getCompanyEin().equals(ein)));
    }
}
