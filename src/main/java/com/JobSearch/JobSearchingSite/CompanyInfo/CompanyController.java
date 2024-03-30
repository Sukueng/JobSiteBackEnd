package com.JobSearch.JobSearchingSite.CompanyInfo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

class Mail{
 String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class PasswordChange_Company{
    String rsemail;
    String rspassword1;
    String rspassword2;

    public String getRsemail() {
        return rsemail;
    }

    public void setRsemail(String rsemail) {
        this.rsemail = rsemail;
    }

    public String getRspassword1() {
        return rspassword1;
    }

    public void setRspassword1(String rspassword1) {
        this.rspassword1 = rspassword1;
    }

    public String getRspassword2() {
        return rspassword2;
    }

    public void setRspassword2(String rspassword2) {
        this.rspassword2 = rspassword2;
    }
}

@RestController
public class CompanyController {
    @Autowired
    CompanyService service;

    @PostMapping("/company/addcompany")
    public String addCompany(@RequestBody CompanyModel company){
        return service.addCompany(company);
    }

    @GetMapping("/company/getall")
    public List<CompanyModel> getAllCompany(){
       return  service.getAllCompany();
    }


    @PostMapping("/company/findcompany")
    public boolean findCompany(@RequestBody CompanyModel company){
        return service.findCompany(company);

    }

    @PostMapping("/company/findandGetcompany")
    public CompanyModel findandGetcompany(@RequestBody CompanyModel company){
        return service.findandGetcompany(company);
    }

    @PostMapping("/company/editcompany")
    public String editcompany(@RequestBody CompanyModel company){
        return service.editcompany(company);
    }

    @PostMapping("/company/findCompanyByMail")
    public CompanyModel findCompanyByMail(@RequestBody String id){
        System.out.println(id);
        return service.findCompanyByMail(id);
    }

    @PostMapping("/company/changePassword")
    public void changePassword(@RequestBody PasswordChange_Company company){
        service.changePassword(company);

    }
}
