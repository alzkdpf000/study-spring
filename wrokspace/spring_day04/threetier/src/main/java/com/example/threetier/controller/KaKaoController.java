package com.example.threetier.controller;

import com.example.threetier.dto.MemberDTO;
import com.example.threetier.service.KaKaoService;
import com.example.threetier.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class KaKaoController {
    private final MemberService memberService;
    private final KaKaoService kaKaoService;
    private final HttpSession session;

    @GetMapping("/kakao/login")
    public RedirectView kakaoLogin(String code) {
        String token = kaKaoService.getKakaoAccessToken(code);
        Optional<MemberDTO> foundMember = kaKaoService.getKakaoInfo(token);
        MemberDTO member = foundMember.orElseThrow(RuntimeException::new);

        memberService.join(member);
        session.setAttribute("member", member);

//        최초 로그인인지 검사
        return new RedirectView();
    }
}















