package com.JobSearch.JobSearchingSite.JobSeeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class ReturnUser{
    String resume;
    String appliedfor;
    String name;

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAppliedfor() {
        return appliedfor;
    }

    public void setAppliedfor(String appliedfor) {
        this.appliedfor = appliedfor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReturnUser{" +
                "resume='" + resume + '\'' +
                ", appliedfor='" + appliedfor + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


@Service
public class UserService {

    @Autowired
    UserRepostory repo;

    public String addUSer(UserModel user) {
        repo.save(user);
        return "added successfully";
    }


    public UserModel finduser(UserModel user) {
        List<UserModel> users = repo.findAll();
        for(UserModel userobj : users){
            if(userobj.getEmail().equals(user.getEmail())){
                return userobj;
            }
        }
        return null;
    }

    public UserModel findByMail(String mail) {

        List<UserModel> users = repo.findAll();
        for(UserModel userobj : users){
            if(userobj.getEmail().equals(mail)){
                return userobj;
            }
        }
        return null;
    }

    public String editUser(UserModel user) {


        List<UserModel> users = repo.findAll();
        for(UserModel userobj : users){
            if(userobj.getEmail().equals(user.getEmail())){
                userobj.setEmail(user.getEmail());
                userobj.setName(user.getName());
                userobj.setPassword(user.getPassword());
                if(user.getResume() != null || !Objects.equals(user.getResume(), "")){
                    userobj.setResume(user.getResume());
                }

                repo.save(userobj);
            }
        }
        return "ok";
    }

    public void changePassword(PasswordChange pass) {
        List<UserModel> users = repo.findAll();
        for(UserModel userobj : users) {
            if (userobj.getEmail().equals(pass.getRsemail())) {
                userobj.setPassword(pass.getRspassword1());
                repo.save(userobj);
            }
        }

    }

    public UserModel findauthuser(UserModel user) {
        List<UserModel> users = repo.findAll();
        for(UserModel userobj : users){
            if(userobj.getEmail().equals(user.getEmail()) && user.getPassword().equals(userobj.getPassword())){
                return userobj;
            }
        }
        return null;
    }

    public void addcompanyid(GetCompanyId companyId) {
        String uname = companyId.getUname();
        String companyid = companyId.getCompanyid()+"/"+companyId.getAppliedfor();

        System.out.println(uname+" "+companyid);

        List<UserModel> users = repo.findAll();
        for(UserModel user : users){
            if(user.getEmail().equals(uname)){
                if (user.getCompany_id() == null ) {
                    user.setCompany_id(new ArrayList<>()); // Initialize if null
                }
                if (user.getPostid() == null ) {
                    user.setPostid(new ArrayList<>()); // Initialize if null
                }
                user.getCompany_id().add(companyid);
                user.getPostid().add(companyId.getPostid());
                repo.save(user);
//                System.out.println(user);
            }

        }
    }

    public List<ReturnUser> applies(String id) {
        List<UserModel> users = repo.findAll();
        List<ReturnUser> allapplies = new ArrayList<>();
        for(UserModel user : users){
            if(user.getCompany_id() != null){
                for(String getval : user.getCompany_id()){
                    String arr[] = getval.split("/");
                    if(arr[0].equals(id)){
                        ReturnUser FinedUser = new ReturnUser();
                        FinedUser.setName(user.getName());
                        FinedUser.setAppliedfor(arr[1]);
                        FinedUser.setResume(user.getResume());
                        allapplies.add(FinedUser);
                    }
//                    for(int i=0;i<arr.length;i+=2){
//                        if(arr[i].equals(id)){
//                            System.out.println(arr[i]);
//
//                        }
//                    }
                }
            }

        }
//        for(ReturnUser user:allapplies){
//            System.out.println("the applied users are "+user.getName());
//        }
        return allapplies;
    }

    public boolean checkapply(CheckApply data) {
        List<UserModel> users = repo.findAll();
        for(UserModel obj : users){
            if(obj.getEmail().equals(data.getUmail())){
                if(obj.getPostid() == null){
                    return true;
                }else{
                    for(String id : obj.getPostid()){
                        if(data.getPostid().equals(id)){
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }
}
