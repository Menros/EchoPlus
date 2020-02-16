package com.menros.echoplus.services.mongodbService.repository;

import com.menros.echoplus.services.mongodbService.collection.DBProject;
import com.menros.echoplus.services.mongodbService.repositoryCustom.DBProjectRepositoryCustom;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DBProjectRepository extends MongoRepository<DBProject, ObjectId>, DBProjectRepositoryCustom {
    @Query(value = "{ 'refPackage' : ?0 }")
    public List<DBProject> findByRefPackage(ObjectId refPackage);
}
