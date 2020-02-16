package com.menros.echoplus.services.mongodbService.collection;

import com.menros.echoplus.services.mongodbService.collection.dbTask.checklist.DBTaskChecklist;
import com.menros.echoplus.services.mongodbService.collection.dbTask.comment.DBTaskComment;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "task")
public class DBTask {
    @Id private ObjectId id;
    private ObjectId projectRef;
    private String currentTasklist;
    private String name;
    private String description;
    private int priority;
    private List<DBTaskChecklist> checklistList;
    private List<DBTaskComment> comments;

    public DBTask() {
    }

    public DBTask(ObjectId projectRef, String currentTasklist, String name) {
        this(new ObjectId(), projectRef, currentTasklist, name, "", 1, new ArrayList<>(), new ArrayList<>());
    }

    public DBTask(ObjectId id, ObjectId projectRef, String currentTasklist, String name, String description, int priority, List<DBTaskChecklist> checklistList, List<DBTaskComment> comments) {
        this.id = id;
        this.projectRef = projectRef;
        this.currentTasklist = currentTasklist;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.checklistList = checklistList;
        this.comments = comments;
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

    public ObjectId getProjectRefId() {
        return projectRef;
    }

    public String getProjectRef() {
        return projectRef.toString();
    }

    public void setProjectRef(ObjectId projectRef) {
        this.projectRef = projectRef;
    }

    public String getCurrentTasklist() {
        return currentTasklist;
    }

    public void setCurrentTasklist(String currentTasklist) {
        this.currentTasklist = currentTasklist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<DBTaskChecklist> getChecklistList() {
        return checklistList;
    }

    public void setChecklistList(List<DBTaskChecklist> checklistList) {
        this.checklistList = checklistList;
    }

    public List<DBTaskComment> getComments() {
        return comments;
    }

    public void setComments(List<DBTaskComment> comments) {
        this.comments = comments;
    }
}
