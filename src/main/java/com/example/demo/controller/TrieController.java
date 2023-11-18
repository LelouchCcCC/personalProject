package com.example.demo.controller;

import com.example.demo.service.TrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<String> startsWith(@RequestParam String prefix) {
        return trieService.getTrie().startsWith(prefix);
    }
}