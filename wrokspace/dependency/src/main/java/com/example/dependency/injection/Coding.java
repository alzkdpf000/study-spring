package com.example.dependency.injection;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString @Getter
@RequiredArgsConstructor
public class Coding {
//    필드 주입(생성 후 주입)
//    사용 방법이 매우 편리하다.
//    주입된 객체를 불변(immutable) 상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있다.
//    OCP(Open-Closed Principle, 개방-폐쇄 원칙)를 위반할 수 있다.
//    생성 시점에서는 순환 참조 발생 여부를 알 수 없다.
//    @Autowired
//    private Computer computer;

//    setter 주입(생성 후 주입)
//    주입된 객체를 불변(immutable) 상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있다.
//    OCP(Open-Closed Principle, 개방-폐쇄 원칙)를 위반할 수 있다.
//    생성 시점에서는 순환 참조 발생 여부를 알 수 없다.
//    ※ 화면으로부터 값을 받을 때에는 setter 메소드를 통해 데이터를 바인딩하므로 DI가 아닌 바인딩 목적으로 사용된다.
//      데이터 바인딩: HTTP 요청 시점에 화면으로부터 전달된 데이터를 서버의 객체에 넣는 기술
//    private final Computer computer;
//
//    @Autowired
//    public void setComputer(Computer computer){
//        this.computer = computer;
//    }

//    생성자 주입(생성과 동시에 주입)
//    가장 권장되는 방식으로 객체 생성 시점에 의존성을 주입하여 불변성을 보장한다.
//    순환 참조 발생 시, 초기화 시점에 감지할 수 있다.
    private final Computer computer;

//    @Autowired
//    public Coding(Computer computer){
//        this.computer = computer;
//    }
}
















