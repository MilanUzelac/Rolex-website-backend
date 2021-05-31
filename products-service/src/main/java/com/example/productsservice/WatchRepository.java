package com.example.productsservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchRepository extends MongoRepository<Watch,Long> {

}
