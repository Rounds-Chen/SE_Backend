package com.rounds.experimentalteachingsystm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rounds.experimentalteachingsystm.mapper")
public class ExperimentalTeachingSystmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperimentalTeachingSystmApplication.class, args);
    }

}
