package com.JobSearch.JobSearchingSite.JobSeeker;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
public class UserModel {
    @Id
    String id;
    String name;
    String email;
    String password;
    String resume;
    List<String> company_id;
    List<String> postid;

    public List<String> getPostid() {
        return postid;
    }

    public void setPostid(List<String> postid) {
        this.postid = postid;
    }

    public List<String> getCompany_id() {
        return company_id;
    }


    public void setCompany_id(List<String> company_id) {
        this.company_id = company_id;
    }

    public UserModel() {
        this.company_id = new ArrayList<>(); // Initialize the company_id list
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", resume='" + resume + '\'' +
                ", company_id=" + company_id +
                '}';
    }
}
