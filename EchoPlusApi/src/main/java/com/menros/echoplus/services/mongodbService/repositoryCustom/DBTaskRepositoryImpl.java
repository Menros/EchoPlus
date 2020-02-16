package com.menros.echoplus.services.mongodbService.repositoryCustom;

import com.menros.echoplus.services.mongodbService.collection.DBTask;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class DBTaskRepositoryImpl implements DBTaskRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;
    private String collectionName = DBTask.class.getAnnotation(Document.class).collection();

    @Override
    public void setTaskToList(ObjectId taskId, String listName) {
        this.mongoTemplate.updateFirst(
                Query.query(Criteria.where("_id").is(taskId)),
                Update.update("currentTasklist", listName),
                this.collectionName
        );
    }

    @Override
    public void deleteAllTasksOfProject(ObjectId projectId) {
        this.mongoTemplate.findAllAndRemove(Query.query(Criteria.where("projectRef").is(projectId)), this.collectionName);
    }
}
