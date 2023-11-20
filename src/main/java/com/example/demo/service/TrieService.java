package com.example.demo.service;


import com.example.demo.mapper.LcThinkingMapper;
import com.example.demo.mapper.TechStackMapper;
import com.example.demo.urlRoute.TechStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrieService {
    @Autowired
    private TechStackMapper techStackMapper;

    private final Trie trie = new Trie();

    public List<String> loadDataFromDatabase() {
        return techStackMapper.selectList(null)
                .stream()
                .map(TechStack::getTechnology)
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        List<String> words = loadDataFromDatabase();
        for (String word : words) {
            trie.insert(word);
        }
    }

    public Trie getTrie() {
        return trie;
    }
}
