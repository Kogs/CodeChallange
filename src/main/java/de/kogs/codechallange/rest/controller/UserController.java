package de.kogs.codechallange.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.kogs.codechallange.data.User;
import de.kogs.codechallange.rest.dto.UserDto;
import de.kogs.codechallange.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/users")
public class UserController {
    

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<Collection<UserDto>> getAllUsers() {
        log.info("Get all userse");
        final Collection<User> users = userService.getAllUsers();
        // TODO map and return entities
        log.info("loaded {} users", users.size());
        return ResponseEntity.ok(null);
    }

    

}
