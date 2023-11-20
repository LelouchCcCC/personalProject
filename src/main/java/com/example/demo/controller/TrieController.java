package com.example.demo.controller;

import com.example.demo.service.TrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class TrieController {
    @Autowired

    private final TrieService trieService;

    @Autowired
    public TrieController(TrieService trieService) {
        this.trieService = trieService;
    }

    @GetMapping("/search")
    public boolean search(@RequestParam String word) {
        return trieService.getTrie().search(word);
    }

    @GetMapping("/startsWith")
    public List<Map> startsWith(@RequestParam String prefix) {
        List<String> list= trieService.getTrie().startsWith(prefix);
        List<Map> res = new ArrayList<>();
        if (list==null){
            return res;
        }
        for (String li:list){
            Map<String, String> map = new HashMap<>();
            map.put("value", li);
            res.add(map);
        }
        return res;
    }
}