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
        String path = null;

//        최초 로그인인지 검사
        Optional<MemberDTO> foundKakaoMember = memberService.getKakaoMember(member.getKakaoEmail());
        if(foundKakaoMember.isEmpty()) {
            memberService.joinKakaoMember(member);
//            추가 정보 필요
//            해당 서블릿으로 redirect 후 정보 기입, 완료
//            완료 처리 컨트롤러에서 전달받은 정보로 해당 회원 정보 update, session에 정보 담아주기
            foundKakaoMember = memberService.getKakaoMember(member.getKakaoEmail());
        }
        session.setAttribute("member", foundKakaoMember.get());

        return new RedirectView("/post/list/1");
    }
}















