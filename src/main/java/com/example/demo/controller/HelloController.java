package com.example.demo.controller;

import com.example.demo.urlRoute.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "HelloController", description = "你好相关接口")
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @Operation(summary = "hello方法", description = "你好")
    @Parameters({
            @Parameter(name = "name", description = "名字"),
            @Parameter(name = "one", description = "其他")
    })
    public String hello(@RequestParam(value = "name", required = false) String name, String one) {
        System.out.println(name);
        System.out.println(one);
        return "hello wo!";
    }

    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    public String postTest(String name, int passwd) {
        System.out.println(name);
        System.out.println(passwd);
        return "ok";
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public String postTest2(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "ok";
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public String postTest3(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "ok";
    }

}
