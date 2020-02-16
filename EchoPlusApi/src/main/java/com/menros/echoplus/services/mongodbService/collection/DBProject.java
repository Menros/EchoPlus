package com.menros.echoplus.services.mongodbService.collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "project")
public class DBProject {
    @Id private ObjectId id;
    private ObjectId refPackage;
    private String name;
    private List<String> tasklist;

    public DBProject() {
    }

    public DBProject(ObjectId refPackage, String name) {
        this(new ObjectId(), refPackage, name, new ArrayList<>());
    }

    public DBProject(ObjectId id, ObjectId refPackage, String name, List<String> tasklist) {
        this.id = id;
        this.refPackage = refPackage;
        this.name = name;
        this.tasklist = tasklist;
    }

    public ObjectId getObjectId() {
        return id;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getRefPackageId() {
        return refPackage;
    }

    public String getRefPackage() {
        return refPackage.toString();
    }

    public void setRefPackage(ObjectId refPackage) {
        this.refPackage = refPackage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTasklist() {
        return tasklist;
    }

    public void setTasklist(List<String> tasklist) {
        this.tasklist = tasklist;
    }
}
