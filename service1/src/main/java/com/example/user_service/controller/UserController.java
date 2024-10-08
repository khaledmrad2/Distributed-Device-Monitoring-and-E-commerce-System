package com.example.user_service.controller;

import com.example.user_service.entities.User;
import com.example.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(name = "type", required = false) String type) {
        return new ResponseEntity<>(userService.getAll(type), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        if (userService.getById(id) != null)
            return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
        return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (userService.deleteUser(id))
            return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
        return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);

    }
}
