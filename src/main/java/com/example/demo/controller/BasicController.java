package com.example.demo.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.mapper.BasicMapper;
import com.example.demo.urlRoute.Basic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BasicController {
    @Autowired
    private BasicMapper basicMapper;
    @PostMapping("/basic-message")
    public Basic getBasicInformationByName(String name){
        Basic b = basicMapper.queryByName(name);
        return b;
    }
}
