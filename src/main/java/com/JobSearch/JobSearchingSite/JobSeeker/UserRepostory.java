package com.JobSearch.JobSearchingSite.JobSeeker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostory extends MongoRepository<UserModel,String> {
}
