package com.JobSearch.JobSearchingSite.CompanyInfo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepostory extends MongoRepository<CompanyModel,String> {
}
