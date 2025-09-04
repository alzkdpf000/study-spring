package com.example.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test/**")
public class TestController {
    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public String ex01() {
        return "/test/ex01";
    }
}
