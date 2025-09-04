package com.example.threetier.controller;

import com.example.threetier.common.exception.LoginFailException;
import com.example.threetier.dto.MemberDTO;
import com.example.threetier.service.KaKaoService;
import com.example.threetier.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member/**")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final KaKaoService kaKaoService;
    private final HttpSession session;

//    회원가입
    @GetMapping("join")
    public String goToJoinForm(MemberDTO memberDTO, Model model){
        model.addAttribute("memberDTO", memberDTO);
        return "/member/join";
    }

    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        memberService.join(memberDTO);
        return new RedirectView("/member/login");
    }

    @PostMapping("check-email")
    @ResponseBody
    public ResponseEntity<?> checkEmail(@RequestBody Map<String, String> member){
        String memberEmail = member.get("memberEmail");
        boolean isExist = memberService.isExistMemberEmail(memberEmail);
        Map<String, Object> result = new HashMap<>();
        result.put("memberEmail", memberEmail);
        result.put("isExist", isExist);
        
        if(isExist){
//            409 중복처리
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok().body(result);
    }

//    로그인
    @GetMapping("login")
    public String goToLoginForm(@CookieValue(name="remember", required = false) boolean remember,
                                @CookieValue(name="remember_member_email", required = false) String rememberedEmail,
                                HttpServletRequest request,
                                MemberDTO memberDTO,
                                Model model){
        memberDTO.setRemember(remember);
        memberDTO.setMemberEmail(rememberedEmail);
        model.addAttribute("memberDTO", memberDTO);
        return "/member/login";
    }

    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO, HttpServletResponse response){
        MemberDTO member = memberService.login(memberDTO).orElseThrow(LoginFailException::new);
        session.setAttribute("member", member);

        Cookie rememberMembmerEmailCookie = new Cookie("remember_member_email", memberDTO.getMemberEmail());
        Cookie rememberCookie = new Cookie("remember", String.valueOf(memberDTO.isRemember()));
        
        rememberMembmerEmailCookie.setPath("/");
        rememberCookie.setPath("/");
        
        if(memberDTO.isRemember()){
            rememberMembmerEmailCookie.setMaxAge(60 * 60 * 24 * 30); // 30일 유지
            response.addCookie(rememberMembmerEmailCookie);

            rememberCookie.setMaxAge(60 * 60 * 24 * 30); // 30일 유지
            response.addCookie(rememberCookie);

        } else{
            rememberMembmerEmailCookie.setMaxAge(0); // 30일 유지
            response.addCookie(rememberMembmerEmailCookie);

            rememberCookie.setMaxAge(0); // 30일 유지
            response.addCookie(rememberCookie);
        }

        return new RedirectView("/post/list/1");
    }

    @GetMapping("logout")
    public RedirectView logout(@CookieValue(name="access_token", required = false) String token, HttpServletResponse response){
        if(token == null){
            session.invalidate();
        }else{
            kaKaoService.logout(token);
            Cookie accessTokenCookie = new Cookie("access_token", token);
            accessTokenCookie.setPath("/");
            accessTokenCookie.setMaxAge(0);

            response.addCookie(accessTokenCookie);
        }
        return new RedirectView("/member/login");
    }
}












