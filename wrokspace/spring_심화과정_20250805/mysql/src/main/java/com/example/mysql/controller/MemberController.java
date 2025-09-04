package com.example.mysql.controller;

import com.example.mysql.domain.MemberVO;
import com.example.mysql.dto.MemberDTO;
import com.example.mysql.enumeration.Status;
import com.example.mysql.mapper.MemberMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member/**")
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberMapper memberMapper;

    @GetMapping("test")
    public String test(Status memberStatus){
        log.info(memberStatus.getValue());
        return "";
    }

    @GetMapping("/member/join")
    public String goToJoinForm(MemberDTO memberDTO, Model model){
        model.addAttribute("member", memberDTO);
        return "/member/join";
    }

    @PostMapping("/member/join")
    public String join(MemberDTO memberDTO){
        log.info("###############################");
        log.info(memberDTO.toString());
        MemberVO memberVO = MemberVO.builder()
                .memberEmail(memberDTO.getMemberEmail())
                .memberPassword(memberDTO.getMemberPassword())
                .memberName(memberDTO.getMemberName())
                .memberStatus(memberDTO.getMemberStatus())
                .build();
        log.info("###############################");
        log.info(memberVO.toString());

        memberMapper.join(memberVO);
        log.info("###############################");
        log.info(memberVO.toString());

        return "";
    }
}
















