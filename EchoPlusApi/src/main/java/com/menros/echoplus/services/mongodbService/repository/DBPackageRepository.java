package com.menros.echoplus.services.mongodbService.repository;

import com.menros.echoplus.services.mongodbService.collection.DBPackage;
import com.menros.echoplus.services.mongodbService.repositoryCustom.DBPackageRepositoryCustom;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBPackageRepository extends MongoRepository<DBPackage, ObjectId>, DBPackageRepositoryCustom {
}
