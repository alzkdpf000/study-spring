package com.example.threetier.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;

    public void sendMail(String mail, HttpServletRequest request, HttpServletResponse response) throws MessagingException {
        String code = createCode();

        Cookie cookie = new Cookie("code", code);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 5);
        response.addCookie(cookie);

        String receiver = mail;
        String sender = "dev.tedhan@gmail.com";
        String title = "인증";

        StringBuilder body = new StringBuilder();
        body.append("<html><body>");
        body.append("<a href=\"http://localhost:10000/mail/confirm?code=" + code + "\">인증 하러 가기</a>");
        body.append("<img src=\"cid:icon.png\">");

        body.append("</body></html>");

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(receiver);
        mimeMessageHelper.setSubject(title);
        mimeMessageHelper.setText(body.toString(), true);

        FileSystemResource fileSystemResource = new FileSystemResource(new File("C:/file/2025/08/14", "7c428432-bcfb-46ea-af6f-7a3e4bf8aede_icon1.png"));
        mimeMessageHelper.addInline("icon.png", fileSystemResource);

        fileSystemResource = new FileSystemResource(new File("D:/gb_0900_hds/spring/memo", "spring.txt"));
        mimeMessageHelper.addAttachment("spring.txt", fileSystemResource);

        javaMailSender.send(mimeMessage);
    }

//    코드 생성
    private String createCode(){
        String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        Random random = new Random();

        for(int i=0; i<10; i++){
            code += codes.charAt(random.nextInt(codes.length()));
        }

        return code;
    }
}















