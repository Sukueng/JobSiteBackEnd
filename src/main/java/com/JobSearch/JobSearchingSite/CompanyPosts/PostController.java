package com.JobSearch.JobSearchingSite.CompanyPosts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PostController {
    @Autowired
    PostService service;

    @PostMapping("/post/addpost")
    public String addPost(@RequestBody PostModel model){
        return service.addPost(model);
    }

    @PostMapping("/post/findPostById")
    public List<PostModel> findPostById(@RequestBody String id){
        return service.getPostById(id);

    }

    @GetMapping("/post/getAll")
    public List<PostModel> getAllPost(){
        return service.getAllPost();
    }

    @PostMapping("/post/deletePost")
    public void deletePost(@RequestBody PostModel post){
        service.deletePost(post);
    }
}
