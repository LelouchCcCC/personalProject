package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.LcThinkingMapper;
import com.example.demo.urlRoute.Thinking;
import jakarta.servlet.http.HttpServletRequest;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.example.demo.utils.JwtUtils.getUsernameFromToken;

@RestController
@CrossOrigin
//@RequestMapping("/thinking")
public class ThinkingController {
    @Autowired
    private LcThinkingMapper thinkingMapper;
    @GetMapping("/byName")
    public List<Thinking> getThinkingsByName(@RequestParam String name) {
        QueryWrapper<Thinking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return thinkingMapper.selectList(queryWrapper);
    }

    @PostMapping("/userthinking")
    public ResponseEntity<String> addThinking(HttpServletRequest request, @RequestBody Thinking thinking) {
        String token = extractToken(request);
        String name = getUsernameFromToken(token);
        thinking.setDate(new Date());
        thinking.setName(name);
        int result = thinkingMapper.insert(thinking);
        Integer id = thinking.getId();

        if (result > 0) {
            return ResponseEntity.ok("Thinking added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add thinking.");
        }

    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Remove "Bearer " prefix
        }
        return null;
    }



}
