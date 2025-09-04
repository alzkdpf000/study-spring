package com.example.controller.common.exception.handler;

import com.example.controller.common.exception.test.TestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.example.controller.controller.ex")
public class ExampleExceptionHandler {

    @ExceptionHandler(TestException.class)
    protected String handleTestException(TestException e){
        return "/ex/test";
    }
}
