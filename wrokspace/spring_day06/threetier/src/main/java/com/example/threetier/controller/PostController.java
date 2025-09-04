package com.example.threetier.controller;

import com.example.threetier.common.exception.PostNotFoundException;
import com.example.threetier.dto.PostDTO;
import com.example.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post/**")
@Slf4j
public class PostController {
    private final PostService postService;

//    게시글 목록
    @GetMapping("list/{page}")
    public String list(@PathVariable int page, Model model){
//        model.addAttribute("postsCriteriaDTO", postService.getList(page));
        return "/post/list";
    }

    //    작성
    @GetMapping("write")
    public String goToWriteForm(PostDTO postDTO, Model model){
        model.addAttribute(postDTO);
        return "/post/write";
    }

    @PostMapping("write")
    public RedirectView write(PostDTO postDTO, @RequestParam("file") List<MultipartFile> files){
        postService.write(postDTO, files);
        return new RedirectView("/post/" + postDTO.getId());
    }

    //    조회
    @GetMapping(value = "{id}")
    public String read(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPost(id).orElseThrow(PostNotFoundException::new));
        return "/post/read";
    }

//    수정
    @GetMapping(value = "/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPost(id).orElseThrow(PostNotFoundException::new));
        return "/post/update";
    }

    @PostMapping("/update")
    public RedirectView update(PostDTO postDTO) {
        postService.update(postDTO);
        return new RedirectView("/post/" + postDTO.getId());
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable Long id){
        postService.delete(id);
        return new RedirectView("/post/list/1");
    }

}













