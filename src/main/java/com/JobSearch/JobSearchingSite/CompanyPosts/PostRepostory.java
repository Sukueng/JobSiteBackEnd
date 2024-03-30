package com.JobSearch.JobSearchingSite.CompanyPosts;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PostRepostory extends MongoRepository<PostModel,String> {
}
