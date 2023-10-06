package com.example.demo.controller;

import com.example.demo.urlRoute.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", required = false) String name, String one) {
        System.out.println(name);
        System.out.println(one);
        return "hello wo!";
    }

    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    public String postTest(String name, int passwd){
        System.out.println(name);
        System.out.println(passwd);
        return "ok";
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public String postTest2(User user){
        System.out.println(user.getName());
        System.out.println(user.getPasswd());
        return "ok";
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public String postTest3(@RequestBody User user){
        System.out.println(user.getName());
        System.out.println(user.getPasswd());
        return "ok";
    }

}
