package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.LcThinkingMapper;
import com.example.demo.mapper.TechMapper;
import com.example.demo.mapper.TechStackMapper;
import com.example.demo.service.ThinkingRequest;
import com.example.demo.service.TrieService;
import com.example.demo.urlRoute.Tech;
import com.example.demo.urlRoute.TechStack;
import com.example.demo.urlRoute.Thinking;
import com.example.demo.utils.ItemList;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.example.demo.utils.JwtUtils.getUsernameFromToken;

@RestController
@CrossOrigin
//@RequestMapping("/thinking")
public class ThinkingController {
    @Autowired
    private LcThinkingMapper thinkingMapper;
    @Autowired
    private TrieService trieService;
    @Autowired
    private TechStackMapper techStackMapper;
    @Autowired
    private TechMapper techMapper;
    @GetMapping("/byName")
    public List<Thinking> getThinkingsByName(@RequestParam String name) {
        QueryWrapper<Thinking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return thinkingMapper.selectList(queryWrapper);
    }

    @PostMapping("/userthinking")
    public ResponseEntity<String> addThinking(HttpServletRequest request, @RequestBody ThinkingRequest tr) {
        try {
        Thinking thinking = tr.getThinking();
        List<String> items = tr.getItems();
            String token = extractToken(request);
            String name = getUsernameFromToken(token);

            thinking.setDate(new Date());
            thinking.setName(name);
            int result = thinkingMapper.insert(thinking);
            Integer id = thinking.getId();
            for (String item:items){
                boolean sts = trieService.getTrie().search(item);
                if(!sts){
                    trieService.getTrie().insert(item);
                    TechStack ts = new TechStack();
                    ts.setTechnology(item);
                    techStackMapper.insert(ts);
                }
                Tech tech = new Tech();
                tech.setThinkingId(id);
                tech.setTech(item);
                techMapper.insert(tech);
            }

            if (result > 0) {
                return ResponseEntity.ok("Thinking added successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add thinking.");
            }
        } catch (ExpiredJwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token expired.");
        } catch (MalformedJwtException | SignatureException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
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
