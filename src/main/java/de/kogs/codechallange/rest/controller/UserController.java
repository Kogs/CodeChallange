package de.kogs.codechallange.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.kogs.codechallange.data.User;
import de.kogs.codechallange.rest.dto.UserDto;
import de.kogs.codechallange.rest.mapper.UserMapper;
import de.kogs.codechallange.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/users")
public class UserController {
    

    private final UserService userService;
    private final UserMapper userMapper;


    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping()
    public ResponseEntity<Collection<UserDto>> getAllUsers() {
        log.info("Get all userse");
        final Collection<User> users = userService.getAllUsers();
        final Collection<UserDto> dtos = userMapper.toDto(users);
        log.info("loaded {} users", users.size());
        return ResponseEntity.ok(dtos);
    }


    @PostMapping()
    public ResponseEntity<UserDto> createOrUpdateUser(@RequestBody UserDto userDto) {
        final User savedUser = userService.save(userMapper.fromDto(userDto));
        return ResponseEntity.ok(userMapper.toDto(savedUser));
    }

    @PutMapping(path = "/{userId}") 
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
        userService.getUser(userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        final User updatedUser = userMapper.fromDto(userDto);
        updatedUser.setId(userId);

        final User savedUser = userService.save(updatedUser);
        return ResponseEntity.ok(userMapper.toDto(savedUser));
    }

    
    

}
