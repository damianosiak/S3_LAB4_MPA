package com.damianosiak.lab4mpa.Controllers;

import com.damianosiak.lab4mpa.Services.CompanyService;
import com.damianosiak.lab4mpa.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping("/")
    String companies(Model model){
        model.addAttribute("companies",companyService.getCompanies());
        return "companies";
    }

    @RequestMapping("/random")
    String randomCompany(Model model){
        Random random = new Random();
        Company company = new Company((long) random.nextInt(99999999-11111111)+11111111,"Company"+(random.nextInt(99999999-11111111)+11111111));
        companyService.addCompanyToList(company);
        model.addAttribute("company",company);
        return "company";
    }

    @RequestMapping("/random/{amount}")
    String randomCompanies(@PathVariable("amount") Integer amount, Model model){
        List<Company> tempCompanies = new ArrayList<>();
        if(amount>1){
            Random random = new Random();
            for(int i=1;i<=amount;i++){
                Company company = new Company();
                company.setCompanyEin((long)random.nextInt(99999999-11111111)+11111111);
                company.setCompanyName("Company"+(random.nextInt(99999999-11111111)+11111111));
                companyService.addCompanyToList(company);
                tempCompanies.add(company);
            }
        }
        model.addAttribute("randomCompanies",tempCompanies);
        return "randomCompanies";
    }

    @RequestMapping("/delete/{ein}")
    RedirectView deleteCompanyByEin(@PathVariable("ein")Long ein, Model model){
        companyService.deleteCompanyFromListByCompanyEin(ein);
        return new RedirectView("/companies/");
    }

    @RequestMapping("/add/")
    String addCompany(@RequestParam(value="companyEin",required=true)Long companyEin, @RequestParam(value="companyName",required=true)String companyName, Model model){
        companyService.createCompany(companyEin,companyName);
        return companies(model);
    }

    @RequestMapping("/add")
    String addCompany(Model model){
        return "addCompany";
    }
}
