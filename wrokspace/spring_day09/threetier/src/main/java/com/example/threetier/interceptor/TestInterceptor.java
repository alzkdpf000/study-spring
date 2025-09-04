package com.example.threetier.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class TestInterceptor implements HandlerInterceptor {
    @Override
    //전처리 -> 나중에 권한 설정 부분
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//      나중에 여기 부분에서 의사 부분이랑 고객부분에 따라 넘기기
//      로그인했는지 유무 체크 이게 나중에는 시큐리티에 해당하는 부분
//      알림 목록 불러오기
        request.setAttribute("test","통과");
        return true;
    }

    @Override
    //후처리
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        여기서는 결제 관련 강사님한테 질문하기
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        log.info("asd");
    }
}
