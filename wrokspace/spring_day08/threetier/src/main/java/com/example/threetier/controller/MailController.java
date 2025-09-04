package com.example.threetier.controller;

import com.example.threetier.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/mail/**")
@RequiredArgsConstructor
@Slf4j
public class MailController {
    private final MailService mailService;

    @PostMapping("send")
    public RedirectView send(String email, HttpServletRequest request, HttpServletResponse response) throws MessagingException {
        mailService.sendMail(email, request, response);
        return new RedirectView("/member/confirm");
    }

    @GetMapping("confirm")
    public RedirectView confirm(@CookieValue(name="code", required = false) String cookieCode,
                                String code,
                                HttpServletResponse response){
        if(cookieCode == null || cookieCode.isEmpty()){
            return new RedirectView("/mail/fail");
        }

        if(cookieCode.equals(code)){
            Cookie cookie = new Cookie("code", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new RedirectView("/mail/success");
        }

        return new RedirectView("/mail/fail");
    }

    @GetMapping("success")
    public String goToSuccessPage(){
        return "/member/success";
    }

    @GetMapping("fail")
    public String goToFailPage(){
        return "/member/fail";
    }
}













