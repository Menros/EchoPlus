package com.menros.echoplus.services.mongodbService.collection;

import com.menros.echoplus.services.mongodbService.collection.dbPackage.DBPackageProject;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "package")
public class DBPackage {
    @Id private ObjectId id;
    private String name;
    private List<DBPackageProject> projects;

    public DBPackage() {
    }

    public DBPackage(String name) {
        this(new ObjectId(), name, new ArrayList<>());
    }

    public DBPackage(String name, List<DBPackageProject> projects) {
        this(new ObjectId(), name, projects);
    }

    public DBPackage(ObjectId id, String name, List<DBPackageProject> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DBPackageProject> getProjects() {
        return projects;
    }

    public void setProjects(List<DBPackageProject> projects) {
        this.projects = projects;
    }
}
