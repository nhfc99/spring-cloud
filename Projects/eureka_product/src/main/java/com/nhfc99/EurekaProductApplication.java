package com.nhfc99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@SpringCloudApplication
public class EurekaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProductApplication.class, args);
    }

}
