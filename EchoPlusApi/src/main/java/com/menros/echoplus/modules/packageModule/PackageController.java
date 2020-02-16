package com.menros.echoplus.modules.packageModule;

import com.menros.echoplus.services.mongodbService.collection.DBPackage;
import com.menros.echoplus.services.mongodbService.repository.DBPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("package")
public class PackageController {
    @Autowired
    private DBPackageRepository packageRepo;

    @GetMapping("/getAllPackages")
    @ResponseBody
    public List<DBPackage> getAllPackages() {
        return this.packageRepo.findAll();
    }

    @GetMapping("/createPackage/{name}")
    @ResponseBody
    public Optional<DBPackage> createUser(@PathVariable String name) {
        DBPackage dbPackage = new DBPackage(name);
        this.packageRepo.insert(dbPackage);
        return this.packageRepo.findById(dbPackage.getObjectId());
    }

    @GetMapping("/deletePackage/{packageId}")
    @ResponseBody
    public void deletePackage(@PathVariable String packageId) {
    }
}
