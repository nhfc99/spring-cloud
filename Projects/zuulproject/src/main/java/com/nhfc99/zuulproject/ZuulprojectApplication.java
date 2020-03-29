package com.nhfc99.zuulproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulprojectApplication.class, args);
    }

}
