package org.ait.deskmanagement.controller;

import java.util.List;
import org.ait.deskmanagement.entity.Users;
import org.ait.deskmanagement.links.ResourceLinks;
import org.ait.deskmanagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping(path = ResourceLinks.LIST_USERS)
    public ResponseEntity<?> listUsers () {
        //log.info("UsersController:  list users");
        final List<Users> resource = usersService.getUsers();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = ResourceLinks.ADD_USER)
    public ResponseEntity<?> saveUser (@RequestBody final Users user) {
        //log.info("UsersController:  list users");
        final Users resource = usersService.saveUser(user);
        return ResponseEntity.ok(resource);
    }
}
