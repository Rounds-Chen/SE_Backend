package com.rounds.experimentalteachingsystm;

import com.rounds.experimentalteachingsystm.mapper.ReportMapper;
import com.rounds.experimentalteachingsystm.service.ReportService;
import com.rounds.experimentalteachingsystm.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SimpleTest {
    @Autowired
    private  ReportMapper reportMapper;

    @Resource
    private ReportService reportService;

    @Resource
    private StudentService studentService;

    @Test
    public void test2(){
        List<Map<String,String>> ans=studentService.getStuClassCours();

        System.out.println(ans);
    }

    @Test
    public  void test() {
        System.out.println(reportMapper.selectList(null));
    }

    @Test
    public void test1(){
        System.out.println(reportService.getOne(1));
    }
}
//jenkins-test2
//success!