package com.example.productsservice.Repository;

import com.example.productsservice.Model.Watch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolexWatchRepository extends MongoRepository<Watch,Long> {
    Watch findWatchByModel(String model);
    String deleteWatchByModel(String model);
    List<Watch> findWatchByGender(String gender);
}
