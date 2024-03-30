package com.JobSearch.JobSearchingSite.CompanyInfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.CoderMalfunctionError;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepostory  repo;

    public List<CompanyModel> getAllCompany() {
        return repo.findAll();
    }


    public String addCompany(CompanyModel company) {
        repo.save(company);
        return "Added Successfully";
    }

    public boolean findCompany(CompanyModel company) {
        List<CompanyModel> companies = repo.findAll();

        for(CompanyModel com : companies){
            if(com.getEmail().equals(company.getEmail())){
                return true;
            }
        }
        return false;
    }

    public CompanyModel findandGetcompany(CompanyModel company) {
        List<CompanyModel> companies = repo.findAll();

        for(CompanyModel com : companies){
            if(com.getEmail().equals(company.getEmail()) && com.getPassword().equals(company.getPassword())){
                return com;
            }
        }
        return null;

    }

    public String editcompany(CompanyModel company) {
        List<CompanyModel> companies = repo.findAll();

        for(CompanyModel com : companies){
            if(com.getEmail().equals(company.getEmail())){
                com.setDescription(company.getDescription());
                com.setEmail(company.getEmail());
                com.setName(company.getName());
                com.setPassword(company.getPassword());

                repo.save(com);
                return "ok";
            }
        }
        return "ok";
    }

    public CompanyModel findCompanyByMail(String id) {
        List<CompanyModel> companies = repo.findAll();

        for(CompanyModel com : companies){
            if(com.getId().equals(id)){
                return com;
            }
        }
        return null;
    }

    public void changePassword(PasswordChange_Company company) {
        List<CompanyModel> companies = repo.findAll();
        for(CompanyModel com : companies){
            if(com.getEmail().equals(company.getRsemail())){
               com.setPassword(company.getRspassword1());
               repo.save(com);
            }
        }

    }


}
