package com.menros.echoplus.services.mongodbService.repositoryCustom;

import org.bson.types.ObjectId;

public interface DBTaskRepositoryCustom {
    void setTaskToList(ObjectId taskId, String listName);

    void deleteAllTasksOfProject(ObjectId projectId);
}
