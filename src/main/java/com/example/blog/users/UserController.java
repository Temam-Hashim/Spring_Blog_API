package com.example.blog.users;

import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

//    UserService us = new UserService();

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void AddUsers(@RequestBody Users users){

        userService.AddUsers(users);
    }

    @DeleteMapping(path="{userId}")
    public void DeleteUsers(@PathVariable("userId") Long userId){

        userService.DeleteUsers(userId);
    }

    @PutMapping(path = "{userId}")
    public void UpdateUser(
            @PathVariable("userId") Long userId,
            @RequestBody Users users
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) String mobile
    ){
        userService.UpdateUser(userId,users.getName(),users.getEmail(),users.getMobile());
    }

//    get user by id
    @GetMapping(path = "{userId}")
    public Optional<Users> GetUserById(@PathVariable("userId") Long userId){
        return userService.GetUserById(userId);
    }

}
