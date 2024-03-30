package com.JobSearch.JobSearchingSite.CompanyPosts;

import com.JobSearch.JobSearchingSite.CompanyInfo.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepostory repo;

    public String addPost(PostModel model) {
        repo.save(model);
        return "added successfully";
    }

    public List<PostModel> getPostById(String id) {
        List<PostModel> allpost = repo.findAll();
        List<PostModel> matches = new ArrayList<>();
        for(PostModel post:allpost){
            if(post.company_id.equals(id)){
                matches.add(post);
            }
        }
        return matches;

    }

    public List<PostModel> getAllPost() {
        return repo.findAll();
    }

    public void deletePost(PostModel post) {
        repo.deleteById(post.getId());
    }
}
