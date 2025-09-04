package com.example.threetier.controller;

import com.example.threetier.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestMapper testMapper;

    @GetMapping("/test")
    public List<String> test(String column, String keyword){
        Set<String> columnSet = Set.of("bloodType", "category", "gender");
        if(!columnSet.contains(column)){
            throw new IllegalArgumentException("잘못된 컬럼명");
        }
        HashMap<String, String> searchMap = new HashMap<>();
        searchMap.put("column", column);
        searchMap.put("keyword", keyword);
        return testMapper.selectName(searchMap);
    }
}
