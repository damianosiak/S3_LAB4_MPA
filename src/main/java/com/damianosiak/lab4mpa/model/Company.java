package com.damianosiak.lab4mpa.model;

public class Company {
    private Long companyEin;
    private String companyName;

    public Long getCompanyEin() {
        return companyEin;
    }

    public void setCompanyEin(Long companyEin) {
        this.companyEin = companyEin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Company(Long companyEin, String companyName) {
        this.companyEin = companyEin;
        this.companyName = companyName;
    }

    public Company() {
    }
}
