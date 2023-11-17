package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.LcThinkingMapper;
import com.example.demo.urlRoute.Thinking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.utils.JwtUtils.getUsernameFromToken;

@RestController
@RequestMapping("/thinking")
public class ThinkingController {
    @Autowired
    private LcThinkingMapper thinkingMapper;
    @GetMapping("/byName")
    public List<Thinking> getThinkingsByName(@RequestParam String name) {
        QueryWrapper<Thinking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return thinkingMapper.selectList(queryWrapper);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addThinking(@RequestBody String token, @RequestBody Thinking thinking) {
        String name = getUsernameFromToken(token);
        System.out.println(name);
//        System.out.println(thinking.toString());
//        int result = thinkingMapper.insert(thinking);
//
//        if (result > 0) {
//            return ResponseEntity.ok("Thinking added successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add thinking.");
//        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add thinking.");
    }



}
