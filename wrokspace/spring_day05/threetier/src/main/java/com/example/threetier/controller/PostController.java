package com.example.threetier.controller;

import com.example.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post/**")
public class PostController {
    private final PostService postService;

//    게시글 목록
    @GetMapping("list/{page}")
    public String list(@PathVariable int page, Model model){
//        model.addAttribute("postsCriteriaDTO", postService.getList(page));
        return "/post/list";
    }
}













