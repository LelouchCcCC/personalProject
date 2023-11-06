package com.example.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.mapper.BasicMapper;
import com.example.demo.urlRoute.Basic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin
@Tag(name = "BasicController", description = "relate to basic message of the user")
public class BasicController {
    @Autowired
    private BasicMapper basicMapper;
    @Operation(summary = "getBasicInformationByName", description = "fetch information depend on name")
    @Parameter(name = "name",description = "who want to get information")
    @GetMapping ("/basic-message")
    @ApiResponse(description = "the response type",content = {
            @Content(
                    schema = @Schema(implementation = Basic.class)
            )
    })
    public Basic getBasicInformationByName(String name){
        Basic b = basicMapper.queryByName(name);
        System.out.println(b);
        return b;
    }
    @Operation(summary = "insertBasicInformationByName", description = "insert information depend on name")
    @PostMapping("basic-message")
    public String addBasicInformation(String name, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth, String School, Double phone, Double subphone, String mailbox, String submailbox, String photo, String githubLink, String linkedInLink){
        Basic bsc = new Basic(name, birth,School,phone,subphone,mailbox,submailbox,photo,githubLink,linkedInLink);
        basicMapper.insert(bsc);
        return "successful";
    }
}
