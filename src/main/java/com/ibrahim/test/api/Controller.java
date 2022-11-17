package com.ibrahim.test.api;

import com.ibrahim.test.entity.User;
import com.ibrahim.test.services.UserService;

import com.ibrahim.test.userdto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {


    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUsers(@RequestBody UserDto user) {
        UserDto resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
        UserDto usersList = userService.getById(id);
        return ResponseEntity.ok(usersList);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto user) {
        UserDto resultUser = userService.updateUser(id, user);
        return ResponseEntity.ok(resultUser);

    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }


}
