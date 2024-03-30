package com.JobSearch.JobSearchingSite.JobSeeker;

import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

class Mail{
    String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

class PasswordChange{
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

class GetCompanyId{
    String companyid;
    String uname;
    String appliedfor;
    String postid;

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getAppliedfor() {
        return appliedfor;
    }

    public void setAppliedfor(String appliedfor) {
        this.appliedfor = appliedfor;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}

class CheckApply{
    String postid;
    String umail;

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail;
    }
}

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/user/adduser")
    public String addUser(@RequestBody UserModel user){
        return service.addUSer(user);
    }

    @PostMapping("/user/finduser")
    public UserModel findUser(@RequestBody UserModel user){
        return service.finduser(user);
    }

    @PostMapping("/user/findauthuser")
    public UserModel findauthuser(@RequestBody UserModel user){
        return service.findauthuser(user);
    }

    @PostMapping("/user/findByMail")
    public UserModel findByMail(@RequestBody Mail mail){
//        System.out.println(mail.getMail());
        return service.findByMail(mail.getMail());
    }

    @PostMapping("/user/edituser")
    public String  editUser(@RequestBody UserModel user){
        return service.editUser(user);

    }

    @PostMapping("/user/changePassword")
    public void changePassword(@RequestBody PasswordChange pass){
        System.out.println(pass.getRsemail());
        service.changePassword(pass);
    }

    @PostMapping("/user/addcompanyid")
    public void addcompanyid(@RequestBody GetCompanyId companyId){
        service.addcompanyid(companyId);
    }

    @PostMapping("/user/applies")
    public List<ReturnUser> applies(@RequestBody String id){
//        System.out.println(id);
       return service.applies(id);
    }

    @PostMapping("/user/checkapply")
    public boolean checkapply(@RequestBody CheckApply data){
//        System.out.println(id);
        return service.checkapply(data);
    }
}
