package com.menros.echoplus.services.mongodbService.collection.dbPackage;

import org.bson.types.ObjectId;

public class DBPackageProject {
    private ObjectId id;
    private String name;

    public DBPackageProject() {
    }

    public DBPackageProject(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
