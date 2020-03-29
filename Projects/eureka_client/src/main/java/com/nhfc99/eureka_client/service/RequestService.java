package com.nhfc99.eureka_client.service;

import com.nhfc99.eureka_client.Fallback.Fallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eurekaproduct", fallback = Fallback.class)
public interface RequestService {
    @GetMapping("/index/getport")
    public String getPort();
}
