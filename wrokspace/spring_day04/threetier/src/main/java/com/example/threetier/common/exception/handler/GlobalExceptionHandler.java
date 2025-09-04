package com.example.threetier.common.exception.handler;

import com.example.threetier.common.exception.LoginFailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice(basePackages = "com.example.threetier.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(LoginFailException.class)
    protected RedirectView handleTestException(LoginFailException e, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("login", "fail");
        return new RedirectView("/member/login");
    }
}
