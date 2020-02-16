package com.menros.echoplus.services.mongodbService.repositoryCustom;

import com.menros.echoplus.services.mongodbService.collection.DBProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;

public class DBProjectRepositoryImpl implements DBProjectRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;
    private String collectionName = DBProject.class.getAnnotation(Document.class).collection();
}
