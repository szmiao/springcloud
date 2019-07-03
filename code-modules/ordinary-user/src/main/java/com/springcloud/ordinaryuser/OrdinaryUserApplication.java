package com.springcloud.ordinaryuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrdinaryUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdinaryUserApplication.class, args);
    }

}
