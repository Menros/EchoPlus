package com.menros.echoplus.services.mongodbService.repository;

import com.menros.echoplus.services.mongodbService.collection.DBUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DBUserRepository extends MongoRepository<DBUser, String> {
    @Query(value = "{ 'username' : ?0 }")
    public List<DBUser> findByUsername(String username);
}
