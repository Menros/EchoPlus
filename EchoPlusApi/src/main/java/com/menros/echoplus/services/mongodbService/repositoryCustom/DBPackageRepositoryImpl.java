package com.menros.echoplus.services.mongodbService.repositoryCustom;

import com.menros.echoplus.services.mongodbService.collection.DBPackage;
import com.menros.echoplus.services.mongodbService.collection.DBProject;
import com.menros.echoplus.services.mongodbService.collection.dbPackage.DBPackageProject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class DBPackageRepositoryImpl implements DBPackageRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;
    private String collectionName = DBPackage.class.getAnnotation(Document.class).collection();

    @Override
    public void addProjectToPackage(ObjectId packageId, DBProject project) {
        DBPackageProject packageProject = new DBPackageProject(project.getObjectId(), project.getName());
        this.mongoTemplate.updateFirst(
                Query.query(Criteria.where("_id").is(packageId)),
                new Update().addToSet("projects", packageProject),
                this.collectionName
        );
    }

    @Override
    public void removeProjectFromPackage(DBProject project) {
        DBPackageProject packageProject = new DBPackageProject(project.getObjectId(), project.getName());
        this.mongoTemplate.updateFirst(
                Query.query(Criteria.where("_id").is(project.getRefPackageId())),
                new Update().pull("projects", packageProject),
                this.collectionName
        );
    }
}
