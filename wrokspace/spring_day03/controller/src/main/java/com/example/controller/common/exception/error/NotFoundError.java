package com.example.controller.common.exception.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotFoundError {
    @GetMapping("/error")
    public String error() {
        return "/error/404";
    }
}
