package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest http) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        String path = http.getServletContext().getRealPath("/upload");

        System.out.println(path);
        saveFile(file, path);

        return "upload success";
    }

    private void saveFile(MultipartFile file, String path) throws IOException{
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdir();
        }
        // need to adjust the name here, not fixed name for every item
        File file1 = new File(path+"\\a.jpg");
        System.out.println(file1.getName());
        String fullAddress = path + "\\a.jpg";
        System.out.println(fullAddress);
        file.transferTo(file1);
    }
}
