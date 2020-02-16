package com.menros.echoplus.modules.userModule;

import com.menros.echoplus.services.mongodbService.collection.DBUser;
import com.menros.echoplus.services.mongodbService.repository.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired private DBUserRepository userRepo;

    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<DBUser> getAllUsers() {
        return this.userRepo.findAll();
    }

    @GetMapping("/createUser/{idUser}/{username}")
    @ResponseBody
    public Optional<DBUser> createUser(@PathVariable String idUser, @PathVariable String username) {
        DBUser user = new DBUser(idUser, username);
        this.userRepo.insert(user);
        return this.userRepo.findById(idUser);
    }
}
