package com.menros.echoplus.services.mongodbService.repository;

import com.menros.echoplus.services.mongodbService.collection.DBTask;
import com.menros.echoplus.services.mongodbService.repositoryCustom.DBTaskRepositoryCustom;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBTaskRepository extends MongoRepository<DBTask, ObjectId>, DBTaskRepositoryCustom {
}
