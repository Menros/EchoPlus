package com.menros.echoplus.services.mongodbService.repositoryCustom;

import com.menros.echoplus.services.mongodbService.collection.DBProject;
import org.bson.types.ObjectId;

public interface DBPackageRepositoryCustom {
    void addProjectToPackage(ObjectId packageId, DBProject project);

    void removeProjectFromPackage(DBProject project);
}
