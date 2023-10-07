package com.example.demo.controller;

import com.example.demo.urlRoute.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public int getUserById(@PathVariable int id){
        return id;
    }

    @PostMapping("/user")
    public String save(User user){
        return "saving";
    }

    @PutMapping("/user")
    public String update(User user){
        return "putting";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable int id){
        return "deleting"+id;
    }
}
