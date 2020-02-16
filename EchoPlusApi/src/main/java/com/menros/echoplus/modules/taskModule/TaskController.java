package com.menros.echoplus.modules.taskModule;

import com.menros.echoplus.services.mongodbService.collection.DBTask;
import com.menros.echoplus.services.mongodbService.repository.DBTaskRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired private DBTaskRepository taskRepo;

    @GetMapping("/createTask/{projectId}/{tasklist}/{taskName}")
    public Optional<DBTask> createTask(@PathVariable String projectId, @PathVariable String tasklist, @PathVariable String taskName) {
        DBTask dbTask = new DBTask(new ObjectId(projectId), tasklist, taskName);
        this.taskRepo.insert(dbTask);
        return this.taskRepo.findById(dbTask.getObjectId());
    }

    @GetMapping("/setTaskToList/{taskId}/{listName}")
    public void setTaskToList(@PathVariable String taskId, @PathVariable String listName) {
        this.taskRepo.setTaskToList(new ObjectId(taskId), listName);
    }

    @PostMapping("/saveTask")
    public Optional<DBTask> saveTask(@RequestBody DBTask task) {
        this.taskRepo.save(task);
        return this.taskRepo.findById(task.getObjectId());
    }
}
