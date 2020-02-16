package com.menros.echoplus.modules.projectModule;

import com.menros.echoplus.services.mongodbService.collection.DBProject;
import com.menros.echoplus.services.mongodbService.repository.DBPackageRepository;
import com.menros.echoplus.services.mongodbService.repository.DBProjectRepository;
import com.menros.echoplus.services.mongodbService.repository.DBTaskRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired private DBProjectRepository projectRepo;
    @Autowired private DBPackageRepository packageRepo;
    @Autowired private DBTaskRepository taskRepo;

    @GetMapping("/createProject/{packageId}/{projectName}")
    public Optional<DBProject> createProject(@PathVariable String packageId, @PathVariable String projectName) {
        DBProject dbProject = new DBProject(new ObjectId(packageId), projectName);
        this.projectRepo.insert(dbProject);
        this.packageRepo.addProjectToPackage(new ObjectId(packageId), dbProject);
        return this.projectRepo.findById(dbProject.getObjectId());
    }

    @GetMapping("/getAllProjectsFromPackage/{packageId}")
    public List<DBProject> getAllProjectsFromPackage(@PathVariable String packageId) {
        return this.projectRepo.findByRefPackage(new ObjectId(packageId));
    }

    @GetMapping("/getProject/{projectId}")
    public Optional<DBProject> getProject(@PathVariable String projectId) {
        return this.projectRepo.findById(new ObjectId(projectId));
    }

    @GetMapping("/deleteProject/{projectId}")
    public void deleteProject(@PathVariable String projectId) {
        DBProject dbProject = this.projectRepo.findById(new ObjectId(projectId)).get();
        this.taskRepo.deleteAllTasksOfProject(dbProject.getObjectId());
        this.packageRepo.removeProjectFromPackage(dbProject);
        this.projectRepo.delete(dbProject);
    }
}
