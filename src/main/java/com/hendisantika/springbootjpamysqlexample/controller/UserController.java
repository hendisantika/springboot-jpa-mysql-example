package com.hendisantika.springbootjpamysqlexample.controller;

import com.hendisantika.springbootjpamysqlexample.entity.User;
import com.hendisantika.springbootjpamysqlexample.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-jpa-mysql-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-02
 * Time: 19:51
 */
@RestController
@RequestMapping(value = {"/user"})
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        logger.info("Fetching User with id " + id);
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User " + user.getName());
        userService.createUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/get", headers = "Accept=application/json")
    public List<User> getAllUser() {
        List<User> tasks = userService.getUser();
        return tasks;
    }

    @PutMapping(value = "/update", headers = "Accept=application/json")
    public ResponseEntity<String> updateUser(@RequestBody User currentUser) {
        logger.info("Update data user ....");
        Optional<User> user = userService.findById(currentUser.getId());
        if (!user.isPresent()) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        userService.update(currentUser, currentUser.getId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
