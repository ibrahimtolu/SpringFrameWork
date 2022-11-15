package com.ibrahim.test.api;

import com.ibrahim.test.entity.User;
import com.ibrahim.test.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controlller {


    private final UserService userService;
    public  Controlller(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUsers(@RequestBody User user){
        User resultUser= userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }
    @PostMapping("/createtest")
    public ResponseEntity <User> userCreate(@RequestBody User user){
         userService.userCreate(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getall")
    public  ResponseEntity<List<User>> getUsers( ){

       List <User> users= userService.getUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getById/{id}")
    public  ResponseEntity<User> getById(@PathVariable("id") Long id){
        User usersList=userService.getById(id);
        return  ResponseEntity.ok(usersList);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody  User user){
        User resultUser=userService.updateUser(id,user);
        return ResponseEntity.ok(resultUser);

    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity <Boolean> deleteUser(@PathVariable("id") Long id) {
        Boolean status=userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }





}
