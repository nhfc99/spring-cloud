package com.nhfc99.eureka_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderApplication.class, args);
    }

}
