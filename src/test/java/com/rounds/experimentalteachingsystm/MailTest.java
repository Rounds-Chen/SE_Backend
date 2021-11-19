package com.rounds.experimentalteachingsystm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class MailTest {
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() {
        String to = "1851049@tongji.edu.cn";
        String subject = "test";
        String content = "test content";
        String from = "1418621447@qq.com";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            System.out.println("简单邮件已经发送。");
        } catch (Exception e) {
            System.out.println("发送简单邮件时发生异常！" + e);
        }
    }
}
