package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.urlRoute.User;
import com.example.demo.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public int getUserById(@PathVariable int id){
        return id;
    }

    @GetMapping("/usermessage")
    public List<User> aotmo(){
//        List<User> users= userMapper.find();

//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("name", "lzy");
//        List<User> users= userMapper.selectList(wrapper);
        List<User> users= userMapper.selectList(null);
        return users;
    }

    @PostMapping("/user")
    public int charu(User user){
//        int x = userMapper.charu(user);
        int x = userMapper.insert(user);
        return x;
    }

    @PutMapping("/user")
    public String update(User user){
        return "putting";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable int id){
        return "deleting"+id;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        String token = JwtUtils.generateToken(user.getName());
        return token;
    }

    public String checkLogin(@RequestBody String token){
        String name = JwtUtils.getUsernameFromToken(token);
        return name;
    }
}
