package com.example.controller.controller.ex;

import com.example.controller.common.exception.test.TestException;
import com.example.controller.domain.Member;
import com.example.controller.domain.School;
import com.example.controller.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/ex/**")
public class ExampleController {
//    @RequestMapping(value = "ex01", method = RequestMethod.GET, consumes = {}, produces = {})
    @GetMapping("ex01")
    public String ex01(){
        System.out.println("ex01................");
        return "/ex/ex01";
    }
    
//    ex02를 선언하고, 본인의 이름을 콘솔창에 출력한다.
//    알맞은 경로에 ex02.html을 생성하고 h1태그로 본인 이름을 출력한다.
    @GetMapping("ex02")
    public String ex02(){
        System.out.println("한동석");
        return "/ex/ex02";
    }

    @GetMapping("ex03")
    public String ex03(int age, Model model){
        System.out.println(age);
        model.addAttribute("age", age);
        return "/ex/ex03";
    }

//    이름을 전달받은 뒤 HTML에서 h1태그로 출력하기
    @GetMapping("ex04")
    public String ex04(@ModelAttribute("name") String name){
        return "/ex/ex04";
    }

    @GetMapping("ex05")
    public String ex05(Member member, Model model) {
        System.out.println(member);
        model.addAttribute("member", member);
        return "/ex/ex05";
    }
    
//    학생 객체 생성(이름, 국어, 영어, 수학)
//    Convention에 맞게 제작한 뒤
//    ex06 제작
//    평균 출력
    @GetMapping("ex06")
    public String ex06(Student student, Model model){
//        int total = student.getKor() + student.getEng() + student.getMath();
//        double average = Double.parseDouble(String.format("%.2f", total / 3.0));
//        model.addAttribute("total", total);
//        model.addAttribute("average", average);

        model.addAttribute("student", student);
        return "/ex/ex06";
    }

    @GetMapping("ex07")
    public void ex07(String[] arData) {
//        Arrays.toString(배열): 배열의 요소를 이쁘게 문자열로 만들어준다.
        System.out.println(Arrays.toString(arData));
    }

//    ex08.html에서 체크박스 3개 구성
//    완료버튼 클릭 시, GET방식으로 다음과 같이 요청한다
//    /ex/ex09
    @GetMapping("ex08")
    public String ex08() {
        return "/ex/ex08";
    }

//    사용자가 선택한 체크박스 value를 받아서 출력한다.
    @GetMapping("ex09")
    public String ex09(@RequestParam("data") String[] arData, Model model) {
        model.addAttribute("arData", arData);
        return "/ex/ex09";
    }

    @GetMapping("ex10")
    public String goToEx10(){
        return "/ex/ex10";
    }

    @PostMapping("ex10")
    public void ex10(School school){
        System.out.println(school);
    }

    @GetMapping("ex11")
    public String ex11(Model model){
        Member member = null;
        model.addAttribute("member", Optional.ofNullable(member).orElseThrow(TestException::new));
        return "/ex/ex11";
    }
}














