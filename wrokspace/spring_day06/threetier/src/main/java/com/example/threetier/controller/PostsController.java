package com.example.threetier.controller;

import com.example.threetier.common.exception.PostNotFoundException;
import com.example.threetier.dto.MemberDTO;
import com.example.threetier.dto.PostCriteriaDTO;
import com.example.threetier.dto.PostDTO;
import com.example.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/posts/**")
@RequiredArgsConstructor
public class PostsController {
    private final PostService postService;

//    목록
    @GetMapping("{page}")
    public ResponseEntity<?> list(@PathVariable("page") int page) {
        PostCriteriaDTO postCriteriaDTO = postService.getList(page);
        if (postCriteriaDTO == null || postCriteriaDTO.getPosts().size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(postCriteriaDTO);
        }
        return ResponseEntity.ok(postCriteriaDTO);
    }
}











