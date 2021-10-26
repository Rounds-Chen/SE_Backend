package com.rounds.experimentalteachingsystm;

import cn.dev33.satoken.stp.StpUtil;
import com.rounds.experimentalteachingsystm.service.ReportService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Scanner;

@SpringBootTest
public class LoginTest {
    @Test
    public void doLogin() {

        Scanner s=new Scanner(System.in);
        String username=s.next();

        Scanner x=new Scanner(System.in);
        String password=x.next();

        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("se".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            System.out.println( "登录成功");;
        }
        System.out.println("登陆失败");
    }

}
