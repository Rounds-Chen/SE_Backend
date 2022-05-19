package com.rounds.experimentalteachingsystm;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.rounds.experimentalteachingsystm.mapper")
public class ExperimentalTeachingSystmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperimentalTeachingSystmApplication.class, args);
    }
}
